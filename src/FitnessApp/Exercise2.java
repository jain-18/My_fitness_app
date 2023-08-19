package FitnessApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

public class Exercise2 extends JFrame implements ActionListener {
  JButton b1,b2,next,back;
  int age,cal,weight,gender;
  public  String Male,Female;
  String emaill;
    JButton exit;

    Exercise2(String Male, String Female ,int age,int cal,int weight,String email)
  {
   this.age = age;
   this.cal = cal;
   this.weight = weight;
   this.Male = Male;
   this.Female = Female;
   emaill = email;
  setTitle("Exercise");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setSize(900, 650);
  setLayout(null);
  setLocationRelativeTo(null);
  setVisible(true);   
      
  
  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/btxt.jpg"));
  JLabel image= new JLabel(i1);
  image.setBounds(0,0,900,650);
  add(image);

  ImageIcon i01 = new ImageIcon(ClassLoader.getSystemResource("image/3.gif"));
  //Image i2 = i01.getImage().getScaledInstance(500,400,1);
  //ImageIcon i3 = new ImageIcon(i2);
  JLabel p1 = new JLabel(i01);
  p1.setLayout(null);
  p1.setBounds(100,70,600,300);
  p1.setBackground(Color.red);
  image.add(p1);    
  
  /*  ImageIcon i02 = new ImageIcon(ClassLoader.getSystemResource("2.gif"));
  //Image i2 = i01.getImage().getScaledInstance(500,400,1);
  //ImageIcon i3 = new ImageIcon(i2);
  JLabel p2 = new JLabel(i02);
  p2.setLayout(null);
  p2.setBounds(440,80,300,300);
  p2.setBackground(Color.red);
  image.add(p2); */

  JLabel title = new JLabel();
  title.setBounds(250,0,700,70);
  title.setFont(new Font("Arial",Font.BOLD,40));
  title.setForeground(new Color(190,120,170));
  title.setText("Cycling (22.5-25.5 kmph)");
  image.add(title);
  
  JLabel exer = new JLabel();
  exer.setBounds(60,380,780,100);
  exer.setFont(new Font("Arial",Font.BOLD,22));
  exer.setForeground(new Color(90,120,170));
  image.add(exer);
  
  JLabel rules = new JLabel ();
    rules.setBounds(10,350,550,350);
    rules.setFont(new Font("",Font.PLAIN,16));
    rules.setForeground(new Color(0,190,40));
    rules.setText(
     "<html>"+ 
        "<ul>" + 
           "<li>"+"When riding a bicycle, take the brake off and get in a relaxed posture. "+   
           "<li>"+"By placing the base of the thumb of the foot on the center of the pedal, you can pedal efficiently."+   
           "<li>"+"Drive with a reasonable gear for your legs so you can prevent fatigue. "+   
           "<li>"+"Be sure to use both front and rear brakes when applying a brake."+ 
        "</ul>" +   
     "<html>"
   
    );
  image.add(rules);
   
   next = new JButton();

    next.setText("NEXT");
    next.setBounds(660,550,100,35);
    next.setBackground(Color.LIGHT_GRAY);
    next.addActionListener(this);
    image.add(next);

    

  back = new JButton();
    back.setText("Back");
    back.setBounds(5,5,100,35);
    back.setBackground(Color.LIGHT_GRAY);
    back.addActionListener(this);
    image.add(back);

    JButton info = new JButton();

    info = new JButton("More Info...");
    info.setBounds(700,450,100,35);
    info.setBackground(Color.LIGHT_GRAY);
    info.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent v)
            {
                try
                {
                    Desktop.getDesktop().browse(URI.create("https://www.everydayhealth.com/fitness/how-to-get-started-with-cycling-workouts-an-absolute-beginners-guide/"));
                } catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        });
        image.add(info);


    exit = new JButton("Exit");
    exit.setBounds(770,550,100,35);
    exit.setBackground(Color.LIGHT_GRAY);
    exit.addActionListener(this);
    image.add(exit);

   //JRadioButton nextWindowRadioButton = new JRadioButton();
   //ButtonModel model = buttonGroup.getSelection();
   
      if(Male.equalsIgnoreCase("MALE") )
      {
       
        if(age > 10 && age <25)   
      {
       double Pno = (cal*60)/(weight*10);
       int tim = (int)Pno;
       exer.setText("To burn "+ cal + " calories, You will have to ride cycle for "+ tim +" minutes ");
      
      }
      else if (age >25 && age < 45)
      {
        double Pno = (cal*60)/(weight*10);
        int tim = (int)Pno;
       exer.setText("To burn "+ cal + " calories, You will have to ride cycle for "+ tim +" minutes ");
       
      }
      else if (age >45 && age < 60)
      {
        double Pno = (cal*60)/(weight*9.8);
        int tim = (int)Pno;
       exer.setText("To burn "+ cal + " calories, You will have to ride cycle for "+ tim +" minutes ");
       
      }
      else if (age >60 && age <75)
      {
        double Pno = (cal*60)/(weight*9.6);
        int tim = (int)Pno;
       exer.setText("To burn "+ cal + " calories, You will have to ride cycle for "+ tim +" minutes ");
       
       
      }
      else if (age < 10 || age >75 )
      {
        JOptionPane.showMessageDialog(null, "Invalid Input for age ", "Error", JOptionPane.ERROR_MESSAGE);
          
      }
    }
      else if (Female.equalsIgnoreCase("FEMALE"))
      {
       if(age > 10 && age <25)   
      {
        double Pno = (cal*60)/(weight*9.8);
        int tim = (int)Pno;
       exer.setText("To burn "+ cal + " calories, You will have to ride cycle for "+ tim +" minutes ");
      }
      else if (age >25 && age < 45)
      {
        double Pno = (cal*60)/(weight*9.6);
        int tim = (int)Pno;
       exer.setText("To burn "+ cal + " calories, You will have to ride cycle for "+ tim +" minutes ");
      }
      else if (age >45 && age < 60)
      {
        double Pno = (cal*60)/(weight*9.4);
        int tim = (int)Pno;
       exer.setText("To burn "+ cal + " calories, You will have to ride cycle for "+ tim +" minutes ");
      }
      else if (age >60 && age <75)
      {
        double Pno = (cal*60)/(weight*9.2);
        int tim = (int)Pno;
       exer.setText("To burn "+ cal + " calories, You will have to ride cycle for "+ tim +" minutes ");
      }
      else if (age < 10 || age >75 )
      {
        JOptionPane.showMessageDialog(null, "Invalid Input for age ", "Error", JOptionPane.ERROR_MESSAGE);
          
      }   
    }

      else
      {
//        JOptionPane.showMessageDialog(null, "Invalid Input for gender ", "Error", JOptionPane.ERROR_MESSAGE);
          
      }  
          
      
   } 
   public void actionPerformed(ActionEvent e) {
    if(e.getSource()== next){
      this.dispose();
         Exercise3 ex3 = new Exercise3(Male,Female,age,cal,weight,emaill);
         ex3.setVisible(true);
    }else if(e.getSource()== back ){
         this.dispose();
         new Exercise1(Male,Female,age,cal,weight,emaill);
        // Exercise1.setVisible(true);
    }else if(e.getSource() == exit){
        this.dispose();
        new Menu(emaill);
    }
    
   
  }  
}        
      
