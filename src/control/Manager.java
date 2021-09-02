package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import lists.ArrayList;
import spacex.Customer;
import spacex.Date;
import spacex.Payload;
import spacex.Time;
import spacex.Mission;
import utility.List;
import utility.LModule;

public class Manager {

	private List<Mission> list;
	private String csvFileHeader;
	
	public Manager() {
		list = new ArrayList<Mission>();
	}
	
	public void filterCustomer(String directory, String customer) throws FileNotFoundException{
		String csvLocation = directory + File.separator + customer + "_csv.csv";
		String txtLocation = directory + File.separator + customer + "_txt.csv";
		File csvFile = new File(csvLocation);
		File txtFile = new File(txtLocation);
		PrintStream csvStream = new PrintStream(csvFile);
		PrintStream txtStream = new PrintStream(txtFile);
		
		Customer missionCustomer;
		Mission mission;
		if(csvFile.exists() && txtFile.exists()) {
			csvStream.println(csvFileHeader);
	
			for(int i = 0;i<list.size();i++) {
				mission = list.get(i);
				missionCustomer = mission.getCustomer();
				
				if(missionCustomer.getName().equals(customer)) {
					csvStream.println(mission.toCSVFormat());
					txtStream.println(mission);
				}
						
			}
		}
		csvStream.close();
		txtStream.close();
	}
	
	public void orderByPayloads(String directory) throws FileNotFoundException{
		String csvLocation = directory + File.separator + "payload_order_csv.csv";
		String txtLocation = directory + File.separator + "payload_order_txt.csv";
		File csvFile = new File(csvLocation);
		File txtFile = new File(txtLocation);
		PrintStream csvStream = new PrintStream(csvFile);
		PrintStream txtStream = new PrintStream(txtFile);
		
		LModule.selectionSort(list);
		if(csvFile.exists() && txtFile.exists()) {
			csvStream.println(csvFileHeader);
	
			for(int i = 0;i<list.size();i++) {
				csvStream.println(list.get(i).toCSVFormat());
				txtStream.println(list.get(i));
			}
		}
		csvStream.close();
		txtStream.close();
	}
	
	private Mission parse(String line) throws IllegalArgumentException{
		String[] str = line.split(",");
		String[] column = new String[16];
		
		for(int i = 0;i<str.length;i++) {
			column[i] = str[i];
		}
		
		if(str.length < column.length) {
			for(int i = str.length; i< column.length; i++) {
				column[i] = "";
			}
		}
	
		String flightNumber    = column[0];
		Date   launchDate      = new Date(column[1]);
		Time   launchTime      = new Time(column[2]);
		String launchSite      = column[3];
		String vehicleType     = column[4];
		double mass            = column[7].equals("") ? 0.0 : Double.parseDouble(column[7]);
		Payload payload        = new Payload(column[5], column[6], mass, column[8]);
		Customer customer      = new Customer(column[9], column[10], column[11]);
		String missionOutcome  = column[12];
		String failureReason   = column[13];
		String landingType     = column[14];
		String landingOutcome  = column[15];
		
		return new Mission.Builder()
				.setFlightNumber(flightNumber)
				.setLaunchDate(launchDate)
				.setLaunchTime(launchTime)
				.setLaunchSite(launchSite)
				.setVehicleType(vehicleType)
				.setPayload(payload)
				.setCustomer(customer)
				.setMissionOutcome(missionOutcome)
				.setFailureReason(failureReason)
				.setLandingType(landingType)
				.setLandingOutcome(landingOutcome)
				.build();
	}
	
	public void read(String location) throws FileNotFoundException{
		File file = new File(location);
		Scanner input = new Scanner(file);
		Mission missionData;
		
		if(input.hasNextLine())
			csvFileHeader = input.nextLine();
		
		while(input.hasNextLine()) {
			missionData = parse(input.nextLine());
			if(!list.contains(missionData))
			    list.add(missionData);
		}
		input.close();
	}
}
