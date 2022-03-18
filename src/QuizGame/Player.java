package QuizGame;

/**
 *
 * @author MATEO
 */
public class Player {

    private String password;
    public String nickname;

    public Player(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
