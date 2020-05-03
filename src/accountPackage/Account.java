package accountPackage;

import java.util.Iterator;


public class Account implements Comparable<Account> {
	
	int id;
	private String name;
	private String type;
	double balance;
	private int maxBalance;
	
	
	
	
	
	public Account(int id, String name, String type, double balance) throws InvalidAccountException {
		
		
		
		ValidationUtils.validateId(id);
		ValidationUtils.validateName(name);
		ValidationUtils.validateType(type);
		
		this.id = id;
		this.name = name;
		this.type = type;
		this.balance = balance;
		
		
	}
	
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", type=" + type + ", balance=" + balance + "]";
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		Account acc = (Account) obj;
		return acc.id == this.id;	
	}


	@Override
	public int compareTo(Account o) {
		
		return o.id-this.id;
	}





	
}
