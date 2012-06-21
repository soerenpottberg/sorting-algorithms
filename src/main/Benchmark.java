package main;

import java.util.Arrays;

import sortingalgorithm.ISortingAlgorithm;
import sortingalgorithm.InsertionSort;
import sortingalgorithm.SelectionSort;

public class Benchmark {

	static final int[] sizes = {10};
	static ISortingAlgorithm[] sortingAlgorithms = new ISortingAlgorithm[2];
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		sortingAlgorithms[0] = new InsertionSort();
		sortingAlgorithms[1] = new SelectionSort();

		int[] list;

		for (ISortingAlgorithm algorithm : sortingAlgorithms) {

			System.out.println(algorithm.getClass().getSimpleName() + ": ");

			for (int size : sizes) {
				
				System.out.println(size);

				// Sortierte Liste
				list = Universum.createSortedList(size);
				System.out.println(Arrays.toString(list));
				algorithm.sort(list);
				System.out.println(Arrays.toString(list));
				System.out.println(algorithm.getResultOfTimeMeasurement() + " ");

				// Inverse Liste
				list = Universum.createInversList(size);
				System.out.println(Arrays.toString(list));
				algorithm.sort(list);
				System.out.println(Arrays.toString(list));
				System.out.println(algorithm.getResultOfTimeMeasurement()+ " ");

				// Zufällige Liste
				for (int i = 0; i < 5; i++) {
					list = Universum.createRandomList(size);
					System.out.println(Arrays.toString(list));
					algorithm.sort(list);
					System.out.println(Arrays.toString(list));
					System.out.println(algorithm.getResultOfTimeMeasurement() + " ");
				}

			}			
		}

		System.out.println("\n");

	}

}
