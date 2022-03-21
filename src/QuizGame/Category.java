package QuizGame;

import Controllers.CategoryController;
import Controllers.QuestionController;
import Model.Entities.CategoryEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public class Category extends CategoryEntity {

    private ArrayList<Question> questions = new ArrayList<>();
    private int categoryId;
    private Reward reward;

    public Category(int category, int idCategory, Reward reward) throws SQLException {
        this.categoryId = idCategory;
        this.reward = reward;
        System.out.println("Preguntas de categoría " + category + " (Mínimo 5 preguntas)");
        setQuestions(category);
    }

    private void setQuestions(int category) throws SQLException {
        int minNQuestions = 2;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escribe una pregunta de categoría " + category + " (Llevas "
                    + questions.size() + "):");
            String questionBody = scanner.next();
            QuestionController.setQuestion(questionBody, categoryId);

            questions.add(new Question(questionBody));
            if (questions.size() >= minNQuestions) {
                System.out.println("Llevas " + questions.size() + " preguntas, ¿deseas escribir más?");
                System.out.println("Continuar escribiendo preguntas de categoría " + category + "\t(1 + enter)");
                System.out.println("Acabar\t\t(Cualquier otra tecla + enter) ");
                String option = scanner.next();
                if (!"1".equals(option)) {
                    break;
                }
            }
        }

    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public Reward getReward() {
        return reward;
    }

}
