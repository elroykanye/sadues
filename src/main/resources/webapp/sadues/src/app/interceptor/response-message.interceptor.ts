import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor, HttpResponse, HttpErrorResponse
} from '@angular/common/http';
import {catchError, EMPTY, Observable, of, Subject, tap} from 'rxjs';
import {SaResponse} from "../model/response/sa-response";
import {MessageService} from "primeng/api";
import {Route, Router} from "@angular/router";

@Injectable()
export class ResponseMessageInterceptor implements HttpInterceptor {

  constructor(
    private router: Router,
    private messageService: MessageService
  ) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    return next.handle(request).pipe(
      tap((event) => {
        if (event instanceof HttpResponse) {
          this.saResponseHandler(event)
        }
      }),
      catchError(err => this.errorResponseHandler(err))
    );
  }

  private saResponseHandler = (response: HttpResponse<any>) => {
    const body = response.body;
    if (body instanceof SaResponse) {
      this.messageService.add({
        severity: 'success', summary: 'Success', detail: body.message
      })
    }
  }

  private errorResponseHandler = (response: HttpErrorResponse) => {
    const error = response.error;
    if (error) {
      let errorDetails: string = ``;
      if (error.errors) {
        const errors = error.errors;
        for (let k in errors) {
          errorDetails += `${k}: ${errors[k]}\n`;
        }
      }
      this.messageService.add({
        severity: 'error', summary: 'Error', detail: error.message
      })
    }
    if(response.status == 401 || response.status == 403) {
      this.router.navigate(['/login']).then();
    }
    return of(error);
  }
}
