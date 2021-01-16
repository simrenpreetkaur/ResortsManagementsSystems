
package resort.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

public class roomInfo extends JFrame implements ActionListener{
    JTable table1;
    JButton button1,button2;
    
    roomInfo(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resort/management/system/images/seven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i3);
        image.setBounds(500,20,550,550);
        add(image);
        
        table1 = new JTable();
        table1.setBounds(0,40,500,400);
        add(table1);
        
        JLabel label1 = new JLabel("Room Number");
        label1.setBounds(10,10,100,20);
        add(label1);
        
        JLabel label2 = new JLabel("Availability");
        label2.setBounds(120,10,100,20);
        add(label2);
        
        JLabel label3 = new JLabel("Status");
        label3.setBounds(230,10,100,20);
        add(label3);
        
        JLabel label4 = new JLabel("Price (RM)");
        label4.setBounds(320,10,100,20);
        add(label4);
        
        JLabel label5 = new JLabel("Room Type");
        label5.setBounds(410,10,100,20);
        add(label5);
        
        button1 = new JButton("Load Data");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(100,460,120,30);
        button1.addActionListener(this);
        add(button1);
        
        button2 = new JButton("Back");
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setBounds(250,460,120,30);
        button2.addActionListener(this);
        add(button2);
        
        setLayout(null);
        setBounds(450,200,1000,650);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == button1){
            try{
                com c = new com();
                String str = "select * from room";
                ResultSet rs = c.s.executeQuery(str);
                table1.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){}
            
        }else if(ae.getSource() == button2){
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        
    }
}
