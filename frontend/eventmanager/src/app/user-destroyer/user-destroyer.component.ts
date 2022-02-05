import { Component, Input, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-destroyer',
  templateUrl: './user-destroyer.component.html',
  styleUrls: ['./user-destroyer.component.css']
})
export class UserDestroyerComponent implements OnInit {

  @Input() username: string = "";

  constructor(private service: UserService) { }

  ngOnInit(): void {
  }

  deleteUser() {
    this.service.deleteUser(this.username).subscribe();
  }

}
