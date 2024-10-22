package Miscellaneous;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class Inputmain {
	public static void main(String[] args) throws ParseException {
		ArrayList<String> inputs = new ArrayList<>();
		inputs.add("01/01/2023 $100.44 FitnessClub (Exercise)");
		inputs.add("05/07/2022 $50.25 Xerox (Instrument)");
		inputs.add("09/01/2021 $70.55 Apple (Food)");

		InputService service = new InputService(inputs);

		
		
		Date startDate = service.parseDate("10/10/2022");
		Date endDate = service.parseDate("01/01/2023");
		double price=100.44;
	    service.queryByDateRange(startDate, endDate);

		
		service.queryByVendor("FitnessClub");

		
		service.queryByCategory("Instrument");

		
	   service.queryByVendorAndCategory("Apple", "Food");
	   System.out.println("\nTransactions with flexible filters:");
       service.printTransactions(service.queryByMultipleFilters(Optional.of(startDate), Optional.empty(), Optional.of("Apple"), Optional.of("Food")));

	}		
}
