import {EVENTS} from '../mock-events'
import {Injectable} from "@angular/core";
import {Event} from "../event";

@Injectable()
export class EventService {
    getEvents(): Promise<Array<Event>> {
        return Promise.resolve(EVENTS);
    }

    getEvent(id: number): Promise<Event> {
        return this.getEvents()
            .then(events => events.find(event => event.id === id));
    }
}