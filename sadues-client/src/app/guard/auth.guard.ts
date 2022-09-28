import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Route, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import {Observable, Subject} from 'rxjs';
import {StorageUtil} from "../storage.util";
import {AuthService} from "../service/auth.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router, private authService: AuthService) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const token = StorageUtil.getToken();
    if (token === '') {
      this.router.navigate(['/login']).then();
      return false;
    }
    const loggedIn = new Subject<boolean>();

    this.authService.check().subscribe({
      next: (result) => {
        loggedIn.next(result);
        loggedIn.complete();
      }, error: () => {
        this.router.navigate(['/login']).then();
        loggedIn.next(false);
        loggedIn.complete();
      }
    });
    return loggedIn.asObservable();
  }

}
