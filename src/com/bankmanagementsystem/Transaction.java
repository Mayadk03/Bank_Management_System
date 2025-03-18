package com.bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener{
	JButton deposit,withdraw,balanceenquiry,fastcash ,exit,pinChange;
	String pinno;
	public Transaction(String pinno) {
		this.pinno = pinno;
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 800, 800);
		add(image);
		
		JLabel text = new JLabel("Please Select your transaction");
		text.setBounds(170, 300, 400, 35);
		text.setForeground(Color.white);
		text.setFont(new Font("Constantia",Font.BOLD,18));
		image.add(text);
		
		deposit =  new JButton("Deposit");
		deposit.setBounds(150, 370, 120, 25);
		deposit.setFont(new Font("Constantia",Font.BOLD,15));
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdraw =  new JButton("Cash Withdraw");
		withdraw.setBounds(285, 370, 153, 25);
		withdraw.setFont(new Font("Constantia",Font.BOLD,15));
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		fastcash =  new JButton("Fast Cash");
		fastcash.setBounds(150, 400, 120, 25);
		fastcash.setFont(new Font("Constantia",Font.BOLD,15));
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		pinChange =  new JButton("Pin Change");
		pinChange.setBounds(150, 430, 120, 25);
		pinChange.setFont(new Font("Constantia",Font.BOLD,15));
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		balanceenquiry=  new JButton("Balance Enquiry");
		 balanceenquiry.setBounds(285, 400, 153, 25);
		 balanceenquiry.setFont(new Font("Constantia",Font.BOLD,15));
		 balanceenquiry.addActionListener(this);
		image.add( balanceenquiry);
		
		exit =  new JButton("Exit");
		 exit.setBounds(285, 430, 153, 25);
		 exit.setFont(new Font("Constantia",Font.BOLD,15));
		 exit.addActionListener(this);
		image.add( exit);
		
		setSize(800,745);
		setLocation(350, 10);
		//it will remove all  border from the frame
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
	
		if(ae.getSource()==exit) {
			System.exit(0);
		} else if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinno).setVisible(true);
		}else if(ae.getSource()==withdraw) {
			setVisible(false);
			new Withdrawl(pinno).setVisible(true);
		}else if(ae.getSource()==fastcash) {
			setVisible(false);
			new Fastcash(pinno).setVisible(true);
		}else if(ae.getSource()==pinChange) {
			setVisible(false);
			new PinChange(pinno).setVisible(true);
		}else if(ae.getSource()==balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinno).setVisible(true);
		}
	}
public static void main(String[] args) {
	new Transaction("");
}
}
