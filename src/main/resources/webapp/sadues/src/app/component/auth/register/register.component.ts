import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Gender, User, UserRegister} from "../../../model/user.model";
import {University} from "../../../model/university.model";
import {Router} from "@angular/router";
import {AuthService} from "../../../service/auth.service";
import {UniversityService} from "../../../service/university.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  genders: string[] = Object.keys(Gender);
  universities: University[] = [];

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private authService: AuthService,
    private universityService: UniversityService

  ) {
    this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]], password: ['', Validators.required],
      regno: ['', Validators.required], name: ['', Validators.required],
      university: [0, Validators.required], gender: [Gender.OTHER, Validators.required]
    });

  }

  ngOnInit(): void {
  }

  registerAction() {
    const user: User = new User(
      0,
      this.registerForm.get('email')?.value,
      this.registerForm.get('regno')?.value,
      this.registerForm.get('name')?.value,
      this.registerForm.get('role')?.value,
      this.registerForm.get('gender')?.value,
    );
    const userRegister: UserRegister = new UserRegister(
      this.registerForm.get('email')?.value, this.registerForm.get('email')?.value, user
    );
    console.log(userRegister);
    /*
    this.authService.register(userRegister).subscribe((res) => {
      this.router.navigate(['/login']).then();
    });
     */
  }
}
