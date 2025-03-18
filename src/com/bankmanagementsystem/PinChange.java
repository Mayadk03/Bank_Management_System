package com.bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PinChange extends JFrame implements ActionListener{
	JPasswordField pin ,repin;
	JButton back,change;
	String pinno;
	public PinChange(String pinno) {
		this.pinno = pinno;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 800, 842);
		add(image);
		
		JLabel text = new JLabel("CHANGE PIN");
		text.setForeground(Color.white);
		text.setBounds(240,290,500,30);
		text.setBackground(Color.black);
		text.setFont(new Font("Constantia",Font.BOLD,16));
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN:");
		pintext.setForeground(Color.white);
		pintext.setBounds(150,340,500,30);
		pintext.setBackground(Color.black);
		pintext.setFont(new Font("Constantia",Font.BOLD,16));
		image.add(pintext);
		
		JLabel repintext = new JLabel("<html>Re-Enter<br>  New PIN:<html>");
		repintext.setForeground(Color.white);
		repintext.setBounds(150,390,500,40);
		repintext.setBackground(Color.black);
		repintext.setFont(new Font("Constantia",Font.BOLD,16));
		image.add(repintext);
		
		pin = new JPasswordField();
		pin.setBounds(240,340,200,30);
		pin.setFont(new Font("Constantia",Font.BOLD,16));
		image.add(pin);
		
		 repin = new JPasswordField();
		repin.setBounds(240,399,200,30);
		repin.setFont(new Font("Constantia",Font.BOLD,16));
		image.add(repin);
		
		 change = new JButton("CHANGE");
		change.setBounds(300,455,140,25);
		change.setFont(new Font("Constantia",Font.BOLD,16));
		change.addActionListener(this);
		image.add(change);
		
		 back = new JButton("BACK");
		back.setBounds(300,486,140,25);
		back.setFont(new Font("Constantia",Font.BOLD,16));
		back.addActionListener(this);
		image.add(back);
		
		setSize(800,800);
		setLocation(300, 10);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
			try {
				String newpin = pin.getText();
				String reepin = repin.getText();
				Conn conn = new Conn();
				if(!newpin.equals(reepin)) {
					JOptionPane.showMessageDialog(null, "Entered Pin does not Match");
					return;
				}
				if(newpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter new Pin");
					return;
				}
				if(reepin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Re-Enter new Pin");
					return;
				}
				String sql = "update bank set pin = ? where pin =? ";
				conn.stmt = conn.con.prepareStatement(sql);
				conn.stmt.setString(1, newpin);
				conn.stmt.setString(2, pinno);
				conn.stmt.executeUpdate();
				
				String sql1 = "update login set pinno = ? where pinno =? ";
				conn.stmt = conn.con.prepareStatement(sql1);
				conn.stmt.setString(1, newpin);
				conn.stmt.setString(2, pinno);
				conn.stmt.executeUpdate();
				
				String sql2 = "update signupthree set pinno = ? where pinno =? ";
				conn.stmt = conn.con.prepareStatement(sql2);
				conn.stmt.setString(1, newpin);
				conn.stmt.setString(2, pinno);
				conn.stmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "PIN changed successfully");
				setVisible(false);
				new Transaction(reepin).setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			setVisible(false);
			new Transaction(pinno).setVisible(true);
		}

	}
public static void main(String[] args) {
	new PinChange("").setVisible(true);
}
}
