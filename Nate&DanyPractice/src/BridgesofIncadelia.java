import java.util.ArrayList;
import java.util.Scanner;


public class BridgesofIncadelia {
	
	static ArrayList<Island> islands = new ArrayList<Island>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfBridges = Integer.parseInt(in.nextLine());
		for(int i = 0; i < numOfBridges; i++){
			String[] line = in.nextLine().split("\\s+");
			String island1 = line[0];
			String island2 = line[1];
			int cost = Integer.parseInt(line[2]);
			int index = getIslandIndex(island1);
			if(index != -1){
				islands.get(index).addConnection(island2, cost);
			} else {
				islands.add(new Island(island1));
				islands.get(islands.size()-1).addConnection(island2, cost);
			}
			int index2 = getIslandIndex(island2);
			if(index2 != -1){
				islands.get(index2).addConnection(island1, cost);
			} else {
				islands.add(new Island(island2));
				islands.get(islands.size()-1).addConnection(island1, cost);
			}	
		}
		
		long totalCost = 0;
		for(int i = 0; i < islands.size(); i++){
			if(islands.get(i).hasOneConnection()){
				totalCost += islands.get(i).getThatOneCost();
				removeThatConnection(islands.get(i).getName());
			}
		}
		
		System.out.println(totalCost);

	}
	
	private static void removeThatConnection(String thatOneConnection) {
		for(Island isla : islands){
			ArrayList<String> list = isla.getConnectedIslands();
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).equalsIgnoreCase(thatOneConnection)){
					list.remove(i);
					isla.getCostOfBridges().remove(i);
				}
			}
		}
	}

	static int getIslandIndex(String island1){
		for (int i = 0; i < islands.size(); i++){
			if(islands.get(i).getName().equalsIgnoreCase(island1))
				return i;
		}
		return -1;
	}

}

class Island{
	String name;
	ArrayList<String> connectedIslands;
	ArrayList<Integer> costOfBridges;
	
	public Island(String name){
		this.name = name;
		connectedIslands = new ArrayList<String>();
		costOfBridges = new ArrayList<Integer>();
	}
	
	public String getName(){
		return name;
	}
	
	public void addConnection(String s, int cost){
		if(newConnection(s))
		connectedIslands.add(s);
		costOfBridges.add(cost);
		
	}
	
	private boolean newConnection(String island) {
		for (String s : connectedIslands)
			if(s.equalsIgnoreCase(island))
				return false;
		return true;
	}

	public boolean hasOneConnection(){
		return connectedIslands.size()==1;
	}
	
	public int getThatOneCost(){
		return costOfBridges.get(0);
	}

	public ArrayList<String> getConnectedIslands() {
		return connectedIslands;
	}

	public ArrayList<Integer> getCostOfBridges() {
		return costOfBridges;
	}
	
	
}
