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
public class MainMenu {

    private static ArrayList<Game> games = new ArrayList<>();
    private static ArrayList<GameEntity> retrivedGames;
    private static final Scanner SCANNER = new Scanner(System.in);

    public MainMenu() throws SQLException {
        retrieveGames();
        menu();
    }

    private static void retrieveGames() throws SQLException {
        retrivedGames = GameController.getGame();
    }

    private static GameEntity getGame(String ak) {
        if (retrivedGames.size() > 0) {
            for (GameEntity game : retrivedGames) {
                if (game.getAccessKey().equals(ak)) {
                    return game;
                }
            }
            System.out.println("No hay cuestionarios registrados con ese identificador.");
        } else {
            System.out.println("¡Aún no hay cuestionarios creados!");
        }
        return null;
    }

    private static boolean validateAccessKey(String ak) {
        return retrivedGames.stream().noneMatch(game -> (game.getAccessKey().equals(ak)));
    }

    private static void setGames(Game game) {
        MainMenu.games.add(game);
    }

    private static void menu() throws SQLException {
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

    private static void createNewGame() throws SQLException {
        System.out.println("Escribe un identificador de acceso al cuestionario:");
        String accessKey = SCANNER.next();
        if (MainMenu.validateAccessKey(accessKey)) {
            Game thisGame = new Game(accessKey);
            if (thisGame.getCategories().size() > 0) {
                setGames(thisGame);
                retrieveGames();
            }
        } else {
            System.out.println("El identificador ya está en uso. Por favor usa otro.");
            createNewGame();
        }
        menu();
    }

    private static void playAGame() throws SQLException {
        System.out.println("Ingresa el identificador del cuestionario que deseas responder:");
        String accessKey = SCANNER.next();
        GameEntity thisGame = MainMenu.getGame(accessKey);
        if (thisGame != null) {
            System.out.println("Ingresa el nombre con el que deseas participar:");
            String nickname = SCANNER.next();
            Record record = new Record(nickname, thisGame.idGame);
        }
        menu();
    }

}
