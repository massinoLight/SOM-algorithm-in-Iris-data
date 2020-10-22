package models;

import java.util.ArrayList;
import java.util.List;


import utils.FonctionVecteur;

public class Voisins extends FonctionVecteur implements Comparable<Voisins>{
	
	double distance ;
	double jesuis[]=new double[4];
	
	
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double[] getJesuis() {
		return jesuis;
	}
	public void setJesuis(double[] jesuis) {
		this.jesuis = jesuis;
	}
	
	
	public Voisins(double distance, double[] jesuis) {
		super();
		this.distance = distance;
		this.jesuis = jesuis;
	}
	
	public Voisins() {
		
	}
	
	
	
	/**
	 * une fonction qui permet 
	 * d'afficher les nodes d'une liste 
	 * passé en paramétre 
	 * **/
	
	public void afficheVoisin(List<Voisins> list) {
		Voisins prov=new Voisins();
		double v1[],v2;
		
		for (int i = 0; i < list.size(); i++) {
			prov=list.get(i);
			v1=prov.jesuis;
			v2=prov.distance;
			System.out.println();
			afficherVecteur(v1);
			
		}
		
	}
	/***
	 * fonction pour comparer les distances
	 * afin de pouvoir trier la liste 
	 * 
	 * ****/
	
	@Override
	public int compareTo(Voisins arg0) {
		// TODO Auto-generated method stub
		return new Double(distance).compareTo( arg0.distance);
	}
	
	
	

}
