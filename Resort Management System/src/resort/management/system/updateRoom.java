
package resort.management.system;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;


public class updateRoom extends JFrame implements ActionListener{
    Choice choice1;
    JTextField text1,text2,text3; 
    JButton button1,button2,button3;
    
    updateRoom(){
        JLabel label1 = new JLabel("Update Room Status"); 
        label1.setFont(new Font("Monospaced", Font.PLAIN, 25));
        label1.setBounds(80,3,300,70);
        add(label1);
        
        JLabel label2 = new JLabel("Guest ID");
        label2.setBounds(30,80,120,20);
        add(label2);
        
        choice1 = new Choice();
        try{
                com c = new com();
                String str = "select * from guest";
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()){
                    choice1.add(rs.getString("number"));
                }
                
        }catch(Exception e){}
        choice1.setBounds(200,80,150,20);
        add(choice1);
        
        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30,130,120,20);
        add(label3);
        
        text1 = new JTextField();
        text1.setBounds(200,130,150,20);
        add(text1);
        
        JLabel label4 = new JLabel("Availability");
        label4.setBounds(30,180,120,20);
        add(label4);
        
        text2 = new JTextField();
        text2.setBounds(200,180,150,20);
        add(text2);
        
        JLabel label5 = new JLabel("Clean Status");
        label5.setBounds(30,230,120,20);
        add(label5);
        
        text3 = new JTextField();
        text3.setBounds(200,230,150,20);
        add(text3);
        
        button1 = new JButton("Check");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(40,290,120,30);
        button1.addActionListener(this);
        add(button1);
        
        button2 = new JButton("Update");
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setBounds(210,290,120,30);
        button2.addActionListener(this);
        add(button2);
        
        button3 = new JButton("Back");
        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.WHITE);
        button3.setBounds(125,335,120,30);
        button3.addActionListener(this);
        add(button3);     
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resort/management/system/images/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i3);
        image.setBounds(400,10,500,400);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(500,200,980,450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == button1){
            String room = null;
            String sl = choice1.getSelectedItem();
            com c = new com();
            try{
                ResultSet rs = c.s.executeQuery("select * from guest where number = '"+sl+"'");
                while(rs.next()){
                    text1.setText(rs.getString("room"));
                    room = rs.getString("room");
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
                while(rs2.next()){
                    text2.setText(rs2.getString("available"));
                    text3.setText(rs2.getString("status"));
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource() == button2){
            try{
                com c = new com();
                String room = text1.getText();
                String available = text2.getText();
                String status = text3.getText();
                
                String str = "update room set available = '"+available+"',status = '"+status+"' where room_number = '"+room+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Room Updated Successfully");
                new reception().setVisible(true);
                this.setVisible(false);
                
            }catch(Exception e){}
        }else if(ae.getSource() == button3){
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }    
    
    public static void main(String[] args){
        new updateRoom().setVisible(true);
    }
}
