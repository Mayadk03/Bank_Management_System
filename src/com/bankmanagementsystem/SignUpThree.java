package com.bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
@SuppressWarnings("all")
public class SignUpThree extends JFrame implements ActionListener {
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	SignUpThree(String formno) {
		this.formno = formno;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel l1 = new JLabel("Page 3 : Account Details");
		l1.setBounds(220, 40,400, 40);
		l1.setFont(new Font("Constantia",Font.BOLD,22));
		add(l1);
		
		JLabel type = new JLabel("Account Type");
		type.setBounds(100, 100,200, 30);
		type.setFont(new Font("Constantia",Font.BOLD,22));
		add(type);
		
		r1 = new JRadioButton("Saving Account");
		r1.setBackground(Color.white);
		r1.setFont(new Font("Constantia",Font.BOLD,16));
		r1.setBounds(100,150,150,30);
		add(r1);
		
		r2 = new JRadioButton("Current Account");
		r2.setFont(new Font("Constantia",Font.BOLD,16));
		r2.setBounds(100,200,180,30);
		r2.setBackground(Color.white);
		add(r2);
		
		r3 = new JRadioButton("Fixed Deposit Account");
		r3.setFont(new Font("Constantia",Font.BOLD,16));
		r3.setBounds(330,150,300,30);
		r3.setBackground(Color.white);
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Constantia",Font.BOLD,16));
		r4.setBounds(330,200,300,30);
		r4.setBackground(Color.white);
		add(r4);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		
		JLabel card = new JLabel("Card Number");
		card.setBounds(100, 270,200, 30);
		card.setFont(new Font("Constantia",Font.BOLD,22));
		add(card);
		
		JLabel carddetails = new JLabel("This Is Your 16 Digit Card Number");
		carddetails.setBounds(330, 300,200, 20);
		carddetails.setFont(new Font("Constantia",Font.BOLD,12));
		add(carddetails);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
		number .setBounds(330, 270,400, 30);
		number .setFont(new Font("Constantia",Font.BOLD,22));
		add(number );
		
		JLabel pin = new JLabel("PIN:");
		pin.setBounds(100, 350,200, 30);
		pin.setFont(new Font("Constantia",Font.BOLD,22));
		add(pin);
		
		JLabel pinnumber = new JLabel("XXXX");
		pinnumber .setBounds(330, 350,400, 30);
		pinnumber .setFont(new Font("Constantia",Font.BOLD,22));
		add(pinnumber );
		
		JLabel pindetails = new JLabel("Your 4 Digit Password");
		pindetails.setBounds(330, 370,200, 20);
		pindetails.setFont(new Font("Constantia",Font.BOLD,12));
		add(pindetails);
		
		JLabel service = new JLabel("Services Required");
		service.setBounds(100, 410,400, 30);
		service .setFont(new Font("Constantia",Font.BOLD,22));
		add(service);
		
		c1 = new JCheckBox("ATM Card");
		c1.setBackground(Color.white);
		c1.setBounds(100,450,150,30);
		c1 .setFont(new Font("Constantia",Font.BOLD,12));
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.white);
		c2.setBounds(300,450,200,30);
		c2.setFont(new Font("Constantia",Font.BOLD,12));
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.white);
		c3.setBounds(100,490,150,30);
		c3 .setFont(new Font("Constantia",Font.BOLD,12));
		add(c3);
		
		c4 = new JCheckBox("Email And SMS Alerts");
		c4.setBackground(Color.white);
		c4.setBounds(300,490,200,30);
		c4 .setFont(new Font("Constantia",Font.BOLD,12));
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.white);
		c5.setBounds(100,530,150,30);
		c5 .setFont(new Font("Constantia",Font.BOLD,12));
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setBackground(Color.white);
		c6.setBounds(300,530,100,30);
		c6 .setFont(new Font("Constantia",Font.BOLD,12));
		add(c6);
		
		c7 = new JCheckBox("I Hereby declares that the above entered details are correct to the best of my known!");
		c7.setBackground(Color.white);
		c7.setBounds(100,590,515,30);
		c7 .setFont(new Font("Constantia",Font.BOLD,12));
		add(c7);
		
		submit = new JButton("Submit");
		submit.setBounds(150, 660, 150, 30);
		submit.setBackground(Color.gray);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		add(submit);
		
		cancel= new JButton("Cancel");
		cancel.setBounds(350, 660, 150, 30);
		cancel.setBackground(Color.gray);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.white);
		setSize(700,800);
		setLocation(350,10);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			String accountType = null;
			if(r1.isSelected()) {
				accountType = "Saving Account"; 
			} else if(r2.isSelected()) {
				accountType = "Fixed Deposit Account";
			}else if(r3.isSelected()) {
				accountType = "Current Account";
			}else if(r4.isSelected()) {
				accountType = "Recuring Deposit Account";
			}
			//To Create Random card Number And PinNumber
			Random random = new Random();
			//String cardno =""+ Math.abs(random.nextLong()%9000000000000l)+1000000000000000l;
			String cardno = "" + Math.abs((random.nextLong() % 9000000000000000L) + 1000000000000000L);

			String pinno = ""+Math.abs(random.nextInt()%9000l+1000l);
			String facility = "";
			if(c1.isSelected()) {
				facility = facility+" ATM Card";
			} else if(c2.isSelected()) {
				facility = facility+" Internet Banking";
			}else if(c3.isSelected()) {
				facility = facility+" Mobile Banking";
			}else if(c4.isSelected()) {
				facility = facility+" Email And SMS Alerts";
			}else if(c5.isSelected()) {
				facility = facility+" Cheque Book";
			}else if(c6.isSelected()) {
				facility = facility+" E-Statement";
			}
			Conn conn = new Conn();
			try {
				if(accountType==null||facility==null||cardno==null||pinno==null) {
					JOptionPane.showMessageDialog(null, "All Fileds Are Required");
				} else {
					String sql = "Insert into signupthree values(?,?,?,?,?)";
					String sql1 = "insert into login values(?,?,?)";
					conn.stmt = conn.con.prepareStatement(sql);
					conn.stmt.setString(1, formno);
					conn.stmt.setString(2, accountType);
					conn.stmt.setString(3, cardno);
					conn.stmt.setString(4,pinno);
					conn.stmt.setString(5,facility);
					conn.stmt.executeUpdate();
					conn.stmt = conn.con.prepareStatement(sql1);
					conn.stmt.setString(1, formno);
					conn.stmt.setString(2, cardno);
					conn.stmt.setString(3, pinno);
					conn.stmt.executeUpdate();
					if(c7.isSelected()) {
						JOptionPane.showMessageDialog(null, "Card Number "+cardno+"\n Pin Number: "+pinno);
						setVisible(false);
						new Login().setVisible(true);
						//new Deposit(pinno).setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Ensure the all the detail checkbox is selected");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					conn.stmt.close();
					conn.con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} else if(ae.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}
public static void main(String[] args) {
	try {
		new SignUpThree("");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
