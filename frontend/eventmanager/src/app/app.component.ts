import { Component } from '@angular/core';

export type ContentType = 'users' | 'events';

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

  toggleEditor(type: ContentType) {
    this.content = type;
  }

}
