package spacex;

public enum Month {

	JAN("Jan"),
	FEB("Feb"),
	MAR("Mar"),
	APR("Apr"),
	MAY("May"),
	JUN("Jun"),
	JUL("Jul"),
	AUG("Aug"),
	SEP("Sep"),
	OCT("Oct"),
	NOV("Nov"),
	DEC("Dec");
	
	private String month;
	
	private Month(String month) {
		this.month = month;
	}
	
	public String toString() {
		return month;
	}
	
}
