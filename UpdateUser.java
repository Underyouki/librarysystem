package Testv1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class UpdateUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUser frame = new UpdateUser();
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
	public UpdateUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u8BFB\u8005\u4FE1\u606F");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(215, 10, 183, 63);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//返回
				setVisible(false);
			}
		});
		btnNewButton.setBounds(484, 328, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u501F\u4E66\u8BC1\u53F7");
		lblNewLabel_1.setBounds(10, 69, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(65, 66, 152, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 94, 567, 224);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 300, 150);
		panel.add(scrollPane);
		
		String []Name = {"借书证号", "姓名", "性别", "联系电话","职业","所在单位"};
		Object [][] rowData = new Object [100][6];           
		JTable table = new JTable(rowData, Name);
		table.setBounds(297, 179, -279, -124);
		table.setRowHeight(30);                          //设置行高
		table.getColumnModel().getColumn(0).setPreferredWidth(110); //第一列列宽
		table.setPreferredScrollableViewportSize(new Dimension(500 ,300));    //设置滚动面板视口大小（超过该大小的行数据需要拖动滚动条）
		scrollPane.setViewportView(table);
		
		try {
			String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
			String userName="sa";
			String userPwd="QWEASDZXC000000";
			Connection dbConn = null;
			
			Statement state = null;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
			state = dbConn.createStatement();
			String sql0 = "select * from 借书者";
			ResultSet rs = state.executeQuery(sql0);		
			//String s1 = new String();
			int i = 0;
			while(rs.next() && i<rowData.length) {
					
				rowData[i][0] = rs.getString(1);
				rowData[i][1] = rs.getString(2);   
				rowData[i][2] = rs.getString(3);   
				rowData[i][3] = rs.getString(4);   
				rowData[i][4] = rs.getString(5);
				rowData[i][5] = rs.getString(6);
					
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

		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {//查询
			public void actionPerformed(ActionEvent e) {
				
				String str0 = new String(textField.getText());
				
				try {
					String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
					String userName="sa";
					String userPwd="QWEASDZXC000000";
					Connection dbConn = null;
					
					Statement state = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
					state = dbConn.createStatement();
					
					String sql0 = "select * from 借书者 where 借书证号='"+str0+"'" ;
					ResultSet rs = state.executeQuery(sql0);		
					
					int i = 0;
					while(rs.next() && i<rowData.length) {
							
						rowData[i][0] = rs.getString(1);
						rowData[i][1] = rs.getString(2);   
						rowData[i][2] = rs.getString(3);   
						rowData[i][3] = rs.getString(4);   
						rowData[i][4] = rs.getString(5);
						rowData[i][5] = rs.getString(6);
						i++;
					}
					while(i>=1 && i<rowData.length) {
						rowData[i][0] = null;
						rowData[i][1] = null;
						rowData[i][2] = null;
						rowData[i][3] = null;
						rowData[i][4] = null;
						rowData[i][5] = null;
						i++;
					}
					//刷新
					TableModel tml = new DefaultTableModel(rowData,Name);
					table.setModel(tml);
					
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
		btnNewButton_1.setBounds(227, 65, 93, 23);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539/ \u6DFB\u52A0");//修改
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				M_Up_user Upuser = new M_Up_user();
				Upuser.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(10, 328, 101, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u590D\u4F4D");
		btnNewButton_3.addActionListener(new ActionListener() {//刷新
			public void actionPerformed(ActionEvent e) {
				
				try {
					String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
					String userName="sa";
					String userPwd="QWEASDZXC000000";
					Connection dbConn = null;
					
					Statement state = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
					state = dbConn.createStatement();
					//String sql1="update 图书管理员 set 姓名=name,性别=sex,职称=work,联系电话=phone where 工号='N10014' ";		//修改
					//state.executeUpdate(sql1);         //将sql语句上传至数据库执行
					
					String sql0 = "select * from 借书者";
					ResultSet rs = state.executeQuery(sql0);		//最后一行
					//String s1 = new String();
					int i = 0;
					while(rs.next() && i<rowData.length) {
							
						rowData[i][0] = rs.getString(1);
						rowData[i][1] = rs.getString(2);   
						rowData[i][2] = rs.getString(3);   
						rowData[i][3] = rs.getString(4);   
						rowData[i][4] = rs.getString(5);
						rowData[i][5] = rs.getString(6);
							
						i++;
					}
					while(i<rowData.length) {
						
						rowData[i][0] = null;
						rowData[i][1] = null;   
						rowData[i][2] = null;   
						rowData[i][3] = null;   
						rowData[i][4] = null;
						rowData[i][5] = null;
							
						i++;
					}
					//刷新
					TableModel tml = new DefaultTableModel(rowData,Name);
					table.setModel(tml);
					
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
		btnNewButton_3.setBounds(484, 65, 93, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("\u8981\u5220\u9664\u7684\u501F\u4E66\u8005\u7684\u8D26\u53F7\u662F");
		lblNewLabel_2.setBounds(137, 332, 144, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u64CD\u4F5C\u6210\u529F");
		lblNewLabel_3.setBounds(371, 350, 54, 15);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		JLabel lblNewLabel_4 = new JLabel("\u64CD\u4F5C\u5931\u8D25");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(295, 350, 54, 15);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(285, 329, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("\u5220\u9664");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = new String(textField_1.getText());
				
				try {
					String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
					String userName="sa";
					String userPwd="QWEASDZXC000000";
					Connection dbConn = null;
				
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
					String sql0 = "delete from 借书者 where 借书证号= ?";
					PreparedStatement pst = dbConn.prepareStatement(sql0);//删除
					pst.setString(1, num);//借书证号
					pst.addBatch();
					pst.executeBatch();
					lblNewLabel_3.setVisible(true);
					//刷新
					Statement state = dbConn.createStatement();
					String sql1 = "select * from 借书者";
					ResultSet rs = state.executeQuery(sql1);		//最后一行
					//String s1 = new String();
					int i = 0;
					while(rs.next() && i<rowData.length) {
							
						rowData[i][0] = rs.getString(1);
						rowData[i][1] = rs.getString(2);   
						rowData[i][2] = rs.getString(3);   
						rowData[i][3] = rs.getString(4);   
						rowData[i][4] = rs.getString(5);
						rowData[i][5] = rs.getString(6);
							
						i++;
					}
					while(i<rowData.length) {
						
						rowData[i][0] = null;
						rowData[i][1] = null;   
						rowData[i][2] = null;   
						rowData[i][3] = null;   
						rowData[i][4] = null;
						rowData[i][5] = null;
							
						i++;
					}
					TableModel tml = new DefaultTableModel(rowData,Name);
					table.setModel(tml);
					
					dbConn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblNewLabel_4.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblNewLabel_4.setVisible(true);
				}
				if(lblNewLabel_3.isVisible()) {
					lblNewLabel_4.setVisible(false);
				}
				if(lblNewLabel_4.isVisible()) {
					lblNewLabel_3.setVisible(false);
				}

			}
		});
		btnNewButton_4.setBounds(361, 328, 93, 23);
		contentPane.add(btnNewButton_4);
		
	}
}
