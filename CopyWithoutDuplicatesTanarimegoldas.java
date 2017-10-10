import java.io.*;
import java.util.Scanner;

public class CopyWithoutDuplicatesTanarimegoldas {
	
	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println("Not enough command line arguments.");
		}
		try {
			copy(args[0], args[1]);
		} catch (FileNotFoundException e) {
			System.err.println("One of the files cannot be opened.");
		} catch (IOException e) {
			System.err.println("An IO error occurred.");	
		}
	}
	
	private static void copy(String input, String output)
	throws FileNotFoundException, IOException {

		try ( Scanner sc = new Scanner(new File(input));
			PrintWriter pw = new PrintWriter(output) ) {

			String previous = null;
			
			while (sc.hasNextLine()) {
				String current = sc.nextLine();
				if ( !current.equals(previous) ) {
					pw.println(current);
				}
				previous = current;
			}
		}
	}
}
