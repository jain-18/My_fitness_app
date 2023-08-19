package FitnessApp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Intro {
    public static void main(String[] args) {

        new IntroFrame();
    }
}
class IntroFrame extends JFrame implements ActionListener {

    JLabel label;
    JButton btn;
    JLabel text1,text2,text3;
    Font font = new Font("Times New Roman",Font.CENTER_BASELINE,40);
    private static class RoundedBorder implements Border {

        private int radius;


        RoundedBorder(int radius) {
            this.radius = radius;
        }


        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }


        public boolean isBorderOpaque() {
            return true;
        }


        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
    IntroFrame(){


//        background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/Intro1.png"));
        System.out.println(i1.getIconHeight());
        label = new JLabel(i1);
        label.setOpaque(false);
        label.setBounds(0,0,i1.getIconWidth(), i1.getIconHeight());
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        this.pack();
        this.setResizable(true);
        label.setPreferredSize(new Dimension(800,532));





//        JLabel
//        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("image/textim.png"));
         text1 = new JLabel("My Fitness App! ");
//         text1.setText("Fitness App");
        text1.setBounds(70,80,300,80);
         text1.setFont(font);
//         text1.setIcon(i2);
//         text1.setOpaque(true);
         text1.setVerticalAlignment(JLabel.CENTER);
         text1.setHorizontalTextPosition(JLabel.CENTER);
         text1.setVerticalTextPosition(JLabel.CENTER);
         text1.setHorizontalTextPosition(JLabel.LEFT);
        text1.setForeground(Color.lightGray);


        Cursor cur = new Cursor(Cursor.HAND_CURSOR);
        btn = new JButton("Start Now");
        btn.setFocusable(false);
        btn.setFont(new Font("",Font.PLAIN,20));
        btn.setCursor(cur);
//        btn.setBorderPainted(false);
        btn.setContentAreaFilled(true);
        btn.setFocusPainted(false);
        btn.setBounds(100,230,200,40);
        btn.setOpaque(false);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.CENTER);
        btn.setBackground(Color.black);
        btn.setForeground(Color.WHITE);
        btn.addActionListener(this);

        JLabel Login = new JLabel("Email -Id");







//      Underline
        text3 = new JLabel();
        text3.setBounds(60,150,300,01);
        text3.setOpaque(true);
        text3.setBackground(Color.WHITE);

        ImageIcon goo = new ImageIcon(ClassLoader.getSystemResource("image/goo.png"));
        JLabel google = new JLabel(goo);
        google.setBounds(120,450,60,50);

        ImageIcon app = new ImageIcon(ClassLoader.getSystemResource("image/app.png"));
        JLabel app1 = new JLabel(app);
        app1.setBounds(200,450,60,50);














//         Layerpane
        JLayeredPane layer = new JLayeredPane();
        layer.setBounds(0,0,800,550);
        layer.add(label,Integer.valueOf(0));
        layer.add(text1,Integer.valueOf(1));
        layer.add(btn,Integer.valueOf(2));
        layer.add(text3,Integer.valueOf(2));
        layer.add(google,Integer.valueOf(3));
        layer.add(app1,Integer.valueOf(3));
//        layer.add(avail,Integer.valueOf(3));




        this.add(layer);







//        Frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0,0,800,550);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn){
            this.dispose();
            new Menu("shubhamjain12368@gmail.com");
        }
    }
}
