import { TestBed } from '@angular/core/testing';

import { ViewTodayDealsService } from './view-today-deals.service';

describe('ViewTodayDealsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewTodayDealsService = TestBed.get(ViewTodayDealsService);
    expect(service).toBeTruthy();
  });
});
