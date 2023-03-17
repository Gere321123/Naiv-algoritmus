import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.sqrt;


public class Naiv_algoritmus {

    public static void main(String[] args) throws IOException {
        System.out.println("Meddig irjuk ki a primszamokat? (ajanlot 1.000.000 az is egy pillanat alatt meglesz)");
        Scanner myObj = new Scanner(System.in);
        int meddig = 0;
        try {
           meddig = myObj.nextInt();
           if (meddig<2){
               System.out.println("Rossz az input!");
               System.exit(0);
           }
        }
     catch (InputMismatchException e){
         System.out.println("Rossz az input!");
     }
        int prim[] = new int[meddig];
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

        while (  k < meddig) {

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
        System.out.println("Osszetett szamok kiszelektalasa");
        while (prim[k]< sqrt(meddig)){
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
   try{
        FileWriter fw=new FileWriter("prims.txt");
        PrintWriter pw = new PrintWriter(fw);
        i= 0;
        while (i<=maxi){
            p=String.valueOf(prim[i]);
            pw.println(p);
            i++;
        }
        fw.close();
        pw.close();
   } catch (IOException ioe){
       System.out.println("Valami hiba van a fajl feltoltessel!");

   }
        System.out.println("A primszamokat kiirta a program a fajba");
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
