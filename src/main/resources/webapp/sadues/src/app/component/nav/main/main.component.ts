import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  styleUrls: ['./main.component.scss'],
  template: `
    <app-header></app-header>
    <router-outlet></router-outlet>
    <app-footer></app-footer>
  `
})
export class MainComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
