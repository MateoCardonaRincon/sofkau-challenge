package QuizGame;

import Controllers.QuestionController;
import Model.Entities.QuestionEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public class Question extends QuestionEntity {

    private final String QUESTIONBODY;
    private final ArrayList<Option> OPTIONS = new ArrayList<>();

    public Question(String questionBody) throws SQLException {
        this.QUESTIONBODY = questionBody;
        setOptions();
    }

    private void setOptions() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe la respuesta correcta (1/4):");
        String option = scanner.nextLine();

        int questionId = QuestionController.getId(QUESTIONBODY);
        OPTIONS.add(new Option(option, 1, questionId));

        for (int i = 2; i <= 4; i++) {
            System.out.printf("Escribe una respuesta incorrecta (%d/4):\n", i);
            option = scanner.nextLine();
            OPTIONS.add(new Option(option, 0, questionId));
        }
    }

    @Override
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
