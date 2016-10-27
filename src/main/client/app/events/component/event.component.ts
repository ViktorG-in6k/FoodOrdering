import {Component, OnInit} from '@angular/core';
import {Event} from "../event";
import {EventService} from "../service/event.service";
import {Router} from "@angular/router";

@Component({
    moduleId: module.id,
    selector: 'event-list',
    template: `
        <h1>events</h1>
        
        <div *ngFor="let event of events">
            <div class="eventsList" >
                <div class="text">
                    {{event.id}} {{event.name}} {{event.responsibleUser.name}}
                </div>
            </div>            
        </div>
       
    `
})

export class EventComponent implements OnInit{
    events: Array<Event>;

    constructor(
        private router: Router,
        private eventService: EventService
    ) {}

    ngOnInit(): void {
        this.getEvents();
    }

    getEvents(): void {
        this.eventService.getEvents().then(events => this.events = events);
    }
}