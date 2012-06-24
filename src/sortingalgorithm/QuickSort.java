package sortingalgorithm;

public class QuickSort extends SortingAlgorithm {

	@Override
	public int[] sort(int[] list) {
		
		startTimeMeasurement();
		
		sort(0, list.length - 1, list);
		
		stopTimeMeasurement();
		
		return list;
		
	}
	
	private int[] sort( int left, int right, int[] list) {
		
		int i;
		while(right > left) {
			i = left - 1;
			int j = right;
			int pivotIndex = getMedian(left, right, (left + right) / 2, list);
			int pivot = list[pivotIndex];
			list[pivotIndex] = list[right];
			list[right] = pivot;
			while (true) {
				do {
					i++;
				} while (i < right && list[i] < pivot);
				do {
					j--;
				} while (j > left && list[j] > pivot);
				if(i >= j) {
					break;
				}
				int x = list[i];
				list[i] = list[j];
				list[j] = x;
			}
			int x = list[i];
			list[i] = list[right];
			list[right] = x;
			sort(left,i - 1, list);
			//sort(i + 1,right, list); wird iterativ durch das while simuliert
			left = i + 1;
		}
		
		return list;
				
	}

	private int getMedian(int left, int right, int middle, int[] list) {
		if(list[left] >= list[right]) {
			if(list[left] <= list[(left + right) / 2]) {
				return left;
			} else if(list[right] >= list[middle] ) {
				return right;
			} else {
				return (left + right) / 2;
			}	
		} else {
			if(list[left] >= list[middle]) {
				return left;
			} else if(list[right] <= list[middle]) {
				return right;
			} else {
				return (left + right) / 2;
			}	
		}
		
	}

}
