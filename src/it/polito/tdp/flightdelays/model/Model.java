package it.polito.tdp.flightdelays.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.flightdelays.db.FlightDelaysDAO;

public class Model {

	private FlightDelaysDAO dao;
	private List<Airline> linee;
	private Map<String, Airport> aereoporti;
	private Graph<Airport, DefaultWeightedEdge> grafo;
	private List<Adiacenza> adiacenze;
	private Simulatore sim;
	
	public Model() {
		dao = new FlightDelaysDAO();
		linee = dao.loadAllAirlines();
		aereoporti = new HashMap<>();
		dao.loadAllAirports(aereoporti);
	}
	
	public List<Airline> caricaLinee() {
		return linee;
	}
	
	public void creaGrafo(Airline scelta) {
		grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(grafo, aereoporti.values());
		
		adiacenze = dao.adiacenze(scelta.getId());
		
		for (Adiacenza a: adiacenze) {
			double distanza = LatLngTool.distance(a.getPrimo(), a.getSecondo(), LengthUnit.KILOMETER);
			
			double peso = a.getRitardo()/distanza;
			
			Graphs.addEdge(grafo, aereoporti.get(a.getId1()), aereoporti.get(a.getId2()), peso);
		}
		
	}
	
	public String peggioriRotte() {
		String s = "Le 10 peggiori Rotte:\n";
		
		Collections.sort(adiacenze);
		for (int i=0; i<10; i++)
			s += adiacenze.get(i).getId1()+" - "+adiacenze.get(i).getId2()+"\n";
		
		return s;
	}
	
	public List<Passeggero> simula(int K, int V) {
		
		sim = new Simulatore();
		sim.init(K, V, grafo);
		sim.run();
		
		return sim.getPasseggeri();
	} 

}