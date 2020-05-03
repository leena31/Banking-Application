package accountPackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;





public class Tester {

	private static double balance;

	public static void main(String[] args) throws InvalidAccountException {
		
		
		List<Account> account = new ArrayList<Account>();
		
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			System.out.println("CHOOSE THE ACTION");
			System.out.println("1 : ADD ACCOUNT");
			System.out.println("2 : DISPLAY ACCOUNT USING ID");
			System.out.println("3 : DISPLAY ALL ACCOUNT");
			System.out.println("4 : DELETE ACCOUNT USING ID");
			System.out.println("5 : WITHDRAW AMOUNT");
			System.out.println("6 : DEPOSIT AMOUNT");
			System.out.println("7 : TRANSFER AMOUNT");
			System.out.println("8 : ACCOUNT HOLDING HIGHEST BALANCE");
			System.out.println("9 : ACCOUNT HOLDING LOWEST BALANCE");
			System.out.println("0 : EXIT");
			System.out.println("----------------------------------------------");
			
			int choice = scan.nextInt();
			
			switch(choice)
			{
			case 1: 
				try {
					Scanner input = new Scanner(System.in);
					
					System.out.println("Enter ID: ");
					int ip1 = input.nextInt();
					System.out.println("Enter Name: ");
					String ip2 = input.next();
					System.out.println("Enter Account Type: \n Saving / Current: ");
					String ip3 = input.next();
					System.out.println("Enter Amount: ");
					double ip4 = input.nextDouble();
					
					Account acc = new Account(ip1,ip2,ip3,ip4);
					
					
					if(account.contains(acc))
					{
						System.out.println("Account Already Exists!");
					}
					else {
						account.add(acc);
						System.out.println("Account Added: \n" + acc);
					}
					System.out.println("----------------------------------------------");
				} catch (InvalidAccountException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
				
			case 2: 
				System.out.println("Enter ID to Display Account: ");
				int id11 = scan.nextInt();
				
				Account tem = new Account();
				tem.setId(id11);
				
				int index = account.indexOf(tem);
				if(index != -1)
				{
					System.out.println(account.get(index));
				}
				else
				{
					System.out.println("Account Does Not Exist.");
				}
			
				System.out.println("----------------------------------------------");
				break;
				
				
			case 3: 
				
				for(Account ac: account)
				{
					System.out.println(ac);
				}
				System.out.println("----------------------------------------------");
				break;
				
				
			case 4: 
				System.out.println("Enter ID to delete Account: ");
				int id1 = scan.nextInt();
				
				Account tem1 = new Account();
				tem1.setId(id1);
				
				int index1 = account.indexOf(tem1);
				if(index1 != -1)
				{
					System.out.println(account.get(index1));
					account.remove(index1);
				}
				else
				{
					System.out.println("Account Does Not Exist.");
				}
				System.out.println("Remaining Accounts: ");
				for(Account ac: account)
				{
					System.out.println(ac);
				}
				System.out.println("----------------------------------------------");
				break;
				
				
			case 5: 
				System.out.println("Enter ID of Your Account: ");
				int id2 = scan.nextInt();
		
				System.out.println("Enter Amount to Withdraw: ");
				double amount = scan.nextDouble();
				
				Iterator iterator;
				Iterator<Account> it = account.iterator();
				while(it.hasNext()) 
				{
					Account acc1 = it.next();
					if(id2 == acc1.getId() ) 
					{
						if(acc1.balance>=amount)
						{
							acc1.balance -= amount;
							System.out.println("Remaining Balance: "+ acc1.balance);
						}
						else 
						{
							System.out.println("Insufficient Balance");
						}
						
					}
				}

				System.out.println("----------------------------------------------");
				break;
				
				
			case 6: 
				System.out.println("Enter ID of Your Account: ");
				int id3 = scan.nextInt();
		
				System.out.println("Enter Amount to Deposit: ");
				double amount1 = scan.nextDouble();
				
				
				Iterator iterator1;
				Iterator<Account> it1 = account.iterator();
				while(it1.hasNext()) 
				{
					Account acc1 = it1.next();
					if(id3 == acc1.getId() ) 
					{
						if(acc1.balance>=amount1)
						{
							acc1.balance += amount1;
							System.out.println("Deposited Successfully...");
							System.out.println("Account Balance: "+ acc1.balance);
							break;
						}
						
					}
				}

				System.out.println("----------------------------------------------");
				break;
				
				
			case 7: 
				System.out.println("Enter ID of Source Account: ");
				int id4 = scan.nextInt();
				
				System.out.println("Enter ID of Destination Account: ");
				int id5 = scan.nextInt();
				
				// Source account activity
				
				System.out.println("Enter Amount to be transfer: ");
				double amount2 = scan.nextDouble();
				
				Iterator iterator2;
				Iterator <Account> it2 = account.iterator();
				while(it2.hasNext())
				{
					Account acc2 = it2.next();
					if(id4 == acc2.getId())
					{
						if(acc2.balance>=amount2)
						{
							acc2.balance = acc2.balance - amount2;
							System.out.println("Amount Transferred Successfully... \n"+ "Remaining Balance: " + acc2.balance);
						}
						else
						{
							System.out.println("Low Balance !");
						}
					}
				}
				
				 
				// Destination account Activity
				
				Iterator iterator3;
				Iterator <Account> it3 = account.iterator();
				while(it3.hasNext())
				{
					Account acc3 = it3.next();
					if(id5 == acc3.getId())
					{
						if(acc3.balance>=amount2)
						{
							acc3.balance = acc3.balance + amount2;
						
						}
					}
				}
				System.out.println("----------------------------------------------");
				break;
				
				
			case 8: 
				BalanceComparator b2 = new BalanceComparator();
				Collections.sort(account,b2);
				
				System.out.println("Maximum Balance Account: "+ (account.get(account.size()-1)));
				System.out.println("----------------------------------------------");
				
				break;
				
				
			case 9: 
				
				BalanceComparator b1 = new BalanceComparator();
				Collections.sort(account,b1);
				
				System.out.println("Minimum Balance Account:"+ account.get(0));
				
				System.out.println("----------------------------------------------");
				
			case 0: 
				System.exit(0);
				System.out.println("----------------------------------------------");
				break;
				
				
			default:
				System.out.println("INVALID CHOICE");
				System.out.println("----------------------------------------------");
				break;
			}
		}
		
		

	}

}
