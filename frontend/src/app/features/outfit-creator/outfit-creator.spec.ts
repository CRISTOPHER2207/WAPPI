import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OutfitCreator } from './outfit-creator';

describe('OutfitCreator', () => {
  let component: OutfitCreator;
  let fixture: ComponentFixture<OutfitCreator>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OutfitCreator]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OutfitCreator);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
