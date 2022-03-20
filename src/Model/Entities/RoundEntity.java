package Model.Entities;

/**
 *
 * @author MATEO
 */
public class RoundEntity {

    private int idRound;
    private int idQuestion;

    public RoundEntity(int idRound, int idQuestion) {
        this.idRound = idRound;
        this.idQuestion = idQuestion;
    }

    public int getIdRound() {
        return idRound;
    }

    public void setIdRound(int idRound) {
        this.idRound = idRound;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

}
