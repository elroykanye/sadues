import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Gender} from "../../../model/user.model";
import {University} from "../../../model/university.model";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  genders: string[] = Object.keys(Gender);
  universities: University[] = [];

  constructor(private fb: FormBuilder) {
    this.registerForm = this.fb.group({
      username: ['', Validators.required, Validators.email],
      password: ['', Validators.required],
      regno: ['', Validators.required],
      name: ['', Validators.required],
      university: [0, Validators.required],
    });
  }

  ngOnInit(): void {
  }

  registerAction() {

  }
}
