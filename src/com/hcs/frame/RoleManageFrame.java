package com.hcs.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.hcs.bean.Role;
import com.hcs.bean.User;
import com.hcs.dao.RoleDao;
import com.hcs.dao.UserDao;

public class RoleManageFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTabbedPane jTabbedPane = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setName("用户管理");
			jTabbedPane.addTab("用户管理", null, getJPanel(), null);
			jTabbedPane.addTab("权限管理", null, getJPanel1(), null);
		}
		return jTabbedPane;
	}
	
	private JPanel rolePanel = null;
	private JPanel getRolePanel(){
		if(rolePanel == null){
			rolePanel = new JPanel();
			rolePanel.setLayout(new FlowLayout());
			
			JButton addBtn = new JButton("添加权限");
			rolePanel.add(addBtn);
		}
		return rolePanel;
	}
	
	private JPanel userPanel = null;
	private JPanel jPanel3 = null;
	private JScrollPane jScrollPane1 = null;
	private JTable jTable1 = null;
	private JPanel getUserPanel(){
		if(userPanel == null){
			userPanel = new JPanel();
			userPanel.setLayout(new FlowLayout());
			
			JButton addBtn = new JButton("添加用户");
			userPanel.add(addBtn);
		}
		return userPanel;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new BorderLayout());
			jPanel.add(getJPanel2(), BorderLayout.CENTER);
			jPanel.add(getUserPanel(), BorderLayout.SOUTH);
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new BorderLayout());
			jPanel1.add(getJPanel3(), BorderLayout.CENTER);
			jPanel1.add(getRolePanel(), BorderLayout.SOUTH);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.gridheight = 1;
			gridBagConstraints.gridx = 0;
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.add(getJScrollPane(), gridBagConstraints);
		}
		return jPanel2;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	private UserDao userDao = new UserDao();
	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			String[] columnNames = {"用户ID", "姓名", "权限", "其他"};
			List<User> users = userDao.listAllUser();
			String[][] initData = new String[users.size()][4];
			DefaultTableModel model = new DefaultTableModel(initData, columnNames);
			jTable = new JTable(model);
		}
		return jTable;
	}

	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.gridheight = 1;
			gridBagConstraints.gridx = 0;
			jPanel3 = new JPanel();
			jPanel3.setLayout(new GridBagLayout());
			jPanel3.add(getJScrollPane1(), gridBagConstraints);
		}
		return jPanel3;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJTable1());
		}
		return jScrollPane1;
	}

	
	private RoleDao roleDao = new RoleDao();
	/**
	 * This method initializes jTable1	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable1() {
		if (jTable1 == null) {
			String[] columnNames = {"权限ID", "权限名称", "级别", "可访问模块", "其他"};
			List<Role> roles = roleDao.listRoles();
			String[][] initData = new String[roles.size()][5];
			DefaultTableModel model = new DefaultTableModel(initData, columnNames);
			jTable1 = new JTable(model);
		}
		return jTable1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RoleManageFrame thisClass = new RoleManageFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public RoleManageFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 385);
		this.setContentPane(getJContentPane());
		this.setTitle("健康体检权限管理");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJTabbedPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
