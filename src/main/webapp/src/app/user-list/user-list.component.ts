import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  cols: any[];

  constructor(private userService: UserService) {

  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });

    this.cols = [
      { field: 'id', header: 'id' },
      { field: 'name', header: 'name' },
      { field: 'email', header: 'email' }
    ];
  }

  deleteUser(user) {
    const i = this.users.indexOf(user);
    this.users.splice(i, 1);
    this.userService.delete(user).subscribe(data => {
      this.users = data;
    });
  }

  updateUser(user){
    this.userService.update(user).subscribe(data => {
      this.users = data;
    });
  }
}
