
/**
 * Beschreiben Sie hier die Klasse Spielfeld.
 * 
 * @author Emil Hofmann, Charlotte Geißler
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.Scanner ;
import javax.swing.JOptionPane;
import java.util.Arrays;
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
    public double a;
    public double p;
   //möglichst wenig public also global definieren
   //jaja hab ich verstanden ;)
   
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


        //EMil 1231231231212
        
        }
        public void poiSortieren (Punkt[] poi)
        {
            
            double Abstand0[] = new double[n-1]; //n haben wir nicht. Nur wenn n global ist und punktEingabe stattfand
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
       }
    
 
}