import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';  // For HTTP requests
import { EnvironmentalService } from './environmental.service';
import { Chart ,registerables } from 'chart.js';
@Component({
  selector: 'app-root',
  standalone: true,  // Marking this component as standalone
  imports: [HttpClientModule],  // Import required modules here
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'environmental-dashboard';
  chart: any = []; 
  concentrationData: any[] = [];
  constructor(private environmentalService: EnvironmentalService) {}

  ngOnInit(): void {
    Chart.register(...registerables);
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
