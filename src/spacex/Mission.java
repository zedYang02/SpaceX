package spacex;

import utility.Comparable;

public class Mission implements Comparable<Mission>{
	private final String   flightNumber;
	private final Date     launchDate;
	private final Time     launchTime;
	private final String   launchSite;
	private final String   vehicleType;
	private final Payload  payload;
	private final Customer customer;
	private final String   missionOutcome;
	private final String   failureReason;
	private final String   landingType;
	private final String   landingOutcome;
	
	public Mission(Builder builder) {
		flightNumber   = builder.flightNumber;
		launchDate     = builder.launchDate;
		launchTime     = builder.launchTime;
		launchSite     = builder.launchSite;
		vehicleType    = builder.vehicleType;
		payload        = builder.payload;
		customer       = builder.customer;
		missionOutcome = builder.missionOutcome;
		failureReason  = builder.failureReason;
		landingType    = builder.landingType;
		landingOutcome = builder.landingOutcome;
	}
	
	public int compareTo(Mission other) {
		return payload.compareTo(other.payload);
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public Date getLaunchDate() {
		return launchDate;
	}

	public Time getLaunchTime() {
		return launchTime;
	}

	public String getLaunchSite() {
		return launchSite;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public Payload getPayload() {
		return payload;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getMissionOutcome() {
		return missionOutcome;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public String getLandingType() {
		return landingType;
	}

	public String getLandingOutcome() {
		return landingOutcome;
	}
	
	public String toCSVFormat() {
		String csv_p1  = String.format("%s" , flightNumber);
		String csv_p2  = String.format(",%s", launchDate.toCSVFormat());
		String csv_p3  = String.format(",%s", launchTime.toCSVFormat());
		String csv_p4  = String.format(",%s", launchSite);
		String csv_p5  = String.format(",%s", vehicleType);
		String csv_p6  = String.format(",%s", payload.toCSVFormat());
		String csv_p7  = String.format(",%s", customer.toCSVFormat());
		String csv_p8  = String.format(",%s", missionOutcome);
		String csv_p9  = String.format(",%s", failureReason);
		String csv_p10 = String.format(",%s", landingType);
		String csv_p11 = String.format(",%s", landingOutcome);
		
		return csv_p1 + csv_p2 + csv_p3 + csv_p4 + csv_p5 + csv_p6 + csv_p7
				 + csv_p8 + csv_p9 + csv_p10 + csv_p11;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
	
		
		int size = 11;
		DataMap[] map = new DataMap[size];
		map[0] = new DataMap("Flight Number: "   , flightNumber);
		map[1] = new DataMap("Launch Date: "     , launchDate.toString());
		map[2] = new DataMap("Launch Time: "     , launchTime.toString());
		map[3] = new DataMap("Launch Site: "     , launchSite);
		map[4] = new DataMap("Vehicle Type: "    , vehicleType);
		map[5] = new DataMap("\nPayload: "         , payload.toString());
		map[6] = new DataMap("Customer: "        , customer.toString());
		map[7] = new DataMap("Mission Outcome: " , missionOutcome);
		map[8] = new DataMap("Failure Reason: "  , failureReason);
		map[9] = new DataMap("Landing Type: "    , landingType);
		map[10]= new DataMap("Landing Outcome: " , landingOutcome);
		
		for(int i = 0;i<size;i++) {
			builder.append(String.format("%-18s %-4s \n",  map[i].name, map[i].value));
		}
		
		return builder.toString();
	}
	
	public static class Builder{
		String   flightNumber;
		Date     launchDate;
		Time     launchTime;
		String   launchSite;
		String   vehicleType;
		Payload  payload;
		Customer customer;
		String   missionOutcome;
		String   failureReason;
		String   landingType;
		String   landingOutcome;
		
		public Builder(){
			flightNumber    = "";
			launchDate      = new Date();
			launchTime      = new Time();
			launchSite      = "";
			vehicleType     = "";
			payload         = new Payload();
			customer        = new Customer();
			missionOutcome  = "";
			failureReason   = "";
			landingType     = "";
			landingOutcome  = "";
		}

		public Builder setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
			return this;
		}

		public Builder setLaunchDate(Date launchDate) {
			this.launchDate = launchDate;
			return this;
		}

		public Builder setLaunchTime(Time launchTime) {
			this.launchTime = launchTime;
			return this;
		}

		public Builder setLaunchSite(String launchSite) {
			this.launchSite = launchSite;
			return this;
		}

		public Builder setVehicleType(String vehicleType) {
			this.vehicleType = vehicleType;
			return this;
		}

		public Builder setPayload(Payload payload) {
			this.payload = payload;
			return this;
		}

		public Builder setCustomer(Customer customer) {
			this.customer = customer;
			return this;
		}

		public Builder setMissionOutcome(String missionOutcome) {
			this.missionOutcome = missionOutcome;
			return this;
		}

		public Builder setFailureReason(String failureReason) {
			this.failureReason = failureReason;
			return this;
		}

		public Builder setLandingType(String landingType) {
			this.landingType = landingType;
			return this;
		}

		public Builder setLandingOutcome(String landingOutcome) {
			this.landingOutcome = landingOutcome;
			return this;
		}
		
		public Mission build() {
			return new Mission(this);
		}
	}

}
