package main;

import sortingalgorithm.BubbleSort;
import sortingalgorithm.BucketSort;
import sortingalgorithm.HeapSort;
import sortingalgorithm.ISortingAlgorithm;
import sortingalgorithm.InsertionSort;
import sortingalgorithm.MergeSort;
import sortingalgorithm.QuickSort;
import sortingalgorithm.SelectionSort;
import sortingalgorithm.ShellSort;

public class Benchmark {

	static final int[] sizes = {1000, 10000, 100000};
	static ISortingAlgorithm[] sortingAlgorithms = new ISortingAlgorithm[8];
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		sortingAlgorithms[0] = new InsertionSort();
		sortingAlgorithms[1] = new SelectionSort();
		sortingAlgorithms[2] = new BubbleSort();
		sortingAlgorithms[3] = new ShellSort();
		sortingAlgorithms[4] = new HeapSort();
		sortingAlgorithms[5] = new QuickSort();
		sortingAlgorithms[6] = new MergeSort();
		sortingAlgorithms[7] = new BucketSort();

		int[] list;
		
		System.out.println("Size\tsortiert\tinvers\t\trandom1\t\t2\t\t3\t\t4\t\t5\n");

		for (ISortingAlgorithm algorithm : sortingAlgorithms) {

			if(algorithm == null) {
				continue;
			}
			
			System.out.println(algorithm.getClass().getSimpleName() + ": ");

			
			for (int size : sizes) {
				
				System.out.print(size + ":\t");
				
				int times = 0;
				double resultSum = 0;
				double result;
				double min = 0;
				double max = 0;

				// Sortierte Liste
				do {
					list = Universum.createSortedList(size);
					algorithm.sort(list);
					result = algorithm.getResultOfTimeMeasurement();
				    min = resultSum / times * .95;
				    max = resultSum / times * 1.05;
				    times++;
				    resultSum += result;
				} while(size <= 10000 &&(times == 1 || min > result || max < result));
				outputTime(resultSum, times);
				
				// Inverse Liste
				do {
					list = Universum.createInversList(size);
					algorithm.sort(list);
					result = algorithm.getResultOfTimeMeasurement();
				    min = resultSum / times * .95;
				    max = resultSum / times * 1.05;
				    times++;
				    resultSum += result;
				} while(size <= 10000 &&(times == 1 || min > result || max < result));
				outputTime(resultSum, times);

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

	private static void outputTime(double resultSum, int times) {

		double resultOfTimeMeasurement = resultSum / times;
		System.out.format("%f", resultOfTimeMeasurement);
		System.out.print("\t");
		
	}

	private static void outputTime(double resultOfTimeMeasurement) {
		
		System.out.format("%f", resultOfTimeMeasurement);
		System.out.print("\t");
		
	}

}
