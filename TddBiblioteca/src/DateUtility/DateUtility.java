package DateUtility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtility {

	private static final int NUMERO_MILISECOND_PER_UN_GIORNO = 864000000; // (3600 * 24 ) * 1000 

	
	public static Date convertStringToDate(String dataString) throws ParseException{

			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date date = sdf.parse(dataString);

			return date;

	}
	
	// convert JavaDate To SqlDate
	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date){

			return new java.sql.Date(date.getTime());
	}
	
	// convert java.sql.Date ---> java.util.Date
	public java.util.Date convertSqlDateToJavaDate(java.sql.Date date){

			return new java.util.Date(date.getTime());
	}

	// convert Calendar To java Date
	public Date convertCalendarToJavaDate(Calendar cal){
		
			return cal.getTime();
	}

	// convert java.util.Date to Calendar
	public Calendar convertJavaDateToCalendar(java.util.Date date){
			
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(date.getTime());
			
			return cal;
	}

	// confront 2 date using java.util.date
	public long getDayDifference(Date date1 , Date date2){

			long diffMilliSecond=date2.getTime()-date1.getTime();
			long dayDiff = diffMilliSecond/NUMERO_MILISECOND_PER_UN_GIORNO;
			
			return dayDiff;
	}
}
