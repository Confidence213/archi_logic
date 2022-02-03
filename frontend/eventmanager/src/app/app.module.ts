import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { EventListComponent } from './event-list/event-list.component';
import { EventListService } from './event-list.service';
import { EventCreatorComponent } from './event-creator/event-creator.component';
import { EventDestroyerComponent } from './event-destroyer/event-destroyer.component';

@NgModule({
  declarations: [
    AppComponent,
    EventListComponent,
    EventCreatorComponent,
    EventDestroyerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    EventListService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
