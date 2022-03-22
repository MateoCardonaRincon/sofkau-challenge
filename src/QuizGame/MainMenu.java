package QuizGame;

import Controllers.GameController;
import Controllers.RecordController;
import Model.Entities.GameEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public class MainMenu {

    private static ArrayList<GameEntity> retrivedGames;
    private static final Scanner SCANNER = new Scanner(System.in);

    public MainMenu() throws SQLException {
        retrieveGames();
        menu();
    }

    //Carga los juegos almacenados en la base de datos
    private static void retrieveGames() throws SQLException {
        retrivedGames = GameController.getGame();
    }

    //Devuelve un objeto de tipo GameEntity, si existe
    private static GameEntity getGame(String ak) {
        if (retrivedGames.size() > 0) {
            for (GameEntity game : retrivedGames) {
                if (game.getAccessKey().equals(ak)) {
                    return game;
                }
            }
        }
        return null;
    }

    private static void menu() throws SQLException {
        System.out.println("     Crear un cuestionario\t(1 + enter)\n"
                + "     Jugar\t\t\t(2 + enter)\n"
                + "     Ver historial\t\t(3 + enter)\n"
                + "     Salir\t\t\t(Cualquier otra tecla + enter)");
        String menuOption = SCANNER.nextLine();

        switch (menuOption) {
            case "1" ->
                createNewGame();
            case "2" ->
                playAGame();
            case "3" ->
                showRecords();
            default -> {
                System.out.println("¡Hasta pronto!");
                System.exit(0);
            }
        }
    }

    private static void createNewGame() throws SQLException {
        System.out.println("Escribe un identificador de acceso al cuestionario:");
        String accessKey = SCANNER.nextLine();
        if (MainMenu.getGame(accessKey) == null) {
            Game thisGame = new Game(accessKey);
            if (thisGame.getCategories().size() > 0) {
                retrieveGames();
            }
        } else {
            System.out.println("El identificador '" + accessKey + "' ya existe. Por favor usa otro.");
            createNewGame();
        }
        menu();
    }

    private static void playAGame() throws SQLException {
        System.out.println("Ingresa el identificador del cuestionario que deseas responder:");
        String accessKey = SCANNER.nextLine();
        GameEntity thisGame = MainMenu.getGame(accessKey);
        if (thisGame != null) {
            System.out.println("Ingresa el nombre con el que deseas participar:");
            String nickname = SCANNER.nextLine();
            Record record = new Record(nickname, thisGame.getIdGame());
        } else {
            System.out.println("No hay juegos registrados con ese identificador.");
        }
        menu();
    }

    private static void showRecords() throws SQLException {
        System.out.println("Identificador del cuestionario del cual desea ver el historial:");
        String accessKey = SCANNER.nextLine();
        GameEntity thisGame = MainMenu.getGame(accessKey);
        if (thisGame != null) {
            int gameId = GameController.getId(accessKey);
            ArrayList<Object[]> records = RecordController.getRecords(gameId);
            System.out.println("Histórico (cuestionario con identificador: '" + accessKey + "')");
            if (records.size() > 0) {
                for (Object[] record : records) {
                    System.out.println(record[0] + "\t---\t" + record[1]);
                }
            } else {
                System.out.println("¡Nadie ha respondido este cuestionario!");
            }

        } else {
            System.out.println("No hay juegos registrados con ese identificador.");
        }
        menu();
    }

}
