abstract class BankAccount
{
	private String accountNumber;
	private String accountName;
	private double balance;
		
	public BankAccount(String accountNumber,String accountName)
	{
			this.accountNumber=(accountNumber);
			this.accountName=(accountName);	
			this.balance=(0.0);
	}

    public String accessAccountNum()
    {
    	return accountNumber;
    }

	public String accessAccountName()
	{
		return accountName;
	}

	
	public double accessBalance()
	{
		return balance;
	}


	public void setAccountNum(String num)
    {
    	accountNumber.add(num);
    }

	public void setAccountName(String name)
    {
    	accountName.add(name);
    }
	public void setBalance(double bal)
    {
    	balance.add(bal);
    }

	

	public boolean deposit(double amount);

	public boolean withdraw(double amount);

	public String toString()
	{
		return "Account No. = "+this.accountNumber+" :: Name = "+this.accountName+" :: Balance = "+this.balance;
	}
}