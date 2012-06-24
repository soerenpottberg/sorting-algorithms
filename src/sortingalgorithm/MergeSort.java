package sortingalgorithm;

public class MergeSort extends SortingAlgorithm {

	@Override
	public int[] sort(int[] list) {

		startTimeMeasurement();
		
		int oldLength = list.length;
		int potenz = (int) Math.ceil(Math.log(oldLength) / Math.log(2));
		int length = (int) Math.pow(2, potenz);
		int[] listA = new int[length];
		int[] listB = new int[length/2];
		int[] listC = new int[length];
		int[] listD = new int[length/2];
		
		for (int i = 0; i < oldLength; i++) {
			if(i%2 == 0) {
				listC[i/2] = list[i];
			} else {
				listD[i/2] = list[i];
			}
		}
		for (int i = oldLength; i < length; i++) {
			if(i%2 == 0) {
				listC[i/2] = Integer.MAX_VALUE;
			} else {
				listD[i/2] = Integer.MAX_VALUE;
			}
		}
		boolean odd = true;
		for(int blockSize = 1; blockSize <= listA.length / 2; blockSize *= 2) {
			if(odd) {
				merge(listC, listD, listA, listB, blockSize);
			} else {
				merge(listA, listB, listC, listD, blockSize);
			}
			odd = !odd;
		}
		
		stopTimeMeasurement();
		
		if(odd){
			for (int i = 0; i < oldLength; i++) {
				list[i] = listC[i];
			}
		} else {
			for (int i = 0; i < oldLength; i++) {
				list[i] = listA[i];
			}
		}
		
		return list;
		
	}

	private void merge(int[] listA, int[] listB, int[] listC, int[] listD, int blockSize) {

		for (int blockOffset = 0; blockOffset * blockSize <= listA.length / 2; blockOffset++) {
			if(blockOffset % 2 == 1) {
				mergeBlock(listA, listB, listD, blockOffset, blockSize);
			} else {
				mergeBlock(listA, listB, listC, blockOffset, blockSize);
			}
		}
		
	}

	private void mergeBlock(int[] listA, int[] listB, int[] listC, int blockOffset, int blockSize) {
		
		int a = blockOffset * blockSize;
		int b = a;
		int c = blockOffset / 2 * 2 * blockSize;
		int nextOffset = (blockOffset+1) * blockSize;
		while (a<nextOffset && b <nextOffset &&  a < listA.length &&  b < listB.length) {
			if (listA[a] <= listB[b]) {
				listC[c++] = listA[a];
				a++;
			} else {
				listC[c++] = listB[b];
				b++;
			}
		}
		while (a < nextOffset &&  a < listA.length) {
			listC[c++] = listA[a];
			a++;
		}
		while (b < nextOffset &&  b < listB.length) {
			listC[c++] = listB[b];
			b++;
		}
	
	}

}
