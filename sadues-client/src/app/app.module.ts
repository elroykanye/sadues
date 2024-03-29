import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SERVICE_INJECTABLES} from "./app.injectables";
import {LoginComponent} from './component/auth/login/login.component';
import {RegisterComponent} from './component/auth/register/register.component';
import {InputTextModule} from "primeng/inputtext";
import {PasswordModule} from "primeng/password";
import {ButtonModule} from "primeng/button";
import {ReactiveFormsModule} from "@angular/forms";
import { AccountComponent } from './component/dashboard/account/account.component';
import { HomeComponent } from './component/dashboard/home/home.component';
import {DropdownModule} from "primeng/dropdown";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { HeaderComponent } from './component/nav/header/header.component';
import { FooterComponent } from './component/nav/footer/footer.component';
import {TabMenuModule} from "primeng/tabmenu";
import { PayDuesComponent } from './component/dashboard/pay-dues/pay-dues.component';
import {RippleModule} from "primeng/ripple";
import {DividerModule} from "primeng/divider";
import {PanelModule} from "primeng/panel";
import {RadioButtonModule} from "primeng/radiobutton";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {ResponseMessageInterceptor} from "./interceptor/response-message.interceptor";
import {MessageService} from "primeng/api";
import {ToastModule} from "primeng/toast";
import { MainComponent } from './component/nav/main/main.component';
import {AuthInterceptor} from "./interceptor/auth.interceptor";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    AccountComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    PayDuesComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    InputTextModule,
    PasswordModule,
    ButtonModule,
    DropdownModule,
    TabMenuModule,
    RippleModule,
    DividerModule,
    PanelModule,
    RadioButtonModule,
    ToastModule
  ],
  providers: [
    SERVICE_INJECTABLES,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ResponseMessageInterceptor, multi: true},
    {provide: MessageService, useClass: MessageService}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
