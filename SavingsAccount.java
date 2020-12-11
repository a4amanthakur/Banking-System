class SavingsAccount extends BankAccount
{
		
	BankAccount acc;
	public SavingsAccount()
	{
		acc=new BankAccount();
	}
	public SavingsAccount(String num,String name,double bal)
	{
		super(num,name);
		this.accNum=num;
		this.accName=name;
		this.balance=bal;
	}	

	void addAccount(String num,String name,double bal)
	{
		acc.setAccountNum(num);
		acc.setAccountName(name);
		acc.setBalance(bal);
	}

	

	

}//end of class