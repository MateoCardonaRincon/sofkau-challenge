package QuizGame;

import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public final class MainMenu {

    private static final Scanner scanner = new Scanner(System.in);
    private static String nickname;

    public MainMenu(String nickname) {
        menu();
    }

    public static void menu() {
        System.out.println("     Crear un cuestionario\t(1 + enter)\n"
                + "     Jugar\t\t\t(2 + enter)\n"
                + "     Salir\t\t\t(3 + enter)");
        String menuOption = scanner.next();

        switch (menuOption) {
            case "1":
                createNewGame();
                break;
            case "2":
                playAGame();
                break;
            case "3":
                System.out.println("¡Hasta pronto!");
                System.exit(0);
                break;
            default:
                menu();
                break;

        }
    }

    private static void createNewGame() {
        System.out.println("Escriba una clave de acceso al cuestionario:");
        String accessKey = scanner.next();
        Game game = new Game(accessKey);
    }

    private static void playAGame() {
        System.out.println("Ingresa la clave del cuestionario a responder:");
        String accessKey = scanner.next();
        Record record = new Record(nickname, new Game(accessKey));
    }

}
