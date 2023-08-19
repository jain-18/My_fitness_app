package FitnessApp;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Rtable extends JFrame implements ActionListener {

    JTable table;
    JButton bu1, bu2, bu3,bu4;
    JDateChooser tarik;
    Cursor cur = new Cursor(Cursor.HAND_CURSOR);
    JTextField ave;
    JLabel avg;
    String emaill;






    public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date) {
        if (date != null) {
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }

    Rtable(String email) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        emaill = email;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/rtab.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,680,2);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel label = new JLabel(i3);
        label.setBounds(1,1,883,660);
        label.setBorder(BorderFactory.createLineBorder(Color.black,2));
        this.add(label);

        Border border = BorderFactory.createLineBorder(Color.lightGray, 5);


        JLabel spec = new JLabel("Specific date:-");
        spec.setBounds(20, 90, 200, 25);
        spec.setFont(new Font("Basic", Font.PLAIN, 20));
        label.add(spec);

        tarik = new JDateChooser();
        tarik.setBounds(160, 93, 100, 25);
        tarik.setCursor(cur);
        label.add(tarik);

        bu1 = new JButton("Weekly report");
        bu1.setBounds(620, 92, 120, 25);
        bu1.setFocusable(false);
        bu1.setCursor(cur);
        bu1.addActionListener(this);
        label.add(bu1);

        bu2 = new JButton("Monthly report");
        bu2.setBounds(750, 92, 120, 25);
        bu2.setFocusable(false);
        bu2.setCursor(cur);
        bu2.addActionListener(this);
        label.add(bu2);

        bu3 = new JButton("Search");
        bu3.setBounds(260, 93, 85, 25);
        bu3.setFocusable(false);
        bu3.setCursor(cur);
        bu3.addActionListener(this);
        label.add(bu3);

        bu4 = new JButton("Back");
        bu4.setBounds(10, 20, 85, 25);
        bu4.setFocusable(false);
        bu4.setCursor(cur);
        bu4.addActionListener(this);
        label.add(bu4);

        avg = new JLabel("Avg. Cal. intake:-");
        avg.setBounds(380, 90, 150, 25);
        avg.setFont(new Font("Basic", Font.ROMAN_BASELINE, 18));
        avg.setVisible(false);
        label.add(avg);

        ave = new JTextField("0");
        ave.setBounds(520, 93, 70, 25);
        ave.setVisible(false);
        label.add(ave);


        table = new JTable();

        try {
            Conn c = new Conn();
            String query = ("select first_name,TIMESTAMPDIFF(YEAR, dob, CURDATE()) AS age,bmi,calin,weight,height,datee from hasrecord h natural join users u where h.email_id = '"+emaill+"' order by datee desc");
            ResultSet rs = c.s.executeQuery(query);
            table.setModel((DbUtils.resultSetToTableModel(rs)));

        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(3, 150, 870, 500);
        label.add(jsp);


    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bu1) {
            ave.setVisible(true);
            avg.setVisible(true);
            try {
                ave.setVisible(true);
                avg.setVisible(true);
                Conn c = new Conn();
                String q = ("Select avg(calin) as avg_cal from (select calin from hasrecord where email_id = '" + emaill + "' order by datee desc limit 7)a; ");
                ResultSet sr = c.s.executeQuery(q);
                while (sr.next()) {
                    ave.setText(sr.getString("avg_cal"));
                    ave.setEditable(false);
                    ave.setOpaque(false);
                }
                String query = ("select first_name,TIMESTAMPDIFF(YEAR, dob, CURDATE()) AS age,bmi,calin,weight,height,datee from hasrecord h natural join users u where h.email_id = '"+emaill+"' order by datee desc limit 7");
                ResultSet rs = c.s.executeQuery(query);
                table.setModel((DbUtils.resultSetToTableModel(rs)));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        else if(e.getSource()==bu2) {
            ave.setVisible(true);
            avg.setVisible(true);
            try {
                ave.setVisible(true);
                avg.setVisible(true);
                Conn c = new Conn();
                String q = ("Select avg(calin) as avg_cal from (select calin from hasrecord where email_id = '" + emaill + "' order by datee desc limit 30)a; ");
                ResultSet sr = c.s.executeQuery(q);
                while (sr.next()) {
                    ave.setText(sr.getString("avg_cal"));
                    ave.setEditable(false);
                    ave.setOpaque(false);
                }
                String query = ("select first_name,TIMESTAMPDIFF(YEAR, dob, CURDATE()) AS age,bmi,calin,weight,height,datee from hasrecord h natural join users u where h.email_id = '"+emaill+"' order by datee desc limit 30");
                ResultSet rs = c.s.executeQuery(query);
                table.setModel((DbUtils.resultSetToTableModel(rs)));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        else if(e.getSource()==bu3)
        {
            String jain=((JTextField)tarik.getDateEditor().getUiComponent()).getText();
            System.out.println(jain);
            if( jain.equals("")){
                JOptionPane.showMessageDialog(null,"Enter date!","Incomplete data!",JOptionPane.ERROR_MESSAGE);

            }
            else if(jain != null){
                avg.setVisible(false);
                ave.setVisible(false);
                String ddate = String.valueOf(convertUtilDateToSqlDate(tarik.getDate()));
                System.out.println(ddate);
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select first_name,TIMESTAMPDIFF(YEAR, dob, CURDATE()) AS age,bmi,calin,weight,height,datee from hasrecord h  inner join users u on u.email_id = '"+emaill+"' and datee = '"+ddate+"'");
                    if(rs.isBeforeFirst()) {
                        table.setModel((DbUtils.resultSetToTableModel(rs)));
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No data on such date","No Data",JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (Exception a){
                    a.printStackTrace();
              }
            }
        }
        else if(e.getSource()==bu4){
            this.dispose();
            new Menu(emaill);
        }
    }
}
