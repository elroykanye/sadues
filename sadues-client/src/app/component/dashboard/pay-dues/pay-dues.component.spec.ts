import {ComponentFixture, TestBed} from '@angular/core/testing';

import {PayDuesComponent} from './pay-dues.component';

describe('PayDuesComponent', () => {
  let component: PayDuesComponent;
  let fixture: ComponentFixture<PayDuesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PayDuesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PayDuesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
