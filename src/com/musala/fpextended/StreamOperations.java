package com.musala.fpextended;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class StreamOperations {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 20, -5, 40, 30);
		
		Optional<String> first = numbers.stream()
		.filter(x -> x % 2 == 0)
		.map(String::valueOf)
		.findFirst();
		
		System.out.println(first.get());
		
		try {
			Files.list(FileSystems.getDefault().getPath("src/com/musala/fp")).
					forEach(x -> System.out.println(x));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Reduction
		List<Integer> ints = Arrays.asList(1,2,3,4,5,2);
		Optional<Integer> res = ints.stream().min((x,y) -> x - y);
		
		//Mutable
		Set<Integer> even = ints.stream()
				.filter(x -> x % 2 == 0)
				.collect(Collectors.toSet());
		
		//Search
		boolean isThereBigInt = ints.stream().anyMatch(x -> x > 10);
		
		//Generic
		ints.forEach(x -> {
			if (x % 2 == 0) {
				System.out.print(x + " ");
			}
		});
	}
}
