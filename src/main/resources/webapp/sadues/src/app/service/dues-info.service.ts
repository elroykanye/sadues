import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {DuesInfo} from "../model/dues-info.model";
import {Observable} from "rxjs";
import {SaResponse} from "../model/response/sa-response";
import {DUES_INFO_API_URL} from "../app.constants";

@Injectable({
  providedIn: 'root'
})
export class DuesInfoService {

  constructor(
    @Inject(DUES_INFO_API_URL) private apiUrl: string,
    private http: HttpClient
  ) {
  }

  create = (duesInfo: DuesInfo): Observable<SaResponse> => this.http.post<SaResponse>(this.apiUrl, duesInfo);
  getAll = (): Observable<DuesInfo[]> => this.http.get<DuesInfo[]>(this.apiUrl);
  getById = (id: number): Observable<DuesInfo> => this.http.get<DuesInfo>(`${this.apiUrl}/${id}`);
  update = (duesInfo: DuesInfo): Observable<SaResponse> => this.http.put<SaResponse>(this.apiUrl, duesInfo);
  delete = (id: number): Observable<void> => this.http.delete<void>(`${this.apiUrl}/${id}`);
}
