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
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) System.out.println("tämä rikkoo checkstylea");
        }
    }
}
