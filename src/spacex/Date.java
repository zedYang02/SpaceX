package spacex;

import utility.Comparable;

public class Date implements Comparable<Date>{

	private int   day;
	private Month month;
	private int   year;
	
	public Date() {
		this(0,Month.JAN,0);
	}
	
	public Date(String date) {
		String[] str = date.split("-");
		day   = Integer.parseInt(str[0]);
		month = Month.valueOf(str[1].toUpperCase());
		year  = Integer.parseInt(str[2]);
	}

	public Date(int day, Month month, int year) {
		
		this.day   = day;
		this.month = month;
		this.year  = year;
	}
	
	public int compareTo(Date other) {
		if(!month.equals(other.month))
			return month.compareTo(other.month);
		else if(day != other.day)
			return day - other.day;
		else
			return year - other.year;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Date){
			Date other = (Date)obj;
			return month.equals(other.month) &&
				   day  == other.day &&
				   year == other.year;
		}
		return false;
	}
	
	public String toCSVFormat() {
		return String.format("%d-%s-%02d", day,month,year);
	}

	public String toString() {
		String date = String.format("%d-%s-%02d",day,month,year);
		return date.equals("0-Jan-0") ? "" : date;
	}
}
