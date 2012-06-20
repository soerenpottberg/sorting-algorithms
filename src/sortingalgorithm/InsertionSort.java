package sortingalgorithm;

public class InsertionSort extends SortingAlgorithm {

	@Override
	public int[] sort(int[] list) {
		
		if(list.length == 0) {
			return list;
		}

		for (int i = 0; i < list.length - 2; i++) {
			int currentEntry = list[i];
			int j = i;
			while (j > 0 && list[j-1] > currentEntry) {
				list[j] = list[j-1];
				j--;
			}
			list[j] = currentEntry;
		}
		
		return list;
		
	}

}
