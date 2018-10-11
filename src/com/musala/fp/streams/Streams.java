package com.musala.fp.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

	static void simpleExample() {
		List<Integer> numbers = Arrays.asList(1, -2, 3, 4, 5);

		Optional<String> number = numbers.stream()
				.filter(x -> x % 2 == 0 && x > 0)
				.map(String::valueOf)
				.findFirst();

		if (number.isPresent()) {
			System.out.println(number.get());
		}
	}

	static void mapExample() {
		
		List<Player> players = new ArrayList<Player>();
		
		players.add(new Player("Nathan", 14));
		players.add(new Player("Michael", 0));
		players.add(new Player("Ian", 7));
		players.add(new Player("Seth", -1));
		
		Stream<String> namesStream = players.stream()
				.map(player -> player.getName())
				.map(name -> name.toUpperCase());
		
		namesStream.forEach(x -> System.out.println(x)); //You can also provide a static function!
	}
	
	static void filterExample() {
		List<Player> players = new ArrayList<Player>();
		
		players.add(new Player("Nathan", 14));
		players.add(new Player("Michael", 0));
		players.add(new Player("Ian", 7));
		players.add(new Player("Seth", -1));
		
		List<Player> positivePoints = 
				players.stream().filter(player -> player.getPoints() > 0).collect(Collectors.toList());
		
		positivePoints.forEach(player -> System.out.println(player.getPoints()));
	}
	
	static void reduceExample() {
		List<Player> players = new ArrayList<Player>();
		
		players.add(new Player("Nathan", 14));
		players.add(new Player("Michael", 0));
		players.add(new Player("Ian", 7));
		players.add(new Player("Seth", -1));
		
		int sum = players.stream()
				.reduce(new Player(), (p1, p2) -> new Player("", p1.getPoints() + p2.getPoints()))
				.getPoints();
		
		System.out.println("Sum is: " + sum);
	}
	
	static void sumInJava7() {
		List<Player> players = new ArrayList<Player>();
		
		players.add(new Player("Nathan", 14));
		players.add(new Player("Michael", 0));
		players.add(new Player("Ian", 7));
		players.add(new Player("Seth", -1));
		
		int sumOfPositivePoints = 0;
		for(Player p : players) {
			
			if (p.getPoints() > 0) {				
				sumOfPositivePoints += p.getPoints();
			}
		}
		
		System.out.println(sumOfPositivePoints);
	}
	
	static void sumOfAllPlayersWithPositiveScores() {
		List<Player> players = new ArrayList<Player>();
		
		players.add(new Player("Nathan", 14));
		players.add(new Player("Michael", 0));
		players.add(new Player("Ian", 7));
		players.add(new Player("Seth", -1));
		players.add(new Player("Miro", 14));
		
		int sum = players.stream()
		.map(player -> player.getPoints())
		.filter(points -> points > 0)
		.distinct()
		.reduce(0, (x, y) -> x + y); //What if we wanted the biggest score?
		
		String reduced = players.parallelStream()
		.map(player -> player.getName())
		.reduce("", (x, y) -> x + y);
		
		System.out.println("Sum is: " + sum);
		System.out.println("Reduced: " + reduced);
	}
	
	static void infiniteStreamsExample() {
		Random r = new Random();
		IntStream ints = r.ints(0, 100);
		
		ints.limit(3).forEach(x -> System.out.println(x));
	}
	
	public static void main(String[] args) {
		simpleExample();
//		mapExample();
//		filterExample();
//		reduceExample();
//		sumOfAllPlayersWithPositiveScores();
//		infiniteStreamsExample();
	}
}

class Player {
	
	private int points;
	private String name;
	
	public Player() {
		points = 0;
		name = "";
	}
	
	public Player(String name, int points) {
		this.points = points;
		this.name = name;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}