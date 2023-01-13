package Testv1;

import java.sql.*;
/*
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class U_upPerson extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					U_upPerson frame = new U_upPerson();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */

/*public U_upPerson() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
*/


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
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
import java.awt.Color;
import java.awt.Dimension;

public class U_upPerson extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					U_upPerson frame = new U_upPerson();
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
	public U_upPerson() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel.setBounds(27, 103, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_1.setBounds(27, 175, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		lblNewLabel_2.setBounds(25, 233, 94, 18);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();				//性别
		textField_1.setBounds(95, 172, 170, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();				//联系电话
		textField_2.setBounds(95, 232, 170, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u804C\u4E1A\uFF1A");
		lblNewLabel_3.setBounds(362, 103, 58, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u6240\u5728\u5355\u4F4D\uFF1A");
		lblNewLabel_4.setBounds(341, 162, 79, 40);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();			//职业
		textField_3.setBounds(434, 100, 142, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//
				setVisible(false);
			}
		});
		btnNewButton.setBounds(479, 231, 97, 23);
		contentPane.add(btnNewButton);
		
		textField_4 = new JTextField();			//所在单位
		textField_4.setBounds(430, 172, 142, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField = new JTextField();			//姓名
		textField.setBounds(97, 100, 168, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u8BF7\u4FEE\u6539\u4E3A\u7537\u6216\u5973");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(110, 206, 97, 15);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		JLabel lblNewLabel_6 = new JLabel("\u4FEE\u6539\u6210\u529F");
		lblNewLabel_6.setBounds(351, 264, 79, 15);
		contentPane.add(lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 585, 67);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 300, 150);
		panel.add(scrollPane);
		
		String []Name = {"借书证号", "姓名", "性别", "联系电话","职业","所在单位"};
		Object [][] rowData = new Object [1][6];           
		JTable table = new JTable(rowData, Name);
		table.setBounds(297, 179, -279, -124);
		table.setRowHeight(30);                          //设置行高
		table.getColumnModel().getColumn(0).setPreferredWidth(110); //第一列列宽
		table.setPreferredScrollableViewportSize(new Dimension(550 ,300));    //设置滚动面板视口大小（超过该大小的行数据需要拖动滚动条）
		scrollPane.setViewportView(table);
		
		String num0 = null;
		try {
			String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
			String userName="sa";
			String userPwd="QWEASDZXC000000";
			Connection dbConn = null;
			
			Statement state = null;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
			state = dbConn.createStatement();
			
			String sql0 = "select top 1* from 操作账号 order by 时间 desc";
			ResultSet rs = state.executeQuery(sql0);		//最后一行
			String s1 = new String();
			while(rs.next()) {
				s1 = rs.getString(1);
			}
			num0 = s1;//账号
			
			Statement stateCnt = dbConn.createStatement();
			String sql1 = "select * from 借书者 where 借书证号='"+num0+"'";
			ResultSet rs_1 = stateCnt.executeQuery(sql1);
			
			int i = 0;
			while(rs_1.next() && i<rowData.length) {
					
				rowData[i][0] = rs_1.getString(1);
				rowData[i][1] = rs_1.getString(2);   
				rowData[i][2] = rs_1.getString(3);   
				rowData[i][3] = rs_1.getString(4);   
				rowData[i][4] = rs_1.getString(5);
				rowData[i][5] = rs_1.getString(6);
				i++;
			}
			dbConn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {				//修改
			public void actionPerformed(ActionEvent e) {
				
				String name = new String(textField.getText());
				String work = new String(textField_3.getText());
				String sex = new String(textField_1.getText());
				String phone = new String(textField_2.getText());
				String site = new String(textField_4.getText());
				String num = new String();
				
				
				String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
				String userName="sa";
				String userPwd="QWEASDZXC000000";
				Connection dbConn = null;
				
				try {
					Statement state = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
					state = dbConn.createStatement();
					//String sql1="update 图书管理员 set 姓名=name,性别=sex,职称=work,联系电话=phone where 工号='N10014' ";		//修改
					//state.executeUpdate(sql1);         //将sql语句上传至数据库执行
					
					String sql0 = "select top 1* from 操作账号 order by 时间 desc";
					ResultSet rs = state.executeQuery(sql0);		//最后一行
					String s1 = new String();
					while(rs.next()) {
						s1 = rs.getString(1);
					}
					
					num = s1;//工号
					
					PreparedStatement pst = null;
					if (name.equals("") == false) {
						String sql = "update 借书者 set 姓名=? where 借书证号=?";
						pst = dbConn.prepareStatement(sql);
						pst.setString(1, name);
						pst.setString(2, num);
						pst.executeUpdate();
						
					}
					if(sex.equals("") == false) {
						try {
							String sql = "update 借书者 set 性别=? where 借书证号=?";
							pst = dbConn.prepareStatement(sql);
							pst.setString(1, sex);
							pst.setString(2, num);
							pst.executeUpdate();
							lblNewLabel_5.setVisible(false);
						}
						catch(Exception ee) {
							// TODO Auto-generated catch block
							ee.printStackTrace();
							lblNewLabel_5.setVisible(true);
							lblNewLabel_6.setVisible(false);
						}
					}
					if(work.equals("") == false) {
						String sql = "update 借书者 set 职业=? where 借书证号=?";
						pst = dbConn.prepareStatement(sql);
						pst.setString(1, work);
						pst.setString(2, num);
						pst.executeUpdate();
						
					}
					if(phone.equals("") == false) {
						String sql = "update 借书者 set 联系电话=? where 借书证号=?";
						pst = dbConn.prepareStatement(sql);
						pst.setString(1, phone);
						pst.setString(2, num);
						pst.executeUpdate();
						
					}
					if(site.equals("") == false) {
						String sql = "update 借书者 set 所在单位=? where 借书证号=?";
						pst = dbConn.prepareStatement(sql);
						pst.setString(1, site);
						pst.setString(2, num);
						pst.executeUpdate();
						
					}
					Statement stateCnt = dbConn.createStatement();
					String sql1 = "select * from 借书者 where 借书证号='"+num+"'";
					ResultSet rs_1 = stateCnt.executeQuery(sql1);
					
					int i = 0;
					while(rs_1.next() && i<rowData.length) {
							
						rowData[i][0] = rs_1.getString(1);
						rowData[i][1] = rs_1.getString(2);   
						rowData[i][2] = rs_1.getString(3);   
						rowData[i][3] = rs_1.getString(4);   
						rowData[i][4] = rs_1.getString(5);
						rowData[i][5] = rs_1.getString(6);
						i++;
					}
					
					//刷新
					TableModel tml = new DefaultTableModel(rowData,Name);
					table.setModel(tml);
				
					pst.close();
					dbConn.close();
					if(lblNewLabel_5.isVisible()) {
						lblNewLabel_6.setVisible(false);
					}else {
						lblNewLabel_6.setVisible(true);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_1.setBounds(341, 231, 93, 23);
		contentPane.add(btnNewButton_1);
		
	}
}

