package QuizGame;

import Controllers.GameController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public class Game {

    private final ArrayList<Category> CATEGORIES = new ArrayList<>();
    private String accessKey;
    private int idGame;

    public Game(String ak) throws SQLException {
        this.accessKey = ak;
        gameMenu();
    }

    public Game() {
    }

    private void gameMenu() throws SQLException {
        int nCategories = 2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("    Crear preguntas\t\t(1 + enter)");
        System.out.println("    Regresar al menú principal\t(Cualquier otra tecla + enter)");
        String menuOption = scanner.next();

        if ("1".equals(menuOption)) {
            GameController.setGame(this.accessKey);
            setIdGame(GameController.getId(this.accessKey));
            for (int cat = 1; cat <= nCategories; cat++) {
                CATEGORIES.add(new Category(cat, idGame));
            }
            System.out.println("¡Tu cuestionario ha sido creado! (Identificador de acceso: " + this.accessKey + ")");
        }
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getIdGame() {
        return idGame;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public ArrayList<Category> getCategories() {
        return CATEGORIES;
    }

}
