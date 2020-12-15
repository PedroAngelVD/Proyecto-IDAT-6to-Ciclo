package com.demo.model;

public class DatosCanAlumSecu {

	private int PrimeroSec;
	private int SegundoSec;
	private int TerceroSec;
	private int CuartoSec;
	private int QuintoSec;
	
	public DatosCanAlumSecu() {
		super();
	}
	
	public DatosCanAlumSecu(int primeroSec, int segundoSec, int terceroSec, int cuartoSec, int quintoSec) {
		super();
		PrimeroSec = primeroSec;
		SegundoSec = segundoSec;
		TerceroSec = terceroSec;
		CuartoSec = cuartoSec;
		QuintoSec = quintoSec;
	}
	
	public int getPrimeroSec() {
		return PrimeroSec;
	}
	public void setPrimeroSec(int primeroSec) {
		PrimeroSec = primeroSec;
	}
	public int getSegundoSec() {
		return SegundoSec;
	}
	public void setSegundoSec(int segundoSec) {
		SegundoSec = segundoSec;
	}
	public int getTerceroSec() {
		return TerceroSec;
	}
	public void setTerceroSec(int terceroSec) {
		TerceroSec = terceroSec;
	}
	public int getCuartoSec() {
		return CuartoSec;
	}
	public void setCuartoSec(int cuartoSec) {
		CuartoSec = cuartoSec;
	}
	public int getQuintoSec() {
		return QuintoSec;
	}
	public void setQuintoSec(int quintoSec) {
		QuintoSec = quintoSec;
	}
	
}
