package FitnessApp;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.NumberFormat;

public class CreateRec extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new CreateRec(0,"shubhamjain12368@gmail.com");
    }

    JButton sub,back,calculate;
    Choice hcal;


    JRadioButton m,f,oth;
    JTextField ffname,fatname,cwei,chei,bbmi,calin;
    JDateChooser datee;
    Cursor cur = new Cursor(Cursor.HAND_CURSOR);
    Double mi,wt,ht;
    int baack=0;
    String emaill;
    Choice act;
    String gen;
    CreateRec(int ca,String email){
        emaill = email;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBounds(0,0,900,700);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        baack = ca;



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/rec22.jpg"));
        JLabel label = new JLabel(i1);
//        label.setBounds(0,0,900,700);
        label.setBounds(1,1,884,661);
        label.setBorder(BorderFactory.createLineBorder(Color.black,5));
        this.add(label);

        JLabel head = new JLabel("Create Record");
        head.setBounds(480,40,300,50);
        head.setFont(new Font("Elephant",Font.BOLD,36));
        head.setForeground(Color.BLACK);
        label.add(head);

        JLabel underline = new JLabel();
        underline.setBounds(450,100,360,2);
        underline.setOpaque(true);
        underline.setBackground(Color.black);
        label.add(underline);

        JLabel name = new JLabel("Name :- ");
        name.setBounds(380,140,100,40);
        name.setFont(new Font("",Font.BOLD,20));
        name.setForeground(Color.BLACK);
        label.add(name);

        JLabel fname = new JLabel("Activity type :- ");
        fname.setBounds(380,200,160,40);
        fname.setFont(new Font("",Font.BOLD,20));
        fname.setForeground(Color.BLACK);
        label.add(fname);

        JLabel wei = new JLabel("Weight in KG :- ");
        wei.setBounds(380,260,200,40);
        wei.setFont(new Font("",Font.BOLD,20));
        wei.setForeground(Color.BLACK);
        label.add(wei);

        JLabel hei = new JLabel("Height :- ");
        hei.setBounds(380,320,200,40);
        hei.setFont(new Font("",Font.BOLD,20));
        hei.setForeground(Color.BLACK);
        label.add(hei);

        JLabel bmi = new JLabel("BMI :- ");
        bmi.setBounds(380,380,200,40);
        bmi.setFont(new Font("",Font.BOLD,20));
        bmi.setForeground(Color.BLACK);
        label.add(bmi);

        JLabel calintake = new JLabel("Cal. Intake :- ");
        calintake.setBounds(380,440,200,40);
        calintake.setFont(new Font("",Font.BOLD,20));
        calintake.setForeground(Color.BLACK);
        label.add(calintake);

        JLabel date = new JLabel("Date :- ");
        date.setBounds(380,500,200,40);
        date.setFont(new Font("",Font.BOLD,20));
        date.setForeground(Color.BLACK);
        label.add(date);

        JLabel gender = new JLabel("Gender :- ");
        gender.setBounds(380,560,200,40);
        gender.setFont(new Font("",Font.BOLD,20));
        gender.setForeground(Color.BLACK);
        label.add(gender);

        ffname = new JTextField();
        ffname.setBounds(550,145,300,30);
        ffname.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,15));
        ffname.setEditable(false);
        ffname.setCursor(cur);
        label.add(ffname);

        act = new Choice();
        act.add("Bed rest (Bed ridden - Unconscious)");
        act.add("Sedentary (Little to no exercise)");
        act.add("Light exercise (1-3 days per week)");
        act.add("Moderate exercise (3-5 days per week)");
        act.add("Heavy exercise (6-7 days per week)");
        act.add("Very heavy exercise (twice per day, extra heavy workouts)");
        act.setFont(new Font("",Font.ROMAN_BASELINE,15));
        act.setBounds(550,205,300,30);
        act.setBackground(Color.LIGHT_GRAY);
        label.add(act);

//        fatname = new JTextField();
//        fatname.setBounds(550,205,300,30);
//        fatname.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,15));
//        fatname.setEditable(false);
//        fatname.setCursor(cur);
//        label.add(fatname);

        cwei = new JTextField();
        cwei.setText("0");
        cwei.setBounds(550,265,300,30);
        cwei.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,15));
        cwei.setCursor(cur);
        label.add(cwei);

        chei = new JTextField();
        chei.setText("0");
        chei.setBounds(550,325,210,30);
        chei.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,15));
        chei.setCursor(cur);
        label.add(chei);

        hcal = new Choice();
        hcal.setFont(new Font("",Font.PLAIN,17));
        hcal.add("cm");
        hcal.add("Feet");
        hcal.add("meter");
        hcal.setBounds(760,325,100,35);
        hcal.setCursor(cur);
        hcal.setFocusable(false);
        hcal.setBackground(Color.lightGray);
        label.add(hcal);



//        Calculation


        calculate = new JButton("Calculate");
        calculate.setBounds(760,385,90,29);
        calculate.setCursor(cur);
        calculate.setFocusable(false);
        calculate.setBackground(Color.lightGray);
        calculate.addActionListener(this);
        label.add(calculate);







        bbmi = new JTextField();
        bbmi.setBounds(550,385,210,30);
        bbmi.setText("0");
        bbmi.setCursor(cur);
        bbmi.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,15));
        label.add(bbmi);





        calin = new JTextField();
        calin.setBounds(550,445,300,30);
        calin.setText(Integer.toString(baack));
        calin.setCursor(cur);
        calin.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,15));
        label.add(calin);

        datee = new JDateChooser();
        datee.setBounds(550,505,300,30);
        datee.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,15));
        datee.setCursor(cur);
        label.add(datee);

        m = new JRadioButton("male");
        m.setBounds(550,565,100,30);
        m.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,18));
        m.setOpaque(false);
        m.setCursor(cur);
        m.setFocusable(false);
        label.add(m);

        f = new JRadioButton("Female");
        f.setBounds(650,565,100,30);
        f.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,18));
        f.setOpaque(false);
        f.setFocusable(false);
        f.setCursor(cur);
        label.add(f);

        oth = new JRadioButton("Others");
        oth.setBounds(750,565,100,30);
        oth.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,18));
        oth.setOpaque(false);
        oth.setFocusable(false);
        oth.setCursor(cur);
        label.add(oth);

        ButtonGroup b = new ButtonGroup();
        b.add(m);
        b.add(f);
        b.add(oth);


        sub = new JButton("Submit");
        sub.setBounds(740,610,100,30);
        sub.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,15));
        sub.setFocusable(false);
        sub.setBackground(Color.lightGray);
        sub.addActionListener(this);
        sub.setCursor(cur);
        label.add(sub);

        back = new JButton("Back");
        back.setBounds(380,610,100,30);
        back.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,15));
        back.setFocusable(false);
        back.setBackground(Color.lightGray);
        back.setCursor(cur);
        back.addActionListener(this);
        label.add(back);

        try{
            Conn c = new Conn();
            String query = ("select * from users where email_id = '"+email+"'");
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                ffname.setText(rs.getString("first_name"));
//                fatname.setText(rs.getString("middle_name"));
                gen = rs.getString("gender");
                if(gen.equals("male")){
                    m.setSelected(true);
                }
                else if(gen.equals("female")){
                    f.setSelected(true);
                }
                else {
                    oth.setSelected(true);
                }

            }

        }catch (Exception exception){
            exception.printStackTrace();
        }


    }
    public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date){
        if(date != null) {
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==calculate){
            String jain = String.valueOf(hcal.getSelectedItem());
            wt = Double.parseDouble(cwei.getText());
            ht = Double.parseDouble(chei.getText());

            NumberFormat nf= NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            if(jain.equals("meter")){

                mi = wt/(ht*ht);
                if(cwei.getText().equals("0") || chei.getText().equals("0")){
                    bbmi.setText("0");
                }
                else {
                    bbmi.setText(nf.format(mi));
                }
            }
            else if(jain.equals("cm")){
                ht = ht/100;
                mi = wt/(ht*ht);
                if(cwei.getText().equals("0") || chei.getText().equals("0")){
                    bbmi.setText("0");
                }
                else {
                    bbmi.setText(nf.format(mi));
                }

            }
            else if(jain.equals("Feet")) {
                ht = ht * 0.3048;
                mi = wt / (ht * ht);
                if (cwei.getText().equals("0") || chei.getText().equals("0")) {
                    bbmi.setText("0");
                } else {
                    bbmi.setText(nf.format(mi));
                }
            }

        }
        else if(e.getSource()==sub){
            if(calin.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter Calorie Intake","Incomplete data!",JOptionPane.ERROR_MESSAGE);
            }else if(cwei.getText().equals("0") || chei.getText().equals("0") || bbmi.getText().equals("0")){
                JOptionPane.showMessageDialog(null,"You have not enter height or weight or bmi","Incomplete data!",JOptionPane.ERROR_MESSAGE);

            }else if( ((JTextField)datee.getDateEditor().getUiComponent()).getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter date!","Incomplete data!",JOptionPane.ERROR_MESSAGE);

            }
            else {
                double weight = Double.parseDouble(cwei.getText());
            double height = ht;
            double bmi =  Double.parseDouble(bbmi.getText());
            int calorie = Integer.parseInt(calin.getText());
            String ddatee = String.valueOf(convertUtilDateToSqlDate(datee.getDate()));
            try{
                Conn c = new Conn();
                String query = ("insert into hasrecord values('"+weight+"','"+height+"','"+bmi+"','"+calorie+"','"+emaill+"','"+ddatee+"')");
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Record saved successfully!","Data Saved",JOptionPane.INFORMATION_MESSAGE);


                int age =0;
                String q = ("select TIMESTAMPDIFF(YEAR, dob, CURDATE()) AS age from users where email_id = '"+emaill+"'");
                ResultSet rss = c.s.executeQuery(q);
                while(rss.next()){
                    age = Integer.parseInt(rss.getString("age"));
                }
                String jain1 = String.valueOf(act.getSelectedItem());
                String gen1 = gen;
                int agee = age;
                double wtt = wt;
                double heit = ht*100;
                double call;


                if(gen1.equals("male")){
                    call = (13.397*wtt) + (4.799 * heit) - (5.677 * agee) + 88.362;
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
                    call = (9.247*wtt) + (3.098 * heit) - (4.330 * agee) + 447.593;
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
                NumberFormat nf= NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);
                JOptionPane.showMessageDialog(null, "You should consume " + nf.format(call) + " calorie" + "\n" + "to maintain this weight", "Calorie consumption", JOptionPane.INFORMATION_MESSAGE);

                double bmii = bmi;
                if (bmii > 24.9) {
                    JOptionPane.showMessageDialog(null, "Bmi = " + nf.format(bmi) + "\nYou should reduce your daily Calorie consumption", "alorie consumption", JOptionPane.INFORMATION_MESSAGE);

                } else if (bmii < 19) {
                    JOptionPane.showMessageDialog(null, "Bmi = " + nf.format(bmi) + "\nYou should increase your daily Calorie consumption", "alorie consumption", JOptionPane.INFORMATION_MESSAGE);
                }



                if((calorie+200)>call) {
                    int cc = (int) (calorie-call);
                    JOptionPane.showMessageDialog(null,"You have consumed "+cc+" more calories","problem",JOptionPane.ERROR_MESSAGE);
                    int annswer = JOptionPane.showConfirmDialog(null,"Do you want to perform exercise \n to burn extra calories ","extra calorie",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(annswer==0){

                        this.dispose();
                        new exercise(emaill,cc,wtt);

                    }



                }

            }catch (Exception exception){
                exception.printStackTrace();
            }

            }
        }
        else  if(e.getSource()==back){
            if(baack==0){
                this.dispose();
                new Menu(emaill);
            }
            else {
                this.dispose();
            }


        }
    }
}
