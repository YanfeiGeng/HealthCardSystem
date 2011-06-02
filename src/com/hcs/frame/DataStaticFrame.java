package com.hcs.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import com.hcs.bean.BasicInformation;
import com.hcs.bean.CheckResultBean;
import com.hcs.dao.BasicInfoDao;
import com.hcs.dao.HealthCheckResultDao;

public class DataStaticFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JTree jTree = null;
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.gridx = 0;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(getJTree(), gridBagConstraints1);
		}
		return jPanel;
	}

	
	private BasicInfoDao basicInfoDao = new BasicInfoDao(); 
	
	private HealthCheckResultDao healthCheckResultDao = new HealthCheckResultDao();  
	/**
	 * This method initializes jTree	
	 * 	
	 * @return javax.swing.JTree	
	 */
	private JTree getJTree() {
		if (jTree == null) {
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("健康体检系统信息统计");
			List<BasicInformation> users = basicInfoDao.getHealthCardRecords();
			for(BasicInformation user : users){
				DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(user);
				List<CheckResultBean> checkResults = healthCheckResultDao.getCheckResultRecords();
				for(CheckResultBean checkResult : checkResults){
					DefaultMutableTreeNode checkResultNode = new DefaultMutableTreeNode(checkResult);
					userNode.add(checkResultNode);
				}
				root.add(userNode);
			}
			jTree = new JTree(root);
		}
		return jTree;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DataStaticFrame thisClass = new DataStaticFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public DataStaticFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(616, 333);
		this.setContentPane(getJContentPane());
		this.setTitle("数据统计界面");
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
			jContentPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.gray, 2), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
