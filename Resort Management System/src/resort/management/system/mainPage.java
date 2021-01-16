
package resort.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainPage extends JFrame implements ActionListener {
    
    JMenuBar mb;
    JMenu menu1,menu2;
    JMenuItem item1,item2,item3;
    JButton button1;
    
    mainPage(){
        mb = new JMenuBar();
        mb.setBounds(0,0,1980,50);
        add(mb);
        
        menu1 = new JMenu("Resort Management");
        menu1.setForeground(Color.BLACK);
        menu1.setFont(new Font("Monospaced", Font.BOLD,20));
        mb.add(menu1);
        
        menu2 = new JMenu("Admin");
        menu2.setForeground(Color.BLACK);
        menu2.setFont(new Font("Monospaced", Font.BOLD,20));
        mb.add(menu2);
        
        item1 = new JMenuItem("Reception");
        item1.setFont(new Font("Monospaced", Font.PLAIN,18));
        item1.addActionListener(this);
        menu1.add(item1);
        
        item2 = new JMenuItem("Add Employees");
        item2.setFont(new Font("Monospaced", Font.PLAIN,18));
        item2.addActionListener(this);
        menu2.add(item2);
        
        item3 = new JMenuItem("Add Rooms");
        item3.setFont(new Font("Monospaced", Font.PLAIN,18));
        item3.addActionListener(this);
        menu2.add(item3);
                  
        setLayout(null);
        setBounds(0,0,1950,1000);
        setVisible(true);
        
        button1 = new JButton("Exit");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(1700,870,130,50);
        button1.addActionListener(this);
        add(button1);
        
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("resort/management/system/images/three.jpg"));
        Image image2 = image1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2); 
        JLabel label1 = new JLabel(image3);
        label1.setBounds(0,0,1800,1000);
        add(label1);
        
        JLabel label2 = new JLabel("WELCOME");
        label2.setBounds(630,400,1000,180);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 150));
        label1.add(label2);
        
       
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Reception")){
            new reception().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Employees")){
            new addEmployee().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Rooms")){
            new addRooms().setVisible(true);
        }else if(ae.getSource() == button1){
            setVisible(false);
        }  
    }    
    
    public static void main(String[] args){
        new mainPage().setVisible(true);
    }
    
}
