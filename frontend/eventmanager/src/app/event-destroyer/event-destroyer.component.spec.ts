import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventDestroyerComponent } from './event-destroyer.component';

describe('EventDestroyerComponent', () => {
  let component: EventDestroyerComponent;
  let fixture: ComponentFixture<EventDestroyerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EventDestroyerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EventDestroyerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
