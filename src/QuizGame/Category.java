package QuizGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public class Category {

    private final int category;
    public ArrayList<Question> questions = new ArrayList<>();

    public Category(int category) {
        this.category = category;
        System.out.println("Preguntas de categoría " + this.category + " (Mínimo 5 preguntas)");
        setQuestions();
    }

    public final void setQuestions() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escribe una pregunta de categoría " + category + " (Llevas "
                    + questions.size() + "):");
            String questionBody = scanner.next();
            questions.add(new Question(questionBody));
            if (questions.size() >= 5) {
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
}
