package it.polito.tdp.flightdelays.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class Simulatore {
	
	private PriorityQueue<Evento> queue;
	private int K;
	private int V;
	private List<Passeggero> passeggeri;
	
	private Map<String, Airport> aereoporti;
	private Random rand;
	
	public void init(int K, int V, Map<String, Airport> aereoporti) {
		
		queue = new PriorityQueue<>();
		rand = new Random();
		this.K = K;
		this.V = V;
		this.aereoporti = aereoporti;
		
		List<Airport> list = new LinkedList<>(aereoporti.values());
		passeggeri = new ArrayList<Passeggero>();
		for (int i=1; i<=K; i++)
			passeggeri.add(new Passeggero(i, list.get(rand.nextInt(list.size()))));
		
//		for ( ) 
//			queue.add(new Evento( ));
		
	}
	
	public void run() {
		
		while ( !queue.isEmpty() ) {     
			Evento ev = queue.poll();
			
//			switch (ev.getTipo()) {
			
//			case :
				
//				break;
				
//			case :
				
				break;
//			}
		}
		
	}
	
	public List<Passeggero> getPasseggeri() {
		return passeggeri;
	}

}