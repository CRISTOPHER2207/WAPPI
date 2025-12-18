import { TestBed } from '@angular/core/testing';

import { OutfitState } from './outfit-state';

describe('OutfitState', () => {
  let service: OutfitState;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OutfitState);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
