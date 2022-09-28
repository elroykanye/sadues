import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {USER_API_URL} from "../app.constants";
import {User} from "../model/user.model";
import {SaResponse} from "../model/response/sa-response";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    @Inject(USER_API_URL) private apiUrl: string,
    private http: HttpClient
  ) {
  }

  getByEmail = (email: string) => this.http.get<User>(`${this.apiUrl}/user`, {
    params: {email: email}
  });

  update = (user: User) => this.http.put<SaResponse>(`${this.apiUrl}`, user);
}
