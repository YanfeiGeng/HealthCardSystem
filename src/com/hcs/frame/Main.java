package com.hcs.frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import com.hcs.bean.Role;
import com.hcs.util.BasicInfoOperator;
import com.hcs.util.RoleDefinition;
import com.hcs.util.StringUtil;
import com.hcs.util.UIUtil;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu healthCardInfo = null;
	private JMenu healthCheck = null;
	private JMenu healthCardPrint = null;
	private JMenu dataStatAndSearch = null;
	private JMenu authManage = null;
	private JMenuItem inputInfo = null;
	private JMenuItem healtyCheckInput = null;
	private JMenuItem healtyCardPrintFeature = null;
	private JMenuItem dataStatic = null;
	private JMenuItem dataSearch = null;
	private JMenuItem authManagent = null;
	private JMenuItem baseInfoEdit = null;
	private JMenuItem checkManagent = null;
	private JLabel welcome = null;
	private Role userRole = null; 

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			if(userRole != null){
				int[] roles = StringUtil.convertRoleLevelToIntArray(userRole.getRoleLevel());
				for(int i = 0; i < roles.length; i++){
					switch(roles[i]){
						case RoleDefinition.BASIC_INFO:
							jJMenuBar.add(getHealthCardInfo());
							break;
						case RoleDefinition.HEALTH_CHECK:
							jJMenuBar.add(getHealthCheck());
							break;
						case RoleDefinition.PRINT_BASIC:
							jJMenuBar.add(getHealthCardPrint());
							break;
						case RoleDefinition.HEALTH_STATICS:
							jJMenuBar.add(getDataStatAndSearch());
							break;
						case RoleDefinition.USER_ROLE:
							jJMenuBar.add(getAuthManage());
							break;
						default:
					}
				}
			}
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes healthCardInfo	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHealthCardInfo() {
		if (healthCardInfo == null) {
			healthCardInfo = new JMenu();
			healthCardInfo.setText("����֤����");
			healthCardInfo.add(getInputInfo());
			healthCardInfo.add(getBaseInfoEdit());
		}
		return healthCardInfo;
	}

	/**
	 * This method initializes healthCheck	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHealthCheck() {
		if (healthCheck == null) {
			healthCheck = new JMenu();
			healthCheck.setText("�������");
			healthCheck.add(getHealtyCheckInput());
			healthCheck.add(getCheckManagent());
		}
		return healthCheck;
	}

	/**
	 * This method initializes healthCardPrint	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHealthCardPrint() {
		if (healthCardPrint == null) {
			healthCardPrint = new JMenu();
			healthCardPrint.setText("����֤��ӡ");
			healthCardPrint.add(getHealtyCardPrintFeature());
		}
		return healthCardPrint;
	}

	/**
	 * This method initializes dataStatAndSearch	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getDataStatAndSearch() {
		if (dataStatAndSearch == null) {
			dataStatAndSearch = new JMenu();
			dataStatAndSearch.setText("����ͳ�Ƽ���ѯ");
			dataStatAndSearch.add(getDataStatic());
			dataStatAndSearch.add(getDataSearch());
		}
		return dataStatAndSearch;
	}

	/**
	 * This method initializes authManage	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getAuthManage() {
		if (authManage == null) {
			authManage = new JMenu();
			authManage.setText("Ȩ�޹���");
			authManage.add(getAuthManagent());
		}
		return authManage;
	}

	/**
	 * This method initializes inputInfo	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getInputInfo() {
		if (inputInfo == null) {
			inputInfo = new JMenuItem();
			inputInfo.setText("����֤��������¼��");
			inputInfo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					BasicInfoInputFrame basicInfoFrame = new BasicInfoInputFrame();
					UIUtil.setInCenter(basicInfoFrame);
					basicInfoFrame.setVisible(true);
				}
			});
		}
		return inputInfo;
	}

	/**
	 * This method initializes healtyCheckInput	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getHealtyCheckInput() {
		if (healtyCheckInput == null) {
			healtyCheckInput = new JMenuItem();
			healtyCheckInput.setText("�����¼��");
			healtyCheckInput.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					SelectBasicInfoForCheckResult sbifr = new SelectBasicInfoForCheckResult();
					UIUtil.setInCenter(sbifr);
					sbifr.setVisible(true);
				}
				
			});
		}
		return healtyCheckInput;
	}

	/**
	 * This method initializes healtyCardPrintFeature	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getHealtyCardPrintFeature() {
		if (healtyCardPrintFeature == null) {
			healtyCardPrintFeature = new JMenuItem();
			healtyCardPrintFeature.setText("����֤��ӡ");
			healtyCardPrintFeature.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					PrintBasicInfoFrame printFrame = new PrintBasicInfoFrame();
					UIUtil.setInCenter(printFrame);
					printFrame.setVisible(true);
				}
				
			});
		}
		return healtyCardPrintFeature;
	}

	/**
	 * This method initializes dataStatic	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getDataStatic() {
		if (dataStatic == null) {
			dataStatic = new JMenuItem();
			dataStatic.setToolTipText("");
			dataStatic.setText("����ͳ��");
			dataStatic.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					DataStaticFrame dataStatic = new DataStaticFrame();
					UIUtil.setInCenter(dataStatic);
					dataStatic.setVisible(true);
				}
				
			});
		}
		return dataStatic;
	}

	/**
	 * This method initializes dataSearch	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getDataSearch() {
		if (dataSearch == null) {
			dataSearch = new JMenuItem();
			dataSearch.setToolTipText("");
			dataSearch.setText("���ݲ�ѯ");
			dataSearch.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					DataSearchFrame dataSearchFrame = new DataSearchFrame();
					UIUtil.setInCenter(dataSearchFrame);
					dataSearchFrame.setVisible(true);
				}
				
			});
		}
		return dataSearch;
	}

	/**
	 * This method initializes authManagent	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAuthManagent() {
		if (authManagent == null) {
			authManagent = new JMenuItem();
			authManagent.setToolTipText("");
			authManagent.setText("����ϵͳȨ��");
			authManagent.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					RoleManageFrame roleManage = new RoleManageFrame();
					UIUtil.setInCenter(roleManage);
					roleManage.setVisible(true);
				}
				
			});
		}
		return authManagent;
	}

	/**
	 * This method initializes baseInfoEdit	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getBaseInfoEdit() {
		if (baseInfoEdit == null) {
			baseInfoEdit = new JMenuItem();
			baseInfoEdit.setText("�������Ϲ���");
			baseInfoEdit.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					BasicInfoManageFrame infoManageFrame = new BasicInfoManageFrame();
					UIUtil.setInCenter(infoManageFrame);
					infoManageFrame.setVisible(true);
				}
				
			});
		}
		return baseInfoEdit;
	}

	/**
	 * This method initializes checkManagent	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCheckManagent() {
		if (checkManagent == null) {
			checkManagent = new JMenuItem();
			checkManagent.setText("���������");
			checkManagent.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					HealthCheckResultManageFrame checkResult = new HealthCheckResultManageFrame();
					UIUtil.setInCenter(checkResult);
					checkResult.setVisible(true);
				}
				
			});
		}
		return checkManagent;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			initGlobalFont();
			UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main thisClass = new Main();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				UIUtil.setInCenter(thisClass);
				thisClass.setVisible(true);
				thisClass.addWindowListener(new WindowAdapter(){

					public void windowClosing(WindowEvent e) {
						BasicInfoOperator.saveData();
					}
					
				});
			}
		});
	}
	
	//Init global Font 
	public static void initGlobalFont(){
		Font font = new Font("����", Font.PLAIN, 13);
		FontUIResource resource = new FontUIResource(font);
		for(Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();){
			Object key = keys.nextElement();
			Object value = UIManager.getDefaults().get(key);
			if(value instanceof FontUIResource){
				UIManager.put(key, resource);
			}
		}
	}
	

	/**
	 * This is the default constructor
	 */
	public Main() {
		super();
		initialize();
	}

	public Main(Role userRole) throws HeadlessException {
		super();
		this.setUserRole(userRole);
		initialize();
		this.userRole = userRole;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(751, 587);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("����֤����ϵͳ");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			welcome = new JLabel();
			welcome.setText("��ӭʹ�ý���֤����ϵͳ");
			welcome.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			welcome.setIcon(new ImageIcon(getClass().getResource("/resources/Welcome.JPG")));
			welcome.setBorder(new EmptyBorder(new Insets(0, 100, 0, 0)));
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(welcome, BorderLayout.CENTER);
		}
		return jContentPane;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
