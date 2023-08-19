package FitnessApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Intro1 extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Intro1();
    }

    JTextField emaill;
    JPasswordField passwor;
    JButton sign,login,forget;
    Cursor cur = new Cursor(Cursor.HAND_CURSOR);
    Intro1(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(0,0,800,550);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/Intro1.png."));
        JLabel label = new JLabel(i1);
//        label.setBounds(-10,-20,820,570);
        label.setBounds(1,1,783,510);
//        label.setBorder(BorderFactory.createLineBorder(Color.white,5));
        this.add(label);

        JLabel head = new JLabel("MY FITNESS APP");
        head.setBounds(50,60,400,100);
        head.setFont(new Font("Times new roman",Font.ROMAN_BASELINE,50));
        head.setForeground(Color.white);
        label.add(head);

        JLabel un = new JLabel("MY FITNESS APP");
        un.setBounds(40,130,400,6);
        un.setFont(new Font("Times new roman",Font.ROMAN_BASELINE,50));
        un.setBackground(Color.black);
        un.setOpaque(true);
        label.add(un);

        JLabel email = new JLabel("Email-ID :- ");
        email.setBounds(50,180,150,30);
        email.setFont(new Font("Bsics",Font.ROMAN_BASELINE,25));
        email.setForeground(Color.lightGray);
        label.add(email);

        JLabel pass = new JLabel("Password :- ");
        pass.setBounds(50,230,200,30);
        pass.setFont(new Font("Bsics",Font.ROMAN_BASELINE,25));
        pass.setForeground(Color.lightGray);
        label.add(pass);

        emaill = new JTextField();
        emaill.setBounds(200,185,230,25);
        emaill.setFont(new Font("Basics",Font.ROMAN_BASELINE,16));
        emaill.setForeground(Color.black);
        emaill.setCursor(cur);
        emaill.setBorder(BorderFactory.createLineBorder(Color.lightGray,2));
        label.add(emaill);

        passwor = new JPasswordField();
        passwor.setBounds(200,235,230,25);
        passwor.setFont(new Font("Basics",Font.ROMAN_BASELINE,25));
        passwor.setForeground(Color.black);
        passwor.setCursor(cur);
        passwor.setBorder(BorderFactory.createLineBorder(Color.lightGray,2));
        label.add(passwor);

        login = new JButton("Login");
        login.setBounds(50,290,180,25);
        login.setFocusable(false);
        login.addActionListener(this);
        login.setForeground(Color.BLACK);
        login.setCursor(cur);
        login.setBackground(Color.lightGray);
        login.setBorder(BorderFactory.createLineBorder(Color.black,1));
        label.add(login);

        sign = new JButton("Sign Up");
        sign.setBounds(250,290,180,25);
        sign.setFocusable(false);
        sign.setForeground(Color.BLACK);
        sign.setBackground(Color.lightGray);
        sign.addActionListener(this);
        sign.setCursor(cur);
        sign.setBorder(BorderFactory.createLineBorder(Color.black,1));
        label.add(sign);

        forget = new JButton("Forget Password");
        forget.setBounds(50,330,380,25);
        forget.setFocusable(false);
        forget.setForeground(Color.BLACK);
        forget.setBackground(Color.lightGray);
        forget.setCursor(cur);
        forget.addActionListener(this);
        forget.setBorder(BorderFactory.createLineBorder(Color.black,1));
        label.add(forget);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            try{
                String email_id = emaill.getText();
                String passwaord = passwor.getText();

                String query = ("select *  from users where email_id = '"+email_id+"' and passwordd = '"+passwaord+"'");
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    this.dispose();
                    new Menu(email_id);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect email and password! ","Incomplete data",JOptionPane.ERROR_MESSAGE);
                }


            }catch (Exception exception){

            }
        } else if (e.getSource() == sign) {
            this.dispose();
            new Signup();

        }else if(e.getSource()==forget){
            this.dispose();
            new Forget();
        }
    }
}