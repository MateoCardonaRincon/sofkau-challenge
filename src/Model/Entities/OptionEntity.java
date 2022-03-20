package Model.Entities;

/**
 *
 * @author MATEO
 */
public class OptionEntity {

    private int idOption;
    private boolean correct;
    private String optonBody;
    private int idQuestion;

    public OptionEntity(int idOption,  String optonBody, boolean correct, int idQuestion) {
        this.idOption = idOption;
        this.idQuestion = idQuestion;
        this.optonBody = optonBody;
        this.correct = correct;
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

    public String getOptonBody() {
        return optonBody;
    }

    public void setOptonBody(String optonBody) {
        this.optonBody = optonBody;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

}
