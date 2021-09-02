package launch;
/*
import utility.Comparable;

public class Date implements Comparable<Date>{

	private int day;
	private int month;
	private int year;
	
	public Date() {
		this(0,0,0);
	}
	
	public Date(String date) {
		String[] str = date.split("/");
		month = Integer.parseInt(str[0]);
		day = Integer.parseInt(str[1]);
		year = Integer.parseInt(str[0]);
	}

	public Date(int day, int month, int year) {
		
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int compareTo(Date other) {
		if(month != other.month)
			return month - other.month;
		else if(day != other.day)
			return day - other.day;
		else
			return year - other.year;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Date){
			Date other = (Date)obj;
			return month == other.month &&
					day == other.day &&
					year == other.year;
		}
		return false;
	}

	public String toString() {
		String date = String.format("%s/%s/%s",month,day,year);
		return date.equals("0/0/0")? "" : date;
	}
	
}
*/
