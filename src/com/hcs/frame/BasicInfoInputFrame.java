package com.hcs.frame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.hcs.bean.BasicInformation;
import com.hcs.dao.BasicInfoDao;
import com.hcs.util.UIUtil;

public class BasicInfoInputFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel basIDValue = null;
	private JLabel basName = null;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JPanel jPanel1 = null;
	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField3 = null;
	private JTextField jTextField4 = null;
	private JTextField jTextField5 = null;
	private JTextField jTextField6 = null;
	private JButton jButton = null;
	private JPanel jPanel2 = null;
	private ButtonGroup group = new ButtonGroup();
	private String basicInfoId = ""; 
	
	private BasicInfoManageFrame basicInfoFrame = null;
	
	private boolean isEdit = false;
	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	/**
	 * This is the default constructor
	 */
	public BasicInfoInputFrame() {
		super();
		initialize();
	}
	
	//{"23123168", "张三", "男", "21", "1990-10-13", "中国河北秦皇岛", "江苏扬州", "Report.xls"},
	public void initValue(BasicInformation basicInfo){
		setEdit(true);
		basicInfoId = basicInfo.getId();
		jTextField1.setText(basicInfo.getName());
		if("男".equals(basicInfo.getSex())){
			getJRadioButton().setSelected(true);
		} else {
			getJRadioButton1().setSelected(true);
		}
		jTextField3.setText(basicInfo.getAge());
		jTextField4.setText(basicInfo.getBirthday().toString());
		jTextField5.setText(basicInfo.getAddress());
		jTextField6.setText(basicInfo.getCurrentAddress());
		
//		String age = jTextField3.getText().trim();
//		String birth = jTextField4.getText().trim();
//		String birthAddress = jTextField5.getText().trim();
//		String currentAddress = jTextField6.getText().trim();
	}
	
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 2;
			gridBagConstraints18.gridy = 0;
			jLabel2 = new JLabel();
			String id = String.valueOf(System.currentTimeMillis()).substring(0, 7);
			jLabel2.setText(id);
			jLabel2.setEnabled(false);
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 2;
			gridBagConstraints17.gridy = 9;
			GridBagConstraints gridBagConstraints121 = new GridBagConstraints();
			gridBagConstraints121.gridx = 3;
			gridBagConstraints121.gridy = 8;
			gridBagConstraints121.insets = new Insets(10, 0, 0, 0);
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints11.gridy = 7;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.gridx = 2;
			gridBagConstraints11.insets = new Insets(10, 30, 0, 0);
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			GridBagConstraints gridBagConstraints101 = new GridBagConstraints();
			gridBagConstraints101.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints101.gridy = 6;
			gridBagConstraints101.weightx = 1.0;
			gridBagConstraints101.gridx = 2;
			gridBagConstraints101.insets = new Insets(10, 30, 0, 0);
			gridBagConstraints101.anchor = GridBagConstraints.WEST;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints9.gridy = 5;
			gridBagConstraints9.weightx = 1.0;
			gridBagConstraints9.gridx = 2;
			gridBagConstraints9.insets = new Insets(10, 30, 0, 0);
			gridBagConstraints9.anchor = GridBagConstraints.WEST;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints8.gridy = 4;
			gridBagConstraints8.weightx = 1.0;
			gridBagConstraints8.gridx = 2;
			gridBagConstraints8.insets = new Insets(10, 30, 0, 0);
			gridBagConstraints8.anchor = GridBagConstraints.WEST;
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			gridBagConstraints61.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints61.gridy = 1;
			gridBagConstraints61.weightx = 1.0;
			gridBagConstraints61.gridx = 2;
			gridBagConstraints61.insets = new Insets(10, 30, 0, 0);
			gridBagConstraints61.anchor = GridBagConstraints.WEST;
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.gridx = 3;
			gridBagConstraints41.gridy = 3;
			gridBagConstraints41.insets = new Insets(10, 0, 0, 0);
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 2;
			gridBagConstraints3.gridy = 3;
			gridBagConstraints3.insets = new Insets(10, 0, 0, 0);
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 1;
			gridBagConstraints21.gridy = 3;
			gridBagConstraints21.insets = new Insets(10, 0, 0, 0);
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.gridx = 0;
			gridBagConstraints14.gridy = 8;
			gridBagConstraints14.insets = new Insets(10, 0, 0, 0);
			jLabel8 = new JLabel();
			jLabel8.setText("体检报告");
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.gridy = 7;
			gridBagConstraints13.insets = new Insets(10, 0, 0, 0);
			jLabel7 = new JLabel();
			jLabel7.setText("现住址：");
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.gridy = 6;
			jLabel6 = new JLabel();
			jLabel6.setText("籍贯：");
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 0;
			gridBagConstraints10.gridy = 5;
			gridBagConstraints10.insets = new Insets(10, 0, 0, 0);
			jLabel5 = new JLabel();
			jLabel5.setText("出生日期：");
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 4;
			gridBagConstraints6.insets = new Insets(10, 0, 0, 0);
			jLabel4 = new JLabel();
			jLabel4.setText("年龄：");
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.gridy = 3;
			gridBagConstraints5.insets = new Insets(10, 0, 0, 0);
			jLabel3 = new JLabel();
			jLabel3.setText("性别：");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.insets = new Insets(10, 0, 0, 0);
			jLabel1 = new JLabel();
			jLabel1.setText("姓名：");
			jLabel1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.insets = new Insets(10, 0, 0, 0);
			jLabel = new JLabel();
			jLabel.setText("健康证ID：");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
			jPanel.add(jLabel, gridBagConstraints);
			jPanel.add(jLabel1, gridBagConstraints2);
			jPanel.add(jLabel3, gridBagConstraints5);
			jPanel.add(jLabel4, gridBagConstraints6);
			jPanel.add(jLabel5, gridBagConstraints10);
			jPanel.add(jLabel6, gridBagConstraints12);
			jPanel.add(jLabel7, gridBagConstraints13);
			jPanel.add(jLabel8, gridBagConstraints14);
			jPanel.add(getJPanel1(), gridBagConstraints21);
			group.add(getJRadioButton());
			group.add(getJRadioButton1());
			jPanel.add(getJRadioButton(), gridBagConstraints3);
			jPanel.add(getJRadioButton1(), gridBagConstraints41);
			jPanel.add(getJTextField1(), gridBagConstraints61);
			jPanel.add(getJTextField3(), gridBagConstraints8);
			jPanel.add(getJTextField4(), gridBagConstraints9);
			jPanel.add(getJTextField5(), gridBagConstraints101);
			jPanel.add(getJTextField6(), gridBagConstraints11);
			jPanel.add(getJButton(), gridBagConstraints121);
			jPanel.add(getJPanel2(), gridBagConstraints17);
			jPanel.add(jLabel2, gridBagConstraints18);
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
			jPanel1.setLayout(new GridBagLayout());
		}
		return jPanel1;
	}

	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setText(" 男");
			jRadioButton.setActionCommand("男");
			jRadioButton.setSelected(true);
		}
		return jRadioButton;
	}

	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setText("女");
			jRadioButton1.setActionCommand("女");
		}
		return jRadioButton1;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setPreferredSize(new Dimension(200, 22));
		}
		return jTextField1;
	}

	/**
	 * This method initializes jTextField3	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setPreferredSize(new Dimension(50, 22));
		}
		return jTextField3;
	}

	/**
	 * This method initializes jTextField4	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setPreferredSize(new Dimension(200, 22));
		}
		return jTextField4;
	}

	/**
	 * This method initializes jTextField5	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField5() {
		if (jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setPreferredSize(new Dimension(220, 22));
		}
		return jTextField5;
	}

	/**
	 * This method initializes jTextField6	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setPreferredSize(new Dimension(220, 22));
		}
		return jTextField6;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("选择文件");
		}
		return jButton;
	}

	private JButton submitButton = new JButton();
	private JButton cancelButton = new JButton();
	private JLabel jLabel2 = null;
	private BasicInfoInputFrame currentDialog = this;
	private BasicInfoDao basicInfoDao = new BasicInfoDao();
	
	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridLayout());
			submitButton.setText("确认");
			
			//Collect all info of current user.
			submitButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					String name = jTextField1.getText().trim();
					String sex = group.getSelection().getActionCommand();
					String age = jTextField3.getText().trim();
					String birth = jTextField4.getText().trim();
					String birthAddress = jTextField5.getText().trim();
					String currentAddress = jTextField6.getText().trim();
					
					if(UIUtil.isEmpty("姓名", name) && 
							UIUtil.isEmpty("性别", sex) &&
							UIUtil.isEmpty("年龄", age) &&
							UIUtil.isEmpty("生日", birth) &&
							UIUtil.isEmpty("籍贯", birthAddress) &&
							UIUtil.isEmpty("现住址", currentAddress)){
//						String id = jLabel2.getText().trim();
//						String[] record = {id, name, sex, age, birth, birthAddress, currentAddress, "initReport.xls"};
						System.out.println(birth);
						Date birthday = Date.valueOf(birth);
						BasicInformation basicInfo = new BasicInformation(name, sex, age, birthday, birthAddress, currentAddress, "initReport.xls");
						basicInfo.setId(basicInfoId);
						if(BasicInfoInputFrame.this.isEdit()){
							basicInfoDao.updateHealthCardRecord(basicInfo);
							if(basicInfoFrame != null){
								basicInfoFrame.refreshBasicInfoTable();
							}
						} else {
							//Original usage
//							BasicInfoOperator.addHealthCardRecord(record);
							
							basicInfoDao.addHealthCardRecord(basicInfo);
							JOptionPane.showMessageDialog(null, name + "\n"
									+ sex + "\n"
									+ age + "\n"
									+ birth + "\n"
									+ birthAddress + "\n"
									+ currentAddress + "\n"
									+ "改记录被成功添加！");
							if(basicInfoFrame != null){
								basicInfoFrame.refreshBasicInfoTable();
							}
						}
						currentDialog.dispose();
					}
				}
			});
			
			cancelButton.setText("取消");
			//Close current dialog
			cancelButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					currentDialog.dispose();
				}
				
			});
			jPanel2.add(submitButton);
			jPanel2.add(cancelButton);
		}
		return jPanel2;
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) { 
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BasicInfoInputFrame thisClass = new BasicInfoInputFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(471, 410);
		this.setContentPane(getJPanel());
		this.setTitle("健康基本资料录入");
	}

	public BasicInfoManageFrame getBasicInfoFrame() {
		return basicInfoFrame;
	}

	public void setBasicInfoFrame(BasicInfoManageFrame basicInfoFrame) {
		this.basicInfoFrame = basicInfoFrame;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
