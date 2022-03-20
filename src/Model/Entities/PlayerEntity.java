package Model.Entities;

/**
 *
 * @author MATEO
 */
public class PlayerEntity {

    private int idPlayer;
    private String nickname;

    public PlayerEntity(int idPlayer, String nickname) {
        this.idPlayer = idPlayer;
        this.nickname = nickname;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
