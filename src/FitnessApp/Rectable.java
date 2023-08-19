package FitnessApp;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Rectable extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Rectable("shubham jain","Sohanlal jain ","male");
    }
    JTable table;
    JButton bu1,bu2,bu3;
    JDateChooser tarik;
    Cursor cur = new Cursor(Cursor.HAND_CURSOR);
    JTextField ave;
    JLabel avg;
    ResultSet rs,week,month;
    Conn c;
    String fn,mn,gd;
    PreparedStatement pst;

    public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date) {
        if (date != null) {
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }
    Rectable(String first_name,String father_name,String gender)
    {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);
            this.setSize(900,700);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            this.setResizable(false);

        Border border = BorderFactory.createLineBorder(Color.lightGray, 5);

            fn = first_name;
            mn = father_name;
            gd = gender;

            JLabel spec = new JLabel("Specific date:-");
            spec.setBounds(20,90,200,25);
            spec.setFont(new Font("Basic",Font.ROMAN_BASELINE,20));
            this.add(spec);

            tarik = new JDateChooser();
            tarik.setBounds(160,93,100,25);
            tarik.setCursor(cur);
            this.add(tarik);

            bu1 = new JButton("Weekly report");
            bu1.setBounds(630,92,120,25);
            bu1.addActionListener(this);
            bu1.setCursor(cur);
            bu1.setFocusable(false);
            this.add(bu1);

            bu2 = new JButton("Monthly report");
            bu2.setBounds(760,92,120,25);
            bu2.addActionListener(this);
            bu2.setCursor(cur);
            bu2.setFocusable(false);
            this.add(bu2);

             bu3 = new JButton("Search");
             bu3.setBounds(260,93,85,25);
             bu3.addActionListener(this);
             bu3.setCursor(cur);
             bu3.setFocusable(false);
            this.add(bu3);

            avg = new JLabel("Avg. Cal. intake:-");
            avg.setBounds(380,90,150,25);
            avg.setFont(new Font("Basic",Font.ROMAN_BASELINE,18));
            avg.setVisible(false);
            this.add(avg);

            ave = new JTextField("0");
            ave.setBounds(520,93,70,25);
            ave.setVisible(false);
            this.add(ave);














            table=new JTable();
            try{
                c = new Conn();
//                ResultSet rs = c.s.executeQuery("Select * from rec where first_name = '"+fn+"' and middle_name = '"+mn+"' and gender = '"+gd+"'");
//                ResultSet rs = c.s.executeQuery("select * from rec");
                rs = c.s.executeQuery("Select * from rec where first_name = '"+fn+"' and gender = '"+gd+"'");
                table.setModel((DbUtils.resultSetToTableModel(rs)));

            }catch (Exception e){
                e.printStackTrace();
            }
            JScrollPane jsp = new JScrollPane(table);
            jsp.setBounds(1,150,884,513);
            this.add(jsp);



    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bu1)
        {
            ave.setVisible(true);
            avg.setVisible(true);
            try{
                ave.setVisible(true);
                avg.setVisible(true);
//                String sql = ("select avg(calin) from rec where first_name = '"+fn+"' and gender = '"+gd+"' order by datee ");
//                pst = c.c.prepareStatement(sql);
//                rs = pst.executeQuery();
//                String weekave = rs.getString("avg(calin)");
//                ave.setText(weekave);

                rs = c.s.executeQuery("select * from rec where first_name = '"+fn+"' and gender = '"+gd+"' order by datee desc limit 7");
                table.setModel((DbUtils.resultSetToTableModel(rs)));
            }catch (Exception exception){
                exception.printStackTrace();
            }

        }
        else if(e.getSource()==bu2) {
            ave.setVisible(true);
            avg.setVisible(true);
            try {
                ave.setVisible(true);
                avg.setVisible(true);
//                month = c.s.executeQuery("select avg(calin) from rec where first_name = '" + fn + "' and gender = '" + gd + "' order by datee desc limit 30");
//                ave.setText(String.valueOf(ave));
                rs = c.s.executeQuery("select * from rec where first_name = '" + fn + "' and gender = '" + gd + "' order by datee desc limit 30");
                table.setModel((DbUtils.resultSetToTableModel(rs)));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }else if(e.getSource()==bu3)
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
                    rs = c.s.executeQuery("select * from rec where first_name = '"+fn+"' and gender = '"+gd+"' and datee = '"+ddate+"'");
                    table.setModel((DbUtils.resultSetToTableModel(rs)));
                }
                catch (Exception a){
                    a.printStackTrace();
                }
            }
        }
    }
}

