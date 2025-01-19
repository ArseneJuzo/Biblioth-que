import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.net.http.WebSocket;

public class Membres extends JPanel{

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);
    }

    private JPanel pane1;
    private JPanel pane2;
    private JPanel pane3;
    private JPanel pane;


    JLabel labelcopi;

    JLabel titreFormulaire;
    JLabel labelnom;
    JLabel labeltelephone;
    JLabel labelemail;
    JLabel labeladresse;
   // JLabel labeldate_enregistrement;


    JTextField titre;
    JTextField nom;
    JTextField telephone;
    JTextField email;
    JTextField adresse;
    //JTextField date_enregistrement;


    JButton button;

    public Membres (){
        titreFormulaire = new JLabel("INFORMATIONS DU MEMBRE");
        titreFormulaire.setIcon(new ImageIcon("C:/Users/root le jokers/Downloads/01.png"));

        labelnom = new JLabel ("Nom du Membre: ",JLabel.CENTER);
        labeltelephone = new JLabel ("Telephone : ",JLabel.CENTER);
        labelemail = new JLabel ("Email : ",JLabel.CENTER);
        labeladresse = new JLabel ("Adresse : ",JLabel.CENTER);
       // labeldate_enregistrement = new JLabel ("Date d'enregistrement : ",JLabel.CENTER);

        nom = new JTextField("");
        telephone = new JTextField("+237 6XXXXXXXX");
        email = new JTextField("Exemple@gmail.com");
        adresse = new JTextField(20);
        //date_enregistrement = new JTextField(20);

        labelcopi = new JLabel("© Copyright 2025. Votre Bibliothèque par les etudiants de l'IAI cameroun (L2A)",JLabel.CENTER);





        pane1 = new JPanel();
        pane1.add(titreFormulaire);
        pane1.setBackground(Color.PINK);


        pane2 = new JPanel(new GridLayout(6, 2, 5, 5));
        pane2.setBackground(Color.GRAY);
        pane2.add(labelnom);
        pane2.add(nom);
        pane2.add(labeltelephone);
        pane2.add(telephone);
        pane2.add(labelemail);
        pane2.add(email);
        pane2.add(labeladresse);
        pane2.add(adresse);
       // pane2.add(labeldate_enregistrement);
      //  pane2.add(date_enregistrement);


        // Buttons for various actions

        JButton findMemberButton = new JButton("Find Member's Info");
        findMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestion.findMemberInfo();
            }
        });

        JButton addMemberButton = new JButton("Add Member");
        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestion.addMember();
            }
        });
        JButton removeMemberButton = new JButton("Remove Member");
        removeMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Gestion.deletemember();
            }
        });

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));

        buttonPanel.add(addMemberButton);
        buttonPanel.add(findMemberButton);
        // Creates a panel to hold the Find buttons
        JPanel findPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        findPanel.setBorder(BorderFactory.createTitledBorder("Find Information"));
        findPanel.add(addMemberButton);
        findPanel.add(removeMemberButton);
        findPanel.add(findMemberButton);




        button = new JButton("enregistrer");
        button.addActionListener(new ListnerMembre() );
        pane3 = new JPanel(new GridLayout(2,1));

        pane3.add(findPanel);
        pane3.add(labelcopi);

        pane3.setBackground(Color.orange);

        pane = new JPanel(new BorderLayout());

        pane.add(pane1,BorderLayout.NORTH);
        pane.add(pane2,BorderLayout.CENTER);
        pane.add(pane3,BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(pane,BorderLayout.CENTER);
        Membres.getDefaultLocale();
        setVisible(true);
        //setSize(500,300);
        //setSize(800,400);
        //pack();
        //setBackground(Color.GREEN);
        //setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    class ListnerMembre implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "enregistrer"){
                //class.forName ("com.mysql.jdbc.Driver");
            }
        }
    }

}
