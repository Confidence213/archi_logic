import { Component, OnInit } from '@angular/core';
import { EventListService } from '../event-list.service';

import { Event } from '../event';

@Component({
  selector: 'app-event-creator',
  templateUrl: './event-creator.component.html',
  styleUrls: ['./event-creator.component.css']
})
export class EventCreatorComponent implements OnInit {

  constructor(private service: EventListService) { }

  ngOnInit(): void {
  }

  addEvent(title: string, description: string) {
    this.service.addEvent({title, description} as Event);
  }

}
