import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PollutionChartComponent } from './pollution-chart.component';

describe('PollutionChartComponent', () => {
  let component: PollutionChartComponent;
  let fixture: ComponentFixture<PollutionChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PollutionChartComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PollutionChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
