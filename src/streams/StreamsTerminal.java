package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamsTerminal {

	public static void main(String[] args) {
		HashMap<Integer, String> unsortedMap = new HashMap<>();
		unsortedMap.put(5, "palak");
		unsortedMap.put(9, "shubham");
		unsortedMap.put(2, "rahul");
		/* Given lists */
		List<Integer> numbers = Arrays.asList(1, 2, 9);
		
		List<String> names = Arrays.asList("alice", "bob", "charlie");

		
		/*
		 * forEach
		 */		 
		numbers.stream().forEach(s->System.out.println(s));
		
		/* count */
		long countNamesWithS = names.stream().filter(s->s.startsWith("a")).count();
		System.out.println(countNamesWithS);
		
		/* reduce */
		Optional<Integer> sum = numbers.stream().reduce((a,b)->a+b);
		System.out.println(sum);
		
		OptionalDouble reslist = numbers.stream().mapToInt(Integer::intValue).average();
		unsortedMap.entrySet().stream().anyMatch(s->s.equals("a"));
		Map<Integer, String> result = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		numbers.forEach(System.out::println);
		//unsortedMap.keySet().stream().c
		names.stream()
        .map(String::toUpperCase)  // Convert each name to uppercase
        .collect(Collectors.toList());
		names.forEach(System.out::println);

	}

}
