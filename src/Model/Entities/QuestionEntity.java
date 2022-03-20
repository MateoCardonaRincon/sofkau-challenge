package Model.Entities;

/**
 *
 * @author MATEO
 */
public class QuestionEntity {

    private int idQuestion;
    private String questionBody;
    private int idCategory;

    public QuestionEntity(int idQuestion, String questionBody, int idCategory) {
        this.idQuestion = idQuestion;
        this.idCategory = idCategory;
        this.questionBody = questionBody;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

}
