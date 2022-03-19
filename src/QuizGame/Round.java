package QuizGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public final class Round {

    private final Scanner scanner = new Scanner(System.in);

    private int category = 1;
    public ArrayList<Question> questions = new ArrayList<>();

    public Round() {
        System.out.println("Preguntas de categoría " + category + " (Mínimo 5 preguntas)");
        setQuestions();
    }

    protected void setQuestions() {
        while (true) {
            System.out.println("Escribe una pregunta de categoría " + category + " (Llevas "
                    + questions.size() + "):");
            String questionBody = scanner.next();
            questions.add(new Question(questionBody));
            if (questions.size() >= 5) {
                System.out.println("Llevas " + questions.size() + " preguntas, ¿deseas escribir más?");
                System.out.println("Continuar escribiendo\t(1 + enter)\nRegresar\t\t(2 + enter) ");
                String option = scanner.next();
                if ("2".equals(option)) {
                    this.category++;
                    break;
                } else if ("1".equals(option)) {
                    setQuestions();
                } else {
                    System.out.println("Ingresa una opción válida");
                    setQuestions();
                }
            }
        }
        Game.gameMenu();
    }
}
