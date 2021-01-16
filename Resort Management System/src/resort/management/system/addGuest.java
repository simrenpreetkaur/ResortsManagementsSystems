
package resort.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class addGuest extends JFrame implements ActionListener{
    JTextField text1,text2,text3,text4,text5,text6,text7;
    JButton button1,button2,button3;
    JComboBox combo1;
    Choice choice1;
    JRadioButton radio1,radio2;
    
    addGuest(){
        JLabel label1 = new JLabel("New Guest Form");
        label1.setBounds(300,6,300,50);
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Monospaced", Font.PLAIN, 30));
        add(label1);
        
        JLabel label2 = new JLabel("ID Type");
        label2.setBounds(35,80,100,20);
        add(label2);
        
        combo1 = new JComboBox(new String [] {"IC Number","Passport","Driving License"});
        combo1.setBounds(200,80,150,20);
        add(combo1);
        
        JLabel label3 = new JLabel("ID Number");
        label3.setBounds(35,120,100,20);
        add(label3);
        
        text1 = new JTextField();
        text1.setBounds(200,120,150,30);
        add(text1);
        
        JLabel label4 = new JLabel("Name");
        label4.setBounds(35,160,100,20);
        add(label4);
        
        text2 = new JTextField();
        text2.setBounds(200,160,150,30);
        add(text2);
        
        JLabel label5 = new JLabel("Gender");
        label5.setBounds(35,200,100,20);
        add(label5);
        
        radio1 = new JRadioButton("Male");
        radio1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        radio1.setBounds(200,200,70,20);
        radio1.setBackground(Color.WHITE);
        add(radio1);
        
        radio2 = new JRadioButton("Female");
        radio2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        radio2.setBounds(275,200,100,20);
        radio2.setBackground(Color.WHITE);
        add(radio2);
        
        JLabel label6 = new JLabel("Country");
        label6.setBounds(35,240,100,20);
        add(label6);
        
        text3 = new JTextField();
        text3.setBounds(200,240,150,30);
        add(text3);
        
        JLabel label7 = new JLabel("Allocated Room Number");
        label7.setBounds(35,280,150,20);
        add(label7);
        
        choice1 = new Choice();
        try{
                com c = new com();
                String str = "select * from room where available = 'Available'";
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()){
                    choice1.add(rs.getString("room_number"));
                }
        }catch(Exception e){};
        choice1.setBounds(200,280,150,25);
        add(choice1);
        
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("resort/management/system/images/tick.png"));
        Image image2 = image1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2); 
        button3 = new JButton(image3);
        button3.setBounds(360,280,20,25);
        button3.addActionListener(this);
        add(button3);
        
        JLabel label10 = new JLabel("Room Type");
        label10.setBounds(35,320,100,20);
        add(label10);
        
        text6 = new JTextField();
        text6.setBounds(200,320,150,30);
        add(text6);
        
        JLabel label11 = new JLabel("Room Price (RM)");
        label11.setBounds(35,360,100,20);
        add(label11);
        
        text7 = new JTextField();
        text7.setBounds(200,360,150,30);
        add(text7);
        
        JLabel label8 = new JLabel("Checked In");
        label8.setBounds(35,400,100,20);
        add(label8);
        
        text4 = new JTextField();
        text4.setBounds(200,400,150,30);
        add(text4);
        
        JLabel label9 = new JLabel("Deposit (RM)");
        label9.setBounds(35,440,100,20);
        add(label9);
        
        text5 = new JTextField();
        text5.setBounds(200,440,150,30);
        add(text5);
        
        button1 = new JButton("Add Guest");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(50,495,120,25);
        button1.addActionListener(this);
        add(button1);
        
        button2 = new JButton("Back");
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setBounds(200,495,120,25);
        button2.addActionListener(this);
        add(button2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resort/management/system/images/eight.jpg"));
        //Image i2 = i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
        //ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i1);
        image.setBounds(335,50,450,450);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(500,200,800,600);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == button1){
            String id = (String)combo1.getSelectedItem();
            String number = text1.getText();
            String name = text2.getText();
            String gender = null;
            if(radio1.isSelected()){
                gender = "Male";
            }else if(radio2.isSelected()){
                gender = "Female";
            }
            String country = text3.getText();
            String room = choice1.getSelectedItem();
            String status = text4.getText();
            String deposit = text5.getText();

            String str = "insert into guest values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
            String str2 = "update room set available = 'Occupied' where room_number = '"+room+"'";
            
            try{
                com c = new com();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);

                JOptionPane.showMessageDialog(null,"New Guest Added");
                new reception().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){}
        
        }else if(ae.getSource() == button2){
            new reception().setVisible(true);
            this.setVisible(false);
            
        }else if(ae.getSource() == button3){
            try{
                String type = null;
                String price = null;
                com c = new com();
                String choice2 = choice1.getSelectedItem();
                String str = "select * from room where room_number = '"+choice2+"'";
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()){
                    text6.setText(rs.getString("room_type"));
                    text7.setText(rs.getString("price"));
                }
            }catch(Exception e){}
        }   
    }
    
    public static void main(String[] args){
        new addGuest().setVisible(true);
    }
}
