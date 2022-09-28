import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor, HttpErrorResponse
} from '@angular/common/http';
import {catchError, Observable, of, tap, throwError} from 'rxjs';
import {StorageUtil} from "../storage.util";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const token = StorageUtil.getToken();
    const req = request.clone({
      headers: request.headers.set('X-Auth-Token', token)
    });
    return next.handle(req);
  }
}
