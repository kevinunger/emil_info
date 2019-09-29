
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
   
   
    public Spielfeld()
    {
    
    }
    
    public Punkt[] punktEingabe()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Anzahl der Punkte:");
        n = scanner.nextInt(); //Anzahl Punkte eintragen
        Punkt[] poi = new Punkt[n+1]; //Arraylänge def. , poi = point of interest
        poi[0] = new Punkt(0,0);
        
        for (int i = 1; i <= n; i++)
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
            Punkt roboter = new Punkt(0,0); //Punkt, der Roboter darstellt
            int n = poi.length;  //4
            double Abstand[] = new double[n-1];//array abstand mit länge von poi erstellen
            for (int i = 1; i < n; i++)   
            {
                System.out.println(poi[i]);
                Abstand[i-1] = roboter.gibAbstand(poi[i].x, poi[i].y);

            }
            Arrays.sort(Abstand);
            System.out.println("kürzester Abstand:" + Abstand[0] + "  " +Abstand[1]);
            //roboter.x = 
            
       }
    
 
}