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
            if (connection == null) {
                System.exit(0);
            }
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

    public static int getId(String ak) throws SQLException {
        int gameId;
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT idGame FROM game WHERE accessKey = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ak);
            ResultSet result = ps.executeQuery();
            result.next();
            gameId = result.getInt(1);
            connection.close();
            return gameId;
        }

    }

    public static void setGame(String accessKey) throws SQLException {
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO game (accessKey) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, accessKey);
            ps.executeUpdate();
            connection.close();
        }
    }
}
