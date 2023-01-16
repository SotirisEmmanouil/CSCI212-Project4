public class Date212  {
	
	private int year;
	private int month;								//private instance variables
	private int day;

  public Date212 (Object object) {						                 //Date212 constructor 
		year = Integer.parseInt(((String) object).substring(0,4));		//split the string 
		month = Integer.parseInt(((String) object).substring(4,6));
		day = Integer.parseInt(((String) object).substring(6,8));
	
        if(((String)object).length() != 8) {
		throw new IllegalDate212Exception("Date length is Invalid: "+ object);	//throw exceptions if dates format is wrong
		}
	if(month<1 || month >12) {
		throw new IllegalDate212Exception("Month is Invalid: "+ object);
		}
	if(day <1 || day >31) {
		throw new IllegalDate212Exception("Day is Invalid:  "+ object);
		
		}
	
	}
	
	public int getYear() {						//get method of year
		return year;
	}
	
	public int getMonth() {					   //get method for month
		return month;
	}
	
	public int getDay() {					   //get method for day
		return day;
	}
	
	public int setYear(int y) {				    //set method for year
		return year = y;
	}
	
	public int setMonth(int m) {				//set method for month
		return month = m;
	}
	
	public int setDay(int d) {					//set method for day
		return day = d;
	}
	
	public boolean equals(Date212 date) {		//equals method that checks to see if two dates are equal 
		if(this.toString().equals(date.toString()))
				return true;
				  return false;    	
		}
	
	public int compareTo(Date212 date) {			// compare method that compares the dates
		 return this.toString().compareTo(date.toString());
							
					}
	
	
	public String toString() {					//toString method that prints the final result 
	     String month1 = null;
	     String days = null;
	      int g = day;
	      int m = month;
	      int k = year % 100;
	      int j = year / 100;
	      int e = (g + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;   //Zeller's Congruence
	      
	    if(e==0) {			
	  	   days = "Saturday";		// checks each result and places the correct day
	     }
	     if (e == 1) {
	  	   days = "Sunday";			// checks each result and places the correct day
	     }
	     if (e == 2) {
	  	   days = "Monday";			// checks each result and places the correct day
	     }
	     if (e == 3) {
	  	   days = "Tuesday";        // checks each result and places the correct day
	     }
	     if (e == 4) {
	  	   days = "Wednesday";		// checks each result and places the correct day
	     }
	     if (e == 5) {
	  	   days = "Thursday";		// checks each result and places the correct day
	     }
	     if (e == 6) {
	  	   days = "Friday";			// checks each result and places the correct day
	  
		  }
		switch(month) {
		   case 01:
		month1 = "January";	
			break;
		   case 02:
		month1 = "February";					//switch to decide month
			break;
		   case 03:
		month1 = "March";
			break;
		   case 04:
		month1 = "April";
			break;
		   case 05:
		month1 = "May";
			break;
		   case 06:
		month1 = "June";
			break;
		   case 07:
		month1 = "July";
			break;
		   case 8:
		month1 = "August";
			break;
		   case 9:
		month1 = "September";
			break;
		   case 10:
		month1= "October";
			break;
		   case 11:
		month1 = "November";
			break;
		   case 12:
		month1= "December";
			break;
			 
		}
	  String day1 = String.valueOf(day);
	  String year1 = String.valueOf(year);
	  String Date2121 = days+ ", "+ month1 + " " + day1 + ", " + year1;			// final string result
			 return Date2121;  
	}
}
