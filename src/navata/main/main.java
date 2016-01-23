package navata.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class main {

	HashMap<Integer, String> NUMBER_HASHMAP = new HashMap<>();
	HashMap<String, String> NUMBER_HASHMAP2 = new HashMap<>();

	List<String> valid = new ArrayList<String>();
	List<String> mis = new ArrayList<String>();

	public static void main(String[] args) {
		main main = new main();
		// main.defineNumberHashMap();
		// main.phantich();
		main.defineNumberHashMap2();
		main.run("0");
	}

	public int getIndex(List<String> valid, int number, String style) {
		int index = 0;

		for (int i = valid.size() - 1; i >= 0; i--) {

			int value = Integer.parseInt(stringToNumber(valid.get(i)));
			if (style.equals("0")) {
				if (number <= value) {
					index = i + 1;
					break;
				}
			}else{
				if (number >= value) {
					index = i + 1;
					break;
				}
			}
		}

		return index;
	}

	public void run(String type) {
		String input = "10, -9, eight, 8, eighteen ,11 ,100, thirty one";
		for (String element : input.split(",")) {
			String number = stringToNumber(element);
			if (number != null) {
				valid.add(getIndex(valid, Integer.parseInt(number),type), element);
				// valid.add(element);
			} else {
				mis.add(element);
			}
		}
		System.out.println(valid);
		System.out.println(mis);
	}

	public static boolean isNumberic(String str) {
		return str.matches("[+-]?\\d+");
	}

	public String formatString(String input) {
		input = input.toLowerCase().trim();
		input = input.replaceAll("\\s+", " ");
		return input;
	}

	private String stringToNumber(String input) {
		// String input = "13";
		input = (formatString(input));
		int sum = 0;
		String[] arr = input.split(" ");
		String dau = "+";

		if (isNumberic(input)) {
			return input;
		} else {

			int i = 0;

			if (arr[0].equals("negative")) {
				dau = "-";
				i++;
			} else if (arr[0].equals("positive")) {
				i++;
			}

			for (; i < arr.length; i++) {
				String value = NUMBER_HASHMAP2.get(arr[i]);
				if (value != null) {
					sum += Integer.parseInt(dau + value);

				} else {
					return null;
				}
			}

			return String.valueOf(sum);
		}

	}

	private String phantich() {
		StringBuilder key = new StringBuilder();
		int input = 90;
		if (input >= 0) {

		} else

		if (input >= 0 && input <= 20) {
			key.append(NUMBER_HASHMAP.get(input));
		} else {
			int tram = input / 100;
			int chuc = ((input % 100) / 10) * 10;
			int dv = input % 100 % 10;
			if (tram > 0) {
				key.append(NUMBER_HASHMAP.get(tram) + " ");
				key.append(NUMBER_HASHMAP.get(100) + " ");
			}

			if (chuc > 0) {
				key.append(NUMBER_HASHMAP.get(chuc) + " ");
			}

			if (dv > 0) {
				key.append(NUMBER_HASHMAP.get(dv));
			}
		}
		return key.toString();
	}

	private void defineNumberHashMap() {
		NUMBER_HASHMAP.put(0, "zero");
		NUMBER_HASHMAP.put(1, "one");
		NUMBER_HASHMAP.put(2, "two");
		NUMBER_HASHMAP.put(3, "three");
		NUMBER_HASHMAP.put(4, "four");
		NUMBER_HASHMAP.put(5, "five");
		NUMBER_HASHMAP.put(6, "six");
		NUMBER_HASHMAP.put(7, "seven");
		NUMBER_HASHMAP.put(8, "eight");
		NUMBER_HASHMAP.put(9, "nine");
		NUMBER_HASHMAP.put(10, "ten");
		NUMBER_HASHMAP.put(11, "eleven");
		NUMBER_HASHMAP.put(12, "twelve");
		NUMBER_HASHMAP.put(13, "thirteen");
		NUMBER_HASHMAP.put(14, "fourteen");
		NUMBER_HASHMAP.put(15, "fifteen");
		NUMBER_HASHMAP.put(16, "sixteen");
		NUMBER_HASHMAP.put(17, "seventeen");
		NUMBER_HASHMAP.put(18, "eight");
		NUMBER_HASHMAP.put(19, "nineten");
		NUMBER_HASHMAP.put(20, "twenty");
		NUMBER_HASHMAP.put(30, "thirty");
		NUMBER_HASHMAP.put(40, "fourty");
		NUMBER_HASHMAP.put(50, "fifty");
		NUMBER_HASHMAP.put(60, "sixty");
		NUMBER_HASHMAP.put(70, "seventy");
		NUMBER_HASHMAP.put(80, "eighty");
		NUMBER_HASHMAP.put(90, "ninety");
		NUMBER_HASHMAP.put(100, "hundred");
	}

	private void defineNumberHashMap2() {
		// NUMBER_HASHMAP2.put("negative", "-");
		// NUMBER_HASHMAP2.put("positive", "+");
		NUMBER_HASHMAP2.put("zero", "0");
		NUMBER_HASHMAP2.put("one", "1");
		NUMBER_HASHMAP2.put("two", "2");
		NUMBER_HASHMAP2.put("three", "3");
		NUMBER_HASHMAP2.put("four", "4");
		NUMBER_HASHMAP2.put("five", "5");
		NUMBER_HASHMAP2.put("six", "6");
		NUMBER_HASHMAP2.put("seven", "7");
		NUMBER_HASHMAP2.put("eight", "8");
		NUMBER_HASHMAP2.put("nine", "9");
		NUMBER_HASHMAP2.put("ten", "10");
		NUMBER_HASHMAP2.put("eleven", "11");
		NUMBER_HASHMAP2.put("twelve", "12");
		NUMBER_HASHMAP2.put("thirteen", "13");
		NUMBER_HASHMAP2.put("fourteen", "14");
		NUMBER_HASHMAP2.put("fifteen", "15");
		NUMBER_HASHMAP2.put("sixteen", "16");
		NUMBER_HASHMAP2.put("seventeen", "17");
		NUMBER_HASHMAP2.put("eighteen", "18");
		NUMBER_HASHMAP2.put("nineten", "19");
		NUMBER_HASHMAP2.put("twenty", "20");
		NUMBER_HASHMAP2.put("thirty", "30");
		NUMBER_HASHMAP2.put("fourty", "40");
		NUMBER_HASHMAP2.put("fifty", "50");
		NUMBER_HASHMAP2.put("sixty", "60");
		NUMBER_HASHMAP2.put("seventy", "70");
		NUMBER_HASHMAP2.put("eighty", "80");
		NUMBER_HASHMAP2.put("ninety", "90");
		NUMBER_HASHMAP2.put("hundred", "100");
	}
}
