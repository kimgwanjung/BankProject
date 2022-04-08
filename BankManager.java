package Bank;
import java.util.*;
public class BankManager {
	private static BankManager instance = new BankManager();
	private ArrayList<Account> accounts = new ArrayList<Account>();
	Scanner kb = new Scanner(System.in);
	private BankManager(){
		
	}
	public static BankManager getInstance() {
		return instance;
	}
	public void showMenu() {
		System.out.println("=======================");
		System.out.println("1. Join");
		System.out.println("2. Login");
		System.out.println("3. Exit");;
		System.out.println("=======================");
	}
	public void join() {
		String id;
		String pwd;
		System.out.println("����� ���̵� �Է��ϼ���.");
		id = kb.next();
		System.out.println("����� ��й�ȣ�� �Է��ϼ���.");
		pwd = kb.next();
		accounts.add(new Account(id,pwd));
		
	}
	public void login() {
		String id;
		String pwd;
		System.out.println("���̵� �Է��ϼ���.");
		id = kb.next();
		System.out.println("��й�ȣ�� �Է��ϼ���.");
		pwd = kb.next();
		for(Account a : accounts) {
			if(a.getId().contains(id) && a.getPwd().contains(pwd)) {
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				
			}
			else {
				System.out.println("���̵� �Ǵ� ��й�ȣ�� �������� �ʽ��ϴ�");
			}
		}
		
	}
	public void showBankMenu() {
		System.out.println("=======================");
		System.out.println("1. desposit");
		System.out.println("2. withdraw");
		System.out.println("3. check");;
		System.out.println("=======================");
	}
	public void deposit() {
		System.out.println("�Ա��� �ݾ��� �Է��ϼ���");
		int amount = kb.nextInt();
		Account c = new Account(amount);
		c.deposit(amount);
		accounts.add(c);
		System.out.println(amount+"���� �ԱݵǾ����ϴ�.");
	}
	public void withdraw() {
		System.out.println("����� �ݾ��� �Է��ϼ���");
		int amount = kb.nextInt();
		Account c = new Account(amount);
		c.withdraw(amount);
		accounts.add(c);
		System.out.println(amount+"���� ��ݵǾ����ϴ�.");
	}
	public void check() {
		for(Account a : accounts) {
			System.out.println(a.getMoney()+"�� �Դϴ�");
		}
		
	}

}
