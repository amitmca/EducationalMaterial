class ConvertValue{

	final static String male      = "Male";
	final static String female    = "Female";
	final static String m 	      = "M";
	final static String f 	      = "F";
	final static String single    = "Single";
	final static String married   = "Married";
	final static String separated = "Separated";
	final static String annulled  = "Annulled";
			

	public String formatGender(String gender){

		if (gender.equalsIgnoreCase(male))
			// gender is male	
			return m;
		else
			// gender is female
			return f;	
		
	}    
	
	public int displayGender(String gender){
	
		if (gender.equalsIgnoreCase(m))

			// gender is male,
			//  return equivalent index of male(0) in combo box	
			return 0;
		else
			// gender is female,
			//  return equivalent index of female(1) in combo box	
			return 1;	
	}	

	public int displayMaritalStatus(String status){
	
		if (status.equalsIgnoreCase(single))
		
			// marital status = single
			return 0;
			
		else if (status.equalsIgnoreCase(married))
			
			// marital status = married
			return 1;	
			
		else if (status.equalsIgnoreCase(separated))
			
			//marital status = separated
			return 2;	
			
		else if (status.equalsIgnoreCase(annulled))
			
			//marital status = annulled
			return 3;	

		else 
			//marital status = divorced
			return 4;
	}
	
	public String displayYear(String date){
	
		// parse 4 character year from String date
		String year = date.substring(0,4);
		return year;

	}	

	public int displayMonth(String date){

		// parse 2 character month from String date, then convert to integer		
		int month = Integer.parseInt(date.substring(5,7));
		return month;
	}	

	public String displayDay(String date){

		// parse 2 character day from String date
		String day = date.substring(8,10);
		return day;
	
	}	






}	