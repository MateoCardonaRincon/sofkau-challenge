package QuizGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public class Question {

    private final String QUESTIONBODY;
    private final ArrayList<Option> OPTIONS = new ArrayList<>();

    public Question(String questionBody) {
        this.QUESTIONBODY = questionBody;
        setOptions();
    }

    private void setOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe la respuesta correcta (1/4):");
        String option = scanner.nextLine();
        OPTIONS.add(new Option(option, true));

        for (int i = 2; i <= 4; i++) {
            System.out.printf("Escribe una respuesta incorrecta (%d/4):\n", i);
            option = scanner.next();
            OPTIONS.add(new Option(option, false));
        }
    }

    public String getQuestionBody() {
        return QUESTIONBODY;
    }

    public ArrayList<Option> getOptions() {
        return OPTIONS;
    }

    @Override
    public String toString() {
        return "Pregunta: " + QUESTIONBODY + "\nRespuestas:\n" + OPTIONS;
    }

}
