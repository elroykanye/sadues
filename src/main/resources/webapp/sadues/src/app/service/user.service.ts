import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {USER_API_URL} from "../app.constants";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    @Inject(USER_API_URL) private apiUrl: string,
    private http: HttpClient
  ) {
  }
}
