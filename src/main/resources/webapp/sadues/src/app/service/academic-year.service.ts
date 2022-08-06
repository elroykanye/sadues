import {Inject, Injectable} from '@angular/core';
import {ACADEMIC_YEAR_API_URL} from "../app.injectables";
import {HttpClient} from "@angular/common/http";
import {AcademicYear} from "../model/academic-year.model";
import {Observable} from "rxjs";
import {SaResponse} from "../model/response/sa-response";

@Injectable({
  providedIn: 'root'
})
export class AcademicYearService {

  constructor(
    @Inject(ACADEMIC_YEAR_API_URL) private apiUrl: string,
    private http: HttpClient
  ) {
  }

  create = (academicYear: AcademicYear): Observable<SaResponse> => this.http.post<SaResponse>(this.apiUrl, academicYear);
  getAll = (): Observable<AcademicYear[]> => this.http.get<AcademicYear[]>(this.apiUrl);
  getById = (id: number): Observable<AcademicYear> => this.http.get<AcademicYear>(`${this.apiUrl}/${id}`);
  update = (academicYear: AcademicYear): Observable<SaResponse> => this.http.put<SaResponse>(this.apiUrl, academicYear);
  delete = (id: number): Observable<void> => this.http.delete<void>(`${this.apiUrl}/${id}`);
}
