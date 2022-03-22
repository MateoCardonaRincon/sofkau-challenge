package Model.Entities;

/**
 *
 * @author MATEO
 */
public class GameEntity {

    private int idGame;
    private String accessKey;

    public GameEntity(int idGame, String accessKey) {
        this.idGame = idGame;
        this.accessKey = accessKey;
    }

    public GameEntity() {
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

}
