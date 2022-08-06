export class DuesInfo {
  constructor(
    public key: DuesInfoKey,
    public amount: number
  ) {
  }
}

export class DuesInfoKey {
  constructor(
    public academicYearId: number,
    public associationId: number
  ) {
  }
}
