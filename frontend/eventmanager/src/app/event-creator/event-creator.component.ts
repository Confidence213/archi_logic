import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { EventService } from '../event.service';

import { Event } from '../event';

@Component({
  selector: 'app-event-creator',
  templateUrl: './event-creator.component.html',
  styleUrls: ['./event-creator.component.css']
})
export class EventCreatorComponent implements OnInit {

  eventForm = this.fb.group({
    title: ['', Validators.required],
    description: [''],
    place: ['', Validators.required],
    date: ['', Validators.required],
    price: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private service: EventService) { }

  ngOnInit(): void {
  }

  addEvent() {
    this.service.addEvent(this.eventForm.value as Event).subscribe();
    this.eventForm.reset();
  }

}
