import java.util.Scanner;
import java.util.*;
class BankingSystem
{
		Scanner sc;
		int choice;
		int totalAcc=0;
		String num,name;
		double bal;

		//BankAccount savingAccObj;
		LinkedList<String> accountNumber=new LinkedList<String>();
		LinkedList<String> accountName=new LinkedList<String>();
		LinkedList<Double> balance=new LinkedList<Double>();
		LinkedList<String> accType=new LinkedList<String>();

	BankingSystem()
	{
		sc=new Scanner(System.in);
		//savingAccObj=new SavingsAccount();
	}

	void menu()
	{
		do
		{
			System.out.println("=========================================");
			System.out.println("1. Create a new account.");
			System.out.println("2. Deposite the money.");
			System.out.println("3. Withdraw the money.");
			System.out.println("4. Transfer the money between two accounts.");
			System.out.println("5. Compound the interest.");
			System.out.println("6. Display all accounts.");
			System.out.println("7. Exit the program.");			
			System.out.println("=========================================");
			System.out.print("Enter your choice (from 1 to 7) : ");
			choice=sc.nextInt();

			switch(choice)
			{
				case 1:
				{
					createAccount();
					break;
				}
				case 2:
				{

				    depositeAmount();
					break;
				}
				case 3:
				{
					WithdrawAmount();
					break;
				}
				case 4:
				{
					transferMoney();
					break;
				}
				case 5:
				{
					calculateInterest();
					break;
				}
				case 6:
				{
					displayAllAcc();
					break;
				}
				case 7:
				{
					System.out.println("Exiting the system...");
					System.exit(0);
					break;
				}
				default:
				{
					System.out.println("Please enter a valid option(from 1 to 7).");
					break;
				}
			}//end of switch-case
		}while(choice!=7);//end of do whiel


	}


		void calculateInterest()
		{
					System.out.println("Calculating the interest of saving account...");
					Iterator<String> itr=accountNumber.iterator();
					
					while(itr.hasNext())
					{
						int index=accountNumber.indexOf(itr.next());
						double percent=balance.get(index)*((1.0/12.0)/100.0);
						double money=(balance.get(index)+percent);
						balance.add(index,money);
					}
					System.out.println("Intrest updated successfully.");
		}
		void transferMoney()
		{
			System.out.println("Transfering money...");
			sc.nextLine();

			//sender
			System.out.println("Enter your account number to deduct money: ");
			String sender=sc.nextLine();

			//check both acc. are valid or not:
			int sindex=accountNumber.indexOf(sender);

			

			if(sindex==-1)
			{
				System.out.println("Warning: Sender Account is not exist.");
			}
			else
			{
				System.out.println("Enter amount to transfer:");
				bal=sc.nextDouble();
				balance.add(sindex,balance.get(sindex)-bal);
				System.out.println("Transaction Successfull.");
				System.out.println("Deducted balance :"+bal);
				System.out.println("Your total balance :"+balance.get(sindex));
			}



			//receiver
			sc.nextLine();
			System.out.println("Enter receiver account number to send money: ");
			String rec=sc.nextLine();

			int rindex=accountNumber.indexOf(rec);
			if(rindex==-1)
			{
				System.out.println("Warning: Receiver Account is not exist.");
			}
			else
			{
				balance.add(rindex,(balance.get(rindex)+bal));
			}

		}
		void WithdrawAmount()
		{
			sc.nextLine();
			System.out.println("Withdraw money...");
			System.out.println("Enter money to Withdraw:");
			bal=sc.nextDouble();

			if(withdraw(bal)==false)
			{
				System.out.println("Warning : Not a valid account.");
			}

		}

		//ading money
		boolean withdraw(double b)
		{
			sc.nextLine();
			System.out.println("enter your account number:");
			num=sc.nextLine();

			int index=accountNumber.indexOf(num);
			if(index==-1)
			{
				return false;
			}
			else
			{
				double currentBal=balance.get(index);
				if(currentBal<b)
				{
					System.out.println("Warning: Not sufficient balance.");
				}
				else
				{
					balance.add(index,(currentBal-b));
					System.out.println("Now Total balance : "+balance.get(index));
					
				}
				return true;
			}
		}


		void depositeAmount()
		{
			sc.nextLine();
			System.out.println("Deposite money...");
			System.out.println("Enter money to Deposite:");
			bal=sc.nextDouble();

			if(deposite(bal)==false)
			{
				System.out.println("Warning : Not a valid account.");
			}

		}

		//ading money
		boolean deposite(double b)
		{
			sc.nextLine();
			System.out.println("enter your account number:");
			num=sc.nextLine();

			int index=accountNumber.indexOf(num);
			if(index==-1)
			{
				return false;
			}
			else
			{
				balance.add(index,(balance.get(index)+b));
				System.out.println("Now Total balance : "+balance.get(index));
				return true;
			}
		}

		void displayAllAcc()
		{
					System.out.println("Displaying all account");
					Iterator<String> itr1=accountNumber.iterator();
					Iterator<String> itr2=accountName.iterator();
					Iterator<Double> itr3=balance.iterator();
					while(itr1.hasNext() && itr2.hasNext() && itr3.hasNext())
					{
						System.out.println(itr1.next()+" , "+itr2.next()+" , "+itr3.next());
					}
		}
		void createAccount()
		{
					System.out.println("Creating new account.......");
					System.out.println("enter your account number : ");
					sc.nextLine();
					num=sc.nextLine();
					int valid=accountNumber.indexOf(num);
					if(valid==-1)
					{
						accountNumber.add(totalAcc,num);
						System.out.println("enter your account name : ");
						name=sc.nextLine();
						accountName.add(totalAcc,name);
					
						System.out.println("enter your beginning balance : ");
						bal=sc.nextDouble();
						balance.add(totalAcc,bal);


						totalAcc++;
						System.out.println("Account created");
					}
					else
					{
						System.out.println("Warning : Account number already exist.");
					}
					
		}


	public static void main(String[] args) 
	{
		BankingSystem obj=new BankingSystem();
		obj.menu();
	}//end of main()
}//end of class