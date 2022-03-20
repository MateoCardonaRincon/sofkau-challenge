package Model.Entities;

/**
 *
 * @author MATEO
 */
public class RecordEntity {

    private int idRecord;
    private int Score;
    private int idPlayer;
    private int idGame;

    public RecordEntity(int idRecord, int Score, int idPlayer, int idGame) {
        this.idRecord = idRecord;
        this.idPlayer = idPlayer;
        this.idGame = idGame;
        this.Score = Score;
    }

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

}
