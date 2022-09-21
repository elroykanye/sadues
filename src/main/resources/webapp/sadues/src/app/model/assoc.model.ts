export class Assoc {
  constructor(
    public id: number,
    public name: string,
    public universityId: number,
    public creatorId: number,
    public headAssociationId?: number,
  ) {
  }
}
