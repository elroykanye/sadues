import {MembershipKey} from "./membership.model";

export class DuesPayment {
  constructor(
    public id: number,
    public amount: number,
    public date: Date,
    public status: PaymentStatus,
    public membershipKey: MembershipKey
  ) {
  }
}

export enum PaymentStatus {
  CANCELLED = 'CANCELLED',
  COMPLETED = 'COMPLETED',
  PENDING = 'PENDING'
}
