package com.musala.fp.functions;

import java.util.function.Function;

@SuppressWarnings("unused")
public class MethodReferences {

	public static void main(String[] args) {
		
		//static
		new Thread(() -> printNumbers()).start();
		new Thread(MethodReferences::printNumbers).start();
		
		//constructor
		Function<String, Integer> converter = x -> new Integer(x);
		Function<String, Integer> constructor = Integer::new;
		
		System.out.println(constructor.apply("100"));
		
		//nonstatic
		MethodReferences instance = new MethodReferences();
		new Thread(instance::sayHello).start();
		
		//invoked on the object
		Function<String, String> upperConverterLong = str -> str.toUpperCase();
		Function<String, String> upperConverter = String::toUpperCase;
		System.out.println(upperConverter.apply("abc"));
	}
	
	private static void printNumbers() {
		for(int i=0; i < 10; ++i) {
			System.out.println(i);
		}
	}
	
	private void sayHello() {
		System.out.println("hello");
	}
}
