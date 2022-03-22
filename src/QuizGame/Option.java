package QuizGame;

import Controllers.OptionController;
import Model.Entities.OptionEntity;
import java.sql.SQLException;

/**
 *
 * @author MATEO
 */
public class Option extends OptionEntity {

    private final int CORRECT;
    private final String OPTIONBODY;

    public Option(String optionBody, int correct, int questionId) throws SQLException {
        this.OPTIONBODY = optionBody;
        this.CORRECT = correct;
        OptionController.setOption(OPTIONBODY, CORRECT, questionId);
    }

    @Override
    public String getOptionBody() {
        return OPTIONBODY;
    }

    @Override
    public int getCorrect() {
        return CORRECT;
    }

    @Override
    public String toString() {
        return OPTIONBODY;
    }

}
