package com.bankmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SignupOne extends JFrame implements ActionListener{
	long random;
	JTextField nametext,fnametext,emailtext,addtext,citytext,statetext,pintext;
	JButton next;
	JDateChooser dateChooser ;
	JRadioButton male,female,other,other1,married,unmarried;
	SignupOne() {
		setLayout(null);
		Random ran = new Random();
		random = Math.abs((ran.nextLong()%9000L)+1000L);
		
		JLabel formno = new JLabel("APPLICATION FORM NO: "  + random);
		formno.setFont(new Font("Constantia",Font.BOLD,38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);
		
		JLabel personalDetails = new JLabel("Page 1: Personal Details ");
		personalDetails.setFont(new Font("Constantia",Font.BOLD,22));
		personalDetails.setBounds(290, 80, 400, 30);
		add(personalDetails);
		
		JLabel name = new JLabel("Name: ");
		name.setFont(new Font("Constantia",Font.BOLD,20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		nametext = new  JTextField();
		nametext.setFont(new Font("Constantia",Font.BOLD,20));
		nametext.setBounds(300, 140, 400,30);
		add(nametext);
		
		JLabel fname = new JLabel("Father's Name: ");
		fname.setFont(new Font("Constantia",Font.BOLD,20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
	    fnametext = new  JTextField();
		fnametext.setFont(new Font("Constantia",Font.BOLD,20));
		fnametext.setBounds(300, 190, 400,30);
		add(fnametext);
		
		JLabel dob = new JLabel("Date of Birth: ");
		dob.setFont(new Font("Constantia",Font.BOLD,20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		 dateChooser = new JDateChooser();
		 dateChooser.setFont(new Font("Constantia",Font.BOLD,20));
		dateChooser.setBounds(300, 240, 400, 30);
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender: ");
		gender.setFont(new Font("Constantia",Font.BOLD,20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 290, 80, 30);
		male.setBackground(Color.white);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(400, 290, 80, 30);
		female.setBackground(Color.white);
		add(female);
		
		other1 = new JRadioButton("Other");
		other1.setBounds(520, 290, 80, 30);
		other1.setBackground(Color.white);
		add(other1);
		
		ButtonGroup genderGroup1 = new ButtonGroup();
		genderGroup1.add(female);
		genderGroup1.add(male);
		genderGroup1.add(other1);
		
		JLabel email = new JLabel("Email: ");
		email.setFont(new Font("Constantia",Font.BOLD,20));
		email.setBounds(100, 340, 200, 30);
		add(email);
		
		emailtext = new  JTextField();
		emailtext.setFont(new Font("Constantia",Font.BOLD,20));
		emailtext.setBounds(300, 340, 400,30);
		add(emailtext);
		
		JLabel marital = new JLabel("Marital Status: ");
		marital.setFont(new Font("Constantia",Font.BOLD,20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300, 390, 80, 30);
		married.setBackground(Color.white);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(400, 390, 100, 30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
	    other = new JRadioButton("Other");
		other.setBounds(520, 390, 80, 30);
		other.setBackground(Color.white);
		add(other);
		
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(unmarried);
		maritalGroup.add(married);
		maritalGroup.add(other);
		
		
		JLabel address = new JLabel("Address: ");
		address.setFont(new Font("Constantia",Font.BOLD,20));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		addtext = new  JTextField();
		addtext.setFont(new Font("Constantia",Font.BOLD,20));
		addtext.setBounds(300, 440, 400,30);
		add(addtext);
		
		JLabel city = new JLabel("City: ");
		city.setFont(new Font("Constantia",Font.BOLD,20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		citytext = new  JTextField();
		citytext.setFont(new Font("Constantia",Font.BOLD,20));
		citytext.setBounds(300, 490, 400,30);
		add(citytext);
		
		JLabel state = new JLabel("State: ");
		state.setFont(new Font("Constantia",Font.BOLD,20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		statetext = new  JTextField();
		statetext.setFont(new Font("Constantia",Font.BOLD,20));
		statetext.setBounds(300, 540, 400,30);
		add(statetext);
		
		JLabel pincode = new JLabel("Pin Code: ");
		pincode.setFont(new Font("Constantia",Font.BOLD,20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);
		
		pintext = new  JTextField();
		pintext.setFont(new Font("Constantia",Font.BOLD,22));
		pintext.setBounds(300, 590, 400,30);
		add(pintext);
		
		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setBounds(600, 660, 100, 30);
		next.setFont(new Font("Constantia",Font.BOLD,22));
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String formno = ""+random;//bcz random is of type long
		String name = nametext.getText();
		String fname = fnametext.getText();
		String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		} else if(female.isSelected()) {
			gender = "Female";
		} else {
			gender = "Other";
		}
		String email = emailtext.getText();
		String marital = null;
		if(married.isSelected()) {
			marital = "Married";
			
		}  else if(unmarried.isSelected()) {
			marital = "Unmarried";
		} else {
			marital = "Other";
		}
		String city = citytext.getText();
		String address = addtext.getText();
		String state = statetext.getText();
		String pin = pintext.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			}
			else if(fname.equals("")) {
				JOptionPane.showMessageDialog(null, "Father Name is Required");
			}
			else if(city.equals("")) {
				JOptionPane.showMessageDialog(null, "City Field is Required");
			}
			else if(address.equals("")) {
				JOptionPane.showMessageDialog(null, "Address Field Is Required");
			}
			else if(state.equals("")) {
				JOptionPane.showMessageDialog(null, "State Field is Required");
			}
			else if(pin.equals("")) {
				JOptionPane.showMessageDialog(null,"Pin Code Field Is Required");
			}
			else if(marital.equals("")) {
				JOptionPane.showMessageDialog(null, "Marital Status Field Is Required");
			}
			else if(gender.equals("")) {
				JOptionPane.showMessageDialog(null,"Gender Field Is Required");
			}
			else if(email.equals("")) {
				JOptionPane.showMessageDialog(null, "Email Field Is Required");
			} else {
					Conn conn = new Conn();
					String sql =" insert into signup values(?,?,?,?,?,?,?,?,?,?,?)";
					conn.stmt =conn. con.prepareStatement(sql);
					conn.stmt.setString(1, formno);
					conn.stmt.setString(2, name);
					conn.stmt.setString(3, fname);
					conn.stmt.setString(4, dob);
					conn.stmt.setString(5, gender);
					conn.stmt.setString(6, email);
					conn.stmt.setString(7, marital);
					conn.stmt.setString(8, address);
					conn.stmt.setString(9,city);
					conn.stmt.setString(10, pin);
					conn.stmt.setString(11, state);
					
					conn.stmt.executeUpdate();
					setVisible(false);
					new SignUpTwo(formno).setVisible(true);
					conn.con.close();
					conn.stmt.close();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
public static void main(String[] args) {
	new SignupOne();
}
}
