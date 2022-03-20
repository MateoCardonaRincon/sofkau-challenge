package QuizGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author MATEO
 */
public class Round {

    private String success;

    public Round(int round, Category category) {
        displayQuestion(round, category);
    }

    private void displayQuestion(int round, Category category) {
        Question thisQuestion = pickQuestion(category);
        System.out.println("Pregunta " + round + ": " + thisQuestion.getQuestionBody());

        displayOptions(thisQuestion.getOptions());
    }

    private Question pickQuestion(Category category) {
        ArrayList<Question> questionList = category.getQuestions();
        Collections.shuffle(questionList, new Random());
        return questionList.get(0);
    }

    private void displayOptions(ArrayList<Option> opt) {
        Collections.shuffle(opt, new Random());
        System.out.printf("\t(1 + enter)\t%s\n\t(2 + enter)\t%s\n\t(3 + enter)\t%s\n\t(4 + enter)\t%s\n",
                opt.get(0).getOptionBody(), opt.get(1).getOptionBody(),
                opt.get(2).getOptionBody(), opt.get(3).getOptionBody());
        System.out.println("\t(5 + enter)\tRetirarse con la puntuación ancual");

        pickOption(opt);
    }

    private void pickOption(ArrayList<Option> opt) {
        Scanner scanner = new Scanner(System.in);
        String pickedOption = scanner.next();

        if ("1234".contains(pickedOption)) {
            if (opt.get(Integer.parseInt(pickedOption) - 1).isCorrect()) {
                System.out.println("¡Respuesta Correcta!");
                setSuccess("success");
            } else {
                setSuccess("failure");
            }
        } else if ("5".equals(pickedOption)) {
            setSuccess("withdraw");
        } else {
            System.out.println("Ingresa una opción válida.");
            pickOption(opt);
        }
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getSuccess() {
        return success;
    }

}
