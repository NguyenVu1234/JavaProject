import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class HammingDist {
	private String vehicle1;
	private String vehicle2;
	private String[] arr = new String[20];
	private int arrSize = 0;
	// Got help from Professor Maiti
	private boolean isEmpty = false;
	private boolean isSingle = false;

	// Default constructor
	public HammingDist() {
		isEmpty = true;
	}

	// Constructor with 1 parameter
	public HammingDist(String vehID) {
		isSingle = true;
	}

	// Constructor with 2 parameter
	public HammingDist(String vehicle1, String vehicle2) throws FileNotFoundException, IOException {
		this.vehicle1 = vehicle1;
		this.vehicle2 = vehicle2;
		// If the second parameter is same to the first parameter then reverse the
		// second input
		this.vehicle2 = reverseString();

		// Read the data and modify it
		String filePath = new String("vanetp1data.txt");
		BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = br.readLine()) != null) {
				String[] array = line.trim().split("\\s+");
				// Extract the vehicleID from data file and convert it to the upper case letter
				arr[arrSize] = array[2].toUpperCase();
				arrSize++;

				// Expand the capacity of the array 2 times if it is full
				if (arrSize >= arr.length) {
					arr = Arrays.copyOf(arr, arr.length * 2);
				}
			}
			br.close();
		}
	

	public String toString() {

		// Print out the result if no input is given
		if (isEmpty) {
			return "The inputs are empty.";
		}

		// Print out the result if 1 input is missing
		if (isSingle) {
			return "The second vehicle is missing.";
		}

		// Print out the result if 2 inputs are given
		return "The Hamming distance between VEH00 and " + this.vehicle1 + " is " + HamDistance(this.vehicle1)
				+ "; between VEH00 and " + this.vehicle2 + " is " + HamDistance(this.vehicle2) + "." + "\n" + "For "
				+ this.vehicle1 + ": Number of vehicles of Hamming Distance " + HamDistance(this.vehicle1) + ": "
				+ findNumVeh(this.vehicle1) + "." + "\n" + "For " + this.vehicle2
				+ ": Number of vehicles of Hamming Distance " + HamDistance(this.vehicle2) + ": "
				+ findNumVeh(this.vehicle2) + ".";

	}

	// Find number of vehicle in data set which have the same Hamming distance with
	// the Hamming distance between VEOO and given input
	public int findNumVeh(String selectedVeh) {
		int count = 0;
		for (int i = 0; i < arr.length && arr[i] != null && selectedVeh != null; ++i) {
			// Hamming distance of each vehicleID in array will be set to 0
			// everytime it is compared with the selected vehicle
			int HamDis = 0;
			for (int j = 0; j < selectedVeh.length() && arr[i].length() == selectedVeh.length(); ++j) {
				if (selectedVeh.charAt(j) != arr[i].charAt(j)) {
					HamDis++;
				}
			}
			// Pick each vehicleID in array which have hamming distance equal to hamming
			// distance of VEOO
			// and given input then increment the count
			if (HamDistance(selectedVeh) == HamDis) {
				count++;

			}
		}
		return count;
	}

	// Method to compare the given input to the VEHOO
	public int HamDistance(String Vehicle) {
		String word = "VEH00";
		int HamDis = 0;
		for (int i = 0; i < word.length() && word.length() == Vehicle.length(); ++i) {
			if (Vehicle != null && Vehicle.charAt(i) != word.charAt(i)) {
				HamDis++;
			}
		}
		return HamDis;
	}

	// Method to reverse the second input
	public String reverseString() {
		String reverseWord = "";
		if (vehicle1.equals(vehicle2)) {
			for (int i = vehicle2.length() - 1; i >= 0; i--) {
				reverseWord = reverseWord + vehicle2.charAt(i);
			}
			return reverseWord;
		}
		return vehicle2;
	}

	// Method to count number of vehicles with vehicleID ended with a zero
	public void getCountZero() {
		int count = 0;
		for (int i = 0; i < arr.length && arr[i] != null; ++i) {
			if (arr[i].charAt(arr[i].length() - 1) == '0') {
				count++;
			}
		}
		System.out.println("Number of vehicles ended with zero: " + count);
	}
}