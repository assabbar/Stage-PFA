import { TestBed } from '@angular/core/testing';

import { DataTableInterconsultationService } from './data-table-interconsultation.service';

describe('DataTableInterconsultationService', () => {
  let service: DataTableInterconsultationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DataTableInterconsultationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
