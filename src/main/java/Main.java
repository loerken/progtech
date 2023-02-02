import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kerlek adj meg egy felhasznalonevet: ");

        String felhasznalonev = scanner.nextLine();

        try {
            PrintWriter out = new PrintWriter("felhasznalonev.txt");
            out.println(felhasznalonev);
            out.close();
            System.out.println("Felhasznalonev elmentve.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Szeretned megtekinteni az elmentett felhasznalonevet? [igen/nem]: ");
        String valasztas = scanner.next();

        if (valasztas.equals("igen")) {
            Scanner beolvas;
            try {
                beolvas = new Scanner(new File("felhasznalonev.txt"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.print("A megadott felhasznalonev: ");
            while (beolvas.hasNextLine()) {
                System.out.println(beolvas.nextLine());
            }

        }
        else if (valasztas.equals("nem")) {
            System.out.println("A program most kilep!");
        }

        else {
            System.out.println("Ervenytelen valasztas!");
        }



    }
}

