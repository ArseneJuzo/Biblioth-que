import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Fenetre extends JFrame{



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




    JMenuItem nouveauL;
    JMenuItem nouveauM;
    public Fenetre(){








        titreFormulaire = new JLabel("INFORMATIONS DU LIVRE");
        titreFormulaire.setIcon(new ImageIcon("C:/Users/root le jokers/Downloads/01.png"));

        labeltitre = new JLabel ("Titre du livre: ");
        labelISBN = new JLabel ("ISBN : ");
        labelgenre = new JLabel ("Genre : ");
        labelannee_de_publication = new JLabel ("Annee de Publication : ");
        labelquantite = new JLabel ("Quantite : ");
        labelauteur = new JLabel ("Auteur : ");

        titre = new JTextField("ajouter un titre");
        ISBN = new JTextField("13 chiffres");
        annee_de_publication = new JTextField(20);
        auteur = new JTextField(20);
        quantite = new JTextField(20);
        labelcopi = new JLabel("© copyright by IAI cameroun");

        genre = new JComboBox();
        genre.addItem("Roman");
        genre.addItem("Poeme");
        genre.addItem("Recit");
        genre.addItem("Drame");
        genre.addItem("etc...");


        labelgenre = new JLabel("Choisi le genre");

        pane1 = new JPanel();
        pane1.add(titreFormulaire);
        pane1.setBackground(Color.PINK);


        pane2 = new JPanel(new GridLayout(6,2));
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


        button = new JButton("Ajouter le livre");
        //button.addActionListener(new Fenetre.ListnerLivre() );
        pane3 = new JPanel();
        pane3.add(labelcopi);

        pane3.setBackground(Color.orange);

        pane = new JPanel(new BorderLayout());

        pane.add(pane1,BorderLayout.NORTH);
        pane.add(pane2,BorderLayout.CENTER);
        pane.add(pane3,BorderLayout.SOUTH);

        JTabbedPane tpane = new JTabbedPane();
        tpane.add("Ajouter un livre ",pane);
        JPanel pane4 = new JPanel();
        pane4.setBackground(Color.yellow);
        tpane.add("Liste des livres ",pane4);


        getContentPane().add(tpane);
        setVisible(true);
        //setSize(500,300);
        //setSize(800,400);
        pack();
        setBackground(Color.GREEN);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);









        JMenuBar barre = new JMenuBar();


        JMenu Livres = new JMenu("Livres");

        barre.setBackground(Color.gray);

        nouveauL = new JMenuItem("nouveau");
        nouveauL.addActionListener(new ListnerMenu());
        JMenuItem rechercherL = new JMenuItem("rechercher");
        JMenuItem supprimerL = new JMenuItem("supprimer");

        Livres.add(nouveauL);
        Livres.add(rechercherL);
        Livres.add(supprimerL);

        JMenu Membres = new JMenu("Membres");

        nouveauM = new JMenuItem("nouveau");
        nouveauM.addActionListener(new ListnerMenu());
        JMenuItem rechercherM = new JMenuItem("rechercher");
        JMenuItem supprimerM = new JMenuItem("supprimer");

        Membres.add(nouveauM);
        Membres.add(rechercherM);
        Membres.add(supprimerM);

        barre.add(Livres);
        barre.add(Membres);

        setJMenuBar(barre);

        setSize(800,400);
        setVisible(true);
        setBackground(Color.GREEN);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);








        class ListnerLivre implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand() == "enregistrer"){
                    //class.forName ("com.mysql.jdbc.Driver");
                }
            }
        }






    }











    class  ListnerMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == nouveauL){
                new Livres();
            }else if (e.getSource() == nouveauM ){
                new Membres();

            }
        }
    }

}
