package com.bankmanagementsystem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
public class Deposit extends JFrame implements ActionListener{
	JButton back,deposit;
	JTextField amount;
	String pinno;
	Deposit(String pinno) {
		this.pinno = pinno;
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 800,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0,800, 800);
		add(image);
		
		JLabel text = new JLabel("Enter The Amount You Want");
		text.setBounds(185, 270, 500, 30);
		text.setForeground(Color.white);
		text.setFont(new Font("Constantia",Font.BOLD,16));
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Constantia",Font.BOLD,16));
		amount.setBounds(190,315,200,30);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(315, 433,120, 25);
		deposit.setFont(new Font("Constantia",Font.BOLD,16));
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back .setBounds(315, 463,120, 25);
		back .setFont(new Font("Constantia",Font.BOLD,16));
		back.addActionListener(this);
		image.add(back );
		
		setLayout(null);
		setSize(800, 780);
		//setUndecorated(false);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==deposit) {
			String number = amount.getText();
			Date d = new Date();
			String date = d.toString();
			if (number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
			} else {
				Conn conn = new Conn();
				String sql = "insert into bank values (?,?,?,?)";
				try {
					conn.stmt = conn.con.prepareStatement(sql);
					conn.stmt.setString(1, pinno);
					conn.stmt.setString(2, date);
					conn.stmt.setString(3, "Deposit");
					conn.stmt.setString(4, number);
					conn.stmt.executeUpdate();
					JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
					setVisible(false);
					new Transaction(pinno).setVisible(true);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else if(ae.getSource()==back) {
			setVisible(false);
			new Transaction(pinno).setVisible(true);
		}
	}
public static void main(String[] args) {
	new Deposit("");
}
}
