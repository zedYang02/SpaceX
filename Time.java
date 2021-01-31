package spacex;

import utility.Comparable;

public class Time implements Comparable<Time>{

	private int hour;
	private int minutes;
	
	
	public Time() {
		this(0,0);
	}
    public Time(String time) {
		String[] str = time.split(":");
		hour         = Integer.parseInt(str[0]);
		minutes      = Integer.parseInt(str[1]);
		
	}
	public Time(int hour, int minutes) {
		
		this.hour    = hour;
		this.minutes = minutes;
	}
	
	public int compareTo(Time other) {
		if(hour != other.hour)
			return hour - other.hour;
		else
			return minutes - other.minutes;
		
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Time) {
			Time other = (Time) obj;
			return hour == other.hour && minutes == other.minutes;
		}
		return false;
	}
	
	public String toCSVFormat() {
		return String.format("%d:%02d",hour,minutes);
	}

	public String toString() {
		String time = String.format("%d:%02d", hour, minutes);
		return time.equals("0:0")? "" : time;
	}
}
