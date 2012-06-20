package sortingalgorithm;

public class SelectionSort extends SortingAlgorithm {

	@Override
	public int[] sort(int[] list) {

		for (int i = 0; i < list.length - 2 ; i++) {
			int k = i;
			for (int j = i + 1; j < list.length - 1; j++) {
				if(list[j] < list[k]) {
					k = j;
				}
			}
			int x = list[k];
			list[k] = list[i];
			list[i] = x;
		}
		
		return list;
		
	}

}
