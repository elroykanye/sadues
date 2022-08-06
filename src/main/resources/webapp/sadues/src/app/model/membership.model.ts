export class Membership {
  constructor(
    public key: MembershipKey,
    public position: Position,
    public joinYear?: string
  ) {}
}

export class MembershipKey {
  constructor(
    public userId: number,
    public associationId: number
  ) {}
}

export enum Position {
  MEMBER = 'MEMBER',
  EXECUTIVE = 'EXECUTIVE',
  PRESIDENT = 'PRESIDENT',
}
