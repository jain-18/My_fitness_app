package FitnessApp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ShowRec extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new ShowRec("shubhamjain12368@gmail.com");
    }
    JTextField n1,n2;
    JButton bu1,bu2;
    JRadioButton r1,r2,r3;
    ButtonGroup b1;
    String emaill ;
    Cursor cur = new Cursor(Cursor.HAND_CURSOR);
    ShowRec(String email){
        emaill = email;
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,550);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/white.png"));
        Border border = BorderFactory.createLineBorder(Color.lightGray, 5);
        Border border1 = BorderFactory.createLineBorder(Color.black, 5);
        JLabel l1 = new JLabel(i1);
        l1.setBorder(border);
        l1.setBounds(0,0,786,513);
        this.add(l1);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("image/rec21.jpg"));
        JLabel l2 = new JLabel(i2);
        l2.setBounds(370,120,400,300);
        l1.add(l2);

//        JLabel label = new JLabel();
//        label.setBounds(10,80,370,200);
//        label.setBackground(Color.lightGray);
//        label.setOpaque(true);
//        l1.add(label);

        JLabel head = new JLabel("Show Record");
        head.setForeground(Color.BLACK);
        head.setBounds(300,30,400,40);
        head.setFont(new Font("Elephant",Font.BOLD,35));
        l1.add(head);

        JLabel un = new JLabel("");
        un.setBounds(280,80,280,3);
        un.setOpaque(true);
        un.setBackground(Color.BLACK);
        l1.add(un);

        JLabel fname = new JLabel("First name:-");
        fname.setBounds(20,150,130,25);
        fname.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
        fname.setForeground(Color.BLACK);
        l1.add(fname);

        JLabel faname = new JLabel("Age :-");
        faname.setBounds(20,220,130,25);
        faname.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
        faname.setForeground(Color.BLACK);
        l1.add(faname);

        JLabel gender = new JLabel("Gender:-");
        gender.setBounds(20,290,130,25);
        gender.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
        gender.setForeground(Color.BLACK);
        l1.add(gender);

        n1 = new JTextField();
        n1.setBounds(170,150,200,25);
        n1.setFont(new Font("",Font.PLAIN,18));
        n1.setEditable(false);
        n1.setCursor(cur);
        l1.add(n1);

        n2 = new JTextField();
        n2.setBounds(170,220,200,25);
        n2.setFont(new Font("",Font.PLAIN,18));
        n2.setCursor(cur);
        n2.setEditable(false);
        l1.add(n2);

        r1 = new JRadioButton("Male");
        r1.setFocusable(false);
        r1.setBounds(170,290,70,25);
        r1.setCursor(cur);
        r1.setOpaque(false);
        l1.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFocusable(false);
        r2.setBounds(240,290,70,25);
        r2.setOpaque(false);
        r2.setCursor(cur);
        l1.add(r2);

        r3 = new JRadioButton("Others");
        r3.setFocusable(false);
        r3.setBounds(310,290,70,25);
        r3.setOpaque(false);
        r3.setCursor(cur);
        l1.add(r3);


        b1 = new ButtonGroup();
        b1.add(r1);
        b1.add(r2);
        b1.add(r3);

        bu1 = new JButton("Back");
        bu1.setBounds(25,360,90,30);
        bu1.setFocusable(false);
        bu1.setCursor(cur);
        bu1.addActionListener(this);
        l1.add(bu1);

        bu2 = new JButton("Next");
        bu2.setBounds(270,360,90,30);
        bu2.setFocusable(false);
        bu2.setCursor(cur);
        bu2.addActionListener(this);
        l1.add(bu2);

        try{
            Conn c = new Conn();
            String query = ("Select *,TIMESTAMPDIFF(YEAR, dob, CURDATE()) AS age from users where email_id = '"+email+"'");
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                n1.setText(rs.getString("first_name"));
                n2.setText(rs.getString("age"));
                String gen = rs.getString("gender");
                if(gen.equals("male")){
                    r1.setSelected(true);
                }
                else if(gen.equals("female")){
                    r2.setSelected(true);
                }
                else {
                    r3.setSelected(true);
                }
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bu2){
            if(n1.getText().equals("") ){
                JOptionPane.showMessageDialog(null,"Enter First name!","Incomplete data.",JOptionPane.ERROR_MESSAGE);
            }
            else if(n2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Middle name!", "Incomplete data.", JOptionPane.ERROR_MESSAGE);
            }
            else if(!(r1.isSelected() || r2.isSelected() || r3.isSelected() )){
                JOptionPane.showMessageDialog(null, "Select Gender!", "Incomplete data.", JOptionPane.ERROR_MESSAGE);
            }
            else if(n1.getText() != "" && n2.getText() != "" && (r1.isSelected() || r2.isSelected() || r3.isSelected() ))
            {
                    String first_name,middle_name;
                    String genderr="";
                    first_name = n1.getText();
                    middle_name = n2.getText();
                    if(r1.isSelected()){
                        genderr="male";
                    }
                    if(r2.isSelected()){
                        genderr="female";
                    }
                    if(r3.isSelected()){
                        genderr="others";
                    }
                    new Rtable(emaill);
                    this.dispose();
                System.out.println(first_name+" "+middle_name+" "+genderr);
            }

        } else if (e.getSource()==bu1) {
            this.dispose();
            new Menu(emaill);
        }
    }
}
