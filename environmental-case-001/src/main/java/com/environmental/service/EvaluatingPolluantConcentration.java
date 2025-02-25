package com.environmental.service;

import com.environmental.model.*;
import org.springframework.stereotype.Service;


@Service
public class EvaluatingPolluantConcentration {

	public EvaluatingPolluantConcentration() {
		// TODO Auto-generated constructor stub
	}
	
	public PolutionEvaluation calculateConcentration(EnvironmentalMetrics metrics) {
	    double u = metrics.getU();
	    double D = metrics.getD();
	    double deltaT = metrics.getDeltaT();
	    double deltaX = metrics.getDeltaX();
	    int N = metrics.getGridLength();
	    int maxTime = metrics.getMaxTime();

	    // Validate that N is a positive integer
	    if (N <= 0) {
	        throw new IllegalArgumentException("N must be a positive integer.");
	    }

	    // Initialize concentration array
	    double[] C = new double[N];
	    for (int i = 0; i < N; i++) {
	        C[i] = 0.0;  // Initial concentration
	    }

	    // Set initial condition (e.g., pollutant is concentrated at the middle)
	    C[N / 2] = 1.0;

	    // Set boundary conditions (fixed concentration at the boundaries)
	    C[0] = 0.0;
	    C[N - 1] = 0.0;

	    // Compute lambda and mu
	    double lambda = (u * deltaT) / (2 * deltaX);
	    double mu = (D * deltaT) / (deltaX * deltaX);

	    // Time-stepping loop
	    for (int t = 0; t < maxTime; t++) {
	        double[] C_new = new double[N];  // Create a temporary array for updated concentrations

	        // Update the interior grid points
	        for (int i = 1; i < N - 1; i++) {
	            C_new[i] = C[i] + deltaT * (lambda * (C[i + 1] - C[i - 1]) + mu * (C[i + 1] - 2 * C[i] + C[i - 1]));
	        }

	        // Boundary conditions remain unchanged
	        C_new[0] = 0.0;
	        C_new[N - 1] = 0.0;

	        // Copy the updated concentrations into the original array
	        System.arraycopy(C_new, 0, C, 0, N);
	    }

	    // Return the result as a response
	    PolutionEvaluation evaluation = new PolutionEvaluation();
	    evaluation.setConcentration(C);
	    return evaluation;
	}
}
