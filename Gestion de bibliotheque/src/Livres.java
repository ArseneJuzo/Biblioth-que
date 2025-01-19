import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Livres extends JFrame{

    JPanel pane1;
    JPanel pane2;
    JPanel pane3;
    JPanel pane;

    JLabel labelcopi;

    JLabel titreFormulaire;
    JLabel labeltitre;
    JLabel labelISBN;
    JLabel labelauteur;
    JLabel labelquantite;
    JLabel labelgenre;
    JLabel labelannee_de_publication;

    JTextField titre;
    JTextField ISBN;
    JTextField auteur;
    JTextField quantite;
    JTextField annee_de_publication;


    JComboBox genre;


     JButton button;

    public Livres (){
        super("GESTION BIBLIOTHEQUE");

titreFormulaire = new JLabel("INFORMATIONS DU LIVRE");
titreFormulaire.setIcon(new ImageIcon("C:/Users/root le jokers/Downloads/01.png"));

        labeltitre = new JLabel ("Titre du livre: ",JLabel.CENTER);
        labelISBN = new JLabel ("ISBN : ",JLabel.CENTER);
        labelgenre = new JLabel ("Genre : ",JLabel.CENTER);
        labelannee_de_publication = new JLabel ("Annee de Publication : ",JLabel.CENTER);
        labelquantite = new JLabel ("Quantite : ",JLabel.CENTER);
        labelauteur = new JLabel ("Auteur : ",JLabel.CENTER);

        titre = new JTextField("ajouter un titre");
        ISBN = new JTextField("13 chiffres");
        annee_de_publication = new JTextField(20);
        auteur = new JTextField(20);
        quantite = new JTextField("05");
        labelcopi = new JLabel("© Copyright 2025. Votre Bibliothèque par les etudiants de l'IAI cameroun (L2A)",JLabel.CENTER);

        genre = new JComboBox();
        genre.addItem("Roman");
        genre.addItem("Poeme");
        genre.addItem("Recit");
        genre.addItem("Drame");
        genre.addItem("etc...");


        labelgenre = new JLabel("Genre : ",JLabel.CENTER);

        pane1 = new JPanel();
        pane1.add(titreFormulaire);
        pane1.setBackground(Color.PINK);

        labeltitre.setPreferredSize(new Dimension(30,20));

        pane2 = new JPanel(new GridLayout(7, 2, 5, 5));
        //pane2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        pane2.setBackground(Color.GRAY);
        pane2.add(labeltitre);
        pane2.add(titre);
        pane2.add(labelISBN);
        pane2.add(ISBN);
        pane2.add(labelgenre);
        pane2.add(genre);
        pane2.add(labelauteur);
        pane2.add(auteur);
        pane2.add(labelannee_de_publication);
        pane2.add(annee_de_publication);
        pane2.add(labelquantite);
        pane2.add(quantite);


      /* button = new JButton("Ajouter le livre");
        button.addActionListener(new ListnerLivre() {
        });
         class AddButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String titre = titleField.getText();
            String contenu = contentArea.getText();
            Date date_pub = new Date(System.currentTimeMillis()); // Initialiser avec la date actuelle

            if (!titre.isEmpty() && !contenu.isEmpty()) {
                informationDAO.createInformation(titre, contenu);
                titleField.setText("");
                contentArea.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
            }
        }
    }
       */

        pane3 = new JPanel(new GridLayout(2,1));




        // Boutons pour diverses actions
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    Gestion.addBook();
            }
        });


        JButton removeButton = new JButton("Remove Book");
        removeButton.addActionListener(new ActionListener(){


            @Override
            public void actionPerformed(ActionEvent e) {
                Gestion.deletebook();
            }
        });
        JButton updateButton = new JButton("Update Record");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestion.updatebook();

            }
        });
        JButton findButton = new JButton("Find Book");
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestion.findbook();
            }
        });
        JButton displayMostLikedButton = new JButton("Display Top 5 Liked Books");
        displayMostLikedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Crée un panneau pour maintenir les boutons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 5, 5));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(displayMostLikedButton);
        buttonPanel.add(findButton);

        pane3.add(buttonPanel);








        //pane3 = new JPanel();
        pane3.add(labelcopi);
        //labelcopi.setPreferredSize(new Dimension(10,20));

        pane3.setBackground(Color.orange);

        pane = new JPanel(new BorderLayout());

        pane.add(pane1,BorderLayout.NORTH);
        pane.add(pane2,BorderLayout.CENTER);
        pane.add(pane3,BorderLayout.SOUTH);

        JTabbedPane tpane = new JTabbedPane();
        tpane.setBackground(Color.lightGray);
        tpane.add("Livres",pane);
        JPanel pane4 = new JPanel();
        pane4.setBackground(Color.yellow);
        tpane.add("Membres", new Membres());
        JPanel pane5 = new JPanel();
        pane5.add(new JLabel("Liste des Emprunt"));

        //pane4.setBackground(Color.magenta);
        tpane.add("Emprunt",pane5);

        JPanel pane6 = new JPanel();
        pane6.add(new JLabel("Liste des Membres"));
        pane6.setBackground(Color.yellow);
        tpane.add("Liste des membres ",pane6);
        //tpane.add(pane6,BorderLayout.EAST);
        JPanel pane7 = new JPanel();
        pane7.add(new JLabel("Liste des Livres"));
        //pane4.setBackground(Color.magenta);
        tpane.add("Liste des livre",pane7);


        getContentPane().add(tpane);
        setVisible(true);
        setResizable(false);

        setSize(1000,500);
        //pack();
        this.setLocationRelativeTo(null);
        setBackground(Color.GREEN);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    class ListnerLivre implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "enregistrer"){
                //class.forName ("com.mysql.jdbc.Driver");
            }
        }
    }

}
