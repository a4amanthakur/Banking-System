import java.util.*;
abstract class a
{
	LinkedList<String> l=new LinkedList<String>();
}
class test
{
	int a;
	String s;

	public static void main(String[] args) {
	 LinkedList<Double> obj=new LinkedList<Double>();
		obj.add(1.1);
		obj.add(11.1);
		obj.add(111.1);
		obj.add(1111.1);
		Iterator<Double> itr=obj.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}	
		System.out.println("2nd:"+obj.get(2));
		System.out.println("intdex of 2nd :"+obj.indexOf(11111111));
	}
}