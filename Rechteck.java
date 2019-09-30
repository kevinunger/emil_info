/**
 * Beschreiben Sie hier die Klasse Rechteck.
 * 
 * @author Emil Hofamnn, Charlotte Geißler
 * @version Alpha_2
 */
import java.awt.Color;
import javax.swing.JOptionPane;
public class Rechteck
{
    public int breite;
    public int laenge;
    public String bezeichnung;
    //public float r,g,b;
    private Color farbe;
    Punkt position = new Punkt(30,20);
    public int v1;
    public int v2;
    
    public Rechteck() 
    {
    
    
    }
    public Rechteck(Punkt position, int breite, int laenge,
    String bezeichnung)
    {
    
    }
    public int getBreite()
    {
       
        return this.breite;
    }
    public int getLaenge()
    {
        return this.laenge; 
    }
    public String bezeichnung()
    {
        return bezeichnung;
    
    }
    public Punkt position()
    {
        return position;
        
    }
    
    public boolean ueberlappt (Rechteck r){
        
        
    
    
        return true;
    }
    public void setBreite (int breite)
    {
    
        this.breite = breite;
              
    }
    public void setLaenge (int laenge)
    {
        this.laenge = laenge;
    
    }    
    public void setPosition (Punkt position)
    {
        this.position = position;
    
    }
    public void setBezeichnung (String bezeichnung)
    {
        this.bezeichnung = bezeichnung;
    
    }
     public void setColor(int r, int g, int b)
    {
       
       if (r>255 || g>255 || b>255)
       { JOptionPane.showMessageDialog(null, "Wert liegt nicht im Definitionsbereich!", "Fehlermeldung", JOptionPane.PLAIN_MESSAGE);
           
        }
       else 
       {farbe = new Color(r, g, b);}
       
    }
    
  
    public void bewegeUm (int dx, int dy)
    {
        position.x = position.x + dx;
        position.y = position.y + dy;
    
    }
    /*public void bewegenUm (int vx, int vy)
    {
        position.x = position.x + vx;
        position.y = position.y + vy;
        
    }*/
    public void bewegeUm(Punkt verschiebevektor)
    {
        position.x = verschiebevektor.x + position.x;
        position.y = verschiebevektor.y + position.y;
    }
    public void ausgabeAttribute()
   
    {
        System.out.println("Breite: " + breite);
        System.out.println("Länge: " + laenge);
        System.out.println("Position: " + position.x + " ; "+position.y);
        System.out.println("Bezeichnung: " + bezeichnung);
        //System.out.println("Farbe: " + r + " ; " +  g + " ; " + b );
        System.out.println(farbe); 
    }
   
   
   
    
    
    
  
}