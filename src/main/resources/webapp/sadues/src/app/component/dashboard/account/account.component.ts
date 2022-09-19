import {Component, OnInit} from '@angular/core';
import {Gender, Role, User} from "../../../model/user.model";
import {Assoc} from "../../../model/assoc.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../../service/user.service";
import {StorageUtil} from "../../../storage.util";
import {UniversityService} from "../../../service/university.service";
import {University} from "../../../model/university.model";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {
  user: User;
  userForm: FormGroup = this.fb.group({});
  association: Assoc[] = [];
  constructor(private fb: FormBuilder) {
    this.user = new User(1, 'john.doe@email.com', 'REG', 'John Doe', Role.USER, Gender.MALE);
    this.userForm = this.fb.group({
      email: [{value: this.user.email, disabled: false}, Validators.required],
      regno: [{value: this.user.regNo, disabled: true}, Validators.required],
      name: [{value: this.user.name, disabled: true}, Validators.required],
      role: [{value: this.user.role, disabled: true}, Validators.required],
      university: [{value: 'University of Bamenda', disabled: true}, Validators.required],
    })
  }

  ngOnInit(): void {
  }

}
