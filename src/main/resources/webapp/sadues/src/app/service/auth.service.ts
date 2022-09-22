import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserLogin, UserRegister} from "../model/user.model";
import {Observable} from "rxjs";
import {SaResponse} from "../model/response/sa-response";
import {AUTH_API_URL} from "../app.constants";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    @Inject(AUTH_API_URL) private apiUrl: string,
    private http: HttpClient
  ) { }

  register = (userRegister: UserRegister): Observable<SaResponse> => this.http.post<SaResponse>(`${this.apiUrl}/register`, userRegister);
  login = (userLogin: UserLogin): Observable<SaResponse> => this.http.post<SaResponse>(`${this.apiUrl}/login`, userLogin);

   */
}
