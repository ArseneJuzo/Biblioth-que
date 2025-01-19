/*import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.sql.*;

public class Affichage extends JFrame {

    try {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM book";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        //creation du modele de table
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("nom");
        model.addColumn("prenom");
        model.addColumn("date_naissance");
        model.addColumn("email");
        model.addColumn("telephone");
        model.addColumn("adresse");
        model.addColumn("matricule");
        model.addColumn("filiere");
        model.addColumn("annee_inscripton");
        model.addColumn("solvable");

        //Remplissage du modele de table avec les donnees
        while (resultSet.next()) {
            model.addRow(new Object[]{
                    resultSet.getString("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom"),
                    resultSet.getString("date_naissance"),
                    resultSet.getString("email"),
                    resultSet.getString("telephone"),
                    resultSet.getString("adresse"),
                    resultSet.getString("matricule"),
                    resultSet.getString("filiere"),
                    resultSet.getString("annee_inscription"),
                    resultSet.getString("solvable")
            });
        }
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

    } catch(SQLException e) {
        e.printStackTrace();
    }

}
*/