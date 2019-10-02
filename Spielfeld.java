

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
    enum AufgabenListe{
        POI,
        Hindernisse,
        Spracherkennung,
    };
    
    Roboter robo = new Roboter();

     
    private static Random zufallsgenerator = new Random();    //Random muss ausserhalb von zufallszahl erstellt werden sonst nicht sehr zufällige werte
   
    public Spielfeld()
    {
    
    }
    
    public Spielfeld(Roboter robo)
    {
    this.robo = robo;
    }
    
    public void main(){
    Scanner scanner = new Scanner(System.in);
    boolean stopWordFound = false;
    
    while (stopWordFound == false){
    System.out.println("\n" + "Welche Aufgabe lösen? : " + "\n"
    + "- Points-of-interest über einen möglichst kurzen Weg abfahren-" + "\n"
    + "- Hindernisse umfahren" + "\n"
    + "- Spracherkennung von Stichwörtern" + "\n"
    );
    
    String Eingabe = scanner.nextLine();
    
    if(Eingabe.toLowerCase().contains("ende")){
        stopWordFound = true;
    }
    
    for(AufgabenListe wort : AufgabenListe.values()){
                 if(Eingabe.toLowerCase().contains(wort.name().toLowerCase())){
                     switch (wort){
                         case POI:
                            System.out.println("POIs werden abgefahren!");
                            this.poiSortieren(this.punktEingabe()); //ersteingabe --> return poi -> nimmt poi für sortieren
                            break;
                         case Hindernisse:
                            System.out.println("Hindernisse werden umfahren!");
                            this.hindernislisteErzeugen();
                            break;
                         case Spracherkennung:
                            System.out.println("Spracherkennung wird gestartet");
                            robo.spracherkennung();
                            break;

                    }
                    }
                    

    }
}
        
        
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
            int n = poi.length;  //Laenge der poi array 
            
            ArrayList<Double> Abstaende = new ArrayList<Double>();
            for (int j = 1; j < n; j++){
                Abstaende.clear();                                                 //abstandsarray leeren
                //System.out.println("Runde " + j); 
                for (int i = 1; i < n; i++)                                     //Abstaende ermitteln
                {
                    poi[i].abstand = roboter.gibAbstand(poi[i].x, poi[i].y);
                    if (poi[i].angefahren == false){
                        Abstaende.add(poi[i].abstand);                          // .add hinzufügen ohne zuornung //hintereinander 
                    }
                }

                Collections.sort(Abstaende);                                    //AbstandsListe sortieren
                
                for (int i = 1; i < n; i++){                                    //PunkteArray durchiterieren und zu Punkt mit geringstem Abstand fahren
                
                    if (poi[i].abstand == Abstaende.get(0)){                    //zu punkt mit geringstem Abstand fahren
                        roboter.x = poi[i].x;
                        roboter.y = poi[i].y;
                        poi[i].angefahren = true;
                        System.out.println("Roboter ist zu " + roboter.x + ", " + roboter.y + " gefahren");
                        System.out.println("Abstand war: " + poi[i].abstand + "\n");
                    }
                } 
            
            }
       }
       public void hindernislisteErzeugen()
       {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Anzahl der Hindernisse: ");
           int n = scanner.nextInt(); //Anzahl Hindernisse eintragen
           ArrayList<Rechteck> Hindernisse = new ArrayList<Rechteck>(); //arraylist liste von objekten, hier Rechtecke
           int failCounter = 0;         //abbruchbedingung 50
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
              for (int j = 0; j < Hindernisse.size(); j++){ //liste aller hindernisse, geht alle durch 
                  
                  if(Hindernis.ueberlappt(Hindernisse.get(j))){ //==true
                     keineUeberlappung = false;
                    }
                    
                }
              
              if (keineUeberlappung == true){ 
                  Hindernisse.add(Hindernis); // .add methode der arraylist (hindernis wird hinzugefügt)
                  System.out.println("Keine ueberlappung");
                  System.out.println(" ");
                  failCounter = 0;
                }
              else
              { 
                  System.out.println("Hindernis wurde nicht hinzugefügt, da es mit einem anderen ueberlapt!");
                  failCounter++;
                  if (failCounter == 50){
                      System.out.println("Es wurde 50 mal hintereinander kein Platz gefunden --> Abbruch! " );
                      return;

                  }
              }
            }
        }
        
        
        private int zufallszahl(int von, int bis)
        {
            
                
            int randZahl = zufallsgenerator.nextInt((bis - von) + 1) + von; //(bis-von)+1 für spanne  +von für startwert
            return randZahl;
            
            
            
            
            
        }
        
        private Color zufallsfarbe()
        {
            int randR = zufallsgenerator.nextInt(256); //plus eins, da nextInt hoechste Zahl nicht beinhaltet
            int randG = zufallsgenerator.nextInt(256);
            int randB = zufallsgenerator.nextInt(256);
            Color zufallsfarbe = new Color(randR, randG, randB);
            
            return zufallsfarbe;
                
            
        }
}
            
