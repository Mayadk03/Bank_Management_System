package com.bankmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	JButton login;
	JButton signup;
	JButton clear;
	JTextField cardText;
	JPasswordField pinText;
	Login() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Bydefault Layout is BorderLayout Son make layout To null
		setLayout(null);
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = icon.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel lebel = new JLabel(i3);
		lebel.setBounds(100, 10, 100, 100);
		add(lebel);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setBounds(270, 40, 400, 40);
		text.setFont(new Font("Constantia",Font.BOLD,38));
		add(text);
		
		JLabel cardno = new JLabel("Card No:");
		cardno.setBounds(120, 150, 150, 30);
		cardno.setFont(new Font("Constantia",Font.BOLD,22));
		add(cardno);
		
		cardText = new JTextField();
		cardText.setBounds(300, 150, 250, 30);
		cardText.setFont(new Font("Constantia",Font.BOLD,14));
		add(cardText);
		
		JLabel pin = new JLabel("PIN:");
		pin.setBounds(120, 220, 100, 30);
		pin.setFont(new Font("Constantia",Font.BOLD,22));
		add(pin);
		
		pinText = new JPasswordField();
		pinText.setBounds(300, 220, 250, 30);
		pinText.setFont(new Font("Constantia",Font.BOLD,22));
		add(pinText);
		
		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 120, 30);
		login.setBackground(Color.black);
		login.setFont(new Font("Constantia",Font.BOLD,22));
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(430, 300, 120, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.setFont(new Font("Constantia",Font.BOLD,22));
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(300, 350, 250, 30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.setFont(new Font("Constantia",Font.BOLD,22));
		signup.addActionListener(this);
		add(signup);
		//Size Of The Jframe
		setSize(700, 600);
		//Bydefault visisbility is false 
		setVisible(true);
		//350 From Left and 200 From Top
		setLocation(350, 200);
		setTitle("Automated Teller Machine");
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==clear) {
			cardText.setText("");
			pinText.setText("");
		} else if(ae.getSource() == login) {
			String cardno = cardText.getText();
			String pinno = pinText.getText();
			try {
				Conn conn = new Conn();
				String sql = "select * from login where cardno = ?and Pinno = ?";
				conn.stmt = conn.con.prepareStatement(sql);
				conn.stmt.setString(1, cardno);
				conn.stmt.setString(2, pinno);
				ResultSet resultSet= conn.stmt.executeQuery();
				if(resultSet.next()) {
					setVisible(false);
					new Transaction(pinno).setVisible(true);;
				} else if(cardno.equals("")&&pinno.equals("")) {
					JOptionPane.showMessageDialog(null, "Fields cannot be empty");
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin Number");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(ae.getSource() == signup) {
			setVisible(false);
			SignupOne one = new SignupOne();
		}
	}
public static void main(String[] args) {
	new Login();
}

}
