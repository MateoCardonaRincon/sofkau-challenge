package QuizGame;

import Controllers.GameController;
import Model.Entities.GameEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public final class MainMenu {

    private static ArrayList<Game> games = new ArrayList<>();
    private static String nickname;
    private static final Scanner SCANNER = new Scanner(System.in);

    public MainMenu(String nickname) {
        MainMenu.nickname = nickname;
        menu();
    }

    private static Game getGame(String ak) {
        if (games.size() > 0) {
            for (Game game : games) {
                if (game.getAccessKey().equals(ak)) {
                    return game;
                }
            }
            System.out.println("No hay cuestionarios registrados con esa clave");
        } else {
            System.out.println("¡Aún no hay cuestionarios creados!");
        }
        return null;
    }

    private static boolean validateAccessKey(String ak) {
        return games.stream().noneMatch(game -> (game.getAccessKey().equals(ak)));
    }

    private static void setGames(Game game) {
        MainMenu.games.add(game);
    }

    private static void menu() {
        System.out.println("     Crear un cuestionario\t(1 + enter)\n"
                + "     Jugar\t\t\t(2 + enter)\n"
                + "     Salir\t\t\t(Cualquier otra tecla + enter)");
        String menuOption = SCANNER.next();

        switch (menuOption) {
            case "1" ->
                createNewGame();
            case "2" ->
                playAGame();
            default -> {
                System.out.println("¡Hasta pronto!");
                System.exit(0);
            }
        }
    }

    private static void createNewGame() {
        System.out.println("Escribe una clave para luego entrar al cuestionario:");
        String accessKey = SCANNER.next();
        if (MainMenu.validateAccessKey(accessKey)) {
            Game thisGame = new Game(accessKey);
            if (thisGame.getCategories().size() > 0) {
                setGames(thisGame);
            }
        } else {
            System.out.println("La contraseña ya está en uso. Por favor usa otra.");
            createNewGame();
        }
        menu();
    }

    private static void playAGame() {
        System.out.println("Ingresa la clave del cuestionario a responder:");
        String accessKey = SCANNER.next();
        Game thisGame = MainMenu.getGame(accessKey);
        if (thisGame != null) {
            Record record = new Record(nickname, thisGame);
        }
        menu();
    }

}
