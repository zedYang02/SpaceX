package spacex;

import utility.Comparable;

public class Customer implements Comparable<Customer>{

	private String name;
	private String type;
	private String country;
	
	public Customer() {
		this("","","");
	}
	
	public Customer(String name, String type, String country) {
		this.name    = name;
		this.type    = type;
		this.country = country;
	}
	
	public int compareTo(Customer other) {
		if(!name.equals(other.name))
			return name.compareTo(other.name);
		else if(!country.equals(other.country))
			return country.compareTo(other.country);
		else 
			return type.compareTo(other.type);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Customer) {
			Customer other = (Customer) obj;
			return name.equals(other.name) &&
				   country.equals(other.country) &&
				   type.equals(other.type);
		}
		return false;
	}
	
	public String toCSVFormat() {
		return String.format("%s,%s,%s", name,type,country);
	}
	
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getCountry() {
		return country;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("\n");
		int size = 3;
		DataMap[] map = new DataMap[size];
		map[0] = new DataMap("Name: "    , name);
		map[1] = new DataMap("Type: "    , type);
		map[2] = new DataMap("Country: " , country);
		
		for(int i = 0;i<size;i++) {
			builder.append(String.format("%-18s %-4s \n",  map[i].name, map[i].value));
		}
		
		return builder.toString();
	}
}
