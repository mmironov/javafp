package com.musala.fpextended;

import java.util.Arrays;
import java.util.List;

public class VariableCapture {

	public static void main(String[] args) {
		
		List<Integer> ints = Arrays.asList(1, 2, 3, 4);
		
		int x = 20;
		
		ints.forEach(integer -> System.out.println(integer + x));
		
	}
}
