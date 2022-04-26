import java.util.ArrayList;

/**
 * Town(vertex) class
 * @author Daniel Cortes Gratacos
 *
 */
public class Town implements Comparable <Town>{

	private String name;
	private ArrayList<Town> adjacentTowns;
	
	/**
	 * constructor instantiates name of town
	 * @param name name to assign to field name
	 */
	public Town(String name) {
		this.name=name;
		adjacentTowns=new ArrayList<Town>();
		
	}
	
	/**
	 * compares 2 towns. returns 0 if they have the same name, a negative number or positive number if they are not equal
	 */
	@Override
	public int compareTo(Town town) {
		if(town.getName().equalsIgnoreCase(name)) {
			return 0;
		}
		else {
			return name.compareToIgnoreCase(town.getName());
		}
	}
	/**
	 * copy constructor
	 * @param templateTown instance of Town
	 */
	public Town(Town templateTown) {
		this(templateTown.getName());
		setAdjacentTowns(templateTown.getAdjacentTowns());
	}
	
	/**
	 * @return name of town
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets name of town
	 * @param name name of town
	 */
	public void setName(String name) {
		this.name=name;
	}
	
	/**
	 * adds a town in the list of adjacent towns
	 * @param town town to be added to the list
	 */
	public void addAdjacentTowns(Town town) {
		adjacentTowns.add(town);
	}
	
	/**
	 * sets the list of adjacent towns 
	 * @param towns arrayList of adjacent towns
	 */
	public void setAdjacentTowns(ArrayList<Town> towns) {
		
		for(int i=0;i<towns.size();i++) {
			adjacentTowns.add(towns.get(i));
		}
	}
	
	
	
	/**
	 * @return reference to list of adjacent towns of a town
	 */
	public ArrayList<Town> getAdjacentTowns(){
		return adjacentTowns;
	}
	
	
	
	/**
	 * @return information on a town in a string format
	 */
	public String toString() {
		String town="";
		for(int i=0;i<adjacentTowns.size();i++) {
			town+=adjacentTowns.get(i).getName()+" ";
		}
		return "Name of Town: "+name +"\t Adjacent Towns: "+ town+"\n";
	}
	
	/**
	 * @return hashCode of name of town
	 */
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * @return name of a town if equal to another given town
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		
		if(!(obj instanceof Town))
			return false;
		
		Town t = (Town) obj;
		
		return this.name.equals(t.name);
			
	}

}