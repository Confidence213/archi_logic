import { Component } from '@angular/core';

export type ContentType = 'users' | 'events' | 'subscriptions';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = "Event manager";

  content: ContentType = 'users';

  get showUserContent() {
    return this.content === 'users';
  }

  get showEventContent() {
    return this.content === 'events';
  }

  get showSubscriptionContent() {
    return this.content === 'subscriptions';
  }

  toggleEditor(type: ContentType) {
    this.content = type;
  }

}
