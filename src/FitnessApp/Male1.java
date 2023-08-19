//package fitness.application;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Male1 extends JFrame {
    
    int age,cal,weight;
    private ImageIcon[] images;
    private String[] captions; // array to store captions for each image
    private int currentImageIndex;
    private JLabel imageLabel;
    private JLabel captionLabel; // label for displaying the caption
    
    
    public Male1(int age,int cal,int weight) {
        setTitle("GIF Slideshow");
        
         this.age = age;
         this.cal = cal;
         this.weight = weight;
        // Load the images
        images = new ImageIcon[5];
        images[0] = new ImageIcon(ClassLoader.getSystemResource("push upp 1.gif"));
        images[1] = new ImageIcon(ClassLoader.getSystemResource("cycling.gif"));
        //images[2] = new ImageIcon(ClassLoader.getSystemResource("icon/EmE8.gif"));
        //images[3] = new ImageIcon(ClassLoader.getSystemResource("icon/ezgif.com-resize.gif"));
        images[3] = new ImageIcon(ClassLoader.getSystemResource("rope skipping.gif"));
        
        
        
        // Set the captions for each image
        int Pno = cal/03;
        int Bmin = (cal*60)/(10*weight);
        int Rmin = (int) ((cal*60)/(6.4*weight));
        int Wmin = (cal*60)/(6*weight);
        int Smin = (cal*60)/(10*weight);
        
        captions = new String[5];
        captions[0] = "PUSHUPS \n" 
                + "\n To burn "+ cal + "calories, You will have to do "+ Pno +" Pushups";        
        captions[1] = "BICYCLING \n"
                + "\n To burn "+ cal + "calories, You will have to ride bicycle "+ Bmin +" minutes";
        captions[2] = "RUNNING \n"
                + "\n For 6.4 kmph , to burn "+ cal +" calories you have to run  "+ Rmin +" minutes"; 
        captions[3] = "WALKING \n "
                + "\n To burn "+ cal + "calories, You will have to walk "+ Wmin +" minutes";
        captions[4] = "SKIPPING \n"
                + "\n To burn "+ cal + "calories, You will have to skip "+ Smin +" minutes";
                     
        
        // Create the image label and set the initial image and caption
        imageLabel = new JLabel();
        //imageLabel.setBounds(150,50,600,500); //corect
        imageLabel.setIcon(images[0]);
        captionLabel = new JLabel(captions[0]);

       // ImageIcon icon = new ImageIcon("texture.jpg");
       // JLabel iconlabel = new JLabel(icon);

        //captionLabel.setBounds(20,700,700,150);
        //captionLabel.setText("TO Burn pushups");
         // Set the font and size of the caption label
         Font captionFont = new Font("Tahoma", Font.BOLD, 18);
         captionLabel.setFont(captionFont);


    
         
        // Add the image label and caption label to a panel
        JPanel imagePanel = new JPanel();
        //imagePanel.setLayout(new BorderLayout());
        imagePanel.setBounds(100,150,750,550);
        //imagePanel.setBackground(Color.BLUE);
        //imagePanel.add(iconlabel);
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        //imagePanel.setHorizontalAlignment(imageLabel.CENTER);
        //JPanel imagePanel1 = new JPanel();
        //imagePanel1.setBounds(20,700,750,100);
        imagePanel.add(captionLabel, BorderLayout.SOUTH);
      // add caption label below image label
        
        // Create the next and previous buttons
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentImageIndex++;
                if (currentImageIndex == images.length) {
                    currentImageIndex = 0;
                }
                imageLabel.setIcon(images[currentImageIndex]);
                captionLabel.setText(captions[currentImageIndex]); // set the new caption
            }
        });
        
        JButton prevButton = new JButton("Previous");
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentImageIndex--;
                if (currentImageIndex < 0) {
                    currentImageIndex = images.length - 1;
                }
                imageLabel.setIcon(images[currentImageIndex]);
                captionLabel.setText(captions[currentImageIndex]); // set the new caption
            }
        });
        
        // Create the exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });
        
        // Add the buttons to a panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(exitButton);
        
        // Add the panels to the frame
        getContentPane().add(imagePanel, BorderLayout.CENTER);
        //getContentPane().add(imagePanel1, BorderLayout.SOUTH);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        // Set the size of the frame to the size of the image
       // Dimension imageSize = new Dimension(images[0].getIconWidth(), images[0].getIconHeight() + 20); // add some extra height for the caption label
        setSize(900,800);
        
        // Center the frame on the screen
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenDimension.width - getSize().width) / 2;
        int y = (screenDimension.height - getSize().height) / 2;
        setLocation(x, y);
    }
    
    public static void main(String[] args) {
         Male1 male1 = null;
         male1 = new Male1(male1.age,male1.cal,male1.weight);
         male1.setVisible(true);
        
    }
}