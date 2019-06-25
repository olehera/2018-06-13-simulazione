package it.polito.tdp.flightdelays.model;

import java.time.LocalDateTime;

public class Evento implements Comparable<Evento> {
	
	public enum TipoEvento {
		PARTENZA,
		ARRIVO
	}
	
	private LocalDateTime tempo;
	private TipoEvento tipo;
	
	public Evento(LocalDateTime tempo, TipoEvento tipo) {
		this.tempo = tempo;
		this.tipo = tipo;
	}
	
	public LocalDateTime getTempo() {
		return tempo;
	}

	public void setTempo(LocalDateTime tempo) {
		this.tempo = tempo;
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}

	@Override
	public int compareTo(Evento ev) {
		return this.tempo.compareTo(ev.tempo);
	}

}