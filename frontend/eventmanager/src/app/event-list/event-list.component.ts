import { Component, OnInit, OnDestroy } from '@angular/core';

import { EventService } from '../event.service';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit, OnDestroy {

  title = "Event list:";
  eventList: any;
  sub: any;

  constructor(private service: EventService) {
  }

  ngOnInit(): void {
    this.sub = this.service.getEventList().subscribe(list => this.eventList = list);
  }

  ngOnDestroy(): void {
    if (this.sub) this.sub.unsubscribe();
  }

}
