package QuizGame;

import Controllers.CategoryController;
import Controllers.GameController;
import Controllers.RewardController;
import Model.Entities.GameEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public final class Game extends GameEntity {

    private String accessKey;
    private int category;
    private Reward reward;
    private final ArrayList<Category> CATEGORIES = new ArrayList<>();

    public Game(String ak) throws SQLException {
        category = 1;
        this.accessKey = ak;
        gameMenu();
    }

    public void gameMenu() throws SQLException {
        int nCategories = 2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("    Crear preguntas\t\t(1 + enter)");
        System.out.println("    Regresar al menú principal\t(Cualquier otra tecla + enter)");
        String menuOption = scanner.next();

        if ("1".equals(menuOption)) {
            GameController.setGame(this.accessKey);
            setIdGame(GameController.getId(this.accessKey));
            while (category <= nCategories) {
                setReward(category);
                int rewardId = RewardController.getId(this.getReward().getValue());
                CategoryController.setCategory(this.idGame, rewardId, category);
                int idCategory = CategoryController.getId(this.idGame, category);
                CATEGORIES.add(new Category(category, idCategory, getReward()));
                category++;
            }
            System.out.println("¡Tu cuestionario ha sido creado! (Identificador de acceso: " + this.accessKey + ")");
        }
    }

    private void setReward(int category) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Puntos por acertar una pregunta de categoría " + category + ":");
        String value = scanner.next();
        try {
            this.reward = new Reward(Integer.parseInt(value));
        }
        catch (NumberFormatException NumberFormatException) {
            setReward(category);
        }
    }

    @Override
    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    @Override
    public String getAccessKey() {
        return accessKey;
    }

    @Override
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public Reward getReward() {
        return reward;
    }

    public ArrayList<Category> getCategories() {
        return CATEGORIES;
    }

}
