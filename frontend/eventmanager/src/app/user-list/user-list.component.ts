import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  title = "Liste des utilisateurs :";
  userList;

  constructor(service: UserService) {
    this.userList = service.getUserList();
  }

  ngOnInit(): void {
  }

}
