import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HeatlBar extends JFrame {
    private JProgressBar healthBar;

    public HeatlBar() {
        // gör en titel längst upp i ramen
        super("Health Bar");
        // Gör så att baren går lodrätt och att max hp är 100 och minsta är 0
        healthBar = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
        // att den är 100 i början
        healthBar.setValue(100);
        // gör så att hp (100% som sedan går neråt) står på panelen
        healthBar.setStringPainted(true);
        // Gör att knappen finns och att det står "Decrease". ActionListener gör så att kanppen fungerar utan den skulle knappen vara där men inte ta bort hp
        JButton decreaseButton = new JButton("Decrease");
        decreaseButton.addActionListener(new ActionListener() {
            // Gör så att healthbaren tappar 10 hp varje klick ActionEvent e är en typ av metod som gör att hela saken fungerar.
            public void actionPerformed(ActionEvent e) {
                int newValue = healthBar.getValue() - 10;
                // detta gör så att om hp är 0 och man klickar kommer den bara stanna på 0. Ingenting kommer hända då.
                healthBar.setValue(newValue < 0 ? 0 : newValue);
            }
        });
        // gör så att ramen blir en box
        JPanel panel = new JPanel(new BorderLayout());
        // gör så att mitten i ramen syns, själva baren.
        panel.add(healthBar, BorderLayout.CENTER);
        // Lägger till knappen man klickar på och South gör att den kommer längst ner
        panel.add(decreaseButton, BorderLayout.SOUTH);

        // Gör så att hela ramen under
        setContentPane(panel);
        // pack gör så att ramen hammnar minst så att allt content får plats
        pack();
        // programet stänger när man klickar på x
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Gör så att fönstret hammnar i mitten på skärmen när man kör pogramet.
        setLocationRelativeTo(null);
        // Sista biten i pusslet. Gör så att fönstret ens dycker upp
        setVisible(true);

    }
}