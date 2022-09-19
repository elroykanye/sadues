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
  universities: University[] = [];
  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private universityService: UniversityService
  ) {
    this.user = new User(1, 'john.doe@email.com', 'REG', 'John Doe', Role.USER, Gender.MALE, 0);
    this.prepareForm();
  }

  ngOnInit(): void {
    this.loadUser();
    this.loadUniversities();
  }

  loadUser = () => {
    const email = StorageUtil.getUserEmail();
    this.userService.getByEmail(email).subscribe(user => {
      this.user = user;
      this.prepareForm();
      StorageUtil.setUser(user);
    })
  }

  loadUniversities = () => this.universityService.getAll().subscribe(unis => this.universities = unis);

  updateUserAction = () => {
    this.user.email = this.userForm.get('email')?.value;
    this.user.universityId = this.userForm.get('university')?.value;
    this.userService.update(this.user).subscribe();
  }

  prepareForm = () => {
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
