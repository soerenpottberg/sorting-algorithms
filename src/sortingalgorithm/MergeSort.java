package sortingalgorithm;

import java.util.Arrays;

public class MergeSort extends SortingAlgorithm {

	@Override
	public int[] sort(int[] listA) {

		startTimeMeasurement();
		
		int length = listA.length;
		int[] listB = new int[length/2];
		int[] listC = new int[length];
		int[] listD = new int[length/2];
		
		for (int i = 0; i < listA.length; i++) {
			if(i%2 == 0) {
				listC[i/2] = listA[i];
			} else {
				listD[i/2] = listA[i];
			}
		}
		boolean odd = true;
		for(int i = 1; i < listA.length; i *= 2) {
			if(odd) {
				merge(listC, listD, listA, listB);
			} else {
				merge(listA, listB, listC, listD);
			}
			odd = !odd;
		}
		
		stopTimeMeasurement();
		
		if(odd){
			listA = Arrays.copyOf(listC, listA.length);
		}
		
		return listA;
		
	}

	private void merge(int[] listA, int[] listB, int[] listC, int[] listD) {

		int a = 0;
		int b = 0;
		int[] result = {a, b};
		for (int i = 0; i < listA.length; i++) {
			if(i % 2 == 1) {
				result = run(listA, listB, listD, result[0], result[1]);
			} else {
				result = run(listA, listB, listC, result[0], result[1]);
			}
			if(result[0] + result[1] >= listC.length) {
				break;
			}
		}
		
	}

	private int[] run(int[] listA, int[] listB, int[] listC, int i, int j) {
		
		int m = listA.length / 2;
		while (i<m && j <m  && i + j < listC.length) {
			if (listA[i] <= listB[j]) {
				listC[i+j] = listA[i];
				i++;
			} else {
				listC[i+j] = listB[j];
				j++;
			}
		}
		while (i < m && i + j < listC.length) {
			listC[i+j] = listA[i];
			i++;
		}
		while (j < m && i + j < listC.length) {
			listC[i+j] = listB[j];
			j++;
		}
		
		int[] result = {i, j};
		return result;
	
	}

}
