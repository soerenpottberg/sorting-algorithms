package main;

import java.util.Arrays;

import sortingalgorithm.BubbleSort;
import sortingalgorithm.ISortingAlgorithm;
import sortingalgorithm.InsertionSort;
import sortingalgorithm.SelectionSort;

public class Benchmark {

	static final int[] sizes = {1000, 10000};
	static ISortingAlgorithm[] sortingAlgorithms = new ISortingAlgorithm[3];
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		sortingAlgorithms[0] = new InsertionSort();
		sortingAlgorithms[1] = new SelectionSort();
		sortingAlgorithms[2] = new BubbleSort();

		int[] list;

		for (ISortingAlgorithm algorithm : sortingAlgorithms) {

			System.out.println(algorithm.getClass().getSimpleName() + ": ");

			for (int size : sizes) {
				
				System.out.print(size + ":\t");

				// Sortierte Liste
				list = Universum.createSortedList(size);
				algorithm.sort(list);
				outputTime(algorithm.getResultOfTimeMeasurement());

				// Inverse Liste
				list = Universum.createInversList(size);
				algorithm.sort(list);
				outputTime(algorithm.getResultOfTimeMeasurement());

				// Zufällige Liste
				for (int i = 0; i < 5; i++) {
					list = Universum.createRandomList(size);
					algorithm.sort(list);
					outputTime(algorithm.getResultOfTimeMeasurement());
				}
				
				System.out.println("");

			}
			
			
			
		}

	}

	private static void outputTime(double resultOfTimeMeasurement) {
		
		System.out.format("%f", resultOfTimeMeasurement);
		System.out.print("\t");
		
	}

}
