package com.hcs.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.hcs.bean.BasicInformation;
import com.hcs.bean.CheckResultBean;
import com.hcs.bean.Role;
import com.hcs.bean.User;
import com.hcs.dao.BasicInfoDao;
import com.hcs.dao.HealthCheckResultDao;
import com.hcs.dao.RoleDao;
import com.hcs.dao.UserDao;
import com.hcs.util.SearchType;
import com.hcs.util.StringUtil;

public class DataSearchFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new BorderLayout());
			jPanel.add(getJPanel1(), BorderLayout.NORTH);
			jPanel.add(getJScrollPane(), BorderLayout.CENTER);
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
			jPanel1.setLayout(new FlowLayout());
			
			JTextField condition = new JTextField();
			condition.setSize(new Dimension(200, 22));
			condition.setPreferredSize(new Dimension(200, 22));
			jPanel1.add(condition);
			
			JComboBox type = new JComboBox(SearchType.allTypes);
			type.setSize(new Dimension(200, 22));
			type.setPreferredSize(new Dimension(80, 22));
			jPanel1.add(type);
			
			
			JButton searchBtn = new JButton("搜索");
			searchBtn.setPreferredSize(new Dimension(60, 22));
			jPanel1.add(searchBtn);
			
			
			jPanel1.setSize(100, 100);
		}
		return jPanel1;
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
	
	private RoleDao roleDao = new RoleDao();
	
	private BasicInfoDao basicDao = new BasicInfoDao();
	
	//Basic info search
	private DefaultTableModel basicInfoResult(String condition){
		List<BasicInformation> basicRecords = basicDao.getHealthCardRecords();
		String[] columnNames = {"健康证ID", "姓名", "性别", "年龄", "出生日期", "籍贯", "现住址", "体检报告"};
		String[][] initData = new String[basicRecords.size()][8];
		for(int i = 0; i < basicRecords.size(); i++){
			BasicInformation info = basicRecords.get(i);
			initData[i][0] = info.getId();
			initData[i][1] = info.getName();
			initData[i][2] = info.getSex();
			initData[i][3] = info.getAge();
			initData[i][4] = info.getBirthday().toString();
			initData[i][5] = info.getAddress();
			initData[i][6] = info.getCurrentAddress();
			initData[i][7] = info.getCheckReport();
		}
		DefaultTableModel model = new DefaultTableModel(initData, columnNames);
		return model;
	}
	
	private HealthCheckResultDao checkResultDao = new HealthCheckResultDao();
	//Check result search result
	private DefaultTableModel checkResult(String condition){
		String[] columnNames = {"体检结果ID", "一般情况", "生化室", "放射科", "心电图", "检验科", "其他"};
		List<CheckResultBean> resultList = checkResultDao.getCheckResultRecords();
		String[][] initData = new String[resultList.size()][7];
		for(int i = 0; i < resultList.size(); i++){
			CheckResultBean result = resultList.get(i);
			initData[i][0] = result.getResultID(); 
			initData[i][1] = result.getGeneralInfo();
			initData[i][2] = result.getShParam1();
			initData[i][3] = result.getRayResult();
			initData[i][4] = result.getHeartResult();
			initData[i][5] = result.getCheckResult();
			initData[i][6] = "暂无";
		}
		DefaultTableModel model = new DefaultTableModel(initData, columnNames);
		return model;
	}
	
	private UserDao userDao = new UserDao();
	//User search result
	private DefaultTableModel userResult(){
		String[] userHeader = {"用户ID", "姓名", "权限", "其他"};
		List<User> users = userDao.listAllUser();
		String[][] initData = new String[users.size()][4];
		for(int i = 0; i < users.size(); i++){
			User user = users.get(i);
			initData[i][0] = user.getId();
			initData[i][1] = user.getName();
			initData[i][2] = user.getRole().getRoleName();
			initData[i][3] = "无";
		}
		DefaultTableModel model = new DefaultTableModel(initData, userHeader);
		return model;
	}
	
	private DefaultTableModel initRoles(){
		String[] columnNames = {"权限ID", "权限名称", "级别", "其他"};
		List<Role> roles = roleDao.listRoles();
		String[][] initData = new String[roles.size()][4];
		for(int i = 0; i < roles.size(); i++){
			Role role = roles.get(i);
			initData[i][0] = role.getId();
			initData[i][1] = role.getRoleName();
			initData[i][2] = StringUtil.convertRoleIdToString(role.getRoleLevel());
			initData[i][3] = "无";
		}
		DefaultTableModel model = new DefaultTableModel(initData, columnNames);
		return model;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(initRoles());
		}
		return jTable;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DataSearchFrame thisClass = new DataSearchFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public DataSearchFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(874, 398);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
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
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
