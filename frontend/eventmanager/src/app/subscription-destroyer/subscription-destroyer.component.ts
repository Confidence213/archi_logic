import { Component, Input, OnInit } from '@angular/core';

import { SubscriptionService } from '../subscription.service';

@Component({
  selector: 'app-subscription-destroyer',
  templateUrl: './subscription-destroyer.component.html',
  styleUrls: ['./subscription-destroyer.component.css']
})
export class SubscriptionDestroyerComponent implements OnInit {

  @Input() ticketNumber: number = 0;

  constructor(private service: SubscriptionService) { }

  ngOnInit(): void {
  }

  deleteSubscription() {
    this.service.deleteSubscription(this.ticketNumber).subscribe();
  }

}
