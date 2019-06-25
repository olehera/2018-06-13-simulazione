package it.polito.tdp.flightdelays.model;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

public class Adiacenza implements Comparable<Adiacenza>{
	
	private String id1;
	private String id2;
	private double ritardo;
	private LatLng primo;
	private LatLng secondo;
	
	public Adiacenza(String id1, String id2, double ritardo, LatLng primo, LatLng secondo) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.ritardo = ritardo;
		this.primo = primo;
		this.secondo = secondo;
	}

	public String getId1() {
		return id1;
	}

	public String getId2() {
		return id2;
	}

	public double getRitardo() {
		return ritardo;
	}

	public LatLng getPrimo() {
		return primo;
	}

	public LatLng getSecondo() {
		return secondo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id1 == null) ? 0 : id1.hashCode());
		result = prime * result + ((id2 == null) ? 0 : id2.hashCode());
		result = prime * result + ((primo == null) ? 0 : primo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(ritardo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((secondo == null) ? 0 : secondo.hashCode());
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
		Adiacenza other = (Adiacenza) obj;
		if (id1 == null) {
			if (other.id1 != null)
				return false;
		} else if (!id1.equals(other.id1))
			return false;
		if (id2 == null) {
			if (other.id2 != null)
				return false;
		} else if (!id2.equals(other.id2))
			return false;
		if (primo == null) {
			if (other.primo != null)
				return false;
		} else if (!primo.equals(other.primo))
			return false;
		if (Double.doubleToLongBits(ritardo) != Double.doubleToLongBits(other.ritardo))
			return false;
		if (secondo == null) {
			if (other.secondo != null)
				return false;
		} else if (!secondo.equals(other.secondo))
			return false;
		return true;
	}

	@Override
	public int compareTo(Adiacenza a) {
		return (int) (-(ritardo/LatLngTool.distance(primo, secondo, LengthUnit.KILOMETER))+(a.getRitardo()/LatLngTool.distance(a.getPrimo(), a.getSecondo(), LengthUnit.KILOMETER)));
	}

}