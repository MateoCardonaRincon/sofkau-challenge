package QuizGame;

import Controllers.CategoryController;
import Controllers.QuestionController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public class Category {

    private ArrayList<Question> questions = new ArrayList<>();
    private int idGame;
    private int idReward;

    public Category(int category, int idGame) throws SQLException {
        this.idGame = idGame;
        setReward(category);
        setQuestions(category);
    }

    private void setReward(int category) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Puntos por acertar una pregunta de categoría " + category + ":");

        try {
            int value = scanner.nextInt();
            Reward reward = new Reward(value);
            this.idReward = reward.getIdReward();
        }
        catch (InputMismatchException e) {
            setReward(category);
        }
    }

    private void setQuestions(int category) throws SQLException {
        int minNQuestions = 3;
        CategoryController.setCategory(idGame, idReward, category);
        int idCategory = CategoryController.getId(getIdGame(), category);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escribe una pregunta de categoría " + category + " (Llevas "
                    + questions.size() + "):");
            String questionBody = scanner.nextLine();
            QuestionController.setQuestion(questionBody, idCategory);
            questions.add(new Question(questionBody));

            if (questions.size() >= minNQuestions) {
                System.out.println("Llevas " + questions.size() + " preguntas, ¿deseas escribir más?");
                System.out.println("Sí, continuar\t(1 + enter)");
                System.out.println("Pasar a la siguiente categoría\t\t(Cualquier otra tecla + enter) ");
                String option = scanner.nextLine();
                if (!"1".equals(option)) {
                    break;
                }
            }
        }
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getIdGame() {
        return idGame;
    }

}
