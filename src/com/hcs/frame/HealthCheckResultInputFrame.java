package com.hcs.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class HealthCheckResultInputFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTabbedPane jTabbedPane = null;
	private JPanel general = null;
	private JPanel shenghuaPanel = null;
	private JPanel fangshePanel = null;
	private JPanel xindiantuPanel = null;
	private JPanel jianyankePanel = null;
	private JEditorPane jEditorPane = null;
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
	private JEditorPane jEditorPane1 = null;
	private JEditorPane jEditorPane2 = null;
	private JScrollPane jScrollPane = null;
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

	/**
	 * This method initializes general	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getGeneral() {
		if (general == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.gridx = 0;
			TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40), "一般情况检查结果");
			general = new JPanel();
			general.setLayout(new GridBagLayout());
			general.setName("generalInfoPanel");
			general.setBorder(titledBorder);
			general.add(getJEditorPane(), gridBagConstraints);
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
			jLabel6.setText("JLabel");
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 0;
			gridBagConstraints7.gridy = 5;
			jLabel5 = new JLabel();
			jLabel5.setText("JLabel");
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 4;
			jLabel4 = new JLabel();
			jLabel4.setText("JLabel");
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.gridy = 3;
			jLabel3 = new JLabel();
			jLabel3.setText("JLabel");
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 2;
			jLabel2 = new JLabel();
			jLabel2.setText("JLabel");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setText("JLabel");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.gridx = 1;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("JLabel");
			shenghuaPanel = new JPanel();
			shenghuaPanel.setLayout(new GridBagLayout());
			shenghuaPanel.setBorder(BorderFactory.createTitledBorder(" 生化室检查结果"));
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
			fangshePanel.setBorder(BorderFactory.createTitledBorder(null, "放射科检查结果", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			fangshePanel.add(getJEditorPane1(), gridBagConstraints15);
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
			xindiantuPanel.setBorder(BorderFactory.createTitledBorder(null, "心电图检查结果", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			xindiantuPanel.add(getJEditorPane2(), gridBagConstraints16);
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
			jianyankePanel = new JPanel();
			jianyankePanel.setLayout(new GridBagLayout());
			jianyankePanel.setBorder(BorderFactory.createTitledBorder(null, "检验科检查结果", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jianyankePanel.add(getJScrollPane(), gridBagConstraints17);
		}
		return jianyankePanel;
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
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
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
		}
		return jTextField6;
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
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.add(new JPanel());
			jScrollPane.add(new JPanel());
			jScrollPane.add(new JPanel());
			jScrollPane.add(new JPanel());
			
		}
		return jScrollPane;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				HealthCheckResultInputFrame thisClass = new HealthCheckResultInputFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public HealthCheckResultInputFrame() {
		super();
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
		this.setTitle("体检结果录入");
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
