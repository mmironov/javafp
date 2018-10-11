package com.musala.fp.functions;

import java.util.function.Function;

public class Functions {

	public static void main(String[] args) {
		
		Function<Integer, String> f =
				Function.<Integer>identity()
				.andThen(x -> x * 2).andThen(String::valueOf);
		
		String result = f.apply(5);
		
		System.out.println(result);
	}
}