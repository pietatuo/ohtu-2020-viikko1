package paaohjelma;
import ohtu.ohtuvarasto.*;

public class Main {

    public static void main(String[] args) {

        Varasto mehua = new Varasto(100.0);
        Varasto olutta = new Varasto(100.0, 20.2);

        System.out.println("Varastosta päivää.");
        System.out.println("Luonnin jälkeen:");
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutvarasto: " + olutta);
        if (1==1) {
            if (2==2) System.out.println("tämä rikkoo checkstylea");
        }
    }
}
