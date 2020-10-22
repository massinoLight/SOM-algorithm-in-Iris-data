package main;

import utils.NormalisationLongeur;
import utils.FonctionVecteur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import models.Node;
import models.Voisins;
import utils.FonctionMatrice;
import utils.Initialisation;

public class Main  extends FonctionMatrice  {

	public static void main(String[] args) {
		
		//la matrice initiale qui va contenir les valeurs brute récupérés par l'iris database 
		double matriceInitiale[][]=new double[150][4];
		//la matrice initiale normalisé 
		double matriceNormalise[][]=new double[150][4];
		//un tableau aléatoire
		int shuffleTable[]=new int[150];
		//normaliser la matrice aléatoire 
		double matriceAleatoire[][]=new double[150][4];
		
		//vecteur moyen centré autour de la moyenne 
		double vecteurMoyen[]=new double[4];
		double vecteurMin[]=new double[4];
		double vecteurMax[]=new double[4];
		double vecteurAleatoireAutourDeLaMoyenne[]=new double[150];
		//prendre un vecteur aléatoire du tas
		double vecteurAleatoire1[]=new double[4];
		double vecteurAleatoire2[]=new double[4];
		double vecteurAleatoire3[]=new double[4];
		
				
		double meilleurVecteur[]=new double[4];
		double levecteur[]=new double[4];
		
		Double [] tableauDesDistancesAtrier=new Double[150];
		

		//une collection de Nodes 
		ArrayList<Node> listDesNodes = new ArrayList<Node>();
		 
		 //une collection de voisins 
		 ArrayList<Voisins> Listevoisin = new ArrayList<Voisins>();
		 
		 //une collection de voisins 
		 ArrayList<Voisins> Lesvoisins = new ArrayList<Voisins>();
		 
		 //un voisin 
		 Voisins v;
		 //un node
		 Node n;
		
		
		 
		 
		Initialisation init=new Initialisation();
		matriceInitiale=init.matrice;
		
		System.out.println("---------------Données Brute--------------------------");
		afficherMatrice(matriceInitiale);
		
		
		
		FonctionVecteur traitementVecteur =new FonctionVecteur();
		shuffleTable=traitementVecteur.shuffle_table();
		
		
		matriceAleatoire=FonctionMatrice.Bdd_aléatoire(shuffleTable, matriceInitiale);
		System.out.println("---------------Données mise de façon aléatoire--------------------------");
		afficherMatrice(matriceAleatoire);
		
		
		
		NormalisationLongeur normal=new NormalisationLongeur(matriceAleatoire);
		matriceNormalise=normal.matriceNormalise;
		System.out.println("---------------les Données mise de façon aléatoire et Normalisé --------------------------");
		afficherMatrice(matriceNormalise);
		
		
		
		vecteurMoyen=traitementVecteur.vecteurMoyen(matriceNormalise);
		traitementVecteur.vminVmax(vecteurMoyen, vecteurMin, vecteurMax);
		
		traitementVecteur.tableAleatoireAutourDeLaMoyenne(vecteurAleatoireAutourDeLaMoyenne, vecteurMin, vecteurMax);
		
		
		
		vecteurAleatoire1=traitementVecteur.unVecteurAleatoire(vecteurAleatoireAutourDeLaMoyenne, shuffleTable);
		vecteurAleatoire2=traitementVecteur.unVecteurAleatoire(vecteurAleatoireAutourDeLaMoyenne, shuffleTable);
		vecteurAleatoire3=traitementVecteur.unVecteurAleatoire(vecteurAleatoireAutourDeLaMoyenne, shuffleTable);

		
		
		
		 //* *************************lancement de l'algorithme SOM*********************************************************
		 
		
		/***
		1*commencer par calculer les distances Euqulidienne 
		entre un vecteur choisit alétoire de notre matrice normalise et les trois vecteurs aléatoire 
		*/
		
		
		//c est ici qu on doit boucler -------------------------------------------------!!!!!!!!!
		
		
		//on prend un vecteur aléatoirement de la matrice normalisé
		levecteur=matriceNormalise[shuffleTable[0]];
		//on charche le vecteur le plus proche de lui parmis les trois vecteurs pris aléatoirement 
		meilleurVecteur=VecteurLePlusProche(levecteur,vecteurAleatoire1,vecteurAleatoire2,vecteurAleatoire3,normal);
		
		//on va chercher les voisins de ce vecteurs et les garder dans une collection triée 
			
					
			/**
			 * on va calculer toute les ditances Euclidienne du vecteur aléatoire 
			 * avec chacun des vecteurs de la matrice normalisé 
			*/
			for (int j = 0; j < tableauDesDistancesAtrier.length; j++) {
								
				tableauDesDistancesAtrier[j]=normal.DistanceEuquledienne(levecteur,matriceNormalise[j]);
				v=new Voisins(tableauDesDistancesAtrier[j],matriceNormalise[j]) ;
				Listevoisin.add(v);
				
			}
		          
            //trier la liste des voisins selon leur distance 
           Collections.sort(Listevoisin);  
           
   		   double d1=normal.DistanceEuquledienne(levecteur, meilleurVecteur);
   		   
   		   //garder iniquement 5 voisins 
   		   for (int i = 0; i < 6; i++) {
   			Lesvoisins.add(i,Listevoisin.get(i));
			
		}
   		   
   		   //trier selon la classe de fleur ici 3 classes possible 
   		   
   		   if (normal.DistanceEuquledienne(meilleurVecteur, vecteurAleatoire1)==0.0) {
   			n=new Node(levecteur,meilleurVecteur,d1,Lesvoisins,1);
			
		} else {
			if (normal.DistanceEuquledienne(meilleurVecteur, vecteurAleatoire2)==0.0) {
				n=new Node(levecteur,meilleurVecteur,d1,Lesvoisins,2);
				
			} else {

				n=new Node(levecteur,meilleurVecteur,d1,Lesvoisins,3);
			}

		}

           
           
           listDesNodes.add(n);
          
           
           
           
           
        	n.afficheNode(listDesNodes);
            
            
		
	
		

	}
	
	
public static double[] VecteurLePlusProche(double unVecteur[],double vecteur1[],
		double vecteur2[],double vecteur3[],NormalisationLongeur normal) {
		
		double meilleur[] = new double[150];
		
		double d1=0.0;
		double d2=0.0;
		double d3=0.0;
		double temp=0.0;
		
		d1=normal.DistanceEuquledienne(vecteur1, unVecteur);
		d2=normal.DistanceEuquledienne(vecteur2, unVecteur);
		d3=normal.DistanceEuquledienne(vecteur3, unVecteur);
		
		temp=Math.min(d1, d2);
		temp=Math.min(temp, d3);
		
		
		//on atribue au node le vecteur le plus proche ainsi que les neighborhoods
		if (temp==d1) {
			meilleur=vecteur1;
			
		} else {
			if (temp==d2) {
				meilleur=vecteur2;
				
			} else {
				meilleur=vecteur3;
			}

		}
			
		return meilleur;
		
		
		
	} 
	
	
	
	

}
