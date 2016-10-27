import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "../app-routing.module";
import {EventComponent} from "../events/component/event.component";
import {EventService} from "../events/service/event.service";

import { AUTH_PROVIDERS }      from 'angular2-jwt';
import {HomeComponent} from "../home/home.component";
import {Auth} from "../auth/auth.service";
import {LoginComponent} from "../login/login.component";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        AppRoutingModule
    ],
    declarations: [
        AppComponent,
        HomeComponent,
        LoginComponent,
        EventComponent
    ],
    providers: [EventService, AUTH_PROVIDERS, Auth],
    bootstrap: [ AppComponent ]
})

export class AppModule {
}
