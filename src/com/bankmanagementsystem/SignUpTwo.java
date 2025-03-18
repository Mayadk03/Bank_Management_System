package com.bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
@SuppressWarnings("all")
public class SignUpTwo extends JFrame implements ActionListener{
	JComboBox rel,cat,inbox,qbox,occbox;
	JTextField adharnumbertext,pannumbertext;
	JRadioButton syes,sno,eyes,eno;
	JButton next;
	String formno;
	public SignUpTwo (String formno) {
		this.formno = formno;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2 ");
		
		JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
		additionalDetails.setFont(new Font("Constantia",Font.BOLD,22));
		additionalDetails.setBounds(210, 10, 400, 40);
		add(additionalDetails);
		
		JLabel religion = new JLabel("Religion: ");
		religion.setFont(new Font("Constantia",Font.BOLD,20));
		religion.setBounds(100, 72, 100, 30);
		add(religion);
		
		String[] ex = {"Hindu","Muslim","Cristian","Other","Sikh"};
		rel = new JComboBox(ex);
		rel.setBounds(300, 72, 300, 30);
		add(rel);
		
		JLabel category = new JLabel("Category : ");
		category .setFont(new Font("Constantia",Font.BOLD,20));
		category .setBounds(100, 112, 150, 40);
		add(category );
		
		String[] ex1 = {"General","OBC","SC","ST","Other"};
	    cat = new JComboBox(ex1);
		cat.setBounds(300, 112, 300, 30);
		add(cat);
		
		JLabel income = new JLabel("Income : ");
		income .setFont(new Font("Constantia",Font.BOLD,20));
		income .setBounds(100, 152, 150, 40);
		add(income );
		
		String[] ex2 = {"null","< 1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
		inbox = new JComboBox(ex2);
		inbox.setBounds(300, 152, 300, 30);
		add(inbox);
		
		JLabel qualifiaction = new JLabel("<html>Educational <br>Qualifiaction: <html>");
		qualifiaction.setFont(new Font("Constantia",Font.BOLD,20));
		qualifiaction.setBounds(100, 202, 200, 50);
		add(qualifiaction );
		
		String[] ex3 = {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Other"};
		qbox = new JComboBox(ex3);
		qbox.setBounds(300, 202, 300, 30);
		add(qbox);
		
		JLabel occupation = new JLabel("Occupation : ");
		occupation .setFont(new Font("Constantia",Font.BOLD,20));
		occupation .setBounds(100, 262, 200, 40);
		add(occupation);
		
		String [] ex4 = {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
		occbox = new JComboBox(ex4);
		occbox .setBounds(300, 262, 300, 30);
		add(occbox);
		
		JLabel pannumber = new JLabel("PAN Number : ");
		pannumber.setFont(new Font("Constantia",Font.BOLD,20));
		pannumber.setBounds(100, 302, 200, 40);
		add(pannumber);
		
		pannumbertext = new JTextField();
		pannumbertext.setBounds(300, 302, 300, 30);
		pannumbertext.setFont(new Font("Constantia",Font.BOLD,20));
		add( pannumbertext);
		
		JLabel adharnumber = new JLabel("Adhar Number : ");
		adharnumber.setFont(new Font("Constantia",Font.BOLD,20));
		adharnumber.setBounds(100, 342, 200, 40);
		add(adharnumber);
		
		adharnumbertext = new JTextField();
		adharnumbertext.setBounds(300, 342, 300, 30);
		adharnumbertext.setFont(new Font("Constantia",Font.BOLD,20));
		add( adharnumbertext);
		
		JLabel senior = new JLabel("Senior Citizen : ");
		senior.setFont(new Font("Constantia",Font.BOLD,20));
		senior.setBounds(100, 382, 200, 40);
		add(senior);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 382, 50, 30);
		syes.setBackground(Color.white);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(390, 382, 50, 30);
		sno.setBackground(Color.white);
		add(sno);
		
		ButtonGroup  bg = new ButtonGroup();
		bg.add(sno);
		bg.add(syes);
		
		JLabel existingAccount = new JLabel("Existing Account : ");
		existingAccount.setFont(new Font("Constantia",Font.BOLD,20));
		existingAccount.setBounds(100, 422, 200, 30);
		add(existingAccount);
		
		 eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 422, 50, 30);
		eyes.setBackground(Color.white);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(390, 422, 50, 30);
		eno.setBackground(Color.white);
		add(eno);
		
		ButtonGroup  bg1 = new ButtonGroup();
		bg1.add(eno);
		bg1.add(eyes);
		
		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setBounds(520, 560, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		//getSelectedItem() method is used for getting the text from JComboBox
		String religion = (String)rel.getSelectedItem();
		String  category = (String) cat.getSelectedItem();
		String income =(String)  inbox.getSelectedItem();
		String qualification = (String) qbox.getSelectedItem();
		String occupation =(String)  occbox.getSelectedItem();
		String seniorCitizen = null;
		if(syes.isSelected()) {
			seniorCitizen = "Yes";
		} else  {
			seniorCitizen = "No";
		}
		String existingAccount = null;
		if(eyes.isSelected()) {
			existingAccount = "Yes";
		} else  {
			existingAccount = "No";
		}
		String adharno = adharnumbertext.getText();
		String panno = pannumbertext.getText();
		if((adharno==null||panno==null||existingAccount==null||seniorCitizen==null)) {
			JOptionPane.showMessageDialog(null, "All Fields Are Required");
		} else {
			Conn conn = new Conn();
		try {
			String sql = "insert into signuptwo(formno, religion, category, income, qualification, occupation, seniorCitizen, existingAccount, adharno, panno)  values (?,?,?,?,?,?,?,?,?,?)";
			conn.stmt = conn.con.prepareStatement(sql);
			conn.stmt.setString(1, formno);
			conn.stmt.setString(2, religion);
			conn.stmt.setString(3, category);
			conn.stmt.setString(4,income);
			conn.stmt.setString(5 ,qualification);
			conn.stmt.setString(6,occupation);
			conn.stmt.setString(7, seniorCitizen);
			conn.stmt.setString(8, existingAccount);
			conn.stmt.setString(9, adharno);
			conn.stmt.setString(10, panno);
			conn.stmt.executeUpdate();
			System.out.println("Form Number in SignUpTwo: " + formno);
			setVisible(false);
			new SignUpThree( formno).setVisible(true);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				conn.stmt.close();
				conn.con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		}
		
	}
public static void main(String[] args) {
	new SignUpTwo("");
}

}
