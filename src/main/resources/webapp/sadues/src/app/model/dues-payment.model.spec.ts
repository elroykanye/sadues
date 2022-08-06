import {DuesPayment, PaymentStatus} from './dues-payment.model';
import {MembershipKey} from "./membership.model";

describe('DuesPayment', () => {
  it('should create an instance', () => {
    expect(new DuesPayment(1, 3000, new Date(), PaymentStatus.PENDING, new MembershipKey(1, 1))).toBeTruthy();
  });
});
