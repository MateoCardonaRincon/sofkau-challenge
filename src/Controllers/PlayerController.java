package Controllers;

import Model.DatabaseConnection;
import Model.Entities.PlayerEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MATEO
 */
public class PlayerController {

    public static PlayerEntity getPlayer(int idPlayer) throws SQLException {
        PlayerEntity player;
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM player WHERE idPlayer = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(idPlayer));
            ResultSet result = ps.executeQuery();
            player = new PlayerEntity(result.getInt(1), result.getString(2));
            connection.close();
        }
        return player;
    }

    public static void setPlayer(String nickname) throws SQLException {
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO player (nickname) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nickname);
            ps.executeQuery();
            connection.close();
        }
    }
}
