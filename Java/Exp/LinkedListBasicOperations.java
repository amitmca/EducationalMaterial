import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator; 
public class LinkedListBasicOperations {
 
    public static void main(String a[]){
         
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("Orange");
        ll.add("Apple");
        ll.add("Grape");
        ll.add("Banana");
		
		Iterator<String> itr=ll.iterator();
		
		while(itr.hasNext())
			{
			System.out.println(itr.next());
			}
		//LinkedList<String> copy = (LinkedList<String>) ll.clone();
        //System.out.println("Cloned LinkedList:"+copy);
		
		ArrayList<String> al=new ArrayList<String>();
		al.add("Orange");
		al.add("Grape");
		System.out.println(ll.containsAll(al));
		al.add("Grape111");
		System.out.println(ll.containsAll(al));
       /* System.out.println(ll);
        System.out.println("Size of the linked list: "+ll.size());
        System.out.println("Is LinkedList empty? "+ll.isEmpty());
        System.out.println("Does LinkedList contains 'Grape'? "+ll.contains("Grape"));
		*/
    }
}