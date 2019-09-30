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
    public int width;
    public int height;
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
    public int getWidth()
    {
       
        return this.width;
    }
    public int getHeight()
    {
        return this.height; 
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
        
        return (position.x < r.position.x + r.width && position.x + width > r.position.x &&
        position.y < r.position.y + r.height && position.y + height > r.position.y);
        
    }
    public void setWidth (int width)
    {
    
        this.width = width;
              
    }
    public void setHeight (int height)
    {
        this.height = height;
    
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
       { JOptionPane.showMessageDialog(null, "Wert liegt nicht im Definitionsbereich! Maximal 255", "Fehlermeldung", JOptionPane.PLAIN_MESSAGE);
           
        }
       else 
       {farbe = new Color(r, g, b);}
       
    }
    
  
    public void bewegeUm (int dx, int dy)
    {
        position.x = position.x + dx;
        position.y = position.y + dy;
    
    }
    public void bewegeUm(Punkt verschiebevektor)
    {
        position.x = verschiebevektor.x + position.x;
        position.y = verschiebevektor.y + position.y;
    }
    public void ausgabeAttribute()
   
    {
        System.out.println("Breite: " + width);
        System.out.println("Länge: " + height);
        System.out.println("Position: " + position.x + " ; "+position.y);
        System.out.println("Bezeichnung: " + bezeichnung);
        //System.out.println("Farbe: " + r + " ; " +  g + " ; " + b );
        System.out.println(farbe); 
    }
    /*public boolean ueberlappt (Rechteck r)
    {
        
    
    }
   */
   
   
    
    
    
  
}