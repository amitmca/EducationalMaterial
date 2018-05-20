/****************************************************************\
@author : Omer Sadiq
@Title : TestEntertainment.java
Definition : Class for testing the Entertainment classes
Comments: This program is solely a DOS program and handles
basic functions of a Movie shop database. It also uses Files
to save the Data, i had had a little bit of success using the
RandomAccessFile to load the data from the File, but last minute
problems forced me to keep that function out of the program. I
have included that program in the comments to give you an idea of
how i was going about it. Please read it and let me know of any
suggestions. 
Extra Features:
1. Filing(Save)
	for both the CD and Movie Objects.
2. SearchModified:
	i have modified the search by name algorithm so that if an 
	element is not found, the closest matches are returned. 
\****************************************************************/







import java.awt.*;
import java.io.*;
import java.lang.Object.*;
import java.util.*;

public class TestEntertainment{
//Static Variables and objects
static Movie aMovie;
static CD aCD;
static private Vector list = new Vector();
static private Vector listb = new Vector();
static RandomAccessFile writer=null;
static RandomAccessFile reader=null;


public static void main(String[] args){
int choice;
while(true){
//Call to method
firstScreen();
choice = Integer.parseInt(readInput());
//Get user choice
switch(choice)
{
case 1:
	//Call to method
	AddMovie();
	
	break;
	

case 2:
	//Call to method
	AddCD();
	break;
	
	
case 3:
	//Call to method
	listb();
	break;
	
case 4:
	//Call to method
	list();
	break;
	
case 5:
	{//Prompt user
	System.out.println("Enter the Name of the Movie: ");
	String s = readInput();
	//Check for match ignoring case
	for(int i = 0;i<list.size();i++)
		{
			if(s.equalsIgnoreCase(((Movie)list.elementAt(i)).getTitle()))
				{
				System.out.println("The Rating For the Movie"+s+"is"+((Movie)list.elementAt(i)).getRating());
				break;
				}
		}			
		System.out.println("Record Not Found \n Check Name and Try Again");
		}
	break;
	
case 6:
	{//Prompt user
	System.out.println("Enter the Label Of the CD : ");
	String t = readInput();
	//Check for match ignoring case
	for(int i = 0;i<listb.size();i++)
		{
			if(t.equalsIgnoreCase(((CD)listb.elementAt(i)).getLabel()))
				{
				System.out.println("The Rating For the Movie"+t+"is"+((CD)listb.elementAt(i)).getRating());
				break;
			}
		}			
		System.out.println("Record Not Found \n Check Name and Try Again");
		}
	break;
	
case 7:
	//Call to method
	sortMR();
	break;
	
case 8:
	//Call to method
	sortCR();
	break;

case 9:
	//Call to method
	sortMT();
	break;
	
case 10:
	//Call to method
	sortCT();
	break;

case 11:
	//Prompt user
	System.out.println("Enter the Name of the Movie: ");
	//Call to method
	searchMov(readInput());
	break;
	
case 12:
	//Prompt user
	System.out.println("Enter the Label Of the CD : ");
	//Call to method
	searchCD(readInput());
	break;
	
case 13:
	//My local method to clear screen
	clrscr();
	//Prompt user to save lists
	System.out.println("\n\n Do you want to Save ? Y/N \n");
char x;
x = (readInput().charAt(0));

switch(x)
{
case 'y':
//Call to save method
save();
//Call to save CD object method
saveCD();
break;
case 'Y':
save();
saveCD();
break;
case 'n':
break;
case 'N':
break;
}
	return;	
	

default: 
System.out.println("Invalid Selection");

}
}
}

//Method to clearscreen uses linefeeds
public static void clrscr(){
System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

}

//Method to input data from user
//returns string
public static String readInput(){

System.out.println("");

int number =0;
String myString = null;
//Init. Input Stream Reader
InputStreamReader myReader = new InputStreamReader(System.in);
//Init. Buffered REader
BufferedReader in = new BufferedReader(myReader);
try{
//REad line 
myString = in.readLine();

if(myString == null){
System.out.println("\n ERror: No String Entered ");
return null;
}
return myString;

}
//catch any IO exceptions
catch(IOException e){

System.out.println("\n Error : " + e);
}
return myString;
}

//Method firstScreen
//Displays options to user
public static void firstScreen(){

System.out.println(" [1] Add  A New Movie.\n");
System.out.println(" [2] Add  A New CD.\n");
System.out.println(" [3] View List Of CDs.\n");
System.out.println(" [4] View List Of Movies.\n");
System.out.println(" [5] View Movie Rating.\n");
System.out.println(" [6] View CD Rating.\n");
System.out.println(" [7] Sort Movies By Rating.\n");
System.out.println(" [8] Sort CDs By Rating.\n");
System.out.println(" [9] Sort Movies By Title.\n");
System.out.println("[10] Sort CDs By Title.\n");
System.out.println("[11] Search For a Movie.\n");
System.out.println("[12] Search For a CD.\n");
System.out.println("[13] Save And|Or Exit Proram.\n");
}

//Method to add data into list
public static void AddMovie(){
clrscr();
int a,b,c,e;
double f;
System.out.println("\n\n Enter the Name :");
String d;
d = readInput();
System.out.println("\n\n Enter the Cost: ");
f = Double.parseDouble(readInput());
System.out.println("\n\n Enter the Duration(Mins.) of the Movie : ");
e = Integer.parseInt(readInput());
System.out.println("\n\n Entre Acting Score From 1 - 5:");
a = Integer.parseInt(readInput());
System.out.println("\n\n Enter Direction Score Frome 1 - 5:");
b = Integer.parseInt(readInput());
System.out.println("\n\n Enter the Sound Track score From 1 - 5:");
c = Integer.parseInt(readInput());

aMovie = new Movie(f,e,d,a,b,c);
//Add into list
list.addElement(aMovie);
clrscr();
System.out.println("\n\n The Movie " +aMovie.getTitle()+" has been added\n\n\n\n");

}
//Method to save Movie Objects
public static void save(){
long xyz = 0;

        try{//Create RandomAccessFile
	       writer= new RandomAccessFile("Movie.txt","rw");
	       //xyz = writer.setFilePointer(null);
	       
	       writer.seek(0);
	       System.out.println(""+writer.length());
	       //writer.writeChars("\n ");
	       for(int i = 0;i<list.size();i++)
	       {
	        System.out.println((list.elementAt(i)).toString());
	   	   	//SAve
	   	   	writer.writeUTF(""+(list.elementAt(i)).toString());
	   	   }
		   
		   xyz = writer.getFilePointer();
	       //System.out.println(""+xyz);
		   //Close RandomAccessFile
		   writer.close();
	 System.out.println("Your Record Was Saved Successfully\n");
	       
        }   
        //Catch Exceptions
	   catch (FileNotFoundException e) {
	    System.err.println("This shouldn't happen: " + e);
	   } 
	    
       catch(IOException e){
	   System.out.println(e.toString());
       }
    }
    
//Method to Sort Movie objects
//Sorts by rating
public static void sortMR(){

	//Selection sort method for score
	int i = 0;
	int j;
	Movie tempi;
	Movie tempj;
	Movie temp;
	//Sort Formula
	for(i=0;i<list.size()-1;i++)
	    {
		for(j = i+1;j<=list.size()-1;j++)
		    {
			//search through all records
			tempi =(Movie)(list.elementAt(i));
			tempj =(Movie)(list.elementAt(j));
			if(tempi.compareTo(tempj) == 1)
			    {
				//swap if not in order
				temp = tempi;
				tempi = tempj;
				tempj = temp;
			    }
			//set elements in sorted order
			list.setElementAt(tempi,i);
			list.setElementAt(tempj,j);
		    }
	    }   	
		list();	
	} // EndSort








//List Elements
//Displays List
public static void list(){

clrscr();

System.out.println("Name\t  Cost\t Duration     Acting\t Direction\tSoundTrack\tRating");
   System.out.println("============================================================================");
for(int i = 0;i<list.size();i++)
	{
	
	System.out.print("\n"+((Movie)(list.elementAt(i))).getTitle());
	System.out.print("\t   ");
	System.out.print(""+((Movie)(list.elementAt(i))).getCost());
	System.out.print("\t  ");
	System.out.print(""+((Movie)(list.elementAt(i))).getDuration());
	System.out.print("\t      ");
	System.out.print(""+((Movie)(list.elementAt(i))).getActing());
	System.out.print("\t\t ");
	System.out.print(""+((Movie)(list.elementAt(i))).getDirection());
	System.out.print("          \t");
	System.out.print(""+(((Movie)list.elementAt(i))).getSoundTrack());
	System.out.print("\t      ");
	System.out.print(""+(((Movie)list.elementAt(i))).getRating());
	System.out.print("\n");
	}
	System.out.println("Press any key to Continue...");
	String p = readInput();
}

//List for CD objects
public static void listb(){


clrscr();
System.out.println("Artist\t  Cost\t Duration     Label\t Vocals\tAccompaniment\tRating");
   System.out.println("============================================================================");
for(int i = 0;i<listb.size();i++)
	{
	
	System.out.print("\n"+((CD)(listb.elementAt(i))).getArtist());
	System.out.print("\t   ");
	System.out.print(((CD)(listb.elementAt(i))).getLabel());
	System.out.print("\t   ");
	System.out.print(((CD)(listb.elementAt(i))).getCost());
	System.out.print("\t  ");
	System.out.print(((CD)(listb.elementAt(i))).getDuration());
	System.out.print("\t      ");
	System.out.print(((CD)(listb.elementAt(i))).getVocals());
	System.out.print("         \t");
	System.out.print((((CD)listb.elementAt(i))).getAccompaniment());
	System.out.print("\t      ");
	System.out.print((((CD)listb.elementAt(i))).getRating());
	System.out.print("\n");
	}
	System.out.println("Press any key to Continue...");
	String p = readInput();
}



//Adds CD objects to list vector

public static void AddCD(){
clrscr();
int a,b,e;
double f;
System.out.println("\n\n Enter the Artist :");
String d,c;
d = readInput();
System.out.println("\n\n Enter the Cost: ");
f = Double.parseDouble(readInput());
System.out.println("\n\n Enter the Duration(Mins.) of the Movie : ");
e = Integer.parseInt(readInput());
System.out.println("\n\n Enter Vocal Score From1 - 5:");
a = Integer.parseInt(readInput());
System.out.println("\n\n Enter Accompaniment Score Frome 1 - 5:");
b = Integer.parseInt(readInput());
System.out.println("\n\n Enter the Label:");
c = readInput();

aCD = new CD(f,e,d,c,a,b);

listb.addElement(aCD);
clrscr();
System.out.println("\n\n The CD " +aCD.getLabel()+" has been added\n\n\n\n");

}

//Sort by title
public static void sortMT(){

int i = 0;
	int j;
	Movie tempi;
	Movie tempj;
	Movie temp;
	//Sort Mechanism
	for(i=0;i<list.size()-1;i++)
	    {
		for(j = i+1;j<=list.size()-1;j++)
		    {
			//search through all records
			tempi =(Movie)(list.elementAt(i));
			tempj =(Movie)(list.elementAt(j));
			if(tempi.CompareTo(tempj) == 1)
			    {
				//swap if not in order
				temp = tempi;
				tempi = tempj;
				tempj = temp;
			    }
			//set elements in sorted order
			list.setElementAt(tempi,i);
			list.setElementAt(tempj,j);
		    }
	    }   	
			
list();
}


//Sort by Rating CD objects
public static void sortCR(){

	//Selection sort method for score
	int i = 0;
	int j;
	CD tempi;
	CD tempj;
	CD temp;
	
	for(i=0;i<listb.size()-1;i++)
	    {
		for(j = i+1;j<=listb.size()-1;j++)
		    {
			//search through all records
			tempi =(CD)(listb.elementAt(i));
			tempj =(CD)(listb.elementAt(j));
			if(tempi.compareTo(tempj) == 1)
			    {
				//swap if not in order
				temp = tempi;
				tempi = tempj;
				tempj = temp;
			    }
			//set elements in sorted order
			listb.setElementAt(tempi,i);
			listb.setElementAt(tempj,j);
		    }
	    }   	
		listb();	
	} // selectionSort



//Sort by Label CD objects
public static void sortCT(){

int i = 0;
	int j;
	CD tempi;
	CD tempj;
	CD temp;
	
	for(i=0;i<listb.size()-1;i++)
	    {
		for(j = i+1;j<=listb.size()-1;j++)
		    {
			//search through all records
			tempi =(CD)(list.elementAt(i));
			tempj =(CD)(list.elementAt(j));
			if(tempi.CompareTo(tempj) == 1)
			    {
				//swap if not in order
				temp = tempi;
				tempi = tempj;
				tempj = temp;
			    }
			//set elements in sorted order
			listb.setElementAt(tempi,i);
			listb.setElementAt(tempj,j);
		    }
	    }   	
			
listb();
}

//Search By Movie name
public static  void searchMov(String n){
	//search for given name
	
	for(int i = 0;i<=list.size()-1;i++)
	    {
		//go through all list
		if(n.equalsIgnoreCase(((Movie)(list.elementAt(i))).getTitle()))
		    {
			//if element found in list, print position found at
			System.out.println("Element Found at Row : "+i+1);
			System.out.println(""+((Movie)(list.elementAt(i))).toString());
			break;
		    }
		
		else
			{
			//if name not found
			//search for closest match
			String match;
			int fname; 
			int count = 0;	
			match = (String)((Movie)(list.elementAt(i))).getTitle();
			System.out.println("Closest Matches");
			if(match.length()<n.length())
				{
				
				fname = match.length()-1;
				}
			else
				{
				fname = n.length()-1;
				}
			
			for(int j = 0;j<=fname;j++)
				{
				if(match.charAt(j)==n.charAt(j))
					{
					count++;
					}
				}
				if(count>2)
					//{
					System.out.println("\n\n\n Match = "+((StudentRecord)(list.elementAt(i))).toString());
					//}
			}	

	    }
    }




//Search For CD Label
public static  void searchCD(String n){
	//search for given name
	
	for(int i = 0;i<=listb.size()-1;i++)
	    {
		//go through all list
		if(n.equalsIgnoreCase(((CD)(listb.elementAt(i))).getLabel()))
		    {
			//if element found in list, print position found at
			System.out.println("Element Found at Row : "+i+1);
			System.out.println(""+((CD)(listb.elementAt(i))).toString());
			break;
		    }
		
		else
			{
			//if name not found
			//search for closest match
			String match;
			int fname; 
			int count = 0;	
			match = (String)((CD)(listb.elementAt(i))).getLabel();
			System.out.println("Closest Matches");
			if(match.length()<n.length())
				{
				
				fname = match.length()-1;
				}
			else
				{
				fname = n.length()-1;
				}
			
			for(int j = 0;j<=fname;j++)
				{
				if(match.charAt(j)==n.charAt(j))
					{
					count++;
					}
				}
				if(count>2)
					//{
					System.out.println("\n\n\n Match = "+((CD)(listb.elementAt(i))).toString());
					//}
			}	

	    }
    }


//Save CD List
public static void saveCD(){
long xyz = 0;

        try{
	       reader= new RandomAccessFile("CD.txt","rw");
	       //xyz = writer.setFilePointer(null);
	       
	       reader.seek(0);
	       System.out.println(""+reader.length());
	       //writer.writeChars("\n ");
	       for(int i = 0;i<listb.size();i++)
	       {
	        System.out.println((listb.elementAt(i)).toString());
	   	   	reader.writeUTF(""+(listb.elementAt(i)).toString());
	   	   }
		   
		   xyz = reader.getFilePointer();
	       //System.out.println(""+xyz);
		   reader.close();
	 System.out.println("Your CD Records Were Saved Successfully\n");
	       
        }   
	   catch (FileNotFoundException e) {
	    System.err.println("This shouldn't happen: " + e);
	   } 
	    
       catch(IOException e){
	   System.out.println(e.toString());
       }
    }




}

//Here is the LoadList function, i had it working when i left 
//Prof. Brink's Office, I have spent most of my time on this
//Althought i could not get it to work, i have learnt a lot
//about file handling in jave because of this. 
//Ask Prof. Brink if you dont believe me!:)
/*
public static void loadList(){

clrscr();
listb = new Vector();
String List = null;
String myString = null;
try{
writer = new RandomAccessFile("Movie.txt","r");
long x = writer.getFilePointer();
writer.seek(0);
Movie Temp = new Movie("Temp");
StringTokenizer Token; 	 
int b = 0;
while((int)writer.getFilePointer()< writer.length())
	{
	 List = writer.readUTF();
	 System.out.println(List);
	 
	 Token = new StringTokenizer(List," ");	
	 	//myString = Token.nextToken();
	 	myString = Token.nextToken();
	 	System.out.println("Cost: '" + myString + "'");
	 	Temp.setCost(Double.parseDouble(myString));
	 	myString = Token.nextToken();
	 	System.out.println("Duration: '" + myString + "'");
	 	Temp.setDuration(Integer.parseInt(myString));
	 	myString = Token.nextToken();
	 	System.out.println("Title: '" + myString + "'");
	 	Temp.setTitle(""+myString);
	 	myString = Token.nextToken();
	 	System.out.println("Acting: '" + myString + "'");
	 	Temp.setActing(Integer.parseInt(myString));
		myString = Token.nextToken();
	 	System.out.println("Direction: '" + myString + "'");
		Temp.setDirection(Integer.parseInt(myString));
		myString = Token.nextToken();
		
	 	System.out.println(myString);
	 	System.out.println("ST : "+myString);
		Temp.setSoundTrack(Integer.parseInt(myString));
		listb.addElement(Temp);
		b++;
		
		System.out.println(""+List);
	}
   }
   catch(IOException e){
   System.out.println("File Not Found");
   }
   
}
 
*/


