export class User {
  constructor(
    public id: number,
    public email: string,
    public regNo: string,
    public name: string,
    public role: string,
    public gender: Gender
  ) {
  }
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
