package QuizGame;

import Controllers.PlayerController;
import java.sql.SQLException;

/**
 *
 * @author MATEO
 */
public class Player {

    private String nickname;

    public Player(String nickname) throws SQLException {
        this.nickname = nickname;
        PlayerController.setPlayer(nickname);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
