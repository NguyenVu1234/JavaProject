import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class DateTimeOne {
	private int second;

	//Create the object of class Date to get the current date and time
	Date currentDate = new Date();

	// Create the object of class SimpleDateFormat to set the wanted format of 
	// current time and date
	SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/YYYY hh:mm a");

	// Calendar's getInstance method returns a Calendar object 
	// whose calendar fields have been initialized with the current date and time
	Calendar cal = Calendar.getInstance();

	// Call the method from Calendar class to get exact time in second
	public int getValueOfSecond() {
		this.second = cal.get(Calendar.SECOND);
		System.out.println("The time in second now: " + this.second);
		return this.second;
	}

	// Use the Thread.sleep method to stop executing program with the specified second
	public void sleepForSec(int sleepSec) {
		try {
			Thread.sleep(sleepSec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// Print out the format of current date and time
	public void dateTimeNow() {
		System.out.println("Current Date/Time: " + dateForm.format(currentDate));
	}
}