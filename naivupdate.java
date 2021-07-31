/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naiv2.pkg0;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Acer
 */
public class Naiv20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
             int prim[] = new int[10000000];
       prim[0]=2;
       prim[1]=3;
      int pf = 2;
      int o =2;
      int j = 1;
      int i = 2;
      int g = 0;
      int k = 3;
      int max = 2;
      int maxi = 2;
      int ii=0;
      int ik =i;
      
     int a=1;
      
        while (  k < 1000000 ) {
           
            if (max<prim[g]){   
                  ik=i;             
        prim[i] = pf+prim[g];
        o++;
      // System.out.println(prim[i]);
     k=prim[i];
     
   
     holtart (k,a,o);
     if (k>a*100000){
     a++;
     }
     
        g = g+1;
            }else{
              
                i=i-1;
            g = g+1;
            }
        if (prim[ik]>pf*prim[j]){
            pf = pf*prim[j];
            max = prim[j];
      
            j=j+1;
            maxi=ik;
            ik=0;                                 
                   while (ik<maxi)
                   {
                     
                  if (prim[ik] % max == 0 && max!=prim[ik]){
                      
                    prim=szelektalas(prim,ik,maxi);
                      maxi=maxi-1;
                      i=i-1;
                  }
                   ik++;
                   }
              g=0;
            
        }
         i = i+1;
     
        
        }

     maxi = i;
    k = 0;
    i = 0;
    System.out.println("Osszetett szamok kisyelektalasa");
    while (prim[k]<1000){
   if (prim[i] % prim[k] == 0 && prim[k]!=prim[i]){
                    
                  prim=szelektalas(prim,i,maxi);
                      maxi=maxi-1;
                      i=i-1;
                  }

    if (i==maxi) {
        
    i=k;
    k++;
    }
                   i++;
    }
    maxi=maxi+1;
   
    String p;
   
           FileWriter fw=new FileWriter("D:\\Matek\\Prim szamok\\prims.txt");  
           PrintWriter pw = new PrintWriter(fw);
           i= 0;
           while (i<=maxi){
              p=String.valueOf(prim[i]); 
           pw.println(p);   
           i++;
           }
           fw.close();    
        pw.close(); 
    }
     public static void holtart(int k,int a, int o){
     if (k>a*100000){
      System.out.println(a+"00.000 ig eddig fut le =  "+o);
     }
     }
       public static int[] szelektalas(int p[], int i, int maxi){
                      while (i<maxi){
                  p[i]=p[i+1];
                  i++;
                
                          }          
    return p;
     }

}
