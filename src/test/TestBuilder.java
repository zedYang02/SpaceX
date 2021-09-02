package test;

import spacex.Customer;
import spacex.Date;
import spacex.Mission;
import spacex.Month;
import spacex.Payload;
import spacex.Time;

public class TestBuilder {

	public static void main(String[] args) {
		
	    Customer customer = new Customer("ATSB","Government","USA");
	    //Date date01 = new Date("07/14/2000");
	    Date date02 = new Date(1,Month.APR,5);
	    Payload payload = new Payload("Razak","Weather",180.0,"Lucian");
	    Time time01 = new Time("3:35");
	    Time time02 = new Time(01,02);
		Mission mission_01 = new Mission.Builder()
				.setFlightNumber("F1-5")
				.setCustomer(customer)
				.setFailureReason("failure reason")
				.setLandingOutcome("failure")
				.setLandingType("During Launch")
				.setLaunchDate(date02)
				.setLaunchSite("Island")
				.setLaunchTime(time01)
				.setMissionOutcome("failure")
				.setPayload(payload)
				.setVehicleType("Falcon 1")
				.build();
				
				

		System.out.println(mission_01);
	}

}
