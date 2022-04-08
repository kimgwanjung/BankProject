package Bank;
public class Account {
	private String id;
	private String pwd;
	private int money;
	public Account(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	public Account(int money) {
		this.money = money;
	}
	public int getMoney() {
		return money;
	}
	public String getId() {
		return id;
	}
	public String getPwd(){
		return pwd;
	}
	public void deposit(int money) {
		this.money += money;
	}
	public void withdraw(int money) {
		this.money -= money;
	}
}
