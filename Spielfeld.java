
/**
 * Beschreiben Sie hier die Klasse Spielfeld.
 * 
 * @author Emil Hofmann, Charlotte Geißler
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.Scanner ;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Random;
import java.awt.Color;

public class Spielfeld
{
    int width = 1000;
    int length = 1000; 
    public int x;
    public int y;
    public int n;
    public int i;
    public int j;
    public int d;
    public int w;
    public int v;
    public int k;
    public int l;
    public int m;
    public int xp;
    public int yp;
    public int o;
    public int c;
    public int h;
    public int q;
    public int breite;
    public int laenge;
    public int yy;
    public int xy;
    public int yx;
    public double a;
    public double p;
   
   
    public Spielfeld()
    {
    
    }
    
    public Punkt[] punktEingabe()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Anzahl der Punkte:");
        n = scanner.nextInt(); //Anzahl Punkte eintragen
        Punkt[] poi = new Punkt[n]; //Arraylänge def. , poi = point of interest
        
        for ( i = 0; i < n; i++)
        {
            System.out.println(i + ". Punkt x-Wert:") ;
            x = scanner.nextInt();
            if (x>1000) 
            { 
                JOptionPane.showMessageDialog(null, "Wert liegt nicht im Spielfeld!", "Fehlermeldung", JOptionPane.PLAIN_MESSAGE);
                System.out.println(i + ". Punkt neuer x-Wert:") ;
                x = scanner.nextInt();
            }
            
            System.out.println(i + ". Punkt y-Wert:") ;
            y = scanner.nextInt();
            if (y>1000) 
            { 
                JOptionPane.showMessageDialog(null, "Wert liegt nicht im Spielfeld!", "Fehlermeldung", JOptionPane.PLAIN_MESSAGE);
                System.out.println(i + ". Punkt neuer y-Wert:") ;
                y = scanner.nextInt();
            }
            poi[i] = new Punkt(x,y);
        }
      
        return poi;
        
        }
    /*    public void poiSortieren (Punkt[] poi)
        {
            
            double Abstand0[] = new double[n-1];
            for (j = 0; j < n-1; j++)   
            {
                int x0 = poi[0].x;
                int y0 = poi[0].y;
                int e = j + 1;
                int xi = poi[e].x;
                int yi = poi[e].y;
            
                Abstand0[j] = Math.sqrt(Math.pow(xi-x0, 2) + Math.pow(yi-x0, 2));
                
            }
            Arrays.sort(Abstand0);
            a = Abstand0[0];
            System.out.println("kürzester Abstand:" + a);
            //Abstand aller Punkte zum Roboter berechnen und aufsteigend sortieren 
            double Verleich0[] = new double[n-1];
            for (k = 0; k < n-1; k++)   
            {
                int x0 = poi[0].x;
                int y0 = poi[0].y;
                int e = k + 1;
                int xi = poi[e].x;
                int yi = poi[e].y;
            
                double b = Math.sqrt(Math.pow(xi-x0, 2) + Math.pow(yi-x0, 2));
                
                if(a == b)
                {
                     d = k;
                }
            }
            //vergleichen der berechneten Werten mit Vergleichsmethode, um herauszufinden, welcher Punkt der nächste ist
            
            System.out.println(d+1 + ". Punkt");  
            
            //Schleife?
            
            for (v = 0; v < n-2;v++)
            {   
                
                double Abstand[] = new double[n-1];
                for (l = 0; l < n-1; l++)   
                {
                    c = l + 1;
                    if (l == d)
                    {
                        xp = 100000;
                        yp = 100000;
                    }
                    else 
                    {
                        xp = poi[c].x;
                        yp = poi[c].y;
                    }
                    int x0 = poi[d].x;
                    int y0 = poi[d].y;
                
                    Abstand[l] = Math.sqrt(Math.pow(xp-x0, 2) + Math.pow(yp-y0, 2));
                }                
                Arrays.sort(Abstand);
                p = Abstand[0];
                System.out.println("kürzester Abstand:" + p);
            
                double Verleich[] = new double[n-1];
                for (o = 0; o < n-1; o++)   
                {
                    int x0 = poi[d].x;
                    int y0 = poi[d].y;
                    int f = o + 1;
                    int xi = poi[f].x;
                    int yi = poi[f].y;
            
                    double b = Math.sqrt(Math.pow(xi-x0, 2) + Math.pow(yi-x0, 2));
                
                    if(p == b)
                    {
                        w = o;
                    }
                }
                System.out.println(w+1 + ". Punkt");  
                d=w;
            }
       }*/
       public void hindernislisteErzeugen()
       {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Anzahl der Hindernisse:");
           h = scanner.nextInt(); //Anzahl Hindernisse eintragen
          /* int hindernis[][] = new int [h][5];
           Random l = new Random();
           Random br = new Random();
           Random xx = new Random();
           Random yy = new Random();
           Random red = new Random();
           Random green = new Random();
           Random blue = new Random();
           //System.out.println("test1");
           for (q = 0; q < h-1; q++)
           {
              hindernis [q][0] = xx.nextInt(999) + 1;
              Color color;
              xy = hindernis [q][0];
              hindernis [q][1] = yy.nextInt(999) + 1;
              yx = hindernis[q][1];
              if (xy > 900)
              {
                  hindernis[q][2] = l.nextInt(999-xy) +1;
              } 
              else if (yx > 900)
              {
                  hindernis [q][3] = br.nextInt(999-yx) +1;
              }
              else
              {
                   hindernis [q][2] = l.nextInt(99) + 1;
                   hindernis [q][3] = br.nextInt(99) + 1;
              }
              int r = red.nextInt(255);
              int g = green.nextInt(255);
              int b = blue.nextInt(255);
             // hindernis[q][4] = new Color(r,g,b);
              
              //System.out.println("S1");
            }
           //System.out.println("test2");
           for (j = 0; j < h-1; j++) 
           {
               System.out.println("länge hindernis " + j+1 + ": " + hindernis[j][0]);
               System.out.println("breite hindernis " + j+1 + ": " + hindernis[j][1]);
               System.out.println("x wert hindernis " + j+1 + ": " + hindernis[j][2]);
               System.out.println("y wert hindernis " + j+1 + ": " + hindernis[j][3]);
               System.out.println("color")
               System.out.println("S2");
            }
            System.out.println("test3");
            */
           
        }
        private int zufallszahlen(int laenge, int breite)
        {
            Random l  = new Random();
            Random br = new Random();
            Random xx = new Random();
            Random yy = new Random();
            for (q = 0; q < h-1; q++)
            {
              x = xx.nextInt(1000);
             
              y = yy.nextInt(1000);
             
              if (x > 900) 
              {
                 laenge = l.nextInt(1000-xy);
              } 
              else if (y > 900)
              {
                  breite = br.nextInt(1000-yx);
              }
              else
              {
                   laenge = l.nextInt(100);
                   breite = br.nextInt(100);
              }
        
            }
         return breite;
        }
        
        private Color zufallsfarbe()
        {
            Color zufallsfarbe;
            Random red = new Random();
            Random green = new Random();
            Random blue = new Random(); 
            int r = red.nextInt(255);
            int g = green.nextInt(255);
            int b = blue.nextInt(255);
            
            
            zufallsfarbe = new Color(r,g,b);
            return zufallsfarbe;
        }
}