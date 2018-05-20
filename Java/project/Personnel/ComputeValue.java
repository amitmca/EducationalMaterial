import java.util.Calendar;
import java.lang.Integer;
class ComputeValue{

	public String computeAge(String year){

		Calendar cal = Calendar.getInstance();
		// compute age based on current year and birthyear
		int age = cal.get(cal.YEAR) - Integer.parseInt(year);

		// return age as string
		return age + "";
		
	}    
}	