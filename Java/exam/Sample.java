import java.util.Calendar;
import java.util.Date;

public class Sample {

public static void main(String arg[])
{
System.out.println("Process Started");
dateDifference();
System.out.println("Process Completed");
}

public static void dateDifference()
{ 
Date currentdate = new Date();
Calendar calUpdated = Calendar.getInstance();
calUpdated.set(2009, 25, 12);
long currentDateMilliSec = currentdate.getTime();
long updateDateMilliSec = calUpdated.getTimeInMillis();
long diffDays = (currentDateMilliSec - updateDateMilliSec) / (24 * 60 * 60 * 1000);
System.out.println("Time in days: " + diffDays + " days.");
}
} 
