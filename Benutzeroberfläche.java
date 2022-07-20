
/**
 * Klasse Benutzeroberfläche.
 *  
 * @author 
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;

import java.util.ArrayList;

public class Benutzeroberfläche extends JFrame{

    private JPanel contentPane;
    private JTextField tfSpielerDrei;
    private JTextField tfSpielerVier;
    private JTextField tfSpielerEins;
    private JTextField tfSpielerZwei;
    private JTextField tfPerson;

    public void main() {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Benutzeroberfläche frame = new Benutzeroberfläche();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    public Benutzeroberfläche() {
        setTitle("Goethe Monopoly");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 350, 400, 280);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        tfSpielerDrei = new JTextField();
        tfSpielerDrei.setFont(new Font("Tahoma", Font.PLAIN, 12));
        tfSpielerDrei.setBounds(267, 80, 87, 20);
        contentPane.add(tfSpielerDrei);

        tfSpielerVier = new JTextField();
        tfSpielerVier.setFont(new Font("Tahoma", Font.PLAIN, 12));
        tfSpielerVier.setBounds(267, 108, 87, 20);
        contentPane.add(tfSpielerVier);

        JLabel spielerDrei = new JLabel("Spieler 3:");
        spielerDrei.setFont(new Font("Tahoma", Font.PLAIN, 12));
        spielerDrei.setBounds(60, 77, 102, 26);
        contentPane.add(spielerDrei);

        JLabel spielerVier = new JLabel("Spieler 4:");
        spielerVier.setFont(new Font("Tahoma", Font.PLAIN, 12));
        spielerVier.setBounds(60, 105, 102, 26);
        contentPane.add(spielerVier);
        

        JButton btNeu = new JButton("Spiel starten");
        btNeu.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    neu();
                }
            });
        btNeu.setBounds(20, 180, 150, 25);
        contentPane.add(btNeu);

        JButton btBeenden = new JButton("Beenden");
        btBeenden.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    beenden();
                }
            });
        btBeenden.setBounds(262, 180, 100, 25);
        contentPane.add(btBeenden);

        JLabel spielerEins = new JLabel("Spieler 1:");
        spielerEins.setFont(new Font("Tahoma", Font.PLAIN, 12));
        spielerEins.setBounds(60, 21, 102, 26);
        contentPane.add(spielerEins);

        tfSpielerEins = new JTextField();
        tfSpielerEins.setFont(new Font("Tahoma", Font.PLAIN, 12));
        tfSpielerEins.setBounds(267, 24, 87, 20);
        contentPane.add(tfSpielerEins);

        JLabel spielerZwei = new JLabel("Spieler 2:");
        spielerZwei.setFont(new Font("Tahoma", Font.PLAIN, 12));
        spielerZwei.setBounds(60, 49, 102, 26);
        contentPane.add(spielerZwei);

        tfSpielerZwei = new JTextField();
        tfSpielerZwei.setFont(new Font("Tahoma", Font.PLAIN, 12));
        tfSpielerZwei.setBounds(267, 52, 87, 20);
        contentPane.add(tfSpielerZwei);


        tfSpielerDrei.requestFocus();
    }
    
    private void add_string(String s, ArrayList<String> list){
        if(s != null){
            list.add(s);
        }
    }
    
    private void neu() {
        tfSpielerEins.setText(tfSpielerEins.getText());
        tfSpielerZwei.setText(tfSpielerZwei.getText());
        tfSpielerDrei.setText(tfSpielerDrei.getText());
        tfSpielerVier.setText(tfSpielerVier.getText());
        String[] spieler = new String[4];
        ArrayList<String> names = new ArrayList<String>();
        add_string(tfSpielerEins.getText(), names);
        add_string(tfSpielerZwei.getText(), names);
        add_string(tfSpielerDrei.getText(), names);
        add_string(tfSpielerVier.getText(), names);
        /*
        spieler[0] = tfSpielerEins.getText();
        spieler[1] = tfSpielerZwei.getText();
        spieler[2] = tfSpielerDrei.getText();
        spieler[3] = tfSpielerVier.getText();*/
        String[] names_= new String[1];
        names_ = names.toArray(names_);
        
        new Spiel(names_);
        dispose();
    }

    private void beenden() {
        dispose();
        System.exit(0);
    }
    /*---------------Methoden------*/    

}
