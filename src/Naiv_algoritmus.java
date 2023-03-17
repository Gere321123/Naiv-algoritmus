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
        Elem e = new Elem(meddig);
        e.setPrimInAPosicion(0,2);
        e.setPrimInAPosicion(1,3);
        int max = 2;
        e=(szamhalmaz_felirasa(e.getPrim(),meddig,max));

        System.out.println("Osszetett szamok kiszelektalasa");
        e=(osszetett_szamok_kisszelektalasa(e,meddig));
        fajba_iras(e);
    }

    private static void fajba_iras(Elem e){
        String p;
        try{
            FileWriter fw=new FileWriter("prims.txt");
            PrintWriter pw = new PrintWriter(fw);
           int i= 0;
            while (i<e.getMaxi()){
                p=String.valueOf(e.getPrimInPosicion(i));
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

    private static Elem osszetett_szamok_kisszelektalasa(Elem e,int meddig) {
        int k = 0;
        int i = 0;
        while (e.getPrimInPosicion(k)< sqrt(meddig)){
            if (e.getPrimInPosicion(i) % e.getPrimInPosicion(k) == 0 && e.getPrimInPosicion(k)!=e.getPrimInPosicion(i)){

                e.setPrim(szelektalas(e.getPrim(),i,e.getMaxi()));
                e.setMaxi(e.getMaxi()-1);
                i=i-1;
            }

            if (i==e.getMaxi()) {

                i=k;
                k++;
            }
            i++;
        }
        e.setMaxi(e.getMaxi()+1);
        return e;
    }

    private static Elem szamhalmaz_felirasa(int[] prim,int meddig,int max) {
        int k = 3;
        int j = 1;
        int i = 2;
        int o =2;
        int maxi = 2;
        int g = 0;
        int a=1;
        int pf = 2;
        int ik = 2;
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
     Elem d = new Elem(prim,i);
        return d;
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
