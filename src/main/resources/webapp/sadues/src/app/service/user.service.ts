import {Inject, Injectable} from '@angular/core';
import {USER_API_URL} from "../app.injectables";
import {HttpClient} from "@angular/common/http";

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
