package utils;

public class FonctionMatrice {
	
	
	//afficher une matrice
    public static void afficherMatrice(double monTab2[][]) {
   	 for(int i = 0 ; i < monTab2.length; i++ ){  
   		 System.out.println(monTab2[i][0]+"  "+monTab2[i][1]+"  "+monTab2[i][2]+"  "+monTab2[i][3]);
   	 
   	}   
   	 }  
   	 
    //afficher un tableau
    public static void afficherTableau(double monTab2[]) {
   	 
   	     for(int j = 0; j< monTab2.length; j++){   
   	    	 System.out.println(monTab2[j]); 
   	     }  
   	
   	 }  
    
    //afficher un tableau
    public static void afficherTableauInt(int monTab2[]) {
   	 
   	     for(int j = 0; j< monTab2.length; j++){   
   	         System.out.print(monTab2[j]+"|"); 
   	     }  
   	
   	 } 

    
    
    
    /**
	 * une fonction qui retourne une nvlle bdd
	 * aléatoire a partir d'un tableau suffle table
	 *  
	 * **/
    
    
    
    public static double[][] Bdd_aléatoire(int tableau[],double matBdd[][]) {
		
    	double matrRetour[][]=new double[150][4];;
    		
    	for (int i = 0; i < matBdd.length; i++) {
    		
    		matrRetour[i][0]=matBdd[tableau[i]][0];
    		matrRetour[i][1]=matBdd[tableau[i]][1];
    		matrRetour[i][2]=matBdd[tableau[i]][2];
    		matrRetour[i][3]=matBdd[tableau[i]][3];
    		
    	}
    	
    		return matrRetour;
    		
    		
    	}
    	
    	

    /**
     * une fonction qui retourn une valeurs
     * de la base de données passé en paramétre de façon 
     * aléatoire a partir d'un indice du tableau de suffle
     *  
     * **/

         public static double[] Vecteur_aleatoire_deLaBdd(int ind,double matBdd[][]) {
    	
           double matrRetour[]=new double[4];
    	
           
    	
    	matrRetour[0]=matBdd[ind][0];
    	matrRetour[1]=matBdd[ind][1];
    	matrRetour[2]=matBdd[ind][2];
    	matrRetour[3]=matBdd[ind][3];
    	

    	return matrRetour;
    	
    	
    }
         
         /**
          * cette fonction retourn les distances euclidiennes d'un 
          * vecteur passé en paramétre 
          * et d'une matrice 
          * 
          * **/
    	
    	public static double distance_euclidienne(double t1[],double t2[]) {
    		
    		
    		double somme=0.0;
    		
    		for (int i = 0; i < t1.length; i++) {
    			
    			somme=somme+Math.pow(t1[i]-t2[i],2);
    			
    		}
    	
    		return Math.sqrt(somme);
    	}
    	
    	/**
    	 * 
    	 * une fonction qui retourn un vecteur de la bdd qui a la plus petite 
    	 * distance Euclidienne entre le vecteur passé
    	 * en paramétre 
    	 * ****/
    	
    	
    public static double[] plus_petite_distance_euclidienne(double t1[],double t2[][],int ind) {
    		
    	double meilleurVecteur[]=new double[4];
    	double distance=0.0;
    	double petite=0.0;
    	distance=distance_euclidienne(t1,t2[0]);
    	petite=distance;
    	
    	for (int i = 1; i < ind; i++) {
    		distance=distance_euclidienne(t1,t2[i]);
    		
    		if (distance<petite) {
    			petite=distance;
    			meilleurVecteur=t2[i];
    			
    		}
    		
    	}
    	for (int i =ind+1; i < t2.length; i++) {
    		distance=distance_euclidienne(t1,t2[i]);
    		
    		if (distance<petite) {
    			petite=distance;
    			meilleurVecteur=t2[i];
    			
    		}
    		
    	}
    	
    	
    	
    		return meilleurVecteur;
    	}
    	
    	
	

}
