package QuizGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public class Category {

    private final ArrayList<Question> questions = new ArrayList<>();
    private Reward reward;

    public Category(int category) {
        System.out.println("Preguntas de categoría " + category + " (Mínimo 5 preguntas)");
        setQuestions(category);
    }

    private void setQuestions(int category) {
        int minNQuestions = 2;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escribe una pregunta de categoría " + category + " (Llevas "
                    + questions.size() + "):");
            String questionBody = scanner.next();
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
        setReward(category);
    }

    private void setReward(int category) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Puntos por acertar una pregunta de categoría " + category + ":");
        String value = scanner.next();
        try {
            reward = new Reward(Integer.parseInt(value));
        }
        catch (NumberFormatException NumberFormatException) {
            setReward(category);
        }

    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public Reward getReward() {
        return reward;
    }
}
