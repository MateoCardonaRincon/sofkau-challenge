package QuizGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public class Round{

    private final Scanner scanner = new Scanner(System.in);

    private final int category;
    public ArrayList<Question> questions = new ArrayList<>();

    public Round(int category) {
        this.category = category;
        System.out.println("Preguntas de categoría " + category + " (Mínimo 5 preguntas)");
        setQuestions();
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public final void setQuestions() {
        if (questions.size() > 0) {
            Game.gameMenu();
        } else {
            roundMenu();
        }

    }

    protected void roundMenu() {
        while (true) {
            System.out.println("Escribe una pregunta de categoría " + category + " (Llevas "
                    + questions.size() + "):");
            String questionBody = scanner.next();
            questions.add(new Question(questionBody));
            if (questions.size() >= 5) {
                System.out.println("Llevas " + questions.size() + " preguntas, ¿deseas escribir más?");
                System.out.println("Continuar escribiendo\t(1 + enter)");
                System.out.println("Regresar\t\t(2 + enter) ");
                String option = scanner.next();
                if ("2".equals(option)) {
                    break;
                } else if ("1".equals(option)) {
                    roundMenu();
                } else {
                    System.out.println("Ingresa una opción válida");
                    roundMenu();
                }
            }
        }
        Game.gameMenu();
    }

}
