package Miscellaneous;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InputService {
	private ArrayList<Input> inputList = new ArrayList<>();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

	public InputService(ArrayList<String> inputs) throws ParseException {
		for (String input : inputs) {
			inputList.add(splitInput(input));
		}
	}

	Input splitInput(String input) throws ParseException {
		String[] parts = input.split(" ");
		Date date = dateFormat.parse(parts[0]); 
		double price = Double.parseDouble(parts[1].substring(1)); 
		String vendor = parts[2]; 
		String category = input.substring(input.indexOf("(") + 1, input.indexOf(")")); 
		return new Input(date, price, vendor, category);
	}

	public ArrayList<Input> queryByDateRange(Date startDate, Date endDate) {
		ArrayList<Input> answer= (ArrayList<Input>) inputList.stream()
				.filter(t -> !t.getDate().before(startDate) && !t.getDate().after(endDate))
				.collect(Collectors.toList());
		System.out.println("query by date in range startdate "+startDate+ " and end date "+endDate+ "is "+answer);
		return answer;
	}

	// Query by vendor
	public ArrayList<Input> queryByVendor(String vendor) {

		 ArrayList<Input> answer=  inputList.stream().filter(t -> t.getVendor().equalsIgnoreCase(vendor))
				.collect(Collectors.toCollection(ArrayList::new));
			System.out.println("query by vendor "+answer);

		 return answer;
	}

	// Query by category
	public ArrayList<Input> queryByCategory(String category) {
		 ArrayList<Input> answer =  inputList.stream().filter(t -> t.getCategory().equalsIgnoreCase(category))
				.collect(Collectors.toCollection(ArrayList::new));
		 System.out.println("query by category "+answer);
		 return answer;
	}

	// Query by vendor and category (combo search)
	public ArrayList<Input> queryByVendorAndCategory(String vendor, String category) {
		return (ArrayList<Input>) inputList.stream()
				.filter(t -> t.getVendor().equalsIgnoreCase(vendor) && t.getCategory().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	}

	// Flexible query by multiple optional filters
	public ArrayList<Input> queryByMultipleFilters(Optional<Date> startDate, Optional<Date> endDate,
			Optional<String> vendor, Optional<String> category) {
		return  inputList.stream().filter(transactionMatches(startDate, endDate, vendor, category))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	// Helper method to build a predicate for flexible querying
	private Predicate<Input> transactionMatches(Optional<Date> startDate, Optional<Date> endDate,
			Optional<String> vendor, Optional<String> category) {
		return t -> (!startDate.isPresent() || !t.getDate().before(startDate.get()))
				&& (!endDate.isPresent() || !t.getDate().after(endDate.get()))
				&& (!vendor.isPresent() || t.getVendor().equalsIgnoreCase(vendor.get()))
				&& (!category.isPresent() || t.getCategory().equalsIgnoreCase(category.get()));
	}

	public Date parseDate(String dateString) throws ParseException {
		return dateFormat.parse(dateString);
	}
    public void printTransactions(ArrayList<Input> inpArrayList) {
    	inpArrayList.forEach(System.out::println);
    }
	
	
}
