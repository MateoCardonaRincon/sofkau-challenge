package QuizGame;

import Controllers.OptionController;
import Controllers.QuestionController;
import Model.Entities.CategoryEntity;
import Model.Entities.OptionEntity;
import Model.Entities.QuestionEntity;
import java.sql.SQLException;
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

    public Round(int round, CategoryEntity category) throws SQLException {
        displayQuestion(round, category);
    }

    private void displayQuestion(int round, CategoryEntity category) throws SQLException {
        QuestionEntity thisQuestion = pickQuestion(category);
        System.out.println("Pregunta " + round + ": " + thisQuestion.getQuestionBody());

        ArrayList<OptionEntity> options = OptionController.getOption(thisQuestion.getIdQuestion());
        displayOptions(options);
    }

    private QuestionEntity pickQuestion(CategoryEntity category) throws SQLException {
        ArrayList<QuestionEntity> questions = QuestionController.getQuestion(category.getIdCategory());
        Collections.shuffle(questions, new Random());
        return questions.get(0);
    }

    private void displayOptions(ArrayList<OptionEntity> opt) {
        Collections.shuffle(opt, new Random());
        System.out.printf("\t(1 + enter)\t%s\n\t(2 + enter)\t%s\n\t(3 + enter)\t%s\n\t(4 + enter)\t%s\n",
                opt.get(0).getOptionBody(), opt.get(1).getOptionBody(),
                opt.get(2).getOptionBody(), opt.get(3).getOptionBody());
        System.out.println("\t(5 + enter)\tRetirarse con la puntuación actual");

        pickOption(opt);
    }

    private void pickOption(ArrayList<OptionEntity> opt) {
        Scanner scanner = new Scanner(System.in);
        String pickedOption = scanner.next();

        if ("1234".contains(pickedOption)) {
            if (opt.get(Integer.parseInt(pickedOption) - 1).getCorrect() == 1) {
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
