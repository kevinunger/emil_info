
/**
 * Beschreiben Sie hier die Klasse Punkt.
 * 
 * @author Emil Hofmann, Charlotte Geißler 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.lang.Math;
public class Punkt
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    public int x;
    public int y;
    public boolean angefahren = false;
    public double abstand;
    /**
     * Konstruktor für Objekte der Klasse Punkt
     */
    public Punkt()
    {
   
       
    }
      //Konstruktor 1 nimmt x und y entgegen und setzt diese in x,y ein
    public Punkt(int x , int y)
    {
        
         this.x = x;
         this.y = y;        

     } 
         

    
    public int getY()
    {
       
        return this.y;
    }
    public int getX()
    {
       
        return this.x; 
    }
    public void setX (int x)
    {
        this.x = x;
        
        
    
    }
    public void setY (int y)
    {
        this.y = y;
        
       
    }
        
    public void aktuellePositionAusgeben()
    {
        System.out.println ("X= " + x + "  "+ "Y= " + y);
       
    }
    public void bewegenUm( int dx, int dy)
    { 
        setX(x + dx);
        setY(y + dy);
    
    }   
    public double gibAbstand(int x2, int y2)
    {
        int x1 = getX();
        int y1 = getY();
        double abstand = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        
        return abstand; //
    
    }
    

  
        
        
        
        
}
