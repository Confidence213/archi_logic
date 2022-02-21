import { Component, OnInit, OnDestroy } from '@angular/core';

import { UserService } from '../user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit, OnDestroy {

  title = "User list:";
  userList: any;
  sub: any;

  constructor(private service: UserService) {
    this.service.getUserList().subscribe(list => this.userList = list);
  }

  ngOnInit(): void {
    this.sub = this.service.getUpdate().subscribe(message => {
      this.log(message);
      this.service.getUserList().subscribe(list => this.userList = list);
    })
  }

  ngOnDestroy(): void {
    if (this.sub) this.sub.unsubscribe();
  }

  private log(message: string) {
    console.log(`UserListComponent: ${message}`);
  }

}
