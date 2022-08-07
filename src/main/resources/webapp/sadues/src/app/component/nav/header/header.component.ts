import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-header',
  styleUrls: ['./header.component.scss'],
  template: `
    <header>
      <p-tabMenu [model]="menuItems" [activeItem]="menuItems[0]" [scrollable]="true">

      </p-tabMenu>
    </header>
  `
})
export class HeaderComponent implements OnInit {
  menuItems: MenuItem[] = [];

  constructor() {
    this.menuItems = [
      {label: 'Home', icon: 'pi pi-fw pi-home', routerLink: '/home'},
      {label: 'Pay Student Dues', icon: 'pi pi-fw pi-money-bill', routerLink: '/pay'},
      {label: 'Account', icon: 'pi pi-fw pi-user', routerLink: '/account'},
      {label: 'Logout', icon: 'pi pi-fw pi-sign-out', command: () => HeaderComponent.logoutAction()}
    ]
  }

  ngOnInit(): void {
  }

  private static logoutAction() {
    console.log('Log out not implemented')
  }
}
