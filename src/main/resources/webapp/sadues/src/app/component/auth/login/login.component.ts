import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserLogin} from "../../../model/user.model";
import {AuthService} from "../../../service/auth.service";
import {Router} from "@angular/router";
import {StorageUtil} from "../../../storage.util";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private authService: AuthService
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
    });
  }

  ngOnInit(): void {
  }

  loginAction() {
    const userLogin: UserLogin = new UserLogin(
      this.loginForm.get('email')?.value,
      this.loginForm.get('password')?.value,
    );
    this.authService.login(userLogin).subscribe((res) => {
      StorageUtil.setToken(res.message);
      StorageUtil.setUserEmail(res.id);
      this.router.navigate(['/account']).then();
    });
  }
}
