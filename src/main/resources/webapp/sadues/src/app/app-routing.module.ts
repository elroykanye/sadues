import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./component/auth/login/login.component";
import {RegisterComponent} from "./component/auth/register/register.component";
import {AccountComponent} from "./component/dashboard/account/account.component";
import {HomeComponent} from "./component/dashboard/home/home.component";
import {PayDuesComponent} from "./component/dashboard/pay-dues/pay-dues.component";
import {AuthGuard} from "./guard/auth.guard";
import {MainComponent} from "./component/nav/main/main.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: '', component: MainComponent, canActivate: [AuthGuard], children: [
      {path: 'home', component: HomeComponent, canActivate: [AuthGuard]},
      {path: 'pay', component: PayDuesComponent, canActivate: [AuthGuard]},
      {path: 'account', component: AccountComponent, canActivate: [AuthGuard]},
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
