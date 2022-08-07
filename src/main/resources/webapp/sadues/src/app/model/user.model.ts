import {Component} from "@angular/core";

export class User {
  constructor(
    public id: number,
    public email: string,
    public regNo: string,
    public name: string,
    public role: string,
    public gender: Gender
  ) {}
}

export class UserRegister {
  constructor(
    public email: string,
    public password: string,
    public user: User
  ) {}
}

export class UserLogin {
  constructor(
    public email: string,
    public password: string
  ) {}
}


export enum Gender {
  MALE = "MALE",
  FEMALE = "FEMALE",
  OTHER = "OTHER"
}

export enum Role {
  USER = "USER",
  ADMIN = "ADMIN"
}
