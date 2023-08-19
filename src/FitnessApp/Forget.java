package FitnessApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Forget extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Forget();
    }
    Font font = new Font("",Font.BOLD,16);
    Font font1 = new Font("",Font.BOLD,14);
    JButton ret,check,back;
    String emaill;
    JTextField email,name,secur_q,secur_a,password;
    Cursor cur = new Cursor(Cursor.HAND_CURSOR);

    Forget(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(0,0,800,550);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/forgetback1.png"));
        JLabel label = new JLabel(i1);
        label.setBounds(0,-20,800,550);
        this.add(label);

        JLabel head = new JLabel("Forget Password ");
        head.setBounds(330,40,250,35);
        head.setFont(new Font("Elephant",Font.BOLD,25));
        label.add(head);

        JLabel ema = new JLabel("Email_ID :- ");
        ema.setBounds(150,130,100,20);
        ema.setFont(font);
        label.add(ema);

        JLabel first = new JLabel("Name :- ");
        first.setBounds(150,180,100,20);
        first.setFont(font);
        label.add(first);

        JLabel sec_q = new JLabel("Security Question :- ");
        sec_q.setBounds(80,230,180,20);
        sec_q.setFont(font);
        label.add(sec_q);

        JLabel sec_a = new JLabel("Answer :- ");
        sec_a.setBounds(150,280,100,20);
        sec_a.setFont(font);
        label.add(sec_a);

        JLabel pass = new JLabel("Password :- ");
        pass.setBounds(150,330,100,20);
        pass.setFont(font);
        label.add(pass);

        email = new JTextField();
        email.setBounds(270,130,200,20);
        email.setFont(font1);
        email.setBorder(BorderFactory.createLineBorder(Color.black,1));
        email.setCursor(cur);
        label.add(email);

        name = new JTextField();
        name.setBounds(270,180,200,20);
        name.setFont(font1);
        name.setBorder(BorderFactory.createLineBorder(Color.black,1));
        name.setCursor(cur);
        label.add(name);

        secur_q= new JTextField();
        secur_q.setBounds(270,230,200,20);
        secur_q.setFont(font1);
        secur_q.setBorder(BorderFactory.createLineBorder(Color.black,1));
        secur_q.setCursor(cur);
        label.add(secur_q);

        secur_a= new JTextField();
        secur_a.setBounds(270,280,200,20);
        secur_a.setFont(font1);
        secur_a.setBorder(BorderFactory.createLineBorder(Color.black,1));
        secur_a.setCursor(cur);
        label.add(secur_a);

        password = new JTextField();
        password.setBounds(270,330,200,20);
        password.setFont(font1);
        password.setBorder(BorderFactory.createLineBorder(Color.black,1));
        password.setCursor(cur);
        label.add(password);

        ret = new JButton("Retrieve");
        ret.setBounds(470,130,100,20);
        ret.setFocusable(false);
        ret.setBorder(BorderFactory.createLineBorder(Color.black,1));
        ret.setBackground(Color.lightGray);
        ret.setFont(font1);
        ret.setCursor(cur);
        ret.addActionListener(this);
        label.add(ret);

        check = new JButton("check");
        check.setBounds(470,280,100,20);
        check.setFocusable(false);
        check.setBorder(BorderFactory.createLineBorder(Color.black,1));
        check.setBackground(Color.lightGray);
        check.setFont(font1);
        check.setCursor(cur);
        check.addActionListener(this);
        label.add(check);

        back = new JButton("Back");
        back.setBounds(300,380,100,20);
        back.setFocusable(false);
        back.setBorder(BorderFactory.createLineBorder(Color.black,1));
        back.setBackground(Color.lightGray);
        back.setFont(font1);
        back.setCursor(cur);
        back.addActionListener(this);
        label.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==ret)
        {
            if(email.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter Email-id","Incomplete data",JOptionPane.ERROR_MESSAGE);
            }
            else {
               emaill = email.getText();
                try{
                    String query = ("Select * from users where email_id = '"+emaill+"'");
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);

                    
                    if(rs.isBeforeFirst()){
                        while(rs.next()){
                            name.setText(rs.getString("first_name"));
                            secur_q.setText(rs.getString("sec_ques"));
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No such user exits!","Wrong data",JOptionPane.ERROR_MESSAGE);
                    }

                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        }
        else if(e.getSource() == check){
            try{
                String query = ("Select * from users where email_id = '"+email.getText()+"' and sec_ans = '"+secur_a.getText()+"'");
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

//                while(rs.next()){
//                    password.setText(rs.getString("passwordd"));
//                }
                if(rs.isBeforeFirst()){
                    while(rs.next()){
                        password.setText(rs.getString("passwordd"));
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Wrong answer!","Wrong data",JOptionPane.ERROR_MESSAGE);
                }

            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        else if(e.getSource()==back){
            this.dispose();
            new Intro1();
        }
    }
}
