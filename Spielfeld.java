

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

import java.util.ArrayList;
import java.util.Collections;

public class Spielfeld
{
    int width = 1000;
    int length = 1000; 
 
    
    private static Random zufallsgenerator = new Random();    //Random muss ausserhalb von zufallszahl erstellt werden sonst nicht sehr zufällige werte
   
   
    public Spielfeld()
    {
    
    }
    
    public Punkt[] punktEingabe()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Anzahl der Punkte:");
        int n = scanner.nextInt(); //Anzahl Punkte eintragen
        Punkt[] poi = new Punkt[n+1]; //Arraylänge def. , poi = point of interest
        poi[0] = new Punkt(0,0);
        poi[0].angefahren = true; //
        
        for (int i = 1; i <= n; i++)
        {
            System.out.println(i + ". Punkt x-Wert:") ;
            int x = scanner.nextInt();
            if (x>1000) 
            { 
                JOptionPane.showMessageDialog(null, "Wert liegt nicht im Spielfeld!", "Fehlermeldung", JOptionPane.PLAIN_MESSAGE);
                System.out.println(i + ". Punkt neuer x-Wert:") ;
                x = scanner.nextInt();
            }
            
            System.out.println(i + ". Punkt y-Wert:") ;
            int y = scanner.nextInt();
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
       public void hindernislisteErzeugen()
       {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Anzahl der Hindernisse: ");
           int n = scanner.nextInt(); //Anzahl Hindernisse eintragen
           ArrayList<Rechteck> Hindernisse = new ArrayList<Rechteck>();
           int failCounter = 0;
           //System.out.println(zufallszahl(0,10));
           
           for (int i = 1; i < n; i++){
               
              Punkt rP = new Punkt(zufallszahl(0,1000), zufallszahl(0,1000));
              Rechteck Hindernis = new Rechteck( 
              rP, 
              zufallszahl(1,100), 
              zufallszahl(1,100), 
              ("Rechteck" + Integer.toString(i)),
              zufallsfarbe()
              );
              System.out.println("Es wurde erzeugt: ");
              Hindernis.ausgabeAttribute();
              System.out.println("-------------------------");
              System.out.println(" ");
              
              //pruefen, ob Hindernis mit anderem Hindernis ueberlappt
              boolean keineUeberlappung = true;
              for (int j = 0; j < Hindernisse.size(); j++){
                  
                  if(Hindernis.ueberlappt(Hindernisse.get(j))){
                     keineUeberlappung = false;
                    }
                    
                }
              
              if (keineUeberlappung == true){ 
                  Hindernisse.add(Hindernis);
                  System.out.println("Keine ueberlappung");
                  System.out.println(" ");
                  failCounter = 0;
                }
              else
              { 
                  System.out.println("Hindernis wurde nicht hinzugefügt, da es mit einem anderen ueberlapt!");
                  failCounter++;
                  if (failCounter == 50){
                      System.out.println("Es wurde 50 mail hintereinander kein Platz gefunden --> Abbruch! " );
                      return;

                  }
              }
            }

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
        
        
        private int zufallszahl(int von, int bis)
        {
            
                
            int randZahl = zufallsgenerator.nextInt((bis - von) + 1) + von;
            return randZahl;
            
            
            
            
            /*
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
         */
        }
        
        private Color zufallsfarbe()
        {
            int randR = zufallsgenerator.nextInt(255) + 1; //plus eins, da nextInt hoechste Zahl nicht beinhaltet
            int randG = zufallsgenerator.nextInt(255) + 1;
            int randB = zufallsgenerator.nextInt(255) + 1;
            Color zufallsfarbe = new Color(randR, randG, randB);
            
            return zufallsfarbe;
                
                /*         
            Color zufallsfarbe;
            Random red = new Random();
            Random green = new Random();
            Random blue = new Random(); 
            int r = red.nextInt(255);
            int g = green.nextInt(255);
            int b = blue.nextInt(255);
            
            
            zufallsfarbe = new Color(r,g,b);
            return zufallsfarbe;
            */
        }
}
            
