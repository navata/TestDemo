package navata.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	HashMap<Integer, String> NUMBER_HASHMAP = new HashMap<>();
	HashMap<String, String> NUMBER_HASHMAP2 = new HashMap<>();

	public static void main(String[] args) {
		Main main = new Main();
		// main.defineNumberHashMap();
		// main.phantich();
		main.defineNumberHashMap2();
		// main.run("1");
		// main.readFile();
//		main.writeFile(main.readFile());
		main.input();
	}

	public void input(){
		Scanner scan = new Scanner(System.in);
		String path;
		String type;
		System.out.print("Please input path file: ");
		path = scan.nextLine();
		if(path != null && !path.isEmpty()){
			System.out.println("---- Type sort ---- ");
			System.out.println("0: descending order");
			System.out.println("1: ascending order");
			System.out.print("Please choose: ");
			type = scan.nextLine();
			writeFile(readFile(path, type));
		}
		
		
	}
	
	public void writeFile(String content) {
		File file = new File("/Navata/text/output.txt");

		try (FileOutputStream fop = new FileOutputStream(file)) {

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readFile(String path, String type) {
//		String path = "/Navata/text/test.txt";
		File file = new File(path);
		StringBuilder output = new StringBuilder();
		
		try {
			FileInputStream inputFile = new FileInputStream(file);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(inputFile));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				if (line != null && !line.isEmpty()) {
					String sortNumber = sortNumber(line, type);
					output.append(sortNumber + "\n");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return output.toString();

	}

	public int getIndex(List<String> valid, int number, String type) {
		int index = 0;

		for (int i = valid.size() - 1; i >= 0; i--) {
			int value = Integer.parseInt(stringToNumber(valid.get(i)));
			if (type.equals("0")) {
				if (number <= value) {
					index = i + 1;
					break;
				}
			} else {
				if (number >= value) {
					index = i + 1;
					break;
				}
			}
		}

		return index;
	}

	public String sortNumber(String input, String type) {
		List<String> valid = new ArrayList<String>();
		List<String> mis = new ArrayList<String>();

		for (String element : input.split(",")) {
			String number = stringToNumber(element);
			if (number != null) {
				int index = getIndex(valid, Integer.parseInt(number), type);
				valid.add(index, element);
			} else {
				mis.add("Invalid:" + element);
			}
		
		}
		
		valid.addAll(mis);
		System.out.println(valid.toString());
		
		return valid.toString();
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
		input = (formatString(input));
		int sum = 0;
		String[] number = input.split(" ");
		String dau = "+";

		if (isNumberic(input)) {

			return input;

		} else {

			int i = 0;

			if (number[0].equals("negative")) {
				dau = "-";
				i++;
			} else if (number[0].equals("positive")) {
				i++;
			}

			for (; i < number.length; i++) {
				String value = NUMBER_HASHMAP2.get(number[i]);
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
