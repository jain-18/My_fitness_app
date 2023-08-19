package FitnessApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.NumberFormat;

public class Calfit extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Calfit("Shubhamjain12368@gmail.com");
    }
    String emaill;
    Font font = new Font("Basics",Font.ROMAN_BASELINE,23);
    Font font1 = new Font("Basics",Font.ROMAN_BASELINE,18);
    JTextField gender,age,weight,height;
    Choice act,hcal;
    JButton back,sub;
    Calfit(String email){
        emaill = email;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,550);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/call.png"));
        Image i2 = i1.getImage().getScaledInstance(800,550,1);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel label = new JLabel(i3);
        label.setBounds(1,1,784,511);
        label.setBorder(BorderFactory.createLineBorder(Color.black,5));
        this.add(label);

        JLabel head = new JLabel("How much Calorie should be Consumed.");
        head.setBounds(270,30,700,40);
        head.setFont(new Font("Elephant",Font.BOLD,23));
        head.setForeground(Color.white);
        head.setOpaque(false);
        label.add(head);

        JLabel l1 = new JLabel("Age :- ");
        l1.setBounds(300,100,70,27);
        l1.setFont(font);
        l1.setForeground(Color.white);
        label.add(l1);

        JLabel l2 = new JLabel("Gender :- ");
        l2.setBounds(300,160,130,25);
        l2.setFont(font);
        l2.setForeground(Color.white);
        label.add(l2);

        JLabel l3 = new JLabel("Weight :- ");
        l3.setBounds(300,220,130,25);
        l3.setFont(font);
        l3.setForeground(Color.white);
        label.add(l3);

        JLabel l4 = new JLabel("height :- ");
        l4.setBounds(300,280,170,25);
        l4.setFont(font);
        l4.setForeground(Color.white);
        label.add(l4);

        JLabel l5 = new JLabel("Activity type :- ");
        l5.setBounds(270,340,160,25);
        l5.setFont(font);
        l5.setForeground(Color.white);
        label.add(l5);

        age = new JTextField();
        age.setBounds(430,100,250,23);
        age.setFont(font1);
        age.setBorder(BorderFactory.createEmptyBorder());
        age.setEditable(false);
        label.add(age);

        gender = new JTextField();
        gender.setBounds(430,160,250,23);
        gender.setFont(font1);
        gender.setBorder(BorderFactory.createEmptyBorder());
        gender.setEditable(false);
        label.add(gender);

        weight = new JTextField();
        weight.setBounds(430,220,250,23);
        weight.setFont(font1);
        weight.setBorder(BorderFactory.createEmptyBorder());
//        age.setEditable(false);
        label.add(weight);

        height = new JTextField();
        height.setBounds(430,280,150,23);
        height.setFont(font1);
        height.setBorder(BorderFactory.createEmptyBorder());
//        age.setEditable(false);
        label.add(height);

        hcal = new Choice();
        hcal.setFont(new Font("",Font.PLAIN,15));
        hcal.add("cm");
        hcal.add("Feet");
        hcal.add("meter");
        hcal.setBounds(580,279,100, 23);
//        hcal.setCursor(cur);
        hcal.setFocusable(false);
        hcal.setBackground(Color.lightGray);
        label.add(hcal);

        act = new Choice();
        act.add("Bed rest (Bed ridden - Unconscious)");
        act.add("Sedentary (Little to no exercise)");
        act.add("Light exercise (1-3 days per week)");
        act.add("Moderate exercise (3-5 days per week)");
        act.add("Heavy exercise (6-7 days per week)");
        act.add("Very heavy exercise (twice per day, extra heavy workouts)");
        act.setFont(new Font("",Font.ROMAN_BASELINE,15));
        act.setBounds(430,340,300,23);
        act.setBackground(Color.LIGHT_GRAY);
        label.add(act);

        back = new JButton("Back");
        back.setBounds(280,400,90,30);
        back.setBorder(BorderFactory.createLineBorder(Color.black,3));
        back.setFocusable(false);
        back.setVerticalTextPosition(JButton.CENTER);
        back.addActionListener(this);
        label.add(back);

        sub = new JButton("Submit");
        sub.setBounds(600,400,90,30);
        sub.setBorder(BorderFactory.createLineBorder(Color.black,3));
        sub.setFocusable(false);
        sub.setVerticalTextPosition(JButton.CENTER);
        sub.addActionListener(this);
        label.add(sub);

        try{
            Conn c = new Conn();
            String q = ("select gender,TIMESTAMPDIFF(YEAR, dob, CURDATE()) AS age from users where email_id = '"+emaill+"'");
            ResultSet rs = c.s.executeQuery(q);
            while (rs.next()){
                age.setText(rs.getString(2));
                gender.setText(rs.getString(1));
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }




    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sub){
            if(height.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter Height!","Incomplete data",JOptionPane.ERROR_MESSAGE);
            }
            else if(weight.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter Weight!","Incomplete data",JOptionPane.ERROR_MESSAGE);
            }
            else {
                double w = Double.parseDouble(weight.getText());
                int a = Integer.parseInt(age.getText());
                String g = gender.getText();
                Double call;

                NumberFormat nf= NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);
                Double cm = 0.0d;

                String jain = String.valueOf(hcal.getSelectedItem());
                if(jain.equals("cm")){
//                    cm = Integer.parseInt(height.getText());
                    cm = Double.parseDouble(height.getText());
                }
                else if(jain.equals("Feet")){
                    cm = Double.parseDouble((height.getText()));
                    cm = cm * 30.48;
                }
                else if(jain.equals("meter")){
                    cm = Double.parseDouble(height.getText());
                    cm = cm * 100;
                }
                String jain1 = String.valueOf(act.getSelectedItem());

                if(gender.getText().equals("male")){
                        call = (13.397*w) + (4.799 * cm) - (5.677 * a) + 88.362;
                    if(jain1.equalsIgnoreCase("Bed rest (Bed ridden - Unconscious)")){
                        call = call * 1.1;
                    } else if (jain1.equalsIgnoreCase("Sedentary (Little to no exercise)")) {
                        call = call * 1.2;
                    }
                    else if(jain1.equalsIgnoreCase("Light exercise (1-3 days per week)")){
                        call = call * 1.3;
                    } else if (jain1.equalsIgnoreCase("Moderate exercise (3-5 days per week)")) {
                        call = call * 1.5;
                    }
                    else if(jain1.equalsIgnoreCase("Very heavy exercise (twice per day, extra heavy workouts)")){
                        call = call * 1.9;
                    } else if (jain1.equalsIgnoreCase("Heavy exercise (6-7 days per week)")) {
                        call = call * 1.7;
                    }
                }
                else{
                    call = (9.247*w) + (3.098 * cm) - (4.330 * a) + 447.593;
                    if(jain1.equals("Bed rest (Bed ridden - Unconscious)")){
                        call = call * 1.1;
                    } else if (jain1.equals("Sedentary (Little to no exercise)")) {
                        call = call * 1.2;
                    }
                    else if(jain1.equals("Light exercise (1-3 days per week)")){
                        call = call * 1.3;
                    } else if (jain1.equals("Moderate exercise (3-5 days per week)")) {
                        call = call * 1.5;
                    }
                    else if(jain1.equals("Very heavy exercise (twice per day, extra heavy workouts)")){
                        call = call * 1.9;
                    } else if (jain1.equals("Heavy exercise (6-7 days per week)")) {
                        call = call * 1.7;
                    }
                }
                JOptionPane.showMessageDialog(null,"You should consume "+nf.format(call)+" calorie"+"\n"+"to maintain this weight","Calorie consumption",JOptionPane.INFORMATION_MESSAGE);


                Double bmi ;
                Double hh = cm/100;
                bmi = w/(hh * hh);
                if(bmi>24.9){
                    JOptionPane.showMessageDialog(null,"Bmi = "+nf.format(bmi)+"\nYou should reduce your daily Calorie consumption","alorie consumption",JOptionPane.INFORMATION_MESSAGE);

                } else if (bmi<19) {
                    JOptionPane.showMessageDialog(null,"Bmi = "+nf.format(bmi)+"\nYou should increase your daily Calorie consumption","alorie consumption",JOptionPane.INFORMATION_MESSAGE);

                }


            }
        }else if(e.getSource()==back){
            this.dispose();
            new Calorie(emaill);
        }
    }
}
