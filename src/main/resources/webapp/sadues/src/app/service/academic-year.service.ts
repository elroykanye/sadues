import {Inject, Injectable} from '@angular/core';
import {ACADEMIC_YEAR_API_URL} from "../app.injectables";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AcademicYearService {

  constructor(
    @Inject(ACADEMIC_YEAR_API_URL) private apiUrl: string,
    private http: HttpClient
  ) {
  }
}
