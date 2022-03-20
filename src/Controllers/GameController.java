package Controllers;

import Model.DatabaseConnection;
import Model.Entities.GameEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MATEO
 */
public class GameController {

    public static ArrayList<GameEntity> getGame() throws SQLException {
        ArrayList<GameEntity> gameList;
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM game";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            gameList = new ArrayList<>();
            while (result.next()) {
                gameList.add(new GameEntity(result.getInt(1), result.getString(2)));
            }
            connection.close();
        }

        return gameList;
    }

    public static void setGame(String accessKey) throws SQLException {
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO game (accessKey) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, accessKey);
            ps.executeQuery();
            connection.close();
        }
    }
}
