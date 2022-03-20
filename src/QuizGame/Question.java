package QuizGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public class Question {

    private final String questionBody;
    private final ArrayList<Option> options = new ArrayList<>();

    public Question(String questionBody) {
        this.questionBody = questionBody;
        setOptions();
    }

    private void setOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe la respuesta correcta (1/4):");
        String option = scanner.nextLine();
        options.add(new Option(option, true));

        for (int i = 2; i <= 4; i++) {
            System.out.printf("Escribe una respuesta incorrecta (%d/4):\n", i);
            option = scanner.next();
            options.add(new Option(option, false));
        }
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "Pregunta: " + questionBody + "\nRespuestas:\n" + options;
    }

}
