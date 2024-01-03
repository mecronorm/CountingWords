import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountingWords {
	public static void main(String[] args) {
		Map<String, Integer> wordCount = new HashMap<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader("Story.txt"))){
			String line;
			
			while((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+");
				
				for (String word : words) {
					word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
					
					wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
				}
			}
			reader.close();
		}
		catch(IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String mostCommon = null;
		int maxCount = 0;
		
		System.out.println("Word Count:");
		for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
			if (entry.getValue() > maxCount) {
				mostCommon = entry.getKey();
				maxCount = entry.getValue();
			}
		}
		
		if(mostCommon != null) {
			System.out.println("\nThe most used word in this text is: " + mostCommon);
		} else {
			System.out.println("There are no words.");
		}
	}
}
