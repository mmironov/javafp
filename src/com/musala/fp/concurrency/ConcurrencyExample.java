package com.musala.fp.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConcurrencyExample {

	public static void main(String[] args) {
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		
		pokemons.add(new Pokemon(10));
		pokemons.add(new Pokemon(1));
		pokemons.add(new Pokemon(4));
		pokemons.add(new Pokemon(4));
		pokemons.add(new Pokemon(4));
		pokemons.add(new Pokemon(20));
		pokemons.add(new Pokemon(100));
		pokemons.add(new Pokemon(14));
		pokemons.add(new Pokemon(3));
		pokemons.add(new Pokemon(5));
		pokemons.add(new Pokemon(11));
		pokemons.add(new Pokemon(11));
		
		Optional<Integer> closestDistance = 
				pokemons.parallelStream()
		.map(pokemon -> {
			System.out.println(Thread.currentThread().getName());
			return pokemon.distance();
		}).min((x, y) -> x - y);
		
		if (closestDistance.isPresent()) {			
			System.out.printf("The closest pokemon is at distance %d km.",
					closestDistance.get());
		}
	}
}

class Pokemon {
	
	private int distance;
	
	public Pokemon(int distance) {
		if (distance >= 0) {
			this.distance = distance;
		}
	}
	
	public int distance() {
		return distance;
	}
}