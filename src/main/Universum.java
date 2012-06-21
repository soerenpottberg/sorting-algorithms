package main;

import java.util.Random;

public class Universum {

	public static int[] createSortedList(int size) {
		
		int[] list = new int[size];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = i;
		}
		
		return list;
		
	}

	public static int[] createInversList(int size) {
		
		int[] list = new int[size];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = list.length - i;
		}
		
		return list;
		
	}

	public static int[] createRandomList(int size) {
		
		int[] list = new int[size];
		Random random = new Random();
		
		for (int i = 0; i < list.length; i++) {
			list[i] = random.nextInt();
		}
		
		return list;
		
	}

}
