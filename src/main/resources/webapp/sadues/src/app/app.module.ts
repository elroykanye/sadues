import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {SERVICE_INJECTABLES} from "./app.injectables";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    SERVICE_INJECTABLES
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
