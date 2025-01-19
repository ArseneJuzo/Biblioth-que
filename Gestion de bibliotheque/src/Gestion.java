import javax.swing.*;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Date;

public class Gestion {
private static JTextField ID=new JTextField();
private static JTextField TITRE=new JTextField();
private static JTextField AUTEUR=new JTextField();
private static JTextField GENRE;
private static JTextField ISBN=new JTextField();
private static JTextField quantite=new JTextField();
private static JTextField ANNEEpub=new JTextField();
private static JTextArea disp=new JTextArea();


//private static JTextField ID_Memb=new JTextField();
private static JTextField NAME=new JTextField();
private static JTextField NUMBER=new JTextField();
private static JTextField EMAIL=new JTextField();
private static JTextField ADRESS=new JTextField();
//private static JTextField AddDateMember=new JTextField();



public static void addBook(){

String query="INSERT INTO book (title,author,isbn,copies_availables,published_year) VALUES(?,?,?,?,?)";
try(Connection connection=DatabaseConnection.getConnection();
    PreparedStatement pst =connection.prepareStatement(query)){

    pst.setString(1,TITRE.getText());
    pst.setString(2,AUTEUR.getText());
    pst.setString(3,ISBN.getText());
    pst.setString(4,quantite.getText());
    pst.setDate(5, Date.valueOf(ANNEEpub.getText()));
    pst.executeUpdate();
    JOptionPane.showMessageDialog(null, "livre ajouté avec sucess!");

}catch(SQLException EXCPT){
        EXCPT.printStackTrace();

} catch (Exception e) {
    throw new RuntimeException(e);
}
}

    public static void deletebook() {
        String query = "DELETE * FROM book WHERE ISBN = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1,ISBN.getText());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "livre supprimé avec sucess!");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void updatebook() {
        String query = "UPDATE book SET title = ?, author=?,isbn = ?, copies_availables=?,published_year = ? WHERE ID_book = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, TITRE.getText());
            stmt.setString(2, AUTEUR.getText());
            stmt.setString(3,ISBN.getText());
            stmt.setString(4, quantite.getText());
            stmt.setDate(5, Date.valueOf(ANNEEpub.getText()));
            stmt.setString(6,ID.getText());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findbook(){
    String query="SELECT * FROM book WHERE title=?";
    try (Connection conex=DatabaseConnection.getConnection();
        PreparedStatement pst=conex.prepareStatement(query)) {
        pst.setString(1,TITRE.getText());

        try (ResultSet rst= pst.executeQuery()){
            if(rst.next()){
                String Titre=rst.getString("titre ");
                String Auteur=rst.getString("auteur");
                String isbn=rst.getString("ISBN");
                String Quantite=rst.getString("quantite");
                Date annee_pub=rst.getDate("date");
                String ID= rst.getString("id");
                String genre=rst.getString("Genre");

                disp.setText(ID+"/t"+Titre+"/t"+genre+"/t"+Auteur+"/t"+isbn+"/t"+Quantite+"/t"+annee_pub);

            }else {disp.setText("aucun livre trouvé"); }

        }catch (SQLException e){e.printStackTrace();}

    }catch (Exception E){E.printStackTrace();}
    }

    public static void addMember(){
    Date AddDateMember=new Date(System.currentTimeMillis());
    int ID_Memb=0;


        String query="INSERT INTO member (first_name,phone_number,email,adresse,membership_date) VALUES(?,?,?,?,?)";
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement pst =connection.prepareStatement(query)){
            pst.setInt(1,ID_Memb);
            pst.setString(1,NAME.getText());
            pst.setString(2,NUMBER.getText());
            pst.setString(3,EMAIL.getText());
            pst.setString(4,ADRESS.getText());
            pst.setDate(5, AddDateMember);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "membre ajouté avec sucess!");

        }catch(SQLException EXCPT){
            EXCPT.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void deletemember() {
    int ID_Memb=0;
        String query = "DELETE * FROM member  WHERE ID_member = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1,ID_Memb);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "membre supprimé avec sucess!");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void findMemberInfo(){
        int ID_Memb=0;

        String query="SELECT * FROM member WHERE ID_member=?";
        try (Connection conex=DatabaseConnection.getConnection();
             PreparedStatement pst=conex.prepareStatement(query)) {
            pst.setInt(1,ID_Memb);

            try (ResultSet rst= pst.executeQuery()){
                if(rst.next()){
                    String Id=rst.getString("ID");
                    String NOM=rst.getString("NOM ");
                    String numero=rst.getString("auteur");
                    String mail=rst.getString("ISBN");
                    String adress=rst.getString("quantite");
                    Date dateadd=rst.getDate("date");


                    disp.setText(Id+"/t"+NOM+"/t"+numero+"/t"+mail+"/t"+adress+"/t"+dateadd);

                }else {disp.setText("aucune info trouvé"); }

            }catch (SQLException e){e.printStackTrace();}

        }catch (Exception E){E.printStackTrace();}
    }




}
