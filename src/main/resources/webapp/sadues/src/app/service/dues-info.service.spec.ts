import { TestBed } from '@angular/core/testing';

import { DuesInfoService } from './dues-info.service';

describe('DuesInfoService', () => {
  let service: DuesInfoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DuesInfoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
