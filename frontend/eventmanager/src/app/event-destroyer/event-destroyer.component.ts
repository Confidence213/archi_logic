import { Component, Input, OnInit } from '@angular/core';
import { EventListService } from '../event-list.service';

@Component({
  selector: 'app-event-destroyer',
  templateUrl: './event-destroyer.component.html',
  styleUrls: ['./event-destroyer.component.css']
})
export class EventDestroyerComponent implements OnInit {

  @Input() eventId: number = 0;

  constructor(private service: EventListService) { }

  ngOnInit(): void {
  }

  deleteEvent() {
    this.service.deleteEvent(this.eventId);
  }

}
