import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserDestroyerComponent } from './user-destroyer.component';

describe('UserDestroyerComponent', () => {
  let component: UserDestroyerComponent;
  let fixture: ComponentFixture<UserDestroyerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserDestroyerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserDestroyerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
