import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Membership} from "../model/membership.model";
import {Observable} from "rxjs";
import {SaResponse} from "../model/response/sa-response";
import {MEMBERSHIP_API_URL} from "../app.constants";

@Injectable({
  providedIn: 'root'
})
export class MembershipService {

  constructor(
    @Inject(MEMBERSHIP_API_URL) private apiUrl: string,
    private http: HttpClient
  ) {
  }

  create = (membership: Membership): Observable<SaResponse> => this.http.post<SaResponse>(this.apiUrl, membership);
  getAll = (): Observable<Membership[]> => this.http.get<Membership[]>(this.apiUrl);
  getById = (id: number): Observable<Membership> => this.http.get<Membership>(`${this.apiUrl}/${id}`);
  update = (membership: Membership): Observable<SaResponse> => this.http.put<SaResponse>(this.apiUrl, membership);
  delete = (id: number): Observable<void> => this.http.delete<void>(`${this.apiUrl}/${id}`);

}
