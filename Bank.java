package structural;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bank {

	private JFrame frame;
	private JTextField userid_register;
	private JTextField userpw_register;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bank window = new Bank();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Bank() {
		initialize();
	}
	public static int totalCount = 0;
	public String name = null;
	public Account[] account = new Account[10];
	public int accountCount = 0;
	public int accountCurrent = -1;
	private JTextField loginid_login;
	private JTextField loginpw_login;
	private JTextField inputMethod_value;
	private JButton registerBtn_main;
	private JTextField outputMethod_value;

	public boolean login(String id, String pw) {
		boolean returnValue = false;
		for (int i = 0; i < accountCount; i++) {
			if (account[i].isLogin(id, pw)) {
				returnValue = true;
				accountCurrent = i;
				break;
			}
		}
		return returnValue;
	}

	public void logout() {
		accountCurrent = -1;
		JOptionPane.showMessageDialog(null, "�α׾ƿ�");
	}

	public void useAccount() {
		if (accountCurrent != -1) {
			account[accountCurrent].menu();
		} else {
			System.out.println("�߸��� �Է�");
		}
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("BankJob");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JPanel login = new JPanel();
		login.setVisible(false);

		JPanel bankprocess = new JPanel();
		bankprocess.setVisible(false);
		bankprocess.setBounds(0, 0, 794, 571);
		frame.getContentPane().add(bankprocess);
		bankprocess.setLayout(null);

		JLabel inputMethod_label = new JLabel("�Աݾ��� �Է��Ͻʽÿ�.");
		inputMethod_label.setVisible(false);
		inputMethod_label.setBounds(180, 326, 128, 23);
		bankprocess.add(inputMethod_label);

		inputMethod_value = new JTextField();
		inputMethod_value.setVisible(false);
		inputMethod_value.setBounds(318, 327, 116, 21);
		bankprocess.add(inputMethod_value);
		inputMethod_value.setColumns(10);

		JButton btnNewButton = new JButton("Ȯ��");
		btnNewButton.setVisible(false);

		JLabel outputMethod_label = new JLabel("��ݾ��� �Է��Ͻʽÿ�.");
		outputMethod_label.setVisible(false);
		outputMethod_label.setBounds(178, 326, 128, 23);
		bankprocess.add(outputMethod_label);

		JButton btnNewButton_1 = new JButton("Ȯ��");

		JButton button_3 = new JButton("�Ա�");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputMethod_label.setVisible(true);
				inputMethod_value.setVisible(true);
				btnNewButton.setVisible(true);
				outputMethod_label.setVisible(false);
				outputMethod_value.setVisible(false);
				btnNewButton_1.setVisible(false);
			}
		});
		button_3.setBounds(318, 164, 97, 23);
		bankprocess.add(button_3);

		outputMethod_value = new JTextField();
		outputMethod_value.setVisible(false);
		outputMethod_value.setBounds(318, 327, 116, 21);
		bankprocess.add(outputMethod_value);
		outputMethod_value.setColumns(10);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account[accountCurrent].withdraw(Integer.parseInt(outputMethod_value.getText()));
				JOptionPane.showMessageDialog(null, "�ܾ� : " + account[accountCurrent].display());
			}
		});
		btnNewButton_1.setVisible(false);
		btnNewButton_1.setBounds(443, 326, 97, 23);
		bankprocess.add(btnNewButton_1);

		JButton button_4 = new JButton("���");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputMethod_label.setVisible(false);
				inputMethod_value.setVisible(false);
				btnNewButton.setVisible(false);
				outputMethod_label.setVisible(true);
				outputMethod_value.setVisible(true);
				btnNewButton_1.setVisible(true);

			}
		});
		button_4.setBounds(318, 210, 97, 23);
		bankprocess.add(button_4);

		JButton button_5 = new JButton("����");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "����");
				System.exit(0);
			}
		});
		button_5.setBounds(318, 259, 97, 23);
		bankprocess.add(button_5);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account[accountCurrent].deposit(Integer.parseInt(inputMethod_value.getText()));
				JOptionPane.showMessageDialog(null, "�ܾ� : " + account[accountCurrent].display());
			}
		});
		btnNewButton.setBounds(443, 326, 97, 23);
		bankprocess.add(btnNewButton);

		JPanel main = new JPanel();
		main.setBounds(0, 0, 787, 649);
		frame.getContentPane().add(main);

		JPanel register = new JPanel();
		register.setVisible(false);
		register.setBounds(0, 0, 787, 649);
		frame.getContentPane().add(register);
		register.setLayout(null);
		JButton btnNewButton_2 = new JButton("ó������");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				main.setVisible(true);
				register.setVisible(false);
				login.setVisible(false);
				bankprocess.setVisible(false);

			}
		});
		btnNewButton_2.setBounds(318, 378, 97, 23);
		bankprocess.add(btnNewButton_2);

		registerBtn_main = new JButton("ȸ������");
		registerBtn_main.setBounds(345, 182, 97, 23);
		registerBtn_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				register.setVisible(true);
			}
		});
		main.setLayout(null);
		main.add(registerBtn_main);

		JButton loginBtn_main = new JButton("�α���");
		loginBtn_main.setBounds(345, 215, 97, 23);
		loginBtn_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				register.setVisible(false);
				login.setVisible(true);
			}
		});
		main.add(loginBtn_main);

		JButton logout_main = new JButton("�α׾ƿ�");
		logout_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
		logout_main.setBounds(345, 248, 97, 23);
		main.add(logout_main);

		JButton exit_main = new JButton("����");
		exit_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "����");
				System.exit(0);
			}
		});
		exit_main.setBounds(345, 284, 97, 23);
		main.add(exit_main);

		JLabel idlb_register = new JLabel("ID �Է�");
		idlb_register.setBounds(60, 200, 246, 32);
		register.add(idlb_register);

		userid_register = new JTextField();
		userid_register.setBounds(318, 206, 116, 21);
		register.add(userid_register);
		userid_register.setColumns(10);

		JLabel pwlb_register = new JLabel("PW �Է�");
		pwlb_register.setBounds(60, 252, 246, 32);
		register.add(pwlb_register);

		userpw_register = new JTextField();
		userpw_register.setColumns(10);
		userpw_register.setBounds(318, 258, 116, 21);
		register.add(userpw_register);

		JButton submit_register = new JButton("Ȯ��");
		submit_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "����Ϸ�", "ȸ������", JOptionPane.PLAIN_MESSAGE);
				account[accountCount++] = new Account(userid_register.getText(), userpw_register.getText());
				main.setVisible(true);
				register.setVisible(false);
			}
		});
		submit_register.setBounds(60, 294, 97, 23);
		register.add(submit_register);

		login.setBounds(0, 0, 787, 571);
		frame.getContentPane().add(login);
		login.setLayout(null);

		JButton loginBtn_login = new JButton("�Է�");
		loginBtn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (login(loginid_login.getText(), loginpw_login.getText())) {
					JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");
					main.setVisible(false);
					register.setVisible(false);
					login.setVisible(false);
					bankprocess.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "�α��� ����");
				}
				;

			}
		});
		loginBtn_login.setBounds(126, 275, 97, 23);
		login.add(loginBtn_login);

		JLabel id_login = new JLabel("���̵�");
		id_login.setBounds(128, 180, 57, 15);
		login.add(id_login);

		JLabel pw_login = new JLabel("�н�����");
		pw_login.setBounds(128, 231, 57, 15);
		login.add(pw_login);

		loginid_login = new JTextField();
		loginid_login.setBounds(215, 177, 116, 21);
		login.add(loginid_login);
		loginid_login.setColumns(10);

		loginpw_login = new JTextField();
		loginpw_login.setColumns(10);
		loginpw_login.setBounds(215, 228, 116, 21);
		login.add(loginpw_login);

		JButton back_login = new JButton("ó������");
		back_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				register.setVisible(false);
				login.setVisible(false);
				bankprocess.setVisible(false);
			}
		});
		back_login.setBounds(234, 275, 97, 23);
		login.add(back_login);

	}
}


