import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscriptionDestroyerComponent } from './subscription-destroyer.component';

describe('SubscriptionDestroyerComponent', () => {
  let component: SubscriptionDestroyerComponent;
  let fixture: ComponentFixture<SubscriptionDestroyerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubscriptionDestroyerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscriptionDestroyerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
