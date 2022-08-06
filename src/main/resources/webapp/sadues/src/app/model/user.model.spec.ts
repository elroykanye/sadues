import {Gender, User} from './user.model';

describe('User', () => {
  it('should create an instance', () => {
    expect(new User(1, "user@email.com", "UREG", "Test User", "USER", Gender.OTHER)).toBeTruthy();
  });
});
