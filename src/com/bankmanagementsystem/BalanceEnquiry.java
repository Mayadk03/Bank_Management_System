package com.bankmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	String pinchange;
	JButton back;
	BalanceEnquiry(String pinchange) {
		setLayout(null);
		this.pinchange = pinchange;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		ImageIcon  i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 800, 844);
		add(image);
		
		back = new JButton("BACK");
		back.setBounds(300,486,140,25);
		back.setFont(new Font("Constantia",Font.BOLD,16));
		back.addActionListener(this);
		image.add(back);
		int balance = 0;
		try {
			Conn conn = new Conn();
			String sql = "select * from bank where pin = ?";
			conn.stmt = conn.con.prepareStatement(sql);
			conn.stmt.setString(1, pinchange);
			ResultSet rs = conn.stmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance = balance + Integer.parseInt(rs.getString("amount"));
				} else if(rs.getString("type").equals("Withdraw")){
					balance = balance - Integer.parseInt(rs.getString("amount"));
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel text = new JLabel("Your Current Account balance is");
		text.setForeground(Color.white);
		text.setBounds(150, 300, 400, 20);
		text.setBackground(Color.black);
		text.setFont(new Font("Constantia",Font.BOLD,19));
		image.add(text);
		
		JLabel tex = new JLabel("Rs. "+balance);
		tex.setForeground(Color.white);
		tex.setBounds(260, 320, 400, 50);
		tex.setBackground(Color.black);
		tex.setFont(new Font("Constantia",Font.BOLD,19));
		image.add(tex);
		
		setSize(800,765);
		setUndecorated(true);
		setVisible(true);
		setLocation(350,10);
		
	}
public void actionPerformed(ActionEvent ae) {
	setVisible(false);
	new Transaction(pinchange).setVisible(true);
}
public static void main(String[] args) {
	new BalanceEnquiry("");
}
}
