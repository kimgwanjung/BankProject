package structural;

import java.util.Scanner;

public class Account {
	 public static int totalCount = 0;
	    public int money = 0;
	    public String id = null;
	    public String pw = null;
	 
	    public Account() {
	        totalCount++;
	    }
	    public Account(String id, String pw) {
	        this();
	        this.id = id;
	        this.pw = pw;
	    }
	    public boolean isLogin(String id, String pw) {
	        boolean retrunValue = false;
	        if (this.id.equals(id) && this.pw.equals(pw)) {
	            retrunValue = true;
	        }
	        return retrunValue;
	    }
	    public int display() {
	    	System.out.println("Id : " + id);
	    	System.out.println("Money : " + money);
	    	return money;
	    }
	    public void deposit(int money) {
	        this.money += money;
	    }
	    public void withdraw(int money) {
	        this.money -= money;
	    }
	    public void menu() {
	        Scanner sc = new Scanner(System.in);
	        String inputString = null;
	        boolean falg = true;
	 
	        while (falg) {
	            System.out.println(" ");
	            System.out.println("1.입금 2.출금 3.종료");
	            inputString = sc.nextLine();
	            switch (inputString) {
	            case "1":
	                display();
	                System.out.println("입글할 금액을 입력하세요.");
	                int money = Integer.parseInt(sc.nextLine());
	                deposit(money);
	                System.out.println(" ");
	                display();
	                break;
	            case "2":
	                display();
	                System.out.println("출금할 금액을 입력하세요.");
	                money = Integer.parseInt(sc.nextLine());
	                withdraw(money);
	                System.out.println(" ");
	                display();
	                break;
	            case "3":
	                System.out.println("종료합니다.");
	                falg = false;
	                break;
	            default:
	                System.out.println("잘못 입력하셨습니다.");
	            }
	        }
	    }
}
