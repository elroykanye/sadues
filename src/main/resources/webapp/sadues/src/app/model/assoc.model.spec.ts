import { Assoc } from './assoc.model';

describe('Assoc', () => {
  it('should create an instance', () => {
    expect(new Assoc(1, "Association", 1)).toBeTruthy();
  });
});
