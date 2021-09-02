package spacex;

import utility.Comparable;

public class Payload implements Comparable<Payload>{

	private String name;
	private String type;
	private double mass;
	private String orbit;
	
	public Payload() {
		this("","",0.0,"");
	}
	public Payload(String name, String type, double mass, String orbit) {
		
		this.name  = name;
		this.type  = type;
		this.mass  = mass;
		this.orbit = orbit;
	}
	
	public int compareTo(Payload other) {
		if(!name.equals(other.name))
			return name.compareTo(other.name);
		else if(mass != other.mass)
			return Double.compare(mass, other.mass);
		else if(!type.equals(other.type))
			return type.compareTo(other.type);
		else 
			return orbit.compareTo(other.orbit);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Payload) {
			Payload other = (Payload) obj;
			return name.equals(other.name) &&
					type.equals(other.type) &&
					mass == other.mass &&
					orbit.equals(other.orbit);
		}
		return false;
	}

	public String toCSVFormat() {
		return String.format("%s,%s,%.2f,%s", name,type,mass,orbit);
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("\n");
		int size = 4;
		DataMap[] map = new DataMap[size];
		map[0] = new DataMap("Name: "     , name);
		map[1] = new DataMap("Type: "     , type);
		map[2] = new DataMap("Mass(kg): " , Double.toString(mass));
		map[3] = new DataMap("Orbit: "    , orbit);
		
		for(int i = 0;i<size;i++) {
			builder.append(String.format("%-18s %-4s \n",  map[i].name, map[i].value));
		}
		
		return builder.toString();
	}
	
	
	
}
