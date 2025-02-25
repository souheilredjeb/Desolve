package com.environmental.model;

public class EnvironmentalMetrics 
{
	private double u; // Advection velocity
	private double D; // Diffusion coefficient
	private double deltaT; // Time step size
	private double deltaX; // Space step size
	private int gridLength; // Number of grid points
	private int maxTime; // Max time steps

	public EnvironmentalMetrics() {
		// TODO Auto-generated constructor stub
	}
	
	

	public EnvironmentalMetrics(double u, double d, double deltaT, double deltaX, int gridLength, int maxTime) {
		super();
		this.u = u;
		this.D = d;
		this.deltaT = deltaT;
		this.deltaX = deltaX;
		this.gridLength = gridLength;
		this.maxTime = maxTime;
	}



	public double getU() {
		return u;
	}

	public void setU(double u) {
		this.u = u;
	}

	public double getD() {
		return D;
	}

	public void setD(double d) {
		this.D = d;
	}

	public double getDeltaT() {
		return deltaT;
	}

	public void setDeltaT(double deltaT) {
		this.deltaT = deltaT;
	}

	public double getDeltaX() {
		return deltaX;
	}

	public void setDeltaX(double deltaX) {
		this.deltaX = deltaX;
	}

	

	public int getGridLength() {
		return gridLength;
	}



	public void setGridLength(int gridLength) {
		this.gridLength = gridLength;
	}



	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}
	
	

}
