import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable,of } from 'rxjs';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root',
})
export class EnvironmentalService {
  private apiUrl = 'http://localhost:8080/api/evaluate'; // Replace with your actual API endpoint

  constructor(private http: HttpClient) {}

  getPollutionData(requestBody: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, requestBody).pipe(
      catchError((error) => {
        console.error('Error fetching pollution data', error);
        return of({ concentration: [] }); // Return an empty array in case of error
      })
    );
  }
}
