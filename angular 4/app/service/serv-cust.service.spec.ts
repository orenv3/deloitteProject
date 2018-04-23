import { TestBed, inject } from '@angular/core/testing';

import { ServCustService } from './serv-cust.service';

describe('ServCustService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServCustService]
    });
  });

  it('should be created', inject([ServCustService], (service: ServCustService) => {
    expect(service).toBeTruthy();
  }));
});
