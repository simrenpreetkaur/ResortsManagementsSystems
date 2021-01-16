//This is the resort management system front page 

package resort.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResortManagementSystem extends JFrame implements ActionListener{
    ResortManagementSystem(){
        setBounds(300,300,1500,600);
        setVisible(true);
        
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("resort/management/system/images/one.jpg"));
        Image image2 = image1.getImage().getScaledInstance(1500, 700,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2); 
        JLabel label1 = new JLabel(image3);
        label1.setBounds(0,0,1500,600);
        add(label1);
                      
        JLabel label2 = new JLabel("Resort Management System");
        label2.setBounds(320,250,1500,90);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("serif", Font.PLAIN,70));
        label1.add(label2);
        
        JLabel label3 = new JLabel("Welcome TO OUR ");
        label3.setBounds(470,180,1000,70);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("serif", Font.PLAIN,70));
        label1.add(label3);
        
        JButton button1 = new JButton("NEXT");
        button1.setBackground(Color.LIGHT_GRAY);
        button1.setForeground(Color.BLACK);
        button1.setBounds(1250, 450, 150, 50);
        button1.addActionListener(this);
        label1.add(button1);
        
        setLayout(null);
        setVisible(true);
        
        while(true){
            label2.setVisible(false);
            try{
                Thread.sleep(650);
            }catch(Exception e){}
            
            label2.setVisible(true);
            try{
                Thread.sleep(650);
            }catch(Exception e){}
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        new login().setVisible(true);
        this.setVisible(false);
    }
    
    public static void main(String[] args) {
        new ResortManagementSystem();
    }
    
}
