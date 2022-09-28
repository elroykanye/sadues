import {Membership, MembershipKey, Position} from './membership.model';

describe('Membership', () => {
  it('should create an instance', () => {
    expect(new Membership(new MembershipKey(1, 1), Position.MEMBER)).toBeTruthy();
  });
});
