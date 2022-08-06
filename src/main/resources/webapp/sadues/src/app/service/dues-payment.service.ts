import {Inject, Injectable} from '@angular/core';
import {DUES_PAYMENT_API_URL} from "../app.injectables";
import {HttpClient} from "@angular/common/http";
import {DuesPayment} from "../model/dues-payment.model";
import {Observable} from "rxjs";
import {SaResponse} from "../model/response/sa-response";

@Injectable({
  providedIn: 'root'
})
export class DuesPaymentService {

  constructor(
    @Inject(DUES_PAYMENT_API_URL) private apiUrl: string,
    private http: HttpClient
  ) {}

  create = (duesPayment: DuesPayment): Observable<SaResponse> => this.http.post<SaResponse>(this.apiUrl, duesPayment);
  getAll = (): Observable<DuesPayment[]> => this.http.get<DuesPayment[]>(this.apiUrl);
  getById = (id: number): Observable<DuesPayment> => this.http.get<DuesPayment>(`${this.apiUrl}/${id}`);
  update = (duesPayment: DuesPayment): Observable<SaResponse> => this.http.put<SaResponse>(this.apiUrl, duesPayment);
  delete = (id: number): Observable<void> => this.http.delete<void>(`${this.apiUrl}/${id}`);
}
