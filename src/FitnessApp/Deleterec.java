package FitnessApp;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Deleterec extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Deleterec("shubhamjain12368@gmail.com");
    }

    JTextField n1, n2;
    JButton bu1, bu2;
    JRadioButton r1, r2, r3, r4, r5;
    ButtonGroup b1, b2;
    JDateChooser ddate;
    String emaill;

    Deleterec(String email) {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 550);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        emaill = email;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/white.png"));
        Border border = BorderFactory.createLineBorder(Color.black, 5);
        Border border1 = BorderFactory.createLineBorder(Color.black, 5);
        JLabel l1 = new JLabel(i1);
        l1.setBorder(border);
//        l1.setBounds(0, 0, 786, 513);
        l1.setBounds(1,1,783,510);
        l1.setBorder(BorderFactory.createLineBorder(Color.black,5));
        this.add(l1);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("image/rec21.jpg"));
        JLabel l2 = new JLabel(i2);
        l2.setBounds(370, 120, 400, 300);
        l1.add(l2);

//        JLabel label = new JLabel();
//        label.setBounds(10,80,370,200);
//        label.setBackground(Color.lightGray);
//        label.setOpaque(true);
//        l1.add(label);

        JLabel head = new JLabel("Delete Record");
        head.setForeground(Color.BLACK);
        head.setBounds(300, 30, 400, 40);
        head.setFont(new Font("Elephant", Font.CENTER_BASELINE, 35));
        l1.add(head);

        JLabel un = new JLabel("");
        un.setBounds(280, 80, 280, 3);
        un.setOpaque(true);
        un.setBackground(Color.BLACK);
        l1.add(un);

        JLabel fname = new JLabel("First name:-");
        fname.setBounds(20, 120, 130, 25);
        fname.setFont(new Font("", Font.LAYOUT_LEFT_TO_RIGHT, 20));
        fname.setForeground(Color.BLACK);
        l1.add(fname);

        JLabel faname = new JLabel("Age :-");
        faname.setBounds(20, 190, 130, 25);
        faname.setFont(new Font("", Font.LAYOUT_LEFT_TO_RIGHT, 20));
        faname.setForeground(Color.BLACK);
        l1.add(faname);

        JLabel gender = new JLabel("Gender:-");
        gender.setBounds(20, 260, 130, 25);
        gender.setFont(new Font("", Font.LAYOUT_LEFT_TO_RIGHT, 20));
        gender.setForeground(Color.BLACK);
        l1.add(gender);

        JLabel specific = new JLabel("Specific Date:-");
        specific.setBounds(20, 320, 130, 25);
        specific.setFont(new Font("", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        specific.setForeground(Color.BLACK);
        l1.add(specific);

        ddate = new JDateChooser();
        ddate.setBounds(170, 350, 150, 24);
        ddate.setVisible(false);
        ddate.setVisible(false);
        l1.add(ddate);

        r4 = new JRadioButton("Yes");
        r4.setFocusable(false);
        r4.setBounds(170, 320, 70, 25);
        r4.addActionListener(this);
        r4.setOpaque(false);
        l1.add(r4);

        r5 = new JRadioButton("No,delete all");
        r5.setFocusable(false);
        r5.setBounds(240, 320, 100, 25);
        r5.addActionListener(this);
        r5.setOpaque(false);
        l1.add(r5);

        b2 = new ButtonGroup();
        b2.add(r4);
        b2.add(r5);


        n1 = new JTextField();
        n1.setBounds(170, 120, 200, 25);
        n1.setFont(new Font("", Font.PLAIN, 18));
        n1.setAlignmentX(1);
        n1.setEditable(false);
        l1.add(n1);

        n2 = new JTextField();
        n2.setBounds(170, 190, 200, 25);
        n2.setFont(new Font("", Font.PLAIN, 18));
        n2.setEditable(false);
        l1.add(n2);

        r1 = new JRadioButton("Male");
        r1.setFocusable(false);
        r1.setBounds(170, 260, 70, 25);
        r1.setOpaque(false);
        l1.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFocusable(false);
        r2.setBounds(240, 260, 70, 25);
        r2.setOpaque(false);

        l1.add(r2);

        r3 = new JRadioButton("Others");
        r3.setFocusable(false);
        r3.setBounds(310, 260, 70, 25);
        r3.setOpaque(false);
        l1.add(r3);

        b1 = new ButtonGroup();
        b1.add(r1);
        b1.add(r2);
        b1.add(r3);

        bu1 = new JButton("Back");
        bu1.setBounds(25, 390, 90, 30);
        bu1.setFocusable(false);
        bu1.addActionListener(this);
        l1.add(bu1);

        bu2 = new JButton("Submit");
        bu2.setBounds(270, 390, 90, 30);
        bu2.setFocusable(false);
        bu2.addActionListener(this);
        l1.add(bu2);

        try {
            Conn c = new Conn();
            String query = ("Select *,TIMESTAMPDIFF(YEAR, dob, CURDATE()) AS age from users where email_id = '" + emaill + "'");
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                n1.setText(rs.getString("first_name"));
                n2.setText(rs.getString("age"));
                String gen = rs.getString("gender");
                if (gen.equals("male")) {
                    r1.setSelected(true);
                } else if (gen.equals("female")) {
                    r2.setSelected(true);
                } else {
                    r3.setSelected(true);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

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
        if (r4.isSelected()) {
            bu2.setBounds(270, 420, 90, 30);
            bu1.setBounds(25, 420, 90, 30);
            ddate.setVisible(true);

        } else if (r5.isSelected()) {
            bu2.setBounds(270, 390, 90, 30);
            bu1.setBounds(25, 390, 90, 30);
            ddate.setVisible(false);
        }
        if (e.getSource() == bu2) {
            if (r4.isSelected())
            {
                String date = String.valueOf(convertUtilDateToSqlDate(ddate.getDate()));
                try {
                    Conn c = new Conn();
                    String query = ("select * from hasrecord where email_id = '" + emaill + "' and datee = '" +date+ "'");
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.isBeforeFirst()) {
                        String q = ("delete from hasrecord where email_id = '" + emaill + "' and datee = '"+date+"'");
                        c.s.executeUpdate(q);
                        JOptionPane.showMessageDialog(null, "Data delete successfully", "Delte", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No data for such date", "Wrong date", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            else if (r5.isSelected()) {
                try {
                    Conn c = new Conn();
                    String query = ("delete from hasrecord where email_id = '" + emaill + "'");
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Data delete successfully", "Delete", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }

        }else if(e.getSource()==bu1){
            this.dispose();
            new Menu(emaill);
        }
    }
}



