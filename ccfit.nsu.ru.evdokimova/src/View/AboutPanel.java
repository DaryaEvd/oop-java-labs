package View;

import javax.swing.*;

public class AboutPanel extends JPanel {
    final private JLabel aboutLabel;

    private final String text = "Ya doma. Hochu pogladit kota, no on ubezhal(";
    public AboutPanel(int width, int height) {
        setLayout(null);

         aboutLabel = new JLabel(text);

//        add(aboutLabel);
//        setVisible(true);


    }

    public void showMsg() {
       add(aboutLabel);
       setVisible(true);
    }
}
