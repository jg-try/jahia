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

  displayDialog: boolean;

  user: User = new User();

  selectedUser: User;

  newUser: boolean;



  constructor(private userService: UserService) {

  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });

    this.cols = [
      { field: 'name', header: 'name' },
      { field: 'email', header: 'email' }
    ];
  }

  showDialogToAdd() {
    this.newUser = true;
    this.user = new User();
    this.displayDialog = true;
  }

  save() {
    let users = [...this.users];
    if (this.newUser) {
      this.userService.save(this.user).subscribe();
      users.push(this.user);
    } else {
      this.userService.update(this.user).subscribe();
      users[this.users.indexOf(this.selectedUser)] = this.user;
    }
    this.users = users;
    this.user = null;
    this.displayDialog = false;
  }

  delete() {
    this.userService.delete(this.user).subscribe();
    let index = this.users.indexOf(this.selectedUser);
    this.users = this.users.filter((val, i) => i != index);
    this.user = null;
    this.displayDialog = false;
  }

  onRowSelect(event) {
    this.newUser = false;
    this.user = this.cloneUser(event.data);
    this.displayDialog = true;
  }

  cloneUser(u: User): User {
    let user = new User();
    for (let prop in u) {
      user[prop] = u[prop];
    }
    return user;
  }
}
