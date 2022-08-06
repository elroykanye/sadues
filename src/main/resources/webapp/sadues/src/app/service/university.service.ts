import {Inject, Injectable} from '@angular/core';
import {UNIVERSITY_API_URL} from "../app.injectables";
import {HttpClient} from "@angular/common/http";
import {University} from "../model/university.model";
import {Observable} from "rxjs";
import {SaResponse} from "../model/response/sa-response";

@Injectable({
  providedIn: 'root'
})
export class UniversityService {

  constructor(
    @Inject(UNIVERSITY_API_URL) private apiUrl: string,
    private http: HttpClient
  ) {}

  create = (university: University): Observable<SaResponse> => this.http.post<SaResponse>(this.apiUrl, university);
  getAll = (): Observable<University[]> => this.http.get<University[]>(this.apiUrl);
  getById = (id: number): Observable<University> => this.http.get<University>(`${this.apiUrl}/${id}`);
  update = (university: University): Observable<SaResponse> => this.http.put<SaResponse>(this.apiUrl, university);
  delete = (id: number): Observable<void> => this.http.delete<void>(`${this.apiUrl}/${id}`);
}
