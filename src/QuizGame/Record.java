package QuizGame;

import Controllers.CategoryController;
import Controllers.PlayerController;
import Controllers.RecordController;
import Controllers.RewardController;
import Model.Entities.CategoryEntity;
import Model.Entities.RewardEntity;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MATEO
 */
public class Record extends Player {

    private final String PLAYER;
    private int round;
    private int score;
    private int gameId;

    public Record(String playerNickname, int idGame) throws SQLException {
        super(playerNickname);
        this.PLAYER = playerNickname;
        this.round = 1;
        this.score = 0;
        this.gameId = idGame;
        setRecord(idGame);
    }

    private void setRecord(int idGame) throws SQLException {
        int nRounds = 2;

        ArrayList<CategoryEntity> categories = CategoryController.getCategory(idGame);

        while (round <= nRounds) {

            Round currentRound = new Round(round, categories.get(round - 1));

            if ("success".equals(currentRound.getSuccess())) {
                RewardEntity reward = RewardController.getReward(categories.get(round - 1).getIdReward());
                setScore(getScore() + reward.getValue());

                if (round == nRounds) {
                    System.out.printf("¡Felicitaciones, %s! Respondiste todas las preguntas correctamente\n", this.PLAYER);
                    System.out.println("Tu puntuación final: ¡" + getScore() + "!");
                    break;
                }
                System.out.println("Puntuación actual: " + getScore());
                round++;

            } else if ("withdraw".equals(currentRound.getSuccess())) {
                System.out.printf("¡%s, te has retirado con una puntuación de %d!\n", PLAYER, getScore());
                break;
            } else {
                setScore(0);
                System.out.println("Fallaste. ¡Has perdido todos tus puntos!");
                System.out.printf("%s, tu puntuación final es: %d\n", PLAYER, getScore());
                break;
            }
        }
        PlayerController.setPlayer(PLAYER);
        int playerId = PlayerController.getId(PLAYER);
        RecordController.setRecord(getScore(), playerId, gameId);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
