import {User} from "./model/user.model";

export class StorageUtil {
  private static readonly  keys = {
    token: "sa_session_token",
    email: "sa_user_email",
    user: "sa_user_user"
  }

  static setToken = (token: string) => {
    localStorage.setItem(StorageUtil.keys.token, token);
  }

  static getToken = (): string => {
    const token = localStorage.getItem(this.keys.token);
    return token ? token : '';
  }

  static setUser = (user: User) => {
    localStorage.setItem(StorageUtil.keys.user, JSON.stringify(user));
  }

  static getUser = (): User | null => {
    const user = localStorage.getItem(StorageUtil.keys.user);
    return user ? JSON.parse(user) : null;
  }

  static setUserEmail = (email: string): void => {
    localStorage.setItem(StorageUtil.keys.email, email);
  }

  static getUserEmail = (): string => {
    const email = localStorage.getItem(StorageUtil.keys.email);
    return email ? email : '';
  }

  static clear = (): void => {
    localStorage.removeItem(StorageUtil.keys.email);
    localStorage.removeItem(StorageUtil.keys.user);
    localStorage.removeItem(StorageUtil.keys.token);
  }
}
