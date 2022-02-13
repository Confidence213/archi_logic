import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { EventService } from './event.service';
import { UserService } from './user.service';

import { EventListComponent } from './event-list/event-list.component';
import { EventCreatorComponent } from './event-creator/event-creator.component';
import { EventDestroyerComponent } from './event-destroyer/event-destroyer.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserCreatorComponent } from './user-creator/user-creator.component';
import { UserDestroyerComponent } from './user-destroyer/user-destroyer.component';
import { SubscriptionListComponent } from './subscription-list/subscription-list.component';
import { SubscriptionCreatorComponent } from './subscription-creator/subscription-creator.component';
import { SubscriptionDestroyerComponent } from './subscription-destroyer/subscription-destroyer.component';

@NgModule({
  declarations: [
    AppComponent,
    EventListComponent,
    EventCreatorComponent,
    EventDestroyerComponent,
    UserListComponent,
    UserDestroyerComponent,
    UserCreatorComponent,
    SubscriptionListComponent,
    SubscriptionCreatorComponent,
    SubscriptionDestroyerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    EventService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
