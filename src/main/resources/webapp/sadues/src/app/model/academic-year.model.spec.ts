import { AcademicYear } from './academic-year.model';

describe('AcademicYear', () => {
  it('should create an instance', () => {
    expect(new AcademicYear(1, "2020/2021")).toBeTruthy();
  });
});
