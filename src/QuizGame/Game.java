package QuizGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public class Game {

    public static String accessKey;
    public static int category = 1;
    public static ArrayList<Category> categories = new ArrayList<>();

    public Game(String ak) {
        Game.accessKey = ak;
        gameMenu();
    }

    public Game() {
    }

    public static void gameMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("    Crear preguntas\t\t(1 + enter)");
        System.out.println("    Regresar al menú principal\t(2 + enter)");
        String menuOption = scanner.next();

        if ("1".equals(menuOption)) {
            while (category <= 5) {
                categories.add(new Category(category));
                category++;
            }
            System.out.println("¡Tu cuestionario ha sido creado! (Acceso: " + accessKey + ")");
            MainMenu.menu();
        } else if ("2".equals(menuOption)) {
            MainMenu.menu();
        } else {
            System.out.println("Por favor, ingrese una opción válida");
            gameMenu();
        }

    }
}
