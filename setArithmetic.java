import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.lang.Double;
import java.lang.Integer;
public class setArithmetic 
{

    public String union (String set1, String set2)
	{
		// Arrays.sort(set1.toCharArray()); // Does not work... again... Thank you Java...
		String set3 = removeDups(set1 + set2);
		String unionSet = "";

		return set3;
	}

	public void subtractSets (String set1, String set2)
	{

	}

	/**
   * Java method to remove duplicate characters from String This method uses a
   * HashSet collection to get rid of duplicate characters.
   *
   * @param word
   * @return String without duplicate characters
   */
	// Referenced from java67.com
  public static String removeDups(String word) {
    Set<Character> chars = new HashSet<>();
    StringBuilder output = new StringBuilder(word.length());

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (chars.add(ch)) {
        output.append(ch);
		output.append(' ');
      }
    }

    return output.toString();
  }

  public String setDifference(String set1, String set2) 
  {
	String newString = "";
      Set<String> numbers = new HashSet<>();
    	numbers.add(set1);

	Set<String> primeNumbers = new HashSet<>();
    primeNumbers.add(set2);

    numbers.removeAll(primeNumbers);
    Object[] array = numbers.toArray();
    for (int i = 0; i < array.length; i++){
        newString = newString + array[i];
    }
    return newString;
  }
}
