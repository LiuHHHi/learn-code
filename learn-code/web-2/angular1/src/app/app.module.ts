import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponent } from './learn/first/first.component';
import { SecondComponent } from './learn/second/second.component';
import { MainComponent } from './learn/main/main.component';
import {FormsModule} from "@angular/forms";
import { HttpComponent } from './learn/http/http.component';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    SecondComponent,
    MainComponent,
    HttpComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
