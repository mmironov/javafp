package com.musala.fp.functions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaExpressions {
	
	public static void main(String[] args) {
		showExamples();
	}
	
	public void sortWithJava7() {
		
		List<Rectangle> rects = new ArrayList<Rectangle>();
		
		rects.add(new Rectangle(1, 2));
		rects.add(new Rectangle(10, 20));
		rects.add(new Rectangle(4, 3));
		
		rects.sort(new Comparator<Rectangle>() {
			@Override
			public int compare(Rectangle left, Rectangle right) {
				return (int) (left.area() - right.area());
			}
		});
	}
	
	public void sortWithJava8() {
		
		List<Rectangle> rects = new ArrayList<Rectangle>();
		
		rects.add(new Rectangle(1, 2));
		rects.add(new Rectangle(10, 20));
		rects.add(new Rectangle(4, 3));
		
		rects.sort((left, right) -> (int) (left.area() - right.area()));
	}
	
	public static void showExamples() {
		Runnable f = () -> System.out.println("Lambda");
		
		Function<String, Integer> length = string -> string.length();
		
		BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> x + y;
		BiFunction<Double, Double, Double> divide = (x, y) -> {
			
			return x / y;};
		
		ArrayList<String> strings = new ArrayList<String>();
		strings.forEach(string -> System.out.println(string.length()));
		
		f.run();
		System.out.println(length.apply("hello"));
		System.out.println(add.apply(5, 6));
		System.out.println(divide.apply(1.0, 2.0));
	}
}

class Rectangle {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		width = width > 0 ? width : 1;
		height = height > 0 ? height : 1;
		
		this.width = width;
		this.height = height;
	}
	
	public double area() {
		return width * height;
	}
}