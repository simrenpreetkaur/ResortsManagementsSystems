
package resort.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class addRooms extends JFrame implements ActionListener {
    
    JTextField text1,text2;
    JComboBox combo1,combo2,combo3;
    JButton button1,button2;
    
    addRooms(){
        
        JLabel label1 = new JLabel("ADD ROOMS");
        label1.setFont(new Font("Monospaced", Font.PLAIN, 30));
        label1.setBounds(150,5,200,70);
        add(label1);
        
        JLabel room = new JLabel("Room Number");
        room.setFont(new Font("Tahoma", Font.PLAIN, 16));
        room.setBounds(60,80,120,30);
        add(room);
        
        text1 = new JTextField();
        text1.setBounds(200,80,150,30);
        add(text1);
        
        JLabel available = new JLabel("Availability");
        available.setFont(new Font("Tahoma", Font.PLAIN, 16));
        available.setBounds(60,130,120,30);
        add(available);
        
        combo1 = new JComboBox(new String [] {"Available", "Occupied"});
        combo1.setBackground(Color.WHITE);
        combo1.setBounds(200,130,150,30);
        add(combo1);
        
        JLabel status = new JLabel("Cleaning Status");
        status.setFont(new Font("Tahoma", Font.PLAIN, 16));
        status.setBounds(60,180,120,30);
        add(status);
        
        combo2 = new JComboBox(new String [] {"Cleaned", "Unclean"});
        combo2.setBackground(Color.WHITE);
        combo2.setBounds(200,180,150,30);
        add(combo2);
        
        JLabel price = new JLabel("Room Price (RM)");
        price.setFont(new Font("Tahoma", Font.PLAIN, 16));
        price.setBounds(60,230,120,30);
        add(price);
        
        text2 = new JTextField();
        text2.setBounds(200,230,150,30);
        add(text2);
        
        JLabel type = new JLabel("Room Type");
        type.setFont(new Font("Tahoma", Font.PLAIN, 16));
        type.setBounds(60,280,120,30);
        add(type);
        
        combo3 = new JComboBox(new String [] {"Single", "Double","Triple","Suite","Villa"});
        combo3.setBackground(Color.WHITE);
        combo3.setBounds(200,280,150,30);
        add(combo3);
        
        button1 = new JButton("Add Room");
        button1.setBounds(60,350,130,30);
        button1.addActionListener(this);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        add(button1);
        
        button2 = new JButton("Back");
        button2.setBounds(220,350,130,30);
        button2.addActionListener(this);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        add(button2);
        
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("resort/management/system/images/five.jpg"));
        Image image2 = image1.getImage().getScaledInstance(550, 550,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2); 
        JLabel label5 = new JLabel(image3);
        label5.setBounds(420,0,540,450);
        add(label5);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(500,200,940,500);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == button1){
            String room = text1.getText();
            String available = (String)combo1.getSelectedItem();
            String status = (String)combo2.getSelectedItem();
            String price = text2.getText();
            String type = (String)combo3.getSelectedItem();
            
            com c = new com();
            try{
                String str = "insert into room values ('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room Added");
                this.setVisible(false);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == button2){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new addRooms().setVisible(true);
    }
    
}
