package accountPackage;

import java.util.Comparator;

public class BalanceComparator implements Comparator<Account>{
	
	
	@Override
	public int compare(Account o1, Account o2) {
		// TODO Auto-generated method stub
		return ((Double)(o1.getBalance())).compareTo(o2.getBalance());
	}
	
}
