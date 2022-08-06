export class University {
  constructor(
    public id: number,
    public name: string,
    public location: string,
    public approved: boolean,
    public currentYearId?: number
  ) {}
}
