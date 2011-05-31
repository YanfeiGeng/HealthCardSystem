package com.hcs.frame;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.hcs.bean.BasicInformation;
import com.hcs.bean.CheckResultBean;
import com.hcs.dao.BasicInfoDao;
import com.hcs.util.UIUtil;

public class SelectBasicInfoForCheckResult extends JFrame {

	public SelectBasicInfoForCheckResult(CheckResultBean referredCheckResult)
			throws HeadlessException {
		super();
		this.referredCheckResult = referredCheckResult;
		initialize();
	}

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JComboBox jComboBox = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private BasicInfoDao basicDao = new BasicInfoDao();
	private CheckResultBean referredCheckResult = null;

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 1;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.insets = new Insets(0, 30, 0, 0);
			jLabel = new JLabel();
			jLabel.setText("请选择体检报告对应的人员:");
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabel, gridBagConstraints);
			jPanel.add(getJComboBox(), gridBagConstraints1);
			jPanel.add(getJButton(), gridBagConstraints2);
			jPanel.add(getJButton1(), gridBagConstraints3);
		}
		return jPanel;
	}
	
	private List<BasicInformation> listInfo = basicDao.getHealthCardRecords();
	private Vector<BasicInformation> vectorInfo = new Vector<BasicInformation>();

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			if(this.referredCheckResult != null){
				vectorInfo.add(this.getReferredCheckResult().getReferedBasicInfo());
			} else {
				for(BasicInformation info : listInfo){
					vectorInfo.add(info);
				}
			}
			jComboBox = new JComboBox(vectorInfo);
			if(this.referredCheckResult != null){
				jComboBox.setEnabled(false);
			}
		}
		return jComboBox;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("选择");
			jButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					HealthCheckResultInputFrame checkResultInput = new HealthCheckResultInputFrame((BasicInformation)getJComboBox().getSelectedItem());
					UIUtil.setInCenter(checkResultInput);
					checkResultInput.setVisible(true);
					CheckResultBean checkResult = SelectBasicInfoForCheckResult.this.getReferredCheckResult();
					if(checkResult != null){
						checkResultInput.initValue(SelectBasicInfoForCheckResult.this.getReferredCheckResult());
					}
					SelectBasicInfoForCheckResult.this.dispose();
				}
				
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("取消");
			jButton1.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					SelectBasicInfoForCheckResult.this.dispose();
				}
				
			});
		}
		return jButton1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SelectBasicInfoForCheckResult thisClass = new SelectBasicInfoForCheckResult();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public SelectBasicInfoForCheckResult() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(368, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("请选择需要添加体检结果的人员");
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

	public CheckResultBean getReferredCheckResult() {
		return referredCheckResult;
	}

	public void setReferredCheckResult(CheckResultBean referredCheckResult) {
		this.referredCheckResult = referredCheckResult;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
