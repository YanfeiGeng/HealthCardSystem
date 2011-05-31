package com.hcs.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import com.hcs.bean.BasicInformation;
import com.hcs.bean.CheckResultBean;
import com.hcs.dao.HealthCheckResultDao;

public class HealthCheckResultInputFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTabbedPane jTabbedPane = null;
	private JPanel general = null;
	private JPanel shenghuaPanel = null;
	private JPanel fangshePanel = null;
	private JPanel xindiantuPanel = null;
	private JPanel jianyankePanel = null;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JTextField jTextField3 = null;
	private JTextField jTextField4 = null;
	private JTextField jTextField5 = null;
	private JTextField jTextField6 = null;
	private JScrollPane jScrollPane = null;
	private JEditorPane jEditorPane3 = null;
	private JScrollPane jScrollPane1 = null;
	private JEditorPane jEditorPane2 = null;
	private JScrollPane jScrollPane2 = null;
	private JEditorPane jEditorPane1 = null;
	private JScrollPane jScrollPane3 = null;
	private JEditorPane jEditorPane = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton jButton1 = null;
	private HealthCheckResultDao resultDao = new HealthCheckResultDao();  //  @jve:decl-index=0:
	private BasicInformation referedBasicInfo = null;  //  @jve:decl-index=0:
	public BasicInformation getReferedBasicInfo() {
		return referedBasicInfo;
	}

	public void setReferedBasicInfo(BasicInformation referedBasicInfo) {
		this.referedBasicInfo = referedBasicInfo;
	}

	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.addTab("一般情况", null, getGeneral(), null);
			jTabbedPane.addTab("生化室结果", null, getShenghuaPanel(), null);
			jTabbedPane.addTab("放射科结果", null, getFangshePanel(), null);
			jTabbedPane.addTab("心电图结果", null, getXindiantuPanel(), null);
			jTabbedPane.addTab("检验科结果", null, getJianyankePanel(), null);
		}
		return jTabbedPane;
	}
	
	private boolean isEdit = false;
	
	private String checkResultID = "";  //  @jve:decl-index=0:
	
	public void initValue(CheckResultBean checkResultBean){
		isEdit = true;
		getJButton1().setText("编辑");

		checkResultID = checkResultBean.getResultID();
		jEditorPane.setText(checkResultBean.getGeneralInfo());
		jTextField.setText(checkResultBean.getShParam1());
		jTextField1.setText(checkResultBean.getShParam2());
		jTextField2.setText(checkResultBean.getShParam3());
		jTextField3.setText(checkResultBean.getShParam4());
		jTextField4.setText(checkResultBean.getShParam5());
		jTextField5.setText(checkResultBean.getShParam6());
		jTextField6.setText(checkResultBean.getShParam7());
		jEditorPane1.setText(checkResultBean.getRayResult());
		jEditorPane2.setText(checkResultBean.getHeartResult());
		jEditorPane3.setText(checkResultBean.getCheckResult());
//		Object checkResult = HealthCheckResultInputFrame.this;
//		String[] fields = {
//				"id",
//				"jEditorPane",
//				"jTextField",
//				"jTextField1", 
//				"jTextField2",
//				"jTextField3",
//				"jTextField4",
//				"jTextField5",
//				"jTextField6",
//				"jEditorPane1",
//				"jEditorPane2",
//				"jEditorPane3"
//			};
//		checkResultID = values[0];
//		for(int pos = 1; pos < fields.length; pos++){
//			try {
//				Field inputItem = checkResult.getClass().getDeclaredField(fields[pos]);
//				inputItem.setAccessible(true);
//				Object inputInstance = inputItem.get(checkResult);
//				Method setMethod = inputInstance.getClass().getMethod("setText", new Class[]{String.class});
//				setMethod.invoke(inputInstance, values[pos]);
//			} catch (SecurityException e) {
//				e.printStackTrace();
//			} catch (NoSuchFieldException e) {
//				e.printStackTrace();
//			} catch (IllegalArgumentException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			} catch (NoSuchMethodException e) {
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				e.printStackTrace();
//			}
//		}
	}

	/**
	 * This method initializes general	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getGeneral() {
		if (general == null) {
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			gridBagConstraints61.gridx = 0;
			gridBagConstraints61.gridy = 1;
			GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
			gridBagConstraints51.gridx = 0;
			gridBagConstraints51.gridy = 1;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 0;
			gridBagConstraints31.gridy = 1;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.fill = GridBagConstraints.BOTH;
			gridBagConstraints18.gridy = 0;
			gridBagConstraints18.weightx = 1.0;
			gridBagConstraints18.weighty = 1.0;
			gridBagConstraints18.gridx = 0;
			general = new JPanel();
			general.setLayout(new GridBagLayout());
			general.setName("generalInfoPanel");
			general.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40), "一般情况检查结果", TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			general.add(getJScrollPane3(), gridBagConstraints18);
			general.add(getJPanel(), gridBagConstraints31);
			general.add(getJPanel1(), gridBagConstraints51);
//			general.add(getJButton1(), gridBagConstraints61);
		}
		return general;
	}

	/**
	 * This method initializes shenghuaPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getShenghuaPanel() {
		if (shenghuaPanel == null) {
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints14.gridy = 6;
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.gridx = 1;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints13.gridy = 5;
			gridBagConstraints13.weightx = 1.0;
			gridBagConstraints13.gridx = 1;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints12.gridy = 4;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.gridx = 1;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints11.gridy = 3;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.gridx = 1;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints10.gridy = 2;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.gridx = 1;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints9.gridy = 1;
			gridBagConstraints9.weightx = 1.0;
			gridBagConstraints9.gridx = 1;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.gridy = 6;
			jLabel6 = new JLabel();
			jLabel6.setText("肌酸磷酸激酶：");
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 0;
			gridBagConstraints7.gridy = 5;
			jLabel5 = new JLabel();
			jLabel5.setText("低密度脂蛋白胆固醇(LDL-CH)：");
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 4;
			jLabel4 = new JLabel();
			jLabel4.setText("高密度脂蛋白胆固醇(HDL-CH)：");
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.gridy = 3;
			jLabel3 = new JLabel();
			jLabel3.setText("尿酸：");
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 2;
			jLabel2 = new JLabel();
			jLabel2.setText("白球比值：");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setText("间接胆红素：");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.gridx = 1;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.insets = new Insets(10, 0, 0, 0);
			jLabel = new JLabel();
			jLabel.setText("总胆红素：");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			shenghuaPanel = new JPanel();
			shenghuaPanel.setLayout(new GridBagLayout());
			shenghuaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40), " 生化室检查结果", TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			shenghuaPanel.add(jLabel, gridBagConstraints1);
			shenghuaPanel.add(getJTextField(), gridBagConstraints2);
			shenghuaPanel.add(jLabel1, gridBagConstraints3);
			shenghuaPanel.add(jLabel2, gridBagConstraints4);
			shenghuaPanel.add(jLabel3, gridBagConstraints5);
			shenghuaPanel.add(jLabel4, gridBagConstraints6);
			shenghuaPanel.add(jLabel5, gridBagConstraints7);
			shenghuaPanel.add(jLabel6, gridBagConstraints8);
			shenghuaPanel.add(getJTextField1(), gridBagConstraints9);
			shenghuaPanel.add(getJTextField2(), gridBagConstraints10);
			shenghuaPanel.add(getJTextField3(), gridBagConstraints11);
			shenghuaPanel.add(getJTextField4(), gridBagConstraints12);
			shenghuaPanel.add(getJTextField5(), gridBagConstraints13);
			shenghuaPanel.add(getJTextField6(), gridBagConstraints14);
		}
		return shenghuaPanel;
	}

	/**
	 * This method initializes fangshePanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getFangshePanel() {
		if (fangshePanel == null) {
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.fill = GridBagConstraints.BOTH;
			gridBagConstraints15.gridy = 0;
			gridBagConstraints15.weightx = 1.0;
			gridBagConstraints15.weighty = 1.0;
			gridBagConstraints15.gridx = 0;
			fangshePanel = new JPanel();
			fangshePanel.setLayout(new GridBagLayout());
			fangshePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40), "放射科检查结果", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			fangshePanel.add(getJScrollPane2(), gridBagConstraints15);
		}
		return fangshePanel;
	}

	/**
	 * This method initializes xindiantuPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getXindiantuPanel() {
		if (xindiantuPanel == null) {
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.fill = GridBagConstraints.BOTH;
			gridBagConstraints16.gridy = 0;
			gridBagConstraints16.weightx = 1.0;
			gridBagConstraints16.weighty = 1.0;
			gridBagConstraints16.gridx = 0;
			xindiantuPanel = new JPanel();
			xindiantuPanel.setLayout(new GridBagLayout());
			xindiantuPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40), "心电图检查结果", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			xindiantuPanel.add(getJScrollPane1(), gridBagConstraints16);
		}
		return xindiantuPanel;
	}

	/**
	 * This method initializes jianyankePanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJianyankePanel() {
		if (jianyankePanel == null) {
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.fill = GridBagConstraints.BOTH;
			gridBagConstraints17.gridy = 0;
			gridBagConstraints17.weightx = 1.0;
			gridBagConstraints17.weighty = 1.0;
			gridBagConstraints17.gridx = 0;
			TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40), "检验科检查结果", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51));
			titledBorder.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
			jianyankePanel = new JPanel();
			jianyankePanel.setLayout(new GridBagLayout());
			jianyankePanel.setBorder(titledBorder);
			jianyankePanel.add(getJScrollPane(), gridBagConstraints17);
		}
		return jianyankePanel;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setPreferredSize(new Dimension(200, 22));
		}
		return jTextField;
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
	 * This method initializes jTextField2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setPreferredSize(new Dimension(200, 22));
		}
		return jTextField2;
	}

	/**
	 * This method initializes jTextField3	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setPreferredSize(new Dimension(200, 22));
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
			jTextField5.setPreferredSize(new Dimension(200, 22));
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
			jTextField6.setPreferredSize(new Dimension(200, 22));
		}
		return jTextField6;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJEditorPane3());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jEditorPane3	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane3() {
		if (jEditorPane3 == null) {
			jEditorPane3 = new JEditorPane();
		}
		return jEditorPane3;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJEditorPane2());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jEditorPane2	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane2() {
		if (jEditorPane2 == null) {
			jEditorPane2 = new JEditorPane();
		}
		return jEditorPane2;
	}

	/**
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getJEditorPane1());
		}
		return jScrollPane2;
	}

	/**
	 * This method initializes jEditorPane1	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane1() {
		if (jEditorPane1 == null) {
			jEditorPane1 = new JEditorPane();
		}
		return jEditorPane1;
	}

	/**
	 * This method initializes jScrollPane3	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setViewportView(getJEditorPane());
		}
		return jScrollPane3;
	}

	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
		}
		return jEditorPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
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
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("添加");
			jButton1.setPreferredSize(new Dimension(100, 22));
			jButton1.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					Object object = HealthCheckResultInputFrame.this;
					String[][] fields = {
								{"jEditorPane","setGeneralInfo","","一般情况检查结果"},
								{"jTextField","setShParam1","","总胆红素"},
								{"jTextField1","setShParam2","","间接胆红素"}, 
								{"jTextField2","setShParam3","","白球比值"},
								{"jTextField3","setShParam4","","尿酸"},
								{"jTextField4","setShParam5","","高密度脂蛋白胆固醇(HDL-CH)"},
								{"jTextField5","setShParam6","","低密度脂蛋白胆固醇(LDL-CH)"},
								{"jTextField6","setShParam7","","肌酸磷酸激酶"},
								{"jEditorPane1","setRayResult","","放射科检查结果"},
								{"jEditorPane2","setHeartResult","","心电图检查结果"},
								{"jEditorPane3","setCheckResult","","检验科检查结果"}
							};
					CheckResultBean checkResult = new CheckResultBean();
					checkResult.setResultID(String.valueOf(System.currentTimeMillis()));
					for(String[] field : fields){
						try {
							
							//Get value.
							Field localField = object.getClass().getDeclaredField(field[0]);
							localField.setAccessible(true);
//							System.out.println(localField.get(object).getClass());
							Object fieldIns = localField.get(object);
							Method getTextMethod = fieldIns.getClass().getMethod("getText", null);
							getTextMethod.setAccessible(true);
							Object value = getTextMethod.invoke(fieldIns, null);
							
							if(value == null || "".equals(value)){
								JOptionPane.showMessageDialog(null, field[3] + " 不能为空！");
								return;
							}
							
							//Set value for the inputs
//							field[2] = StringUtil.filterGamaAndEnter(value.toString());
							field[2] = value.toString();
//							System.out.println("Value is: " + value);
							
							//Set Value
//							Method setValue = checkResult.getClass().getDeclaredMethod(field[1], new Class[]{String.class});
//							setValue.invoke(checkResult, value);
							
						} catch (SecurityException e1) {
							e1.printStackTrace();
						} catch (NoSuchFieldException e1) {
							e1.printStackTrace();
						} catch (NoSuchMethodException e1) {
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							e1.printStackTrace();
						} catch (InvocationTargetException e1) {
							e1.printStackTrace();
						}
					}
					
//					String[] value = {
//							checkResult.getResultID(),
//							fields[0][2], 
//							fields[1][2],
//							fields[2][2], 
//							fields[3][2], 
//							fields[4][2], 
//							fields[5][2], 
//							fields[6][2], 
//							fields[7][2], 
//							fields[8][2], 
//							fields[9][2], 
//							fields[10][2], 
//							};
					CheckResultBean healthCheckResult = new CheckResultBean(fields[0][2], 
							fields[1][2],
							fields[2][2], 
							fields[3][2], 
							fields[4][2], 
							fields[5][2], 
							fields[6][2], 
							fields[7][2], 
							fields[8][2], 
							fields[9][2], 
							fields[10][2]);
					if(HealthCheckResultInputFrame.this.isEdit){
						//Original Usage
//						CheckResultOperator.updateCheckResultRecord(HealthCheckResultInputFrame.this.checkResultID, value);
						healthCheckResult.setResultID(checkResultID);
						healthCheckResult.setReferedBasicInfo(referedBasicInfo);
						resultDao.updateCheckResultRecord(healthCheckResult);
						JOptionPane.showMessageDialog(null, "体检记录修改成功！");
					} else {
						//Original Usage
//						CheckResultOperator.addCheckResultRecord(value);
						healthCheckResult.setReferedBasicInfo(referedBasicInfo);
						resultDao.addCheckResultRecord(healthCheckResult);
						JOptionPane.showMessageDialog(null, "体检记录添加成功！");
					}
//					CheckResultOperator.saveData();
					HealthCheckResultInputFrame.this.dispose();
				}
			});
		}
		return jButton1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				HealthCheckResultInputFrame thisClass = new HealthCheckResultInputFrame();
//				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				thisClass.setVisible(true);
//			}
//		});
	}

	/**
	 * This is the default constructor
	 */
	public HealthCheckResultInputFrame(BasicInformation basicInfo) {
		super();
		this.referedBasicInfo = basicInfo;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(937, 526);
		this.setContentPane(getJContentPane());
		this.setTitle("[" + this.getReferedBasicInfo().getName() + "] - 体检结果录入");
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
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout());
			buttonPanel.add(getJButton1());
			JButton cancelButton = new JButton();
			cancelButton.setText("取消");
			cancelButton.setPreferredSize(new Dimension(100, 22));
			cancelButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					HealthCheckResultInputFrame.this.dispose();
				}
				
			});
			buttonPanel.add(cancelButton);
			jContentPane.add(buttonPanel, BorderLayout.SOUTH);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"

