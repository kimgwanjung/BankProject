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
		System.out.println("만드실 아이디를 입력하세요.");
		id = kb.next();
		System.out.println("만드실 비밀번호를 입력하세요.");
		pwd = kb.next();
		accounts.add(new Account(id,pwd));
		
	}
	public void login() {
		String id;
		String pwd;
		System.out.println("아이디를 입력하세요.");
		id = kb.next();
		System.out.println("비밀번호를 입력하세요.");
		pwd = kb.next();
		for(Account a : accounts) {
			if(a.getId().contains(id) && a.getPwd().contains(pwd)) {
				System.out.println("접속이 완료되었습니다.");
				
			}
			else {
				System.out.println("아이디 또는 비밀번호가 존재하지 않습니다");
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
		System.out.println("입금할 금액을 입력하세요");
		int amount = kb.nextInt();
		Account c = new Account(amount);
		c.deposit(amount);
		accounts.add(c);
		System.out.println(amount+"원이 입금되었습니다.");
	}
	public void withdraw() {
		System.out.println("출금할 금액을 입력하세요");
		int amount = kb.nextInt();
		Account c = new Account(amount);
		c.withdraw(amount);
		accounts.add(c);
		System.out.println(amount+"원이 출금되었습니다.");
	}
	public void check() {
		for(Account a : accounts) {
			System.out.println(a.getMoney()+"원 입니다");
		}
		
	}

}
