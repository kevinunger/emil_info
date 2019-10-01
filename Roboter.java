import java.util.Scanner ;
import java.util.Scanner ;
import java.util.Scanner;


public class Roboter
{
    // instance variables - replace the example below with your own
    private int x;
    enum Stichwort{
        Name,
        Hersteller,
        Geschlecht,
        Geburtsdatum

    };


    public Roboter()
    {
        // initialise instance variables
        x = 0;
    }


    public void spacherkennung()
    {
    Scanner scanner = new Scanner(System.in);
    boolean stopWordFound = false;
    int sizeEnum = Stichwort.values().length;      //Groeße des enums ermitteln
    
    while (stopWordFound == false){
    System.out.println("Stelle eine Frage! ");
    String Eingabe = scanner.nextLine();
    
    if(Eingabe.toLowerCase().contains("ende")){
        stopWordFound = true;
    }
    
    for(Stichwort wort : Stichwort.values()){
                 if(Eingabe.toLowerCase().contains(wort.name().toLowerCase())){
                     switch (wort){
                         case Name:
                            System.out.println("Mein Name ist Robohomo 9000");
                            break;
                         case Geschlecht:
                            System.out.println("Mein Geschlecht ist undefiniert beep boop");
                            break;
                         case Hersteller:
                            System.out.println("Mein Hersteller ist Emil");
                            break;
                         case Geburtsdatum:
                            System.out.println("Mein Geburtsdatum ist 20.4.1920");
                            break;
                    }
                    }
                    

    }
}
        
    }
}
