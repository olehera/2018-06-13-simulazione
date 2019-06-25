package it.polito.tdp.flightdelays.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Simulatore {
	
	private PriorityQueue<Evento> queue;
	private int K;
	private int V;
	private List<Passeggero> passeggeri;
	
	private Graph<Airport, DefaultWeightedEdge> grafo;
	private Random rand;
	
	public void init(int K, int V, Graph<Airport, DefaultWeightedEdge> grafo) {
		
		queue = new PriorityQueue<>();
		rand = new Random();
		this.grafo = grafo;
		this.K = K;
		this.V = V;
		
		passeggeri = new ArrayList<Passeggero>();
		for (int i=1; i<=K; i++)
			passeggeri.add(new Passeggero(i, ));
		
		for ( ) 
			queue.add(new Evento( ));
		
	}
	
	public void run() {
		
		while ( !queue.isEmpty() ) {     
			Evento ev = queue.poll();
			
			switch (ev.getTipo()) {
			
			case :
				
				break;
				
			case :
				
				break;
			}
		}
		
	}
	
	public List<Passeggero> getPasseggeri() {
		return passeggeri;
	}

}