package send_the_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class signin_signup {

	private JFrame frame;
	private JTextField tb1;
	private JPasswordField tb2;
	private JTextField tb3;
	private JPasswordField tb4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signin_signup window = new signin_signup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public signin_signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		frame.setBounds(100, 100, 566, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setBounds(41, 103, 43, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(41, 168, 95, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		tb1 = new JTextField();
		tb1.setBounds(148, 100, 130, 26);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		tb2 = new JPasswordField();
		tb2.setBounds(148, 158, 130, 26);
		frame.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("USER");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(304, 105, 50, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PASSWORD");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(304, 163, 95, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		tb3 = new JTextField();
		tb3.setBounds(412, 100, 130, 26);
		frame.getContentPane().add(tb3);
		tb3.setColumns(10);
		
		tb4 = new JPasswordField();
		tb4.setBounds(412, 158, 130, 26);
		frame.getContentPane().add(tb4);
		tb4.setColumns(10);
		
		JButton btnNewButton = new JButton("SIGN IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=tb1.getText();
				String password=tb2.getText();
				try 
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CSE","root","manjula123");
					PreparedStatement stn=con.prepareStatement("select user,password from users where USER=? and PASSWORD =?");
					stn.setString(1, user);
					stn.setString(2,password);
					ResultSet rs =stn.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(btnNewButton, "Valid User ");
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, "Invalid User \n Please SignUp ");
					}
					
			 }
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setBounds(106, 254, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tb3.getText();
				String pwd=tb4.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CSE","root","manjula123");
					String g="insert into users values('"+name+"', '"+pwd+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(g);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton_1, "done");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(369, 254, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
	}

	protected PreparedStatement setString(int i, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
