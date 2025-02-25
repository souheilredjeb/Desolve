import { Component, OnInit } from '@angular/core';
import { EnvironmentalService } from '../environmental.service';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-pollution-chart',
  templateUrl: './pollution-chart.component.html',
  styleUrls: ['./pollution-chart.component.css']
})
export class PollutionChartComponent implements OnInit {
  chart: any = []; 
  concentrationData: any[] = [];

  constructor(private environmentalService: EnvironmentalService) {}

  ngOnInit(): void {
    const requestBody = {
      u: 1.0,
      D: 0.1,
      deltaT: 0.01,
      deltaX: 0.1,
      gridLength: 10,
      maxTime: 100,
    };
    this.environmentalService.getPollutionData(requestBody).subscribe((data) => {
      this.concentrationData = data.concentration;
      this.createChart();
    });
  }

  createChart() {
    this.chart = new Chart('canvas', {
      type: 'line',
      data: {
        labels: this.concentrationData.map((_, index) => `Point ${index}`),
        datasets: [
          {
            label: 'Pollution Concentration',
            data: this.concentrationData,
            borderColor: 'rgba(75, 192, 192, 1)',
            fill: false,
          },
        ],
      },
      options: {
        scales: {
          x: {
            title: {
              display: true,
              text: 'Grid Points',
            },
          },
          y: {
            title: {
              display: true,
              text: 'Concentration',
            },
            min: 0,
            max: 1,
          },
        },
      },
    });
  }
}
