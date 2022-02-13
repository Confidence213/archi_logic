import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'app-user-creator',
  templateUrl: './user-creator.component.html',
  styleUrls: ['./user-creator.component.css']
})
export class UserCreatorComponent implements OnInit {

  userForm = this.fb.group({
    username: ['', Validators.required],
    firstname: [''],
    lastname: [''],
    dateOfBirth: [''],
    email: [''],
    password: ['']
  });

  error = "";

  constructor(private fb: FormBuilder, private service: UserService) { }

  ngOnInit(): void {
  }

  addUser() {
    this.service.addUser(this.userForm.value as User).subscribe();
    this.userForm.reset();
  }

}
