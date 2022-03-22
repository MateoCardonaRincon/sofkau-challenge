package Model.Entities;

/**
 *
 * @author MATEO
 */
public class OptionEntity {

    private int idOption;
    private int correct;
    private String optionBody;
    private int idQuestion;

    public OptionEntity(int idOption, String optionBody, int correct, int idQuestion) {
        this.idOption = idOption;
        this.idQuestion = idQuestion;
        this.optionBody = optionBody;
        this.correct = correct;
    }

    public OptionEntity() {
    }

    public int getIdOption() {
        return idOption;
    }

    public void setIdOption(int idOption) {
        this.idOption = idOption;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getOptionBody() {
        return optionBody;
    }

    public void setOptionBody(String optionBody) {
        this.optionBody = optionBody;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

}
