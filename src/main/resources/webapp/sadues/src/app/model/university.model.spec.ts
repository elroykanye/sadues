import { University } from './university.model';

describe('University', () => {
  it('should create an instance', () => {
    expect(new University(1, "University of Bamenda", "Bambili", false)).toBeTruthy();
  });
});
