import { TestBed } from '@angular/core/testing';
import { Servicearticulos } from './servicearticulos';

describe('Servicearticulos', () => {
  let service: Servicearticulos;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Servicearticulos);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
