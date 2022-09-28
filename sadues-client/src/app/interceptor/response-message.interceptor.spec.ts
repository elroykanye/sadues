import { TestBed } from '@angular/core/testing';

import { ResponseMessageInterceptor } from './response-message.interceptor';

describe('ResponseMessageInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      ResponseMessageInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: ResponseMessageInterceptor = TestBed.inject(ResponseMessageInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
