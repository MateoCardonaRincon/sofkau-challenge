package QuizGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public class Game {

    public String accessKey;
    public static ArrayList<Round> rounds = new ArrayList<>();

    public Game(String ak) {
        this.accessKey = ak;
        gameMenu();
    }

    public Game() {
    }

    public static void gameMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presiona el número correspondiente seguido de la tecla Enter:");
        for (int i = 1; i <= 5; i++) {
            System.out.printf("    %d. Crear preguntas de la ronda %d\n", i, i);
        }
        System.out.println("    6. Regresar al menú principal");
        String menuOption = scanner.next();

        if ("12345".contains(menuOption)) {
            createRounds(menuOption);
        } else if ("6".equals(menuOption)) {
            MainMenu.menu();
        } else {
            System.out.println("Por favor, ingrese una opción válida");
            gameMenu();
        }
    }

    private static void createRounds(String nRound) {
        rounds.add(new Round(Integer.parseInt(nRound)));
    }
}
