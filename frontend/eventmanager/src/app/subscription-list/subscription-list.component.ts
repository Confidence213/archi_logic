import { Component, OnInit, OnDestroy } from '@angular/core';

import { SubscriptionService } from '../subscription.service';

@Component({
  selector: 'app-subscription-list',
  templateUrl: './subscription-list.component.html',
  styleUrls: ['./subscription-list.component.css']
})
export class SubscriptionListComponent implements OnInit, OnDestroy {

  title = "Subscription list:";
  subscriptionList: any;
  sub: any;

  constructor(private service: SubscriptionService) {
    this.service.getSubscriptionList().subscribe(list => this.subscriptionList = list);
  }

  ngOnInit(): void {
    this.sub = this.service.getUpdate().subscribe(message => {
      this.log(message);
      this.service.getSubscriptionList().subscribe(list => this.subscriptionList = list);
    })
  }

  ngOnDestroy(): void {
    if (this.sub) this.sub.unsubscribe();
  }

  private log(message: string) {
    console.log(`SubscriptionListComponent: ${message}`);
  }

}
