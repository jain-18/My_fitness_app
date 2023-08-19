package FitnessApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

public class Exercise5 extends JFrame implements ActionListener {
  JButton b1,b2,next,back;
  int age,cal,weight,gender;
  public  String Male,Female;
  String emaill;
  JButton exit;
  
  Exercise5(String Male, String Female ,int age,int cal,int weight,String email)
  {
   this.age = age;
   this.cal = cal;
   this.weight = weight;
   this.Male = Male;
   this.Female = Female;
   emaill = email;
  setTitle("Exercise");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setSize(1000, 720);
  setLayout(null);
  setLocationRelativeTo(null);
  setVisible(true);   
      
  
  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/black.jpg"));
  JLabel image= new JLabel(i1);
  image.setBounds(0,0,1000,780);
  add(image);

  ImageIcon i01 = new ImageIcon(ClassLoader.getSystemResource("image/walking1.gif"));
  //Image i2 = i01.getImage().getScaledInstance(500,400,1);
  //ImageIcon i3 = new ImageIcon(i2);
  JLabel p1 = new JLabel(i01);
  p1.setLayout(null);
  p1.setBounds(80,80,250,300);
  p1.setBackground(Color.red);
  image.add(p1);    
  
   ImageIcon i02 = new ImageIcon(ClassLoader.getSystemResource("image/walking22.gif"));
  //Image i2 = i01.getImage().getScaledInstance(500,400,1);
  //ImageIcon i3 = new ImageIcon(i2);
  JLabel p2 = new JLabel(i02);
  p2.setLayout(null);
  p2.setBounds(360,80,250,300);
  p2.setBackground(Color.red);
  image.add(p2); 

  ImageIcon i03 = new ImageIcon(ClassLoader.getSystemResource("image/walking3.gif"));
  //Image i2 = i01.getImage().getScaledInstance(500,400,1);
  //ImageIcon i3 = new ImageIcon(i2);
  JLabel p3 = new JLabel(i03);
  p3.setLayout(null);
  p3.setBounds(680,80,250,300);
  p3.setBackground(Color.red);
  image.add(p3); 

  JLabel title = new JLabel();
  title.setBounds(400,0,700,70);
  title.setFont(new Font("Arial",Font.BOLD,40));
  title.setForeground(new Color(190,120,170));
  title.setText("Walking");
  image.add(title);
  
  JLabel exer = new JLabel();
  exer.setBounds(60,370,780,150);
  exer.setFont(new Font("Arial",Font.BOLD,22));
  exer.setForeground(new Color(90,120,170));
  image.add(exer);
  
  JLabel rules = new JLabel ();
    rules.setBounds(10,340,650,450);
    rules.setFont(new Font("",Font.PLAIN,16));
    rules.setForeground(new Color(0,190,40));
    rules.setText(
     "<html>"+ 
        "<ul>" + 
           "<li>"+"1. Beginner - Try walking briskly at a 3 to 3.5-mph pace (walking a mile in 17-20 minutes), beginning with 10 minutes per day for the first three weeks. Slowly increase the time you walk by 5 minutes per week until you are able to walk 30 minutes per day, six days per week. "+ 
           "<li>"+"2. Intermediate -If you are already regularly active, start at this level. Aim for a pace of 3.5 to 4.5 mph (13-17 minutes per mile), walking 3 miles (about 45 minutes), 3-5 times per week."+ 
           "<li>"+"3. Advanced -  Walk/hike with a 10-15 lb. backpack.  Add uphill/downhill and stairclimbing to your regular walks .  Try racewalking (5-9 mph).  "+
        "</ul>" +   
     "<html>"
   
    );
  image.add(rules);

    JLabel l1 = new JLabel();
    l1.setBounds(130,350,150,100);
    l1.setFont(new Font("Playfair",Font.BOLD,22));
    l1.setForeground(Color.WHITE);
    l1.setText("Beginner");
    image.add(l1);
   
    JLabel l2 = new JLabel();
    l2.setBounds(400,350,150,100);
    l2.setFont(new Font("Playfair",Font.BOLD,22));
    l2.setForeground(Color.WHITE);
    l2.setText("Intermediate");
    image.add(l2);

    JLabel l3 = new JLabel();
    l3.setBounds(730,350,150,100);
    l3.setFont(new Font("Playfair",Font.BOLD,22));
    l3.setForeground(Color.WHITE);
    l3.setText(" Advanced ");
    image.add(l3);



  next = new JButton();

    next.setText("NEXT");
    next.setBounds(740,550,100,35);
    next.setBackground(Color.LIGHT_GRAY);
    next.addActionListener(this);
    image.add(next);

     back = new JButton();

    back.setText("BACK");
    back.setBounds(5,5,100,35);
    back.setBackground(Color.LIGHT_GRAY);
    back.addActionListener(this);
    image.add(back);

    JButton info = new JButton();

    info = new JButton("More Info...");
    info.setBounds(795,470,100,35);
    info.setBackground(Color.LIGHT_GRAY);
    info.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent v)
        {
            try
            {
                Desktop.getDesktop().browse(URI.create("https://uhs.berkeley.edu/health-topics/exercise-starting-walking-program"));
            } catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
    });
    image.add(info);


  
    exit = new JButton("EXIT");
    exit.setBounds(860,550,100,35);
    exit.setBackground(Color.LIGHT_GRAY);
    exit.addActionListener(this);
    image.add(exit);

   //JRadioButton nextWindowRadioButton = new JRadioButton();
   //ButtonModel model = buttonGroup.getSelection();
   
      if(Male.equalsIgnoreCase("MALE") )
       
        if(age > 10 && age <25)   
      {
       double Pno = (cal*60)/(weight*5.6);
       int tim = (int)Pno;
      exer.setText("To burn "+ cal + " calories, You will have to walk for "+ tim +" minutes ");
      
      }
      else if (age >25 && age < 45)
      {
      double Pno = (cal*60)/(weight*5.6);
      int tim = (int)Pno;
      exer.setText("To burn "+ cal + " calories, You will have to walk for  "+ tim +" Minutes "); 
      }
      else if (age >45 && age < 60)
      {
      double Pno = (cal*60)/(weight*5.3);
      int tim = (int)Pno;
      exer.setText("To burn "+ cal + " calories, You will have to walk for "+ tim +" Minutes "); 
      }
      else if (age >60 && age <75)
      {
      double Pno = (cal*60)/(weight*5.0);
      int tim = (int)Pno;
      exer.setText("To burn "+ cal + " calories, You will have to walk for "+ tim +" Minutes ");  
      }
      else if (age < 10 || age >75 )
      {
        JOptionPane.showMessageDialog(null, "Invalid Input for age ", "Error", JOptionPane.ERROR_MESSAGE);  
          
      }
      else if (Female.equalsIgnoreCase("FEMALE"))
      {
       if(age > 10 && age <25)   
      {
       double Pno = (cal*60)/(weight*5.6);
       int tim = (int)Pno;
      exer.setText("To burn "+ cal + "calories, You will have to walk for "+ tim +" Minutes ");
      }
      else if (age >25 && age < 45)
      {
      double Pno = (cal*60)/(weight*5.4);
      int tim = (int)Pno;
      exer.setText("To burn "+ cal + "calories, You will have to walk for "+ tim +" Minutes "); 
      }
      else if (age >45 && age < 60)
      {
      double Pno = (cal*60)/(weight*5.1);
      int tim = (int)Pno;
      exer.setText("To burn "+ cal + "calories, You will have to walk for "+ tim +" Minutes "); 
      }
      else if (age >60 && age <75)
      {
      double Pno = (cal*60)/(weight*4.8);
      int tim = (int)Pno;
      exer.setText("To burn "+ cal + "calories, You will have to walk for "+ tim +" Minutes ");  
      }
      else if (age < 10 || age >75 )
      {
        JOptionPane.showMessageDialog(null, "Invalid Input for age ", "Error", JOptionPane.ERROR_MESSAGE);  
          
      }   
          
      }
   } 
   public void actionPerformed(ActionEvent e) {
     if (e.getSource() == next) {
       this.dispose();
       Exercise6 ex6 = new Exercise6(Male, Female, age, cal, weight, emaill);
       ex6.setVisible(true);
     }
     if (e.getSource() == back) {
       this.dispose();
       new Exercise4(Male, Female, age, cal, weight, emaill);
     } else if (e.getSource() == exit) {
       this.dispose();
       new Menu(emaill);

     }
   }
   
   
  }          
      
