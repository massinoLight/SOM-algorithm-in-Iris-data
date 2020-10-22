package utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FonctionVecteur {
	

	/**
	 * Calcule du vecteur moyen
	 * comme résultat on aura 
	 * un tableau de 4 cases qui va représenter 
	 * la moyenne des valeurs colléctées dans la BDD
	 * 
	 * ***/
	
	
	public static double[] vecteurMoyen(double matrice[][]) {
		double vecteurMoy[]=new double[4];
		double v=0.0;
		int j ;
		
			for (int i = 0; i < 4; i++) {
				
			
			for ( j = 0; j < 149; j++) {
				
				v=v+matrice[j][i];
			}
			vecteurMoy[i]=v/j;
		
			}
		
		return vecteurMoy;
		
	}
	
	/**
	 * Calcule des vecteurs Min et Max 
	 * autours de la Moyenne
	 * et les garder dans des tableaux
	 * ***/
	public static void vminVmax(double vmoyen[],double vmin[],double vmax[]) {
		
		for(int a=0;a<vmoyen.length;a++) {
			vmin[a]=vmoyen[a]-0.005;
			vmax[a]=vmoyen[a]+0.005;
			
		}
		
		
	}
	
	/**
	 * Génération d'un tableau aléatoire 
	 * centré autours de la moyenne 
	 * comme retours on  aura un tableau de 150 cases 
	 * qui va contenir pour chaque case une valeur généré aléatoirement 
	 * entre (VecteurMin,VecteurMax)
	 * 
	 * 
	 * ***/
	
	
	public static void tableAleatoireAutourDeLaMoyenne(double vAleatoire[],double vmin[],double vmax[]) {
		
		double random=0.0;
		int h=0;
		for(int a=0;a<vAleatoire.length;a++) {
			
			
				if (h==4) {
					h=0;
				}
				random = ThreadLocalRandom.current().nextDouble(vmin[h], vmax[h]);
				
				if (random>1) {
					random=random-1;
					
				}	
				vAleatoire[a]=random;
			h++;
			
			
		}
		
		
	}
	
	/**
	 * generation d'un tableau aleatoire
	 * shuffle table 
	 * 
	 * ***/
	
	public static int[] shuffle_table() {
		
		int tableau[] = new int[150];
		//remplire le tableau
		for (int i = 0; i < tableau.length; i++) {
			tableau[i]=i;
		}
		
		
			Random c=new Random();
			int al=c.nextInt(149);
			
			int prov=0;
			//mettre le tableau de magniére aleatoire 
			for (int i = 0; i < tableau.length; i++) {
				prov=tableau[i];
				tableau[i]=tableau[al];
				tableau[al]=prov;
				c=new Random();
				 al=c.nextInt(149);
			}
			
		return tableau;
		
		
		
	}

	
	
/***
 * 
 * une fonction qui retourne 
 * un vecteur a 4 dim aléatoire a paritir d'un vecteur centré autour de la moyenne 
 * et d'un shuffle table 
 * 
 * ****/
	
public static double[] unVecteurAleatoire(double vAleatoire[],int shuffleTable[]) {
		
		double tableau[] = new double[4];
		
		for (int i = 0; i < tableau.length; i++) {
			tableau[i]=vAleatoire[shuffleTable[i]];
		}
		return tableau;
		
		
		
	}
	

/****
 * 
     * Cette methode tri le tableau.
     * Le tri est fait comme le tri slection, mais a chaque tour de la boucle
     * interne, vous devez choisir le minimum et le maximum.
     * Lorsque la boucle interne les a trouve, alors elle les places au bon
     * endroit.
 * 
 * 
 *  @param tab Le tableau a trier.
     * @param <E> Le type des elements du tableau.  Le tri utilise le comparateur
     *           de ce type (Comparable).
 * */


		public static < E extends Comparable< E > >
			void triDoubleSelection( E [] tab ) {
			
			int n=tab.length;
			for (int i = 0, j = n - 1; i < j; i++, j--)  
			{ 
					E min = tab[i], max = tab[i]; 
					int min_i = i, max_i = i; 
					for (int k = i; k <= j; k++)  
					{ 
						if (tab[k].compareTo(max) > 0) 
							{ 
							max = tab[k]; 
							max_i = k; 
							}  
              
						else if (tab[k].compareTo(min) < 0)  
						{ 
							min = tab[k]; 
							min_i = k; 
						} 
					} 
  
        
        changer(tab, i, min_i); 
        
        if (tab[min_i] == max)  
        	changer(tab, j, min_i); 
        else
        	changer(tab, j, max_i); 
    } 
	 

}
	/**
	 * cette fonction permet d'inverser entre deux
	 * cases du tableu 
	 * son role est d'uniquement rendre plus lisible le  code 
	 * son cout en complexité est prit en compt 
	 * cout(changer)=4
	 * 
	 * **/
	public static < E extends Comparable< E > >
		E[] changer( E [] T, int i, int j) 
		{ 
    E temp = T[i]; 
    T[i] = T[j]; 
    T[j] = temp; 
    return T; 
		}  







	
	
	
	 //afficher un vecteur
    public static void afficherVecteur(double monTab2[]) {
   	 
   	     for(int j = 0; j< monTab2.length; j++){   
   	    	 System.out.print(monTab2[j]+" | "); 
   	     }  
   	
   	 }  
    
    
  //afficher un vecteur
    public static void afficherVecteur(Double monTab2[]) {
   	 
   	     for(int j = 0; j< monTab2.length; j++){   
   	    	 System.out.print(monTab2[j]+" | "); 
   	     }  
   	
   	 }  

	
	

}
