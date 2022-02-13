import { Component, OnInit } from '@angular/core';

import { SubscriptionService } from '../subscription.service';

@Component({
  selector: 'app-subscription-list',
  templateUrl: './subscription-list.component.html',
  styleUrls: ['./subscription-list.component.css']
})
export class SubscriptionListComponent implements OnInit {

  title = "Subscription list:";
  subscriptionList: any;

  constructor(private service: SubscriptionService) {
    let _sub = this.service.getSubscriptionList().subscribe(list => this.subscriptionList = list);
  }

  ngOnInit(): void {
  }

}
