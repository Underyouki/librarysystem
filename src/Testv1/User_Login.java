package Testv1;


import java.sql.*;
import java.util.Calendar;
import java.util.Date;

import javax.xml.stream.events.*;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
/*
class searchNameP {

	ResultSet seach() throws Exception {
		// TODO Auto-generated method stub

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
		String userName="sa";
		String userPwd="QWEASDZXC000000";
		Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement state = dbConn.createStatement();
		String sql = "select 借书证号,密码 from 借书者";
		ResultSet rs = state.executeQuery(sql);
		/*
		while (rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
		}*/
	/*dbConn.close();
		return rs;
	}

}
*/

public class User_Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Login frame = new User_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public User_Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BFB\u8005\u767B\u5F55");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(170, 10, 115, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u501F\u4E66\u8BC1\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(44, 64, 84, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(59, 126, 42, 15);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(138, 72, 184, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(309, 197, 93, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 123, 184, 18);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("\u501F\u4E66\u8BC1\u53F7\u6216\u5BC6\u7801\u9519\u8BEF\uFF0C\u8BF7\u91CD\u65B0\u8F93\u5165");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(138, 163, 198, 24);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);

		JButton btnNewButton_1 = new JButton("\u767B\u5F55");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strP = new String(passwordField.getPassword());//密码
				String strT = new String(textField.getText());//借书证号
				
				String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
				String userName="sa";
				String userPwd="QWEASDZXC000000";
				Connection dbConn = null;
				String sql = "select 借书证号,密码 from 借书者";
				
				try {
					Statement state = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
					state = dbConn.createStatement();
					ResultSet rs = state.executeQuery(sql);
					while (rs.next()) {
						//System.out.println(rs.getString(1)+" "+rs.getString(2));
						if(strT.equals(rs.getString(1)) && strP.equals(rs.getString(2))) {
							lblNewLabel_3.setVisible(false);
							U_mianPage ump = new U_mianPage();
							ump.setVisible(true);
							
							Calendar c = Calendar.getInstance();
							//String s = String.valueOf(c.getTime());
							
							PreparedStatement pst = null;
							pst = dbConn.prepareStatement("insert into 操作账号 values(?,?)");
							pst.setString(1, strT);
							pst.setTimestamp(2, new Timestamp(c.getTimeInMillis()));
							pst.addBatch();
							pst.executeBatch();
						}
						else {
							lblNewLabel_3.setVisible(true);
						}
					}
					dbConn.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(8, 197, 93, 23);
		contentPane.add(btnNewButton_1);
				
	}

}