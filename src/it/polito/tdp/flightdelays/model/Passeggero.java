package it.polito.tdp.flightdelays.model;

public class Passeggero {
	
	private int id;
	private double ritardo;
	private int voli;
	private Airport attuale;
	
	public Passeggero(int id, Airport attuale) {
		super();
		this.id = id;
		ritardo = 0;
		voli = 0;
		this.setAttuale(attuale);
	}

	public int getId() {
		return id;
	}

	public double getRitardo() {
		return ritardo;
	}

	public void aumentaRitardo(double ritardo) {
		this.ritardo += ritardo;
	}

	public int getVoli() {
		return voli;
	}

	public void aumentaVoli(int voli) {
		this.voli += voli;
	}
	
	public Airport getAttuale() {
		return attuale;
	}

	public void setAttuale(Airport attuale) {
		this.attuale = attuale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passeggero other = (Passeggero) obj;
		if (id != other.id)
			return false;
		return true;
	}

}