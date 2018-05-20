/*********************************************************\
@Title : Entertainment.java
@author : Omer Sadiq
implements: Comparable
Abstract Class
Comments : Abstract super class for CD and Movie classes
overrides toString(), compareTo and equal methods.
\*********************************************************/






import java.util.*;
import java.lang.Object.*;
import java.io.*;


abstract class Entertainment implements Comparable{
//Private Variables
private double cost;
private int duration;

//Constructor
public Entertainment(){
cost = 0.00;
duration = 60;
}

public Entertainment(double c){
cost = c;
this.duration = 60;
}

public Entertainment(int r){
this.cost = 0.00;
duration = r;
}
//Constructor
public Entertainment(double c, int r){

cost = c;
duration = r;
}

//To String method
public String toString(){

String toString = null;

toString = cost+" "+duration;
return toString;
}

public double getCost(){

return cost;
}

public int getDuration(){

return duration;
}

public void setCost(double c){

this.cost = c;
}

public void setDuration(int r){

this.duration = r;
}
//Abstract method call
abstract public double getRating();


//CompareTo for Objects of subclasses
public int compareTo(Object o){

if(!(o instanceof Entertainment)) 
return 10;
Entertainment e = (Entertainment)o;
if(this.getRating() < e.getRating())
return -1;

else if(this.getRating() > e.getRating())
return 1;

else 
return 0;
}

//Equals method for objects of subclasses
public boolean equals(Object o){

Entertainment temp = (Entertainment)o;
if(!(o instanceof Entertainment))
return false;
if(this.getRating() == temp.getRating())
return true;

else 
return false;
}

}