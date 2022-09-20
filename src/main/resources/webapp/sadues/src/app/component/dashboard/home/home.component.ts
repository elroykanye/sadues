import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Membership, Position} from "../../../model/membership.model";
import {Assoc} from "../../../model/assoc.model";
import {AssocService} from "../../../service/assoc.service";
import {User} from "../../../model/user.model";
import {StorageUtil} from "../../../storage.util";
import {MembershipService} from "../../../service/membership.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  user: User | null = null;
  membershipForm: FormGroup;
  associationForm: FormGroup;
  associations: Assoc[] = [];
  positions: string[] = Object.keys(Position);
  constructor(
    private fb: FormBuilder,
    private associationService: AssocService,
    private membershipService: MembershipService
  ) {
    const user = StorageUtil.getUser();
    if (user) {
      console.log(user)
      this.user = user;
    } else {

    }
    this.membershipForm = this.fb.group({assoc: [0, Validators.required], position: [0, Validators.required],});
    this.associationForm = this.fb.group({name: ['', Validators.required], hassoc: [0]});
  }

  ngOnInit(): void {
  }

}
