import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountingWords {
	public static void main(String[] args) {
		try {
			File myText = new File("C:\\Users\\alessandro\\eclipse-workspace\\CountingWords\\src\\Story.txt");
			Scanner myReader = new Scanner(myText);
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
