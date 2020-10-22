package models;

import java.util.ArrayList;
import java.util.List;


import utils.FonctionVecteur;

public class Node extends FonctionVecteur{
	double vacteurEnQuestion[];
	String Etiquette;
	double DistanceEuqlidenne;
	double meilleurVecteur[];
	ArrayList<Voisins> lesNeighborhoods ;
	int classe;
	
	//un constructeur vide
		public Node() {
		}
		
		
		
		/***
		 * le constructeur des Nodes 
		 * qui va prendre en paramétres un vecteur une etiquette 
		 * une distance euqulidienne
		 * et le vecteur en question 
		 * 
		 * **/
		
		public Node(double vecteur[],String etiquette,double distance,double proche[],ArrayList<Voisins> LesVoisins ) {
			this.vacteurEnQuestion=vecteur;
			this.Etiquette=etiquette;
			this.DistanceEuqlidenne=distance;
			this.meilleurVecteur=proche;
			this.lesNeighborhoods=LesVoisins;
			
			
		}
		
		public Node(double vecteur[],double proche[],double distance,ArrayList<Voisins> LesVoisins ,int classe) {
			this.vacteurEnQuestion=vecteur;
			this.DistanceEuqlidenne=distance;
			this.meilleurVecteur=proche;
			this.lesNeighborhoods=LesVoisins;
			this.classe=classe;
			
			
		}
		
		
		
		
		/**
		 * une fonction qui permet 
		 * d'afficher les nodes d'une liste 
		 * passé en paramétre 
		 * **/
		
		public void afficheNode(List<Node> list) {
			Node prov=new Node();
			ArrayList<Voisins> pro=new ArrayList<Voisins>();
			Voisins v=new Voisins();
			double v1[],v2[];
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println();
				System.out.println("***************Node"+i+"************************");
				prov=list.get(i);
				v1=prov.vacteurEnQuestion;
				v2=prov.meilleurVecteur;
				pro=prov.lesNeighborhoods;
				System.out.println("je suis le vecteur ");
				afficherVecteur(v1);
				System.out.println();
				System.out.println("mes voisins sont ");
				System.out.println();
				v.afficheVoisin(pro);
				
				System.out.println("|");
				System.out.println("et le meilleur vecteur est ");
				afficherVecteur(v2);
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("************************************************");
				
			}
			
		}
		
		
	
	

}
