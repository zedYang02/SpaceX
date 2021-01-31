

import java.io.File;
import java.io.FileNotFoundException;

public class MissionControl {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Choose your own directory
		String directory = File.separator + "Users" + File.separator +"zed" +
				File.separator + "Documents";
		//Choose your own file location
		String fileLocation = 
				File.separator + "Users" + File.separator + "zed" +
				File.separator + "Downloads" + 
				File.separator + "datasets_896_1637_database (1).csv";
		Manager missionManager = new Manager();
		missionManager.read(fileLocation);
		missionManager.filterCustomer(directory, "SES");
		missionManager.orderByPayloads(directory);

		
	}

}
