/************************************************\
Class : Movie
Extends : Entertainment
@author : Omer Sadiq
Comments : Movie class, holds movie attributes
overrides toString
\************************************************/ 



class Movie extends Entertainment {

//Private Variables  : 
private String Title;
private int Acting;
private int Direction;
private int SoundTrack;
// Constructor
public Movie(String title){
Title = title;
}

public Movie(String title, int acting){
Title = title;
Acting = acting;
}

public Movie(String title, int acting, int direction){

Title = title;
Acting = acting;
Direction = direction;
}
//Constructor
public Movie(double cost, int duration,String title, int acting, int direction, int soundtrack){


super(cost, duration);

Title = title;
Acting = acting;
Direction = direction;
SoundTrack = soundtrack;
}
//toString method
public String toString(){

String MString = null;
MString = Title+" "+super.getCost()+" "+super.getDuration()+" "+Acting+" "+Direction+" "+SoundTrack;
return MString;
}
//Abstract method definition
public double getRating(){
double r;
r = (double)((Acting+Direction+SoundTrack)/3);
return r;
}

public double getCost(){

return super.getCost();
}

public int getDuration(){

return super.getDuration();
}

public int getActing(){

return Acting;
}

public int getDirection(){

return Direction;
}

public int getSoundTrack(){

return SoundTrack;
}

public String getTitle(){

return Title;
}

public void setTitle(String title){

Title = title;
}

public void setActing(int i){

Acting = i;
}

public void setDirection(int j){

Direction = j;
}

public void setSoundTrack(int k){

SoundTrack = k;
}

//Local Compare to method for comparing by Name
public int CompareTo(Object o){

Movie tmp = (Movie)o;
String one;
String two;
one = this.getTitle();
two = tmp.getTitle();
int i = 0;
while(i<one.length()){
if(one.charAt(i)> two.charAt(i))
return 1;
if(one.charAt(i)<two.charAt(i))
return -1;
i++;
}
return 0;
}





}