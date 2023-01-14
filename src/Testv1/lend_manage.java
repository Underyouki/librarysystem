package Testv1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class lend_manage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lend_manage frame = new lend_manage();
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
	public lend_manage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 524, 286);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 300, 150);
		panel.add(scrollPane);
		
		String []Name = {"借书证号", "姓名", "书号", "书名","借书时间"};
		Object [][] rowData = new Object [100][5];           
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
			String sql0 = "select * from 借书 order by 借书时间 asc";
			ResultSet rs = state.executeQuery(sql0);
			
			int i = 0;
			while(rs.next() && i<rowData.length) {
					
				rowData[i][0] = rs.getString(1);
				rowData[i][1] = rs.getString(2);   
				rowData[i][2] = rs.getString(3);   
				rowData[i][3] = rs.getString(4);   
				rowData[i][4] = rs.getString(5);
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
		textField = new JTextField();
		textField.setBounds(74, 306, 73, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u4E66\u53F7");
		lblNewLabel.setBounds(10, 309, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u64CD\u4F5C\u6210\u529F");
		lblNewLabel_1.setBounds(113, 338, 54, 15);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("\u64CD\u4F5C\u5931\u8D25");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(166, 338, 54, 15);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);

		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(441, 334, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u66F4\u6539\u5F52\u8FD8");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Bnum = new String(textField.getText());
				Calendar c = Calendar.getInstance();
				String tm = null;
				
				try {
					String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
					String userName="sa";
					String userPwd="QWEASDZXC000000";
					Connection dbConn = null;
				
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
					
					String Unum = null;
					Statement state_1 = dbConn.createStatement();
					String sql1 = "select * from 借书 where 书号='"+Bnum+"'";
					ResultSet rs1 = state_1.executeQuery(sql1);
					String s1 = new String();
					while(rs1.next()) {
						s1 = rs1.getString("借书证号");
					}
					Unum = s1;
				
					String name = null;
					Statement state_2 = dbConn.createStatement();
					String sql2 = "select * from 借书 where 书号='"+Bnum+"'";
					ResultSet rs2 = state_2.executeQuery(sql2);
					String s2 = new String();
					while(rs2.next()) {
						s2 = rs2.getString("姓名");
					}
					name = s2;
				
					String Bname = null;
					Statement state_3 = dbConn.createStatement();
					String sql3 = "select * from 借书 where 书号='"+Bnum+"'";
					ResultSet rs3 = state_3.executeQuery(sql3);
					while(rs3.next()) {
						Bname = rs3.getString("书名");
					}
										
					Statement state_4 = dbConn.createStatement();
					String sql4 = "select 借书时间 from 借书 where 书号 = '"+Bnum+"'";
					ResultSet rs_4 = state_4.executeQuery(sql4);
					while(rs_4.next()) {
						tm = rs_4.getString(1);		//时间戳
					}
					
					PreparedStatement pst2 = null;		//插入还书表
					pst2 = dbConn.prepareStatement("insert into 还书 values(?,?,?,?,?,?)");//借书证号，姓名，书号，书名，借书时间，还书时间
					pst2.setString(1, Unum);
					pst2.setString(2, name);
					pst2.setString(3, Bnum);
					pst2.setString(4, Bname);
					pst2.setString(5, tm);
					pst2.setTimestamp(6, new Timestamp(c.getTimeInMillis()));
					pst2.addBatch();
					pst2.executeBatch();
					
					PreparedStatement pst1 = null;
					pst1 = dbConn.prepareStatement("update 图书 set 状态=? where 书号=?");
					pst1.setString(1, "空闲在册");
					pst1.setString(2, Bnum);
					pst1.addBatch();
					pst1.executeBatch();
				
					String sql0 = "delete from 借书 where 书号= ?";
					PreparedStatement pst = dbConn.prepareStatement(sql0);//删除
					pst.setString(1, Bnum);
					pst.addBatch();
					pst.executeBatch();
					
					Statement state_1_1 = dbConn.createStatement();
					String sql1_1 = "select * from 借书 order by 借书时间 asc";
					ResultSet rs_1 = state_1_1.executeQuery(sql1_1);
					
					int i = 0;
					while(rs_1.next() && i<rowData.length) {
						rowData[i][0] = rs_1.getString(1);
						rowData[i][1] = rs_1.getString(2);   
						rowData[i][2] = rs_1.getString(3);  
						rowData[i][3] = rs_1.getString(4);   
						rowData[i][4] = rs_1.getString(5);
						
						i++;
					}
					while(i<rowData.length) {
						rowData[i][0] = null;
						rowData[i][1] = null;   
						rowData[i][2] = null;   
						rowData[i][3] = null;
						rowData[i][4] = null;
						
						i++;
					}
					//刷新
					TableModel tml = new DefaultTableModel(rowData,Name);
					table.setModel(tml);
					
					dbConn.close();
					lblNewLabel_1.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblNewLabel_2.setVisible(true);
					lblNewLabel_1.setVisible(false);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblNewLabel_2.setVisible(true);
					lblNewLabel_1.setVisible(false);
				}
				if(lblNewLabel_1.isVisible()) {
					lblNewLabel_2.setVisible(false);
				}
				if(lblNewLabel_2.isVisible()) {
					lblNewLabel_1.setVisible(false);
				}
				
			}
		});
		btnNewButton_1.setBounds(10, 334, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u8FD8\u4E66\u8BB0\u5F55");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Retrun_table rb = new Retrun_table();
				rb.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(441, 306, 93, 23);
		contentPane.add(btnNewButton_2);
		
	}

}