

/**
 * Beschreiben Sie hier die Klasse Spielfeld.
 * 
 * @author Emil Hofmann, Charlotte Geißler
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.Scanner ;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

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
        poi[0].angefahren = true; //
        
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
        }
        public void poiSortieren (Punkt[] poi)
        {
            Punkt roboter = new Punkt(0,0); //Punkt, der Roboter darstellt
            int n = poi.length;  //6
            //double Abstaende[] = new double[n-1];//array abstand mit länge von poi erstellen
            //List Abstaende = new ArrayList();
            ArrayList<Double> Abstaende = new ArrayList<Double>();
            for (int j = 1; j < n; j++){
                Abstaende.clear();     //abstandsarray leeren
                System.out.println("Runde " + j); 
                for (int i = 1; i < n; i++)                                     //Abstaende ermitteln
                {
                    poi[i].abstand = roboter.gibAbstand(poi[i].x, poi[i].y);
                    //System.out.println("Abstand von " + poi[i].x + ", " + poi[i].y + " ist: " + poi[i].abstand);
                    if (poi[i].angefahren == false){
                        Abstaende.add(poi[i].abstand);
                        //System.out.println("Hinzugefuegt: " + poi[i].x + ", " + poi[i].y);
                    }
                }

                Collections.sort(Abstaende);
                                  //AbstandsListe sortieren
                System.out.println(Abstaende.get(0));
                for (int i = 1; i < n; i++){                //PunkteArray durchiterieren und zu Punkt mit geringstem Abstand fahren
                
                    if (poi[i].abstand == Abstaende.get(0)){      //zu punkt mit geringstem Abstand fahren
                        roboter.x = poi[i].x;
                        roboter.y = poi[i].y;
                        poi[i].angefahren = true;
                        System.out.println("Roboter ist zu " + roboter.x + ", " + roboter.y + " gefahren");
                        System.out.println("Abstand war: " + poi[i].abstand);
                    }
                } 
            
            }
            
            
       }
    
    }