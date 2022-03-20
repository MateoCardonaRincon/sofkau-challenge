package QuizGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public final class Game {

    private String accessKey;
    private int category;
    private final ArrayList<Category> CATEGORIES = new ArrayList<>();

    public Game(String ak) {
        category = 1;
        this.accessKey = ak;
        gameMenu();
    }

    public void gameMenu() {
        int nCategories = 2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("    Crear preguntas\t\t(1 + enter)");
        System.out.println("    Regresar al menú principal\t(Cualquier otra tecla + enter)");
        String menuOption = scanner.next();

        if ("1".equals(menuOption)) {
            while (category <= nCategories) {
                CATEGORIES.add(new Category(category));
                category++;
            }
            System.out.println("¡Tu cuestionario ha sido creado! (Acceso: " + this.accessKey + ")");
        }
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
