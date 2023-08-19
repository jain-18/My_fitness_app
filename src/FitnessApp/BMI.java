package FitnessApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

//class BMI{
//    public static void main(String[] args) {
//        new Bmii();
//    }
//}
class BMI extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new BMI("shubhamjain12368@gmail.com");
    }

    JLabel label;
    Choice hcal;
    JButton back,next,chart;
    JTextField wei,hei;
    String emaill;

    BMI(String email){
        emaill = email;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,550);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);

//        Background
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("image/bmi1.jpg"));
        label = new JLabel(image);
        label.setBounds(1,1,783,510);
        label.setBorder(BorderFactory.createLineBorder(Color.black,5));


//        text and text field
        JLabel bmi = new JLabel("BMI");
        bmi.setBounds(480,50,300,60);
        bmi.setFont(new Font("Elephant",Font.BOLD,60));

        JLabel weight = new JLabel("Weight (KG) :-");
        weight .setBounds(350,140,150,60);
        weight.setFont(new Font("",Font.PLAIN,20));

        wei = new JTextField();
        wei.setBounds(500,157,200,30);
        wei.setFont(new Font("",Font.PLAIN,15));


        JLabel height = new JLabel("Height  (m)  :-");
        height .setBounds(350,210,150,60);
        height.setFont(new Font("",Font.PLAIN,20));

         hei = new JTextField();
        hei.setBounds(500,230,150,30);
        hei.setFont(new Font("",Font.PLAIN,15));

        hcal = new Choice();
        hcal.setFont(new Font("",Font.PLAIN,18));
        hcal.add("Inches");
        hcal.add("Feet");
        hcal.add("meter");
        hcal.setBounds(650,230,100,35);
//        hcal.setCursor();
        hcal.setFocusable(false);
        hcal.setBackground(Color.lightGray);
        label.add(hcal);

//        BUttons
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);
        back = new JButton("Back");
        back.setBounds(370,310,80,30);
        back.setFocusable(false);
        back.setCursor(cur);
        back.addActionListener(this);

        next = new JButton("Submit");
        next.setBounds(610,310,80,30);
        next.setFocusable(false);
        next.setCursor(cur);
        next.addActionListener(this);

        chart = new JButton("Chart");
        chart.setBounds(490,310,80,30);
        chart.setFocusable(false);
        chart.setCursor(cur);
        chart.addActionListener(this);




//        Jlayerpane
        JLayeredPane layer = new JLayeredPane();
        layer.setBounds(0,0,800,550);
        layer.add(label,Integer.valueOf(0));
        layer.add(bmi,Integer.valueOf(1));
        layer.add(weight,Integer.valueOf(1));
        layer.add(height,Integer.valueOf(1));
        layer.add(wei,Integer.valueOf(1));
        layer.add(hei,Integer.valueOf(1));
        layer.add(back,Integer.valueOf(1));
        layer.add(next,Integer.valueOf(1));
        layer.add(chart,Integer.valueOf(1));
        layer.add(hcal,Integer.valueOf(1));

        this.add(layer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next)
        {
            String mass = wei.getText();
            String Hei = hei.getText();
            if (mass.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter weight in KG", "Error!", JOptionPane.ERROR_MESSAGE);
            } else if (Hei.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Height", "Error!", JOptionPane.ERROR_MESSAGE);
            } else {
                Double Weight = Double.parseDouble(mass);
                Double Height = Double.parseDouble(Hei);
                Double bmi = 0.0;
                NumberFormat nf= NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);
                String jain = String.valueOf((hcal.getSelectedItem()));
                if(jain.equals("meter")){
                    bmi = Weight/(Height*Height);
                }
                else if(jain.equals("Inches")){
                    Height = Height *  0.0254;
                    bmi = Weight/(Height*Height);
                }
                else if(jain.equals("Feet")){
                    Height = Height * 0.3048;
                    bmi = Weight/(Height*Height);
                }



                if (bmi < 15 && bmi > 12) {
                    JOptionPane.showMessageDialog(null, "Your BMI  is "+nf.format(bmi)+"\nCategory is : Starvation ", "Result", JOptionPane.PLAIN_MESSAGE);
                } else if (bmi >= 15.1 && bmi <= 17.5) {
                    JOptionPane.showMessageDialog(null, "Your BMI is "+nf.format(bmi)+"\nCategory is : Anorexic ", "Result", JOptionPane.PLAIN_MESSAGE);
                } else if (bmi >= 17.6 && bmi <= 18.5) {
                    JOptionPane.showMessageDialog(null, "Your BMI is "+nf.format(bmi)+"\nCategory is : Underweight ", "Result", JOptionPane.PLAIN_MESSAGE);
                } else if (bmi >= 18.6 && bmi <= 24.9) {
                    JOptionPane.showMessageDialog(null, "Your BMI is "+nf.format(bmi)+"\nCategory is : Ideal ", "Result", JOptionPane.PLAIN_MESSAGE);
                } else if (bmi >= 25 && bmi <= 29.9) {
                    JOptionPane.showMessageDialog(null, "Your BMI is "+nf.format(bmi)+"\nCategory is : OverWeight ", "Result", JOptionPane.PLAIN_MESSAGE);
                } else if (bmi >= 30 && bmi <= 34.9) {
                    JOptionPane.showMessageDialog(null, "Your BMI is "+nf.format(bmi)+"\nCategory is : Obese ", "Result", JOptionPane.PLAIN_MESSAGE);
                } else if (bmi >= 35 && bmi < 37) {
                    JOptionPane.showMessageDialog(null, "Your BMI Category is : Extremely Obese", "Result", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Input", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if(e.getSource()==back){
            this.dispose();
            new Menu(emaill);
        }
        if(e.getSource()==chart){
            new bchart();
        }
    }
}
class bchart extends JFrame implements ActionListener{
    Font font = new Font("Arial",Font.PLAIN,18);
    JButton btn1;
    bchart(){
        this.setSize(400,550);
        this.setLayout(null);
        this.setBounds(550,140,400,500);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

//        JLabel
        JLabel label1 = new JLabel("BMI Chart");
        label1.setBounds(120,30,300,30);
        label1.setFont(new Font("Elephant",Font.PLAIN,25));
        this.add(label1);

        JLabel label2 = new JLabel("BMI less than 15                   : Starvation");
        label2.setBounds(30,80,400,30);
        label2.setFont(font);
        this.add(label2);

        JLabel label3 = new JLabel("BMI between 15.1 and 17.5 : Anorexic");
        label3.setBounds(30,120,400,30);
        label3.setFont(font);
        this.add(label3);

        JLabel label4 = new JLabel("BMI between 17.6 and 18.5 : Underweight");
        label4.setBounds(30,160,400,30);
        label4.setFont(font);
        this.add(label4);

        JLabel label5 = new JLabel("BMI between 18.5 and 24.9 : Ideal");
        label5.setBounds(30,200,400,30);
        label5.setFont(font);
        this.add(label5);

        JLabel label6 = new JLabel("BMI between 25 and 29.9   : Overweight");
        label6.setBounds(30,240,400,30);
        label6.setFont(font);
        this.add(label6);

        JLabel label7 = new JLabel("BMI between 30 and 34.9   : Obese");
        label7.setBounds(30,280,400,30);
        label7.setFont(font);
        this.add(label7);

        JLabel label8 = new JLabel("BMI greater than 35       : Extremely obese");
        label8.setBounds(30,320,400,30);
        label8.setFont(font);
        this.add(label8);

        btn1 = new JButton("OK");
        btn1.setBounds(160,380,60,30);
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn1.setFocusable(false);
        btn1.addActionListener(this);
        this.add(btn1);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            this.dispose();
        }
    }
}
