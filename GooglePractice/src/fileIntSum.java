import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class fileIntSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filename = "file";
		sumIntOnFile(filename);
	}

	private static void sumIntOnFile(String filename) {
		try {
			File file = new File(filename);
			Scanner in = new Scanner(file);
			int sum = 0;
			while(in.hasNextInt())
				sum += in.nextInt();
			System.out.println("The sum of ints at file '" + filename + "' is: " + sum);
		} catch (FileNotFoundException e) {
			System.out.println("IO Error: Cannot fine file.");
		}
		
	}

}
