import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FirstComponent} from "./learn/first/first.component";
import {SecondComponent} from "./learn/second/second.component";
import {MainComponent} from "./learn/main/main.component";
import {HttpComponent} from "./learn/http/http.component";

const routes: Routes = [
  {path: '', component: MainComponent},
  {path: 'learn/first', component: FirstComponent},
  {path: 'learn/Second', component: SecondComponent},
  {path: 'learn/Second2/:object', component: SecondComponent},
  {path: 'learn/http', component: HttpComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
