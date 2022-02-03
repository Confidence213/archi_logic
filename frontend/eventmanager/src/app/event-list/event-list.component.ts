import { Component, OnInit } from '@angular/core';
import { EventListService } from '../event-list.service';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {

  title = "Liste des évènements :";
  eventList;

  constructor(service: EventListService) {
    this.eventList = service.getEventList();
  }

  ngOnInit(): void {
  }

}
