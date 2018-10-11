package com.musala.fp.immutability;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ImmutabilityExamples {

	public static void main(String[] args) {
		
		//Mutable mindset - DO NOT USE!
		List<MutableNumber> numbers = Arrays.asList(
						new MutableNumber(1),
						new MutableNumber(2),
						new MutableNumber(3));
		
		numbers.forEach(number -> {
			if (number.x % 2 != 0) {
				number.x *= -1;
			}
		});
		
		//Immutable mindset
		List<MutableNumber> list = Arrays.asList(
				new MutableNumber(1),
				new MutableNumber(2),
				new MutableNumber(3));
		
		List<MutableNumber> changed = list.stream().map(number -> {
			if (number.x % 2 != 0) {
				return new MutableNumber(number.x * (-1));
			}
			
			return new MutableNumber(number.x);
		}).collect(Collectors.toList());
		
		System.out.println(numbers);
		System.out.println(changed);
	}
}

class MutableNumber {
	int x;
	
	public MutableNumber(int x) {
		this.x = x;
	}
	
	@Override
	public String toString() {
		return String.valueOf(x);
	}
}