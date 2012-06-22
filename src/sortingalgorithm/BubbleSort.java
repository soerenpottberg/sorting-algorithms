package sortingalgorithm;

public class BubbleSort extends SortingAlgorithm {

	@Override
	public int[] sort(int[] list) {
		
		startTimeMeasurement();

		for (int i = 1; i < list.length; i ++) {
			for (int j = list.length - 1; j >= i; j--) {
				if (list[j-1] > list[j]) {
					int x = list[j];
					list[j] = list[j-1];
					list[j-1] = x;
				}
			}
		}
		
		stopTimeMeasurement();
		
		return list;
		
	}

}
