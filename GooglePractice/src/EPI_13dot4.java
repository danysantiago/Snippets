import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;



public class EPI_13dot4 {
	

	public static void main(String[] args) {
		String[] personKeys = {
				"abc3", "aed3", "abc3", "meme", "wepa", "abc3", "meme", "loko"
		};
		
		HashMap<String, ArrayList<Person>> map = new HashMap<>();
		
		//Add persons
		for(int i = 0; i < personKeys.length; i++) {
			if(map.containsKey(personKeys[i])) {
				map.get(personKeys[i]).add(new Person(personKeys[i]));
			} else {
				ArrayList<Person> bucket = new ArrayList<>();
				bucket.add(new Person(personKeys[i]));
				map.put(personKeys[i], bucket);
			}
		}
		
		//Print persons, sorted
		Object[] keys = map.keySet().toArray();
		Arrays.sort(keys);
		for(int i = 0; i < keys.length; i++) {
			ArrayList<Person> bucket = map.get(keys[i]);
			for(int j = 0; j < bucket.size(); j++) {
				System.out.println(bucket.get(j).key);
			}
		}
		

	}
	
	private static class Person {
		String key;

		public Person(String key) {
			this.key = key;
		}
		
	}

}
