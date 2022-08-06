import {DuesInfo, DuesInfoKey} from './dues-info.model';

describe('DuesInfo', () => {
  it('should create an instance', () => {
    expect(new DuesInfo(new DuesInfoKey(1, 2), 3000)).toBeTruthy();
  });
});
