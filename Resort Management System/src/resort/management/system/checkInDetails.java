
package resort.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class checkInDetails extends JFrame implements ActionListener{
    JButton button1,button2;
    Choice choice1;
    JTextField text1,text2,text3,text4,text5;
    
    checkInDetails(){
        JLabel label1 = new JLabel("Check-In Details"); 
        label1.setFont(new Font("Monospaced", Font.PLAIN, 25));
        label1.setBounds(100,5,250,70);
        add(label1);
        
        JLabel label2 = new JLabel("Guest ID");
        label2.setBounds(30,80,100,20);
        add(label2);
        
        choice1 = new Choice();
        try{
            com c = new com();
            ResultSet rs = c.s.executeQuery("select * from guest");
                while(rs.next()){
                    choice1.add(rs.getString("number"));
                }    
        }catch(Exception e){}
        choice1.setBounds(200,80,150,20);
        add(choice1);
        
        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30,120,120,20);
        add(label3);
        
        text1 = new JTextField();
        text1.setBounds(200,120,150,20);
        add(text1);
        
        JLabel label4 = new JLabel("Name");
        label4.setBounds(30,160,120,20);
        add(label4);
        
        text2 = new JTextField();
        text2.setBounds(200,160,150,20);
        add(text2);
        
        JLabel label5 = new JLabel("Check In");
        label5.setBounds(30,200,120,20);
        add(label5);
        
        text3 = new JTextField();
        text3.setBounds(200,200,150,20);
        add(text3);
        
        JLabel label6 = new JLabel("Amount Paid");
        label6.setBounds(30,240,120,20);
        add(label6);
        
        text4 = new JTextField();
        text4.setBounds(200,240,150,20);
        add(text4);
        
        JLabel label7 = new JLabel("Pending Amount");
        label7.setBounds(30,280,120,20);
        add(label7);
        
        text5 = new JTextField();
        text5.setBounds(200,280,150,20);
        add(text5);
        
        button1 = new JButton("Check");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(40,330,120,30);
        button1.addActionListener(this);
        add(button1);
        
        button2 = new JButton("Back");
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setBounds(200,330,120,30);
        button2.addActionListener(this);
        add(button2);     
        
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("resort/management/system/images/ten.jpg"));
        Image image2 = image1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2); 
        JLabel image = new JLabel(image3);
        image.setBounds(400,50,500,300);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(500,200,980,450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == button1){
            try{
                String room = null;
                String deposit = null;
                int amountPaid;
                String price = null;
                com c = new com();
                String id = choice1.getSelectedItem();
                String str = "select * from guest where number = '"+id+"'";
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()){
                    text1.setText(rs.getString("room"));
                    text2.setText(rs.getString("name"));
                    text3.setText(rs.getString("status"));
                    text4.setText(rs.getString("deposit"));
                    room = rs.getString("room");
                    deposit = rs.getString("deposit");
                }
                
                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
                while(rs2.next()){
                    price = rs2.getString("price");
                    amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                   text5.setText(Integer.toString(amountPaid));
                }
            }catch(Exception e){}
            
        }else if(ae.getSource() == button2){
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new checkInDetails().setVisible(true);
    }
    
}
