import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscriptionCreatorComponent } from './subscription-creator.component';

describe('SubscriptionCreatorComponent', () => {
  let component: SubscriptionCreatorComponent;
  let fixture: ComponentFixture<SubscriptionCreatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubscriptionCreatorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscriptionCreatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
