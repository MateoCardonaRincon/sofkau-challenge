package QuizGame;

/**
 *
 * @author MATEO
 */
public class Record extends Player {

    public String player;
    public Game game;
    public int score;
    public int round;

    public Record(String playerNickname, String gameAccessKey) {
        super(playerNickname);
        this.player = playerNickname;
        setRecord();
    }

    private void setRecord() {
        
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
