package utils;



public class NormalisationLongeur {

	 public double matriceNormalise[][]=new double[150][4];
	 double tableaDeLongeur[]=new double[150];


	public NormalisationLongeur(double matr[][]) {
		
		matriceNormalise=normalisationVecteur(matr);
		 
}
	
	//fonction pour normaliser un vecteur 
	public static double[][] normalisationVecteur(double matr[][]) {
   	 
   	 
   	 double longeur[]=calculeLongeurVecteur(matr);
   	 double matriceDestination[][]=new double[150][4];
   	  	   
 	 for (int j = 0; j < matriceDestination.length; j++) {
 		
   	  for (int j2 = 0; j2 < 4; j2++) {
   		  
   		  matriceDestination[j][j2]=matr[j][j2]/longeur[j];
   	  }
   		  
		}
 	   return matriceDestination;
   	 } 
	
	
	
	//fonction pour calculer la longeur d'un vecteur  ------
	//utiliser et on garde la longeur de chaque vecteur dans un tableau
	public static double[] calculeLongeurVecteur(double monTab2[][]) {
    	double longeurVecteur=0.0;
  	   double lesLongeur[]=new double[150];
  	   for (int i = 0; i < lesLongeur.length; i++) {
  		 longeurVecteur=0.0;
		for (int j = 0; j < 4; j++) {
  		   
  		   longeurVecteur=longeurVecteur+Math.pow(monTab2[i][j],2);
  		   //System.out.println(longeurVecteur);
  	       }
  	   lesLongeur[i]=Math.sqrt(longeurVecteur);
  	   
  	   }
  	  
    	 return lesLongeur;
    	 } 
	
	
	
	
	//fonction pour calculer la Distance Euqlidienne entre deux vecteurs de méme dimantion  ------
		
		public static double DistanceEuquledienne(double v1[],double v2[]) {
	    	double distanceEuquledienne=0.0;
	  	  
	    	if (v1.length==v2.length) {
							
	    	
	  	   for (int i = 0; i < v1.length; i++) {
	  		 
				distanceEuquledienne=distanceEuquledienne + Math.pow(v1[i]-v2[i],2);
	  	   
	  	   }
	  	   
	    	}
	  	  
	    	 return Math.sqrt(distanceEuquledienne);
	    	 } 
	
	
	
	
	

}
