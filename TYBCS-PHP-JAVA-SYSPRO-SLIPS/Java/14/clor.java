import java.io.*;
import java.util.*;
public class red
{
	public static void main(String[] args)
	{
	LinkedList lr=new LinkedList();
	lr.add("red");
	lr.add("blue");
	lr.add("yellow");
	lr.add("orange");
	ListIterator litr=lr.listIterator();
	while(litr.hasNext())
	{
		String elt=(String)litr.next();
		System.out.println(elt);
		litr.set("" + elt);
	}
	System.out.println("revrerse order: ");
	while(litr.hasPrevious())
		System.out.println(litr.previous());

 System.out.println("After inserting pink & green:");
             
        LinkedList lr1=new LinkedList();
        lr1.add("red");
        lr1.add("blue");
        lr1.add("yellow");
        lr1.add("orange");
        lr1.add(2,"pink");
        lr1.add(3,"green");

        ListIterator litr1=lr1.listIterator();
        while(litr1.hasNext())
        {
                String elt1=(String)litr1.next();
                System.out.println(elt1);
                litr1.set("" + elt1);
        }
}
}
