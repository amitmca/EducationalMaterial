/***************************************************\
@author: Omer Sadiq
@Title : CD
Extends : Entertainment
Comments : CD class, holds and groups the variables for
Object CD, overrides toString method
\****************************************************/




class CD extends Entertainment {

//Private Variables
private double Cost;
private int Duration;
private String Artist;
private String Label;
private int Vocals = 0;
private int Accompaniment = 0;

//Constructor
public CD(String artist){
Artist = artist;
}

public CD(String artist, String label){
Artist = artist;
Label = label;
}
//Constructor
public CD(double cost, int duration, String artist,String label,int vocals, int accompaniment){

super(cost, duration);
Artist = artist;
Label = label;
Vocals = vocals;
Accompaniment = accompaniment;
}
//toString()
public String toString(){

String MString = null;
MString = Artist+" "+super.getCost()+" "+super.getDuration()+" "+Label+" "+Vocals+" "+Accompaniment;
return MString;
}
//Abstract method definition
public double getRating(){
double r;
r = (double)((Vocals + Accompaniment)/3);
return r;
}

public double getCost(){

return super.getCost();
}

public int getDuration(){

return super.getDuration();
}

public int getVocals(){

return Vocals;
}

public int getAccompaniment(){

return Accompaniment;
}

public String getArtist(){

return Artist;
}

public void setArtist(String artist){

Artist = artist;
}

public void setVocals(int i){

Vocals = i;
}

public void setAccompaniment(int j){

Accompaniment = j;
}

public String getLabel(){

return Label;
}

public void setLabel(String label){

Label = label;

}

public void setCost(double x){

super.setCost(x);
}

public void setDuration(int y){

super.setDuration(y);
}


//Local compareTo method for CD labels
public int CompareTo(Object o){

CD tmp = (CD)o;
String one;
String two;
one = this.getLabel();
two = tmp.getLabel();
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