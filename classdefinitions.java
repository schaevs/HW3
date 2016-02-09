import java.util.*;

public class classdefinitions{
	public static void main(String[] args){
		Sequence list = new Sequence();

        /*
	    list.add(new MyInteger(0),0);
		//printcheck(list);
		
	    list.add(new MyInteger(1),0);
		//printcheck(list);
		
	    list.add(new MyInteger(2),0);
		//printcheck(list);
		
	    list.add(new MyInteger(3),0);
		//printcheck(list);
		
	    list.add(new MyInteger(4),0);
		//printcheck(list);
		
		list.add(new MyInteger(5),5);
		//printcheck(list);
		
		list.add(new MyInteger(6),5);
		//printcheck(list);
		
		list.add(new MyInteger(7),7);
		//printcheck(list);
		
		list.add(new MyChar('f'),8);
		
		Sequence list2 = new Sequence();
		
		list2.add(new MyChar('O'),0);
		Sequence list4 = new Sequence();
		list4.add(new MyChar('G'),0);
		list2.add(list4,1);
		
		list.add(list2,1);
		
		Sequence list3 = list.copy();
		
		SequenceIterator it = new SequenceIterator();
		it = list3.begin();

		list3.Print();
		int fuck = 0;
		for (it = list3.begin(); !it.equal(list3.end()); it.advance()) {
			// not working because?
			
			System.out.println("I'm woking..." + fuck);
			fuck++;
			(it.sqPtr).n1.Print();
		} */
       
	}
	
	public static void printcheck(Sequence checkedSequence)
	{
		System.out.println("\n\nsequence count is: " + checkedSequence.length());
		for (int k = 0; k<checkedSequence.length(); k++){
			System.out.println("printing "+ ((checkedSequence.getLink(k)).n1).i);
		}
		
	}
}




