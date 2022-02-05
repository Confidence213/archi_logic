import { Component, OnInit } from '@angular/core';
import { EventService } from '../event.service';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {

  title = "Liste des évènements :";
  eventList;

  constructor(service: EventService) {
    this.eventList = service.getEventList();
  }

  ngOnInit(): void {
  }

}
