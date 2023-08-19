package FitnessApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;



class Calorie extends JFrame implements AdjustmentListener, ActionListener {

    public static void main(String[] args) {
        new Calorie("shubhamjain12368@gmail.com");
    }
    
    Scrollbar bar;
    JComboBox combo;
    String food[]= {"Veg food","Non-veg food","Sweets"};
    JButton sub,back,fit;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    int tt1,tt2,tt3,tt4,tt5,tt6,tt7,tt8,tt9,tt10;
    JLabel fty;
    int v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,
    v21,v22,v23,v24,v25,v26,v27,v28,v29,v30;
    int n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11;
    int s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    JTextField t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
    JTextField t21,t22,t23,t24,t25,t26,t27,t28,t29,t30;
    JTextField t31,t32,t33,t34,t35,t36,t37,t38,t39,t40;

    JTextField t41,t42,t43,t44,t45,t46,t47,t48,t49,t50;
    JLabel label;
    String emaill;
    Calorie(String email){
        emaill = email;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900,700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/foo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700,2);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);

        label.setBounds(1,1,884,661);
        label.setBorder(BorderFactory.createLineBorder(Color.white,7));
        this.add(label);




      bar = new Scrollbar();
      bar.setBounds(860,8,15,647);
      bar.setVisibleAmount(10);
      bar.setMaximum(100);
      bar.setMinimum(0);
      bar.setBackground(Color.white);
      bar.getVisibleAmount();
      bar.setFocusable(true);
      bar.addAdjustmentListener(this);
      System.out.println(bar.getValue());
      label.add(bar);

      combo = new JComboBox(food);
      combo.setBounds(670,140,150,25);
      combo.addActionListener(this);
      label.add(combo);

      sub = new JButton("Submit");
      sub.setBounds(160,600,100,30);
      sub.setVisible(true);
      sub.addActionListener(this);
      sub.setBackground(Color.decode("#F9A7B0"));
      sub.setBorder(BorderFactory.createLineBorder(Color.black,2));
      label.add(sub);

      back = new JButton("Back");
      back.setBounds(50,600,100,30);
      back.setVisible(true);
      back.addActionListener(this);
      back.setBackground(Color.decode("#F9A7B0"));
      back.setBorder(BorderFactory.createLineBorder(Color.black,2));
      label.add(back);

      fit = new JButton("Calories to remain fit");
      fit.setBounds(660,600,170,30);
      fit.setFocusable(false);
      fit.setVisible(true);
      fit.addActionListener(this);
      fit.setBackground(Color.decode("#F9A7B0"));
      fit.setForeground(Color.BLACK);
      fit.setBorder(BorderFactory.createLineBorder(Color.black,2));
      label.add(fit);


      JLabel heading = new JLabel("Food Chart");
      heading.setBounds(330,15,400,60);
      heading.setFont(new Font("Elephant",Font.BOLD,40));
      heading.setForeground(Color.WHITE);
      label.add(heading);

      JLabel un = new JLabel();
      un.setBounds(320,70,280,4);
      un.setOpaque(true);
      un.setBackground(Color.getColor("51-204-255"));
      label.add(un);

      JLabel foodname = new JLabel("Food");
      foodname.setBounds(60,100,70,30);
      foodname.setFont(new Font("",Font.ROMAN_BASELINE,25));
      foodname.setForeground(Color.WHITE);
      label.add(foodname);

      JLabel qnty = new JLabel("Qnty.");
      qnty.setBounds(280,100,70,30);
      qnty.setFont(new Font("",Font.ROMAN_BASELINE,25));
      qnty.setForeground(Color.WHITE);
      label.add(qnty);

      JLabel Cal = new JLabel("Calories");
      Cal.setBounds(480,100,110,30);
      Cal.setFont(new Font("",Font.ROMAN_BASELINE,25));
      Cal.setForeground(Color.WHITE);
      label.add(Cal);

      JLabel con = new JLabel("Qnty. Consumed");
      con.setBounds(650,100,250,30);
      con.setFont(new Font("",Font.ROMAN_BASELINE,25));
      con.setForeground(Color.WHITE);
      label.add(con);

      fty = new JLabel("Veg Food");
      fty.setBounds(60,140,250,32);
      fty.setFont(new Font("Algerian",Font.ROMAN_BASELINE,25));

      fty.setHorizontalTextPosition(JLabel.CENTER);
      fty.setVerticalAlignment(JLabel.CENTER);
      fty.setOpaque(false);
      fty.setForeground(Color.WHITE);
      label.add(fty);


      t1 = new JTextField("0");
      t1.setBounds(670,180,150,28);
      label.add(t1);

      t2 = new JTextField("0");
      t2.setBounds(670,220,150,28);
      label.add(t2);

      t3 = new JTextField("0");
      t3.setBounds(670,260,150,28);
      label.add(t3);

      t4 = new JTextField("0");
      t4.setBounds(670,300,150,28);
      label.add(t4);

      t5 = new JTextField("0");
      t5.setBounds(670,340,150,28);
      label.add(t5);

      t6 = new JTextField("0");
      t6.setBounds(670,380,150,28);
      label.add(t6);

      t7 = new JTextField("0");
      t7.setBounds(670,420,150,28);
      label.add(t7);

      t8 = new JTextField("0");
      t8.setBounds(670,460,150,28);
      label.add(t8);

      t9 = new JTextField("0");
      t9.setBounds(670,500,150,28);
      label.add(t9);

      t10 = new JTextField("0");
      t10.setBounds(670,540,150,28);
      label.add(t10);

        t11 = new JTextField("0");
        t11.setBounds(670,180,150,28);
        t11.setVisible(false);
        label.add(t11);

        t12 = new JTextField("0");
        t12.setBounds(670,220,150,28);
        t12.setVisible(false);
        label.add(t12);

        t13 = new JTextField("0");
        t13.setBounds(670,260,150,28);
        t13.setVisible(false);
        label.add(t13);

        t14 = new JTextField("0");
        t14.setBounds(670,300,150,28);
        t14.setVisible(false);
        label.add(t14);

        t15 = new JTextField("0");
        t15.setBounds(670,340,150,28);
        t15.setVisible(false);
        label.add(t15);

        t16 = new JTextField("0");
        t16.setBounds(670,380,150,28);
        t16.setVisible(false);
        label.add(t16);

        t17 = new JTextField("0");
        t17.setBounds(670,420,150,28);
        t17.setVisible(false);
        label.add(t17);

        t18 = new JTextField("0");
        t18.setBounds(670,460,150,28);
        t18.setVisible(false);
        label.add(t18);

        t19 = new JTextField("0");
        t19.setBounds(670,500,150,28);
        t19.setVisible(false);
        label.add(t19);

        t20 = new JTextField("0");
        t20.setBounds(670,540,150,28);
        t20.setVisible(false);
        label.add(t20);

        t21 = new JTextField("0");
        t21.setBounds(670,180,150,28);
        t21.setVisible(false);
        label.add(t21);

        t22 = new JTextField("0");
        t22.setBounds(670,220,150,28);
        t22.setVisible(false);
        label.add(t22);

        t23 = new JTextField("0");
        t23.setBounds(670,260,150,28);
        t23.setVisible(false);
        label.add(t23);

        t24 = new JTextField("0");
        t24.setBounds(670,300,150,28);
        t24.setVisible(false);
        label.add(t24);

        t25 = new JTextField("0");
        t25.setBounds(670,340,150,28);
        t25.setVisible(false);
        label.add(t25);

        t26 = new JTextField("0");
        t26.setBounds(670,380,150,28);
        t26.setVisible(false);
        label.add(t26);

        t27 = new JTextField("0");
        t27.setBounds(670,420,150,28);
        t27.setVisible(false);
        label.add(t27);

        t28 = new JTextField("0");
        t28.setBounds(670,460,150,28);
        t28.setVisible(false);
        label.add(t28);

        t29 = new JTextField("0");
        t29.setBounds(670,500,150,28);
        t29.setVisible(false);
        label.add(t29);

        t30 = new JTextField("0");
        t30.setBounds(670,540,150,28);
        t30.setVisible(false);
        label.add(t30);

        t31 = new JTextField("0");
        t31.setBounds(670,180,150,28);
        t31.setVisible(false);
        label.add(t31);

        t32 = new JTextField("0");
        t32.setBounds(670,220,150,28);
        t32.setVisible(false);
        label.add(t32);

        t33 = new JTextField("0");
        t33.setBounds(670,260,150,28);
        t33.setVisible(false);
        label.add(t33);

        t34 = new JTextField("0");
        t34.setBounds(670,300,150,28);
        t34.setVisible(false);
        label.add(t34);

        t35 = new JTextField("0");
        t35.setBounds(670,340,150,28);
        t35.setVisible(false);
        label.add(t35);

        t36 = new JTextField("0");
        t36.setBounds(670,380,150,28);
        t36.setVisible(false);
        label.add(t36);

        t37 = new JTextField("0");
        t37.setBounds(670,420,150,28);
        t37.setVisible(false);
        label.add(t37);

        t38 = new JTextField("0");
        t38.setBounds(670,460,150,28);
        t38.setVisible(false);
        label.add(t38);

        t39 = new JTextField("0");
        t39.setBounds(670,500,150,28);
        t39.setVisible(false);
        label.add(t39);

        t40 = new JTextField("0");
        t40.setBounds(670,540,150,28);
        t40.setVisible(false);
        label.add(t40);

        t41 = new JTextField("0");
        t41.setBounds(670,180,150,28);
        t41.setVisible(false);
        label.add(t41);

        t42 = new JTextField("0");
        t42.setBounds(670,220,150,28);
        t42.setVisible(false);
        label.add(t42);

        t43 = new JTextField("0");
        t43.setBounds(670,260,150,28);
        t43.setVisible(false);
        label.add(t43);

        t44 = new JTextField("0");
        t44.setBounds(670,300,150,28);
        t44.setVisible(false);
        label.add(t44);

        t45 = new JTextField("0");
        t45.setBounds(670,340,150,28);
        t45.setVisible(false);
        label.add(t45);

        t46 = new JTextField("0");
        t46.setBounds(670,380,150,28);
        t46.setVisible(false);
        label.add(t46);

        t47 = new JTextField("0");
        t47.setBounds(670,420,150,28);
        t47.setVisible(false);
        label.add(t47);

        t48 = new JTextField("0");
        t48.setBounds(670,460,150,28);
        t48.setVisible(false);
        label.add(t48);

        t49 = new JTextField("0");
        t49.setBounds(670,500,150,28);
        t49.setVisible(false);
        label.add(t49);

        t50 = new JTextField("0");
        t50.setBounds(670,540,150,28);
        t50.setVisible(false);
        label.add(t50);






        l1 = new JLabel("1. Idli                        1 unit                         100");
      l1.setBounds(50,180,550,30);
      l1.setFont(new Font("",Font.ROMAN_BASELINE,25));
      l1.setForeground(Color.WHITE);
      label.add(l1);

      l2 = new JLabel("2. Plain dosa            1 unit                         120");
      l2.setBounds(50,220,550,30);
      l2.setFont(new Font("",Font.ROMAN_BASELINE,25));
      l2.setForeground(Color.WHITE);
      label.add(l2);

      l3 = new JLabel("3. Masala Dosa        1 unit                         250");
      l3.setBounds(50,260,550,30);
      l3.setFont(new Font("",Font.ROMAN_BASELINE,25));
      l3.setForeground(Color.WHITE);
      label.add(l3);

      l4 = new JLabel("4. Boiled Rice          1 Cup                        120");
      l4.setBounds(50,300,550,30);
      l4.setFont(new Font("",Font.ROMAN_BASELINE,25));
      l4.setForeground(Color.WHITE);
      label.add(l4);

      l5 = new JLabel("5. Fried Rice            1 Cup                        150");
      l5.setBounds(50,340,550,30);
      l5.setFont(new Font("",Font.ROMAN_BASELINE,25));
      l5.setForeground(Color.WHITE);
      label.add(l5);

      l6 = new JLabel("6. Sambhar              1 Cup                        150");
      l6.setBounds(50,380,550,30);
      l6.setFont(new Font("",Font.ROMAN_BASELINE,25));
      l6.setForeground(Color.WHITE);
      label.add(l6);

      l7 = new JLabel("7. Curd                     1 Cup                        100");
      l7.setBounds(50,420,550,30);
      l7.setFont(new Font("",Font.ROMAN_BASELINE,25));
      l7.setForeground(Color.WHITE);
      label.add(l7);

      l8 = new JLabel("8. Samosa               1 Unit                        140");
      l8.setBounds(50,460,550,30);
      l8.setFont(new Font("",Font.ROMAN_BASELINE,25));
      l8.setForeground(Color.WHITE);
      label.add(l8);

      l9 = new JLabel("9. Vada                    1 Unit                         70");
      l9.setBounds(50,500,550,30);
      l9.setFont(new Font("",Font.ROMAN_BASELINE,25));
      l9.setForeground(Color.WHITE);
      label.add(l9);

      l10 = new JLabel("10. Sandwich           1 Unit                         300");
      l10.setBounds(50,540,550,25);
      l10.setFont(new Font("",Font.ROMAN_BASELINE,25));
      l10.setForeground(Color.WHITE);
      label.add(l10);
      bar.addAdjustmentListener(this);





    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        if(bar.getValue()<10){
            l1.setText("1. Idli                        1 unit                         100");
            l2.setText("2. Plain dosa            1 unit                         120");
            l3.setText("3. Masala Dosa        1 unit                         250");
            l4.setText("4. Boiled Rice          1 Cup                        120");
            l5.setText("5. Fried Rice            1 Cup                        150");
            l6.setText("6. Sambhar              1 Cup                        150");
            l7.setText("7. Curd                     1 Cup                        100");
            l8.setText("8. Samosa               1 Unit                        140");
            l9.setText("9. Medu Vada           1 Unit                          70");
            l10.setText("10. Sandwich           1 Unit                         250");

            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t5.setVisible(true);
            t6.setVisible(true);
            t7.setVisible(true);
            t8.setVisible(true);
            t9.setVisible(true);
            t10.setVisible(true);
        }
            else if(bar.getValue()>10 && bar.getValue()<=20){



                t1.setVisible(false);
                t2.setVisible(false);
                t3.setVisible(false);
                t4.setVisible(false);
                t5.setVisible(false);
                t6.setVisible(false);
                t7.setVisible(false);
                t8.setVisible(false);
                t9.setVisible(false);
                t10.setVisible(false);

                t11.setVisible(true);
                t12.setVisible(true);
                t13.setVisible(true);
                t14.setVisible(true);
                t15.setVisible(true);
                t16.setVisible(true);
                t17.setVisible(true);
                t18.setVisible(true);
                t19.setVisible(true);
                t20.setVisible(true);


//                t1.setText("0");
//                t2.setText("0");
//                t3.setText("0");
//                t4.setText("0");
//                t5.setText("0");
//                t6.setText("0");
//                t7.setText("0");
//                t8.setText("0");
//                t9.setText("0");
//                t10.setText("0");




                l1.setText("11. Bhel/Pani puri    1 Serving                   150");
                l2.setText("12. Pav Bhaji            1 Plate                      610");
                l3.setText("13. Indian Sweets    1 Piece                     150");
                l4.setText("14. Falooda             1 Glass                      300");
                l5.setText("15. Cheese              50g                           155");
                l6.setText("16. Butter                 1 Tablespoon              45");
                l7.setText("17. Ghee                 1 Tablespoon               45");
                l8.setText("18. Whole milk        1 Cup                        150");
                l9.setText("19. Chole Bhature    1 Serving                   450");
                l10.setText("20. Pakoras              50g                           175");

                if(bar.getValue()==11) {
                    System.out.println(tt1);
                }
            }
            else if(bar.getValue() > 20 && bar.getValue() <=30){
                fty.setText("Veg Food");

            t11.setVisible(false);
            t12.setVisible(false);
            t13.setVisible(false);
            t14.setVisible(false);
            t15.setVisible(false);
            t16.setVisible(false);
            t17.setVisible(false);
            t18.setVisible(false);
            t19.setVisible(false);
            t20.setVisible(false);

            t21.setVisible(true);
            t22.setVisible(true);
            t23.setVisible(true);
            t24.setVisible(true);
            t25.setVisible(true);
            t26.setVisible(true);
            t27.setVisible(true);
            t28.setVisible(true);
            t29.setVisible(true);
            t30.setVisible(true);






//            t1.setText("0");
//            t2.setText("0");
//            t3.setText("0");
//            t4.setText("0");
//            t5.setText("0");
//            t6.setText("0");
//            t7.setText("0");
//            t8.setText("0");
//            t9.setText("0");
//            t10.setText("0");



            l1.setText("21. Chapatti            1 Unit                             65");
            l2.setText("22. Poha                 1 bowl                           300");
            l3.setText("23. Sabzi                1 Cup                           150");
            l4.setText("24. Veg Frankie       1 Unit                           270");
            l5.setText("25. Vada pav           1 Unit                           290");
            l6.setText("26. Daal                  300g                             350");
            l7.setText("27. Chole Bhature   1 serve                         450");
            l8.setText("28. Halwa               1 cup                            250");
            l9.setText("29. Whole Milk        225ml(1 Cup)               150");
            l10.setText("30. Muttur Paneer   100g                            272");

            System.out.println(tt2);
        }
            else if(bar.getValue() > 30 && bar.getValue() <= 40){
                fty.setText("Non-Veg Food");

            t21.setVisible(false);
            t22.setVisible(false);
            t23.setVisible(false);
            t24.setVisible(false);
            t25.setVisible(false);
            t26.setVisible(false);
            t27.setVisible(false);
            t28.setVisible(false);
            t29.setVisible(false);
            t30.setVisible(false);

            t31.setVisible(true);
            t32.setVisible(true);
            t33.setVisible(true);
            t34.setVisible(true);
            t35.setVisible(true);
            t36.setVisible(true);
            t37.setVisible(true);
            t38.setVisible(true);
            t39.setVisible(true);
            t40.setVisible(true);




//            v15 = Integer.parseInt(t5.getText());
//            v16 = Integer.parseInt(t6.getText());
//            v17 = Integer.parseInt(t7.getText());
//            v18 = Integer.parseInt(t8.getText());
//            v19 = Integer.parseInt(t9.getText());
//            v20 = Integer.parseInt(t10.getText());



//            t1.setText("0");
//            t2.setText("0");
//            t3.setText("0");
//            t4.setText("0");
//            t5.setText("0");
//            t6.setText("0");
//            t7.setText("0");
//            t8.setText("0");
//            t9.setText("0");
//            t10.setText("0");


            l1.setText("1. Egg                    1 Unit                             75");
            l2.setText("2. Boiled Egg         1 Unit                             80");
            l3.setText("3. Omelette            1 Unit                           120");
            l4.setText("4. Mutton Briyani    1 Cup                          225");
            l5.setText("5. Fried Chicken     1 Serving                     200");
            l6.setText("6. Butter chicken    1 Serving                     490");
            l7.setText("7. Crab                   100g                              81");
            l8.setText("8. Burger                1 Unit                           250");
            l9.setText("9. Fish                    50g                               55");
            l10.setText("");

        }
            else if(bar.getValue()>40 && bar.getValue()<=50){
                sub.setVisible(true);
            fty.setText("Sweets and Drinks");

            t31.setVisible(false);
            t32.setVisible(false);
            t33.setVisible(false);
            t34.setVisible(false);
            t35.setVisible(false);
            t36.setVisible(false);
            t37.setVisible(false);
            t38.setVisible(false);
            t39.setVisible(false);
            t40.setVisible(false);

            t41.setVisible(true);
            t42.setVisible(true);
            t43.setVisible(true);
            t44.setVisible(true);
            t45.setVisible(true);
            t46.setVisible(true);
            t47.setVisible(true);
            t48.setVisible(true);
            t49.setVisible(true);
            t50.setVisible(true);



//            t1.setText("0");
//            t2.setText("0");
//            t3.setText("0");
//            t4.setText("0");
//            t5.setText("0");
//            t6.setText("0");
//            t7.setText("0");
//            t8.setText("0");
//            t9.setText("0");
//            t10.setText("0");





            l1.setText("1. Cake(Rich chocolate) 50g                    225");
            l2.setText("2. Cake(plain)         50g                           135");
            l3.setText("3. Jalebi                  20g                          100");
            l4.setText("4. Rasgulla             50g                           140");
            l5.setText("5. Cola                   200 ml                        90");
            l6.setText("6. Kheer                 1 cup                        263");
            l7.setText("7. Ice cream/cone   132g                         270");
            l8.setText("8. Gulab Jamun      1 piece                     150");
            l9.setText("9. Mithai                 1 piece                     172");

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sub){
            s1= Integer.parseInt(t41.getText());
            s2= Integer.parseInt(t42.getText());
            s3= Integer.parseInt(t43.getText());
            s4= Integer.parseInt(t44.getText());
            s5= Integer.parseInt(t45.getText());
            s6= Integer.parseInt(t46.getText());
            s7= Integer.parseInt(t47.getText());
            s8= Integer.parseInt(t48.getText());
            s9= Integer.parseInt(t49.getText());
            s10= Integer.parseInt(t50.getText());

            v1 = Integer.parseInt(t1.getText());
            v2 = Integer.parseInt(t2.getText());
            v3 = Integer.parseInt(t3.getText());
            v4 = Integer.parseInt(t4.getText());
            v5 = Integer.parseInt(t5.getText());
            v6 = Integer.parseInt(t6.getText());
            v7 = Integer.parseInt(t7.getText());
            v8 = Integer.parseInt(t8.getText());
            v9 = Integer.parseInt(t9.getText());
            v10 = Integer.parseInt(t10.getText());

            v11 = Integer.parseInt(t11.getText());
            v12 = Integer.parseInt(t12.getText());
            v13 = Integer.parseInt(t13.getText());
            v14 = Integer.parseInt(t14.getText());
            v15 = Integer.parseInt(t15.getText());
            v16 = Integer.parseInt(t16.getText());
            v17 = Integer.parseInt(t17.getText());
            v18 = Integer.parseInt(t18.getText());
            v19 = Integer.parseInt(t19.getText());
            v20 = Integer.parseInt(t20.getText());

            v21 = Integer.parseInt(t21.getText());
            v22 = Integer.parseInt(t22.getText());
            v23 = Integer.parseInt(t23.getText());
            v24 = Integer.parseInt(t24.getText());
            v25 = Integer.parseInt(t25.getText());
            v26 = Integer.parseInt(t26.getText());
            v27 = Integer.parseInt(t27.getText());
            v28 = Integer.parseInt(t28.getText());
            v29 = Integer.parseInt(t29.getText());
            v30 = Integer.parseInt(t30.getText());


            n1 = Integer.parseInt(t31.getText());
            n2 = Integer.parseInt(t32.getText());
            n3 = Integer.parseInt(t33.getText());
            n4 = Integer.parseInt(t34.getText());
            n5 = Integer.parseInt(t35.getText());
            n6 = Integer.parseInt(t36.getText());
            n7 = Integer.parseInt(t37.getText());
            n8 = Integer.parseInt(t38.getText());
            n9 = Integer.parseInt(t39.getText());
            n10 = Integer.parseInt(t30.getText());
            tt1 = (v1 * 100) + (v2 * 120) + (v3 * 250) + (v4 * 120) + (v5 * 150) + (v6 * 150) + (v7 * 100) + (v8 * 140) + (v9 * 70) + (v10 * 250);
            tt2 = tt1 + (v11 * 150) + (v12 * 610) + (v13 * 150) + (v14 * 300) + (v15 * 155) + (v16 * 45) + (v17 * 45) + (v18 * 150) + (v19 * 450) + (v20 * 175);
            tt3 = tt2 + (v21 * 65) + (v22 * 300) + (v23 * 150) + (v24 * 270) + (v25 * 290) + (v26 * 350) + (v27 * 450) + (v28 * 250) + (v29 * 150)+(v30 * 272);
            tt4 = tt3 + (n1 * 70) + (n2 * 80) + (n3 * 120) + (n4 * 225) + (n5 * 200) + (n6 * 490) + (n7 * 81) + (n8 * 250) + (n9 * 55);
            tt5 = tt4+(s1*225)+(s2*135)+(s3*100)+(s4*100)+(s5*90)+(s6*263)+(s7*270)+(s8*150)+(s9*172)+(s10*0);

            JOptionPane.showMessageDialog(null,"You have ConSumed : "+tt5+" Calories","Calorie Consumed.",JOptionPane.PLAIN_MESSAGE);
            int annswer = JOptionPane.showConfirmDialog(null,"Do you want to save this record?","Save?",JOptionPane.YES_NO_CANCEL_OPTION);
            if(annswer==0){
                this.dispose();
                new CreateRec(tt5,emaill);
            }
        } else if (e.getSource()==back) {
            this.dispose();
            new Menu(emaill);
        }
        else if(e.getSource()==combo){
            if(combo.getSelectedItem().equals("Veg food")){
                bar.setValue(5);
                bar.setUnitIncrement(1);
            } else if (combo.getSelectedItem().equals("Non-veg food")) {
                bar.setValue(35);
                bar.setUnitIncrement(1);
                bar.setValue(35);
            }
            else if(combo.getSelectedItem().equals("Sweets")){
                bar.setValue(45);
                bar.setUnitIncrement(1);
            }
        }
        else if(e.getSource()==fit){
            this.setVisible(false);
            new Calfit(emaill);
        }

    }
}