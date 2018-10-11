package com.musala.fpextended;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamSourceExample {

	public static void main(String[] args) {
		
		IntStream.range(0, 1).forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		List<String> countries = Arrays.asList("Bulgaria", "Serbia", "Canada");
		
		countries.stream().forEach(country -> System.out.println(country));
	}
}
