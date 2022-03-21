package Controllers;

import Model.DatabaseConnection;
import Model.Entities.OptionEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MATEO
 */
public class OptionController {

    public static ArrayList<OptionEntity> getOption(int idQuestion) throws SQLException {
        ArrayList<OptionEntity> options = new ArrayList<>();
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM answer WHERE Question_idQuestion = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idQuestion);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                options.add(new OptionEntity(result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4)));
            }
            connection.close();
        }
        return options;
    }

    public static void setOption(String body, int correct, int idQuestion) throws SQLException {
        try ( Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO answer (option_body, isCorrect, Question_idQuestion) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, body);
            ps.setInt(2, correct);
            ps.setInt(3, idQuestion);
            ps.executeUpdate();
            connection.close();
        }
    }
    public static void main(String[] args) throws SQLException {
        getOption(1);
    }
}
