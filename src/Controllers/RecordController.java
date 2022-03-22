package Controllers;

import Model.DatabaseConnection;
import Model.Entities.RecordEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MATEO
 */
public class RecordController {

    public static ArrayList<RecordEntity> getRecord(int idGame) throws SQLException {
        ArrayList<RecordEntity> records = new ArrayList<>();
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM record WHERE Game_idGame = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(idGame));
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                records.add(new RecordEntity(result.getInt(1),
                        result.getInt(2),
                        result.getInt(3),
                        result.getInt(4)));
            }
            connection.close();
        }
        return records;
    }

    public static ArrayList<Object[]> getRecords(int idGame) throws SQLException {
        ArrayList<Object[]> records = new ArrayList<>();
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT score, nickname FROM "
                    + "record JOIN player ON record.Player_idPlayer = player.idPlayer "
                    + "WHERE Game_idGame = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(idGame));
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                records.add(new Object[] {result.getInt(1),result.getString(2)});
            }
            connection.close();
        }
        return records;
    }

    public static void setRecord(int score, int idPlayer, int idGame) throws SQLException {
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO record (score, Player_idPlayer, Game_idGame) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, score);
            ps.setInt(2, idPlayer);
            ps.setInt(3, idGame);
            ps.executeUpdate();
            connection.close();
        }
    }
}
