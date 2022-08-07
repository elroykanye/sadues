import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Assoc} from "../model/assoc.model";
import {Observable} from "rxjs";
import {SaResponse} from "../model/response/sa-response";
import {ASSOC_API_URL} from "../app.constants";

@Injectable({
  providedIn: 'root'
})
export class AssocService {

  constructor(
    @Inject(ASSOC_API_URL) private apiUrl: string,
    private http: HttpClient
  ) {
  }

  create = (assoc: Assoc): Observable<SaResponse> => this.http.post<SaResponse>(this.apiUrl, assoc);
  getAll = (): Observable<Assoc[]> => this.http.get<Assoc[]>(this.apiUrl);
  getById = (id: number): Observable<Assoc> => this.http.get<Assoc>(`${this.apiUrl}/${id}`);
  update = (assoc: Assoc): Observable<SaResponse> => this.http.put<SaResponse>(this.apiUrl, assoc);
  delete = (id: number): Observable<void> => this.http.delete<void>(`${this.apiUrl}/${id}`);
}
