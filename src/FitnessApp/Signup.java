package FitnessApp;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Signup();
    }
    JRadioButton r1,r2,r3;
    String qq[] = {"Who is your best Friend?","Favourite Superhero?","Favourite movie?"};

    JButton sub,back;

    JTextField namee,mnamee,emaild,password,ans,securitya;
    JDateChooser datee;
    Choice security;
    Font font = new Font("",Font.PLAIN,15);
    Cursor cur = new Cursor(Cursor.HAND_CURSOR);
    Signup(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0,900,700);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/white.png"));
        Image i2 = i1.getImage().getScaledInstance(700,900,0);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i1);
        label.setBounds(1,1,884,661);
        label.setBorder(BorderFactory.createLineBorder(Color.black,5));
        this.add(label);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("image/signup1.jpg"));
        JLabel ss = new JLabel(i4);
        ss.setBounds(400,100,550,400);
        label.add(ss);

        JLabel head = new JLabel("Sign Up");
        head.setBounds(400,20,210,40);
        head.setFont(new Font("Elephant",Font.BOLD,35));
        label.add(head);

        JLabel un = new JLabel();
        un.setBounds(350,70,270,2);
        un.setBackground(Color.black);
        un.setOpaque(true);
        un.setFont(new Font("Elephant",Font.BOLD,35));
        label.add(un);

        JLabel name = new JLabel("Name :- ");
        name.setBounds(40,140,100,25);
        name.setFont(new Font("Basics",Font.ROMAN_BASELINE,20));
        label.add(name);

        JLabel fname = new JLabel("Father Name :- ");
        fname.setBounds(40,200,150,25);
        fname.setFont(new Font("Basics",Font.ROMAN_BASELINE,20));
        label.add(fname);

        JLabel email = new JLabel("Email-ID :- ");
        email.setBounds(40,260,150,25);
        email.setFont(new Font("Basics",Font.ROMAN_BASELINE,20));
        label.add(email);

        JLabel pass = new JLabel("Password :- ");
        pass.setBounds(40,320,150,25);
        pass.setFont(new Font("Basics",Font.ROMAN_BASELINE,20));
        label.add(pass);

        JLabel securityq = new JLabel("Security Ques. :-");
        securityq.setBounds(40,380,160,25);
        securityq.setFont(new Font("Basics",Font.ROMAN_BASELINE,20));
        label.add(securityq);

        JLabel securitya = new JLabel("Answer :-");
        securitya.setBounds(40,440,160,25);
        securitya.setFont(new Font("Basics",Font.ROMAN_BASELINE,20));
        label.add(securitya);

        JLabel dob= new JLabel("D.O.B :-");
        dob.setBounds(40,500,160,25);
        dob.setFont(new Font("Basics",Font.ROMAN_BASELINE,20));
        label.add(dob);

        JLabel gender = new JLabel("Gender :-");
        gender.setBounds(40,560,160,25);
        gender.setFont(new Font("Basics",Font.ROMAN_BASELINE,20));
        label.add(gender);

        r1 = new JRadioButton("Male");
        r1.setFocusable(false);
        r1.setBounds(200,562,70,25);
        r1.setCursor(cur);
        r1.setOpaque(false);
        label.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFocusable(false);
        r2.setBounds(260,562,70,25);
        r2.setOpaque(false);
        r2.setCursor(cur);
        label.add(r2);

        r3 = new JRadioButton("Others");
        r3.setFocusable(false);
        r3.setCursor(cur);
        r3.setBounds(320,562,70,25);
        r3.setOpaque(false);
        label.add(r3);

        ButtonGroup b1 = new ButtonGroup();
        b1.add(r1);
        b1.add(r2);
        b1.add(r3);

        namee = new JTextField();
        namee.setBounds(200,143,200,23);
        namee.setCursor(cur);
        namee.setFont(font);
        label.add(namee);

        mnamee = new JTextField();
        mnamee.setBounds(200,203,200,23);
        mnamee.setCursor(cur);
        mnamee.setFont(font);
        label.add(mnamee);

        emaild = new JTextField();
        emaild.setBounds(200,263,200,23);
        emaild.setCursor(cur);
        emaild.setFont(font);
        label.add(emaild);

        password = new JTextField();
        password.setBounds(200,323,200,23);
        password.setCursor(cur);
        password.setFont(font);
        label.add(password);

        security = new Choice();
        security.add("Who is your best Friend?");
        security.add("Favourite Superhero?");
        security.add("Favourite movie?");
        security.setBounds(200,383,200,23);
        security.setCursor(cur);
        security.setFont(new Font("",Font.PLAIN,14));
        label.add(security);

        ans = new JTextField();
        ans.setBounds(200,443,200,23);
        ans.setCursor(cur);
        ans.setFont(font);
        label.add(ans);

        datee = new JDateChooser();
        datee.setBounds(200,503,200,23);
        datee.setCursor(cur);
        label.add(datee);

        back = new JButton("Back");
        back.setBounds(40,615,90,25);
        back.setFocusable(false);
        back.addActionListener(this);
        back.setCursor(cur);
        label.add(back);

        sub = new JButton("Submit");
        sub.setBounds(320,615,90,25);
        sub.setFocusable(false);
        sub.setCursor(cur);
        sub.addActionListener(this);
        label.add(sub);

    }
    public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date) {
        if (date != null) {
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sub)
        {
            if(namee.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter name!","Incomplete data",JOptionPane.ERROR_MESSAGE);
            }
            else if(mnamee.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter middle name!","Incomplete data",JOptionPane.ERROR_MESSAGE);
            }
            else if(emaild.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter Email-ID!","Incomplete data",JOptionPane.ERROR_MESSAGE);
            }
            else if (((JTextField)datee.getDateEditor().getUiComponent()).getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Enter D.O.B!","Incomplete data",JOptionPane.ERROR_MESSAGE);
            }else if(password.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter PassWord!","Incomplete data",JOptionPane.ERROR_MESSAGE);
            }
            else{
                String first_name = namee.getText();
                String middle_name = mnamee.getText();
                String email_ID = emaild.getText();
                String passwordd = password.getText();
                String sq = String.valueOf(security.getSelectedItem());
                String sa = ans.getText();
                String jain= String.valueOf(convertUtilDateToSqlDate(datee.getDate()));
                String genderr="";
                if(r1.isSelected()){
                    genderr="male";
                }
                if(r2.isSelected()){
                    genderr="female";
                }
                if(r3.isSelected()){
                    genderr="others";
                }
                try{
                    Conn c = new Conn();
                    String q = ("select * from users where email_id = '"+email_ID+"'");
                    ResultSet rs = c.s.executeQuery(q);
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null,"This email-id is already taken!","Data problem",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        String query = "insert into users values('"+first_name+"','"+middle_name+"','"+email_ID+"','"+passwordd+"','"+sq+"','"+sa+"','"+jain+"','"+genderr+"')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Data Saved Successfully","Message",JOptionPane.PLAIN_MESSAGE);
                    }

                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }

        }else if(e.getSource()==back){
            this.dispose();
            new Intro1();
        }
    }
}
