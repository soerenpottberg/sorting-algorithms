package sortingalgorithm;

public class HeapSort extends SortingAlgorithm {

	@Override
	public int[] sort(int[] list) {
		
		startTimeMeasurement();
		
		arrayToHeap(list);
		
		int right = list.length - 1;
		while (right > 0) {
			int x = list[0];
			list[0] = list[right];
			list[right] = x;
			right--;
			sift(0, right, list);
		}
		
		stopTimeMeasurement();
		
		return list;
		
	}
	
	private void sift(int left, int right, int[] list) {
		
		int i = left;
		int j = 2 * i;
		int x = list[left];
		while (j <= right) {
			if (j < right && list[j+1] > list[j]) {
				j ++;
			}
			if (list[j] > x) {
				list[i] = list[j];
				list[j] = x;
				i = j;
				j = 2 * i ;
			} else {
				j = right + 1;
			}
		}
		
	}
		
	void arrayToHeap(int[] list) {
		
		int left = (list.length) / 2;
		while (left > 0) {
			left--;
			sift(left, list.length - 1 , list);
		}		
		
	}
	
}
