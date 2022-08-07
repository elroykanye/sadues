import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Position} from "../../../model/membership.model";
import {Assoc} from "../../../model/assoc.model";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  membershipForm: FormGroup;
  associations: Assoc[] = [];
  positions: string[] = Object.keys(Position);
  constructor(private fb: FormBuilder) {
    this.membershipForm = this.fb.group({
      assoc: [0, Validators.required],
      position: [0, Validators.required],
    })
  }

  ngOnInit(): void {
  }

}
