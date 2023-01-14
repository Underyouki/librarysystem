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
import javax.swing.JTextField;
import javax.swing.JButton;
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
import java.awt.Color;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u53F7");
		lblNewLabel.setBounds(10, 306, 54, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(54, 303, 107, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u64CD\u4F5C\u6210\u529F");
		lblNewLabel_1.setBounds(107, 360, 54, 15);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {//����
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(408, 356, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u64CD\u4F5C\u5931\u8D25");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(34, 331, 54, 15);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 507, 286);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 300, 150);
		panel.add(scrollPane);
		
		String []Name = {"���", "����", "���ʱ��"};
		Object [][] rowData = new Object [100][3];           
		JTable table = new JTable(rowData, Name);
		table.setBounds(297, 179, -279, -124);
		table.setRowHeight(30);                          //�����и�
		table.getColumnModel().getColumn(0).setPreferredWidth(110); //��һ���п�
		table.setPreferredScrollableViewportSize(new Dimension(480 ,300));    //���ù�������ӿڴ�С�������ô�С����������Ҫ�϶���������
		scrollPane.setViewportView(table);
		
		String user = null;
		
		try {
			String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
			String userName="sa";
			String userPwd="QWEASDZXC000000";
			Connection dbConn = null;
			
			Statement state = null;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
			state = dbConn.createStatement();
			String sql0 = "select top 1* from �����˺� order by ʱ�� desc";
			ResultSet rs = state.executeQuery(sql0);		//���һ��
			String s1 = new String();
			while(rs.next()) {
				s1 = rs.getString(1);
			}
			user = s1;//�˺�
			
			Statement state_1 = dbConn.createStatement();
			String sql1 = "select * from ���� where ����֤�� = '"+user+"' order by ����ʱ�� asc";
			ResultSet rs_1 = state_1.executeQuery(sql1);
			
			int i = 0;
			while(rs_1.next() && i<rowData.length) {
				rowData[i][0] = rs_1.getString("���");
				rowData[i][1] = rs_1.getString("����");   
				rowData[i][2] = rs_1.getString("����ʱ��");   
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
		
		JLabel lblNewLabel_3 = new JLabel("\u5DF2\u8D85\u65F6\u8FD8\u4E66\uFF0C\u8BF7\u5230\u524D\u53F0\u7F34\u6EDE\u7EB3\u91D1");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(182, 331, 184, 15);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		JButton btnNewButton = new JButton("\u8FD8\u4E66");
		btnNewButton.addActionListener(new ActionListener() {//ȷ�ϻ���
			public void actionPerformed(ActionEvent e) {
				String Bnum = new String(textField.getText());
				Calendar c = Calendar.getInstance();
				String tm = null;
				long result = 0;
				
				try {//��ȡʱ�䣬�ж��Ƿ�ʱ
					String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
					String userName="sa";
					String userPwd="QWEASDZXC000000";
					Connection dbConn = null;
					
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
					Statement state_1 = dbConn.createStatement();
					String sql1 = "select ����ʱ�� from ���� where ��� = '"+Bnum+"'";
					ResultSet rs_1 = state_1.executeQuery(sql1);
					while(rs_1.next()) {
						tm = rs_1.getString(1);		//ʱ���
					}
					Calendar ct = Calendar.getInstance();
					Timestamp ts = Timestamp.valueOf(tm);
					ct.setTime(ts);
					result = (c.getTimeInMillis() - ct.getTimeInMillis())/(1000*60*60*24);
					//ʱ���
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblNewLabel_2.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblNewLabel_2.setVisible(true);
				}
				if(result>30) {//����30��
					lblNewLabel_3.setVisible(true);	
					lblNewLabel_2.setVisible(true);
					lblNewLabel_1.setVisible(false);
					
				}
				else {
					lblNewLabel_3.setVisible(false);
					lblNewLabel_2.setVisible(false);
					try {
						String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
						String userName="sa";
						String userPwd="QWEASDZXC000000";
						Connection dbConn = null;
					
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
						
						PreparedStatement pst1 = null;
						pst1 = dbConn.prepareStatement("update ͼ�� set ״̬=? where ���=?");//�޸�
						pst1.setString(1, "�����ڲ�");
						pst1.setString(2, Bnum);
						pst1.addBatch();
						pst1.executeBatch();
						
						String Unum = null;
						Statement state_1 = dbConn.createStatement();
						String sql1 = "select * from ���� where ���='"+Bnum+"'";
						ResultSet rs1 = state_1.executeQuery(sql1);
						String s1 = new String();
						while(rs1.next()) {
							s1 = rs1.getString("����֤��");
						}
						Unum = s1;
					
						String name = null;
						Statement state_2 = dbConn.createStatement();
						String sql2 = "select * from ���� where ���='"+Bnum+"'";
						ResultSet rs2 = state_2.executeQuery(sql2);
						String s2 = new String();
						while(rs2.next()) {
							s2 = rs2.getString("����");
						}
						name = s2;
					
						String Bname = null;
						Statement state_3 = dbConn.createStatement();
						String sql3 = "select * from ���� where ���='"+Bnum+"'";
						ResultSet rs3 = state_3.executeQuery(sql3);
						while(rs3.next()) {
							Bname = rs3.getString("����");
						}
											
						PreparedStatement pst2 = null;		//���뻹���
						pst2 = dbConn.prepareStatement("insert into ���� values(?,?,?,?,?,?)");//����֤�ţ���������ţ�����������ʱ�䣬����ʱ��
						pst2.setString(1, Unum);
						pst2.setString(2, name);
						pst2.setString(3, Bnum);
						pst2.setString(4, Bname);
						pst2.setString(5, tm);
						pst2.setTimestamp(6, new Timestamp(c.getTimeInMillis()));
						pst2.addBatch();
						pst2.executeBatch();
						
						String sql0 = "delete from ���� where ���= ?";
						PreparedStatement pst = dbConn.prepareStatement(sql0);//ɾ��
						pst.setString(1, Bnum);
						pst.addBatch();
						pst.executeBatch();
						
						Statement state_1_1 = dbConn.createStatement();
						String sql1_1 = "select * from ���� where ����֤�� = '"+Unum+"' order by ����ʱ�� asc";
						ResultSet rs_1 = state_1_1.executeQuery(sql1_1);
						
						int i = 0;
						while(rs_1.next() && i<rowData.length) {
							rowData[i][0] = rs_1.getString("���");
							rowData[i][1] = rs_1.getString("����");   
							rowData[i][2] = rs_1.getString("����ʱ��");   
							i++;
						}
						while(i<rowData.length) {
							rowData[i][0] = null;
							rowData[i][1] = null;   
							rowData[i][2] = null;   
							i++;
						}
						//ˢ��
						TableModel tml = new DefaultTableModel(rowData,Name);
						table.setModel(tml);
						
						dbConn.close();
						lblNewLabel_1.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						lblNewLabel_2.setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						lblNewLabel_2.setVisible(true);
					}
					if(lblNewLabel_2.isVisible() || lblNewLabel_3.isVisible()) {
						lblNewLabel_1.setVisible(false);
					}
					if(lblNewLabel_1.isVisible()) {
						lblNewLabel_2.setVisible(false);
						lblNewLabel_3.setVisible(false);
					}
				}
			}
		});
		btnNewButton.setBounds(10, 356, 93, 23);
		contentPane.add(btnNewButton);
		
	}

}
/*String user_1=null;
Statement state = dbConn.createStatement();
String sql2 = "select top 1* from �����˺� order by ʱ�� desc";
ResultSet rs = state.executeQuery(sql2);		//���һ��
String s1 = new String();
while(rs.next()) {
	s1 = rs.getString(1);
}
user_1 = s1;//�˺�

Statement state_1 = dbConn.createStatement();
String sql1 = "select * from ���� where ����֤�� = '"+user_1+"'";
ResultSet rs_1 = state_1.executeQuery(sql1);

int i = 0;
while(rs_1.next() && i<rowData.length) {
	rowData[i][0] = rs_1.getString("���");
	rowData[i][1] = rs_1.getString("����");   
	rowData[i][2] = rs_1.getString("����ʱ��");   
	i++;
}
*/
