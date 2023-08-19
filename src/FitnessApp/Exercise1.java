package FitnessApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

public class Exercise1 extends JFrame implements ActionListener {
  JButton b1,b2,next,exit;
  int age,cal,weight,gender;
  public  String Male,Female;
  String emaill;
  
  Exercise1(String Male, String Female ,int age,int cal,int weight,String email)
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

  ImageIcon i01 = new ImageIcon(ClassLoader.getSystemResource("image/1.gif"));
  //Image i2 = i01.getImage().getScaledInstance(500,400,1);
  //ImageIcon i3 = new ImageIcon(i2);
  JLabel p1 = new JLabel(i01);
  p1.setLayout(null);
  p1.setBounds(65,80,300,300);
  p1.setBackground(Color.red);
  image.add(p1);    
  
  ImageIcon i02 = new ImageIcon(ClassLoader.getSystemResource("image/2.gif"));
  //Image i2 = i01.getImage().getScaledInstance(500,400,1);
  //ImageIcon i3 = new ImageIcon(i2);
  JLabel p2 = new JLabel(i02);
  p2.setLayout(null);
  p2.setBounds(440,80,300,300);
  p2.setBackground(Color.red);
  image.add(p2); 

  JLabel title = new JLabel();
  title.setBounds(330,0,700,70);
  title.setFont(new Font("Arial",Font.BOLD,40));
  title.setForeground(new Color(190,120,170));
  title.setText("PUSH UP");
  image.add(title);
  
  JLabel exer = new JLabel();
  exer.setBounds(60,380,700,100);
  exer.setFont(new Font("Arial",Font.BOLD,22));
//  exer.setForeground(new Color(90,120,170));
      exer.setForeground(Color.white);
  exer.setVisible(true);
  image.add(exer);
  
  JLabel rules = new JLabel ();
    rules.setBounds(10,350,500,350);
    rules.setFont(new Font("",Font.PLAIN,16));
    rules.setForeground(new Color(0,190,40));
    rules.setText(
     "<html>"+ 
        "<ul>" + 
           "<li>"+"Place your hands firmly on the ground, directly under shoulders. "+   
           "<li>"+"Flatten your back so your entire body is straight and slowly lower your body"+   
           "<li>"+"Draw shoulder blades back and down, keeping elbows tucked close to your body"+   
           "<li>"+"Exhale as you push back to the starting position."+ 
           "<li>"+"Do pushups in set of [10 rep/ 20 rep] as per convinience"+
        "</ul>" +   
     "<html>"
   
    );
  image.add(rules);
    
    next = new JButton();

    next.setText("NEXT");
    next.setBounds(600,550,100,35);
    next.setBackground(Color.LIGHT_GRAY);
    next.addActionListener(this);
    image.add(next);
  

    JButton back = new JButton();

    back = new JButton("BACK");
    back.setBounds(5,5,100,35);
    back.setBackground(Color.LIGHT_GRAY);
    image.add(back);

    JButton info = new JButton();

    info = new JButton("More Info...");
    info.setBounds(700,400,100,35);
    info.setBackground(Color.LIGHT_GRAY);
    info.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent v)
            {
                try
                {
                    Desktop.getDesktop().browse(URI.create("https://musclewiki.com/bodyweight/male/chest"));
                } catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        });
        image.add(info);

   exit = new JButton();
  
    exit = new JButton("Exit");
    exit.setBounds(720,550,100,35);
    exit.setBackground(Color.LIGHT_GRAY);
    exit.addActionListener(this);
    image.add(exit);

   //JRadioButton nextWindowRadioButton = new JRadioButton();
   //ButtonModel model = buttonGroup.getSelection();
   
      if(Male.equalsIgnoreCase("MALE") ){
       
        if(age > 10 && age <25)   
      {
       int Pno = cal/03;
      exer.setText("To burn "+ cal + " calories, You will have to do "+ Pno +" Pushups ");
      }
      else if (age >25 && age < 45)
      {
      int Pno = cal/03;
      exer.setText("To burn "+ cal + " calories, You will have to do "+ Pno +" Pushups "); 
      }
      else if (age >45 && age < 60)
      {
      int Pno = cal/03;
      exer.setText("To burn "+ cal + " calories, You will have to do "+ Pno +" Pushups "); 
      }
      else if (age >60 && age <75)
      {
      
      int Pno = cal/03;
      exer.setText("To burn "+ cal + " calories, You will have to do "+ Pno +" Pushups ");  
      }
      else if (age < 10 || age >75 )
      {
//        JOptionPane.showMessageDialog(null, "Invalid Input for age ", "Error", JOptionPane.ERROR_MESSAGE);
          
      }
    }
      else if (Female.equalsIgnoreCase("FEMALE"))
      {
       if(age > 10 && age <25)   
      {
       int Pno = cal/03;
      exer.setText("To burn "+ cal + "calories, You will have to do "+ Pno +" Pushups ");
      }
      else if (age >25 && age < 45)
      {
      int Pno = cal/03;
      exer.setText("To burn "+ cal + "calories, You will have to do "+ Pno +" Pushups "); 
      }
      else if (age >45 && age < 60)
      {
      int Pno = cal/03;
      exer.setText("To burn "+ cal + "calories, You will have to do "+ Pno +" Pushups "); 
      }
      else if (age >60 && age <75)
      {
      int Pno = cal/03;
      exer.setText("To burn "+ cal + "calories, You will have to do "+ Pno +" Pushups ");  
      }
      else if (age < 10 || age >75 )
      {
        JOptionPane.showMessageDialog(null, "Invalid Input for age ", "Error", JOptionPane.ERROR_MESSAGE);  
          
      }   
          
      }
   } 
   
     
  public void actionPerformed(ActionEvent e) {
    if(e.getSource()== next){
         this.dispose();
         Exercise2 ex2 = new Exercise2(Male,Female,age,cal,weight,emaill);
         ex2.setVisible(true);
    } else if(e.getSource()== exit){
        this.dispose();
        new Menu(emaill);
    }
          
    

} 

/*public static void main(String Args[])
{   
    Exercise1 ex1 = null;
    ex1 = new Exercise1(ex1.Male,ex1.Female,ex1.age,ex1.cal,ex1.weight); 
    ex1.setVisible(true);
    

      
   
    
}     */ 
}
