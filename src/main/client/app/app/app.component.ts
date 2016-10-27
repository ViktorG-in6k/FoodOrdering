import {Component} from "@angular/core";
import {Auth} from "../auth/auth.service";

@Component({
    moduleId: module.id,
    selector: 'my-app',
    providers: [ Auth ],
    template: `
    <nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Auth0 - Angular 2</a>
            <button class="btn btn-primary btn-margin" [routerLink]="['']">Home</button>
            <button class="btn btn-primary btn-margin" [routerLink]="['login']" *ngIf="!auth.authenticated()">Log In</button>
            <button class="btn btn-primary btn-margin" (click)="auth.logout()" *ngIf="auth.authenticated()">Log Out</button>
        </div>
    </div>
</nav>

<main class="container">
    <router-outlet></router-outlet>
</main>
`,
    styleUrls: ['app.component.css']
})

export class AppComponent {
    constructor(private auth: Auth) {}
};