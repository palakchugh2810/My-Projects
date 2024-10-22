package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamIntermediate {

	public static void main(String[] args) {

		HashMap<Integer, String> unsortedMap = new HashMap<>();
		unsortedMap.put(5, "palak");
		unsortedMap.put(9, "shubham");
		unsortedMap.put(2, "rahul");
		/* Given lists */
		List<Integer> numbers = Arrays.asList(1, 2, 9, 4, 5, 6, 9, 4, 7, 3);
		// String listOfLists[][]= {{"a","b"}, {"c","d"}, {"e","f"}};
		List<List<String>> listOfLists = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "d"),
				Arrays.asList("e", "f"));
		List<String> names = Arrays.asList("alice", "bob", "charlie");

		List<Employee> employees = Arrays.asList(new Employee("Alice", 50000), new Employee("Bob", 75000),
				new Employee("Charlie", 30000), new Employee("David", 60000));

		/* -----filter-------- */
		List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).distinct() // Intermediate operation
				.collect(Collectors.toList());
		System.out.println(evenNumbers);

		/*------- map------------ */
		List<String> upperCaseNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(upperCaseNames); // Output: [ALICE, BOB, CHARLIE]

		/*--------- sorted -------------*/
		List<String> sortedNames = names.stream().sorted().distinct().collect(Collectors.toList());
		System.out.println(sortedNames);

		/* ----------reverse----------------- */
		List<String> reverseNames = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverseNames);

		/*------- distinct------------ */
		List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctNumbers);

		/* limit */
		List<Integer> limitFourList = numbers.stream().limit(4).collect(Collectors.toList());
		System.out.println(limitFourList);

		/* flatmap */
		List<String> flatList = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(flatList);

		/* peek is used for debugging */
		List<String> peek = names.stream().peek(n -> System.out.println("Processing: " + n))
				.collect(Collectors.toList());
		System.out.println(peek);

		List<Employee> sortedEmployees = employees.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());

		sortedEmployees.forEach(System.out::println);
		Map<String, Double> employeeMap = employees.stream().sorted(Comparator.comparing(Employee::getSalary)) // Sort
																												// by
																												// salary
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary, (existing, replacement) -> existing,
						LinkedHashMap::new));

		/*
		 * streams on map
		 */

		List<Entry<Integer, String>> sortedMap = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toList());
		System.out.println("map to sorted list" + sortedMap);

		List<Entry<Integer, String>> distinctMap = unsortedMap.entrySet().stream().skip(2).collect(Collectors.toList());
		System.out.println("skip map " + distinctMap);

		Map<Integer, String> streamMap = unsortedMap.entrySet().stream().skip(2)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("streamed map " + streamMap);

		Map<Integer, String> sortedStreamMap = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("sorted streamed map " + sortedStreamMap);
		
		numbers.stream().filter(line->line.equals(2)).collect(Collectors.toList());
		
		//parallel stream
		numbers.parallelStream().anyMatch(s->s.equals(2));
		
		employees.stream().sorted(Comparator.comparing(Employee :: getName).thenComparing(Employee :: getSalary)).collect(Collectors.toList());
		
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry:: getKey, Map.Entry:: getValue));

	}

}
