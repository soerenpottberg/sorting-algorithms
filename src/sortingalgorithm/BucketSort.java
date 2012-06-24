package sortingalgorithm;

import java.util.ArrayList;
import java.util.List;


public class BucketSort extends SortingAlgorithm {

	@Override
	public int[] sort(int[] list) {
		
		startTimeMeasurement();
		
		sort(list, 0);

		stopTimeMeasurement();		

		return list;
		
	}
	
	private int[] sort(int[] list, int position) {
		
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new ArrayList[10];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		
		for (int element : list) {
			int index = (int) ((int)(element / Math.pow(10, position)) % 10);
			buckets[index].add(element);
		}
		
		int i = 0;
		for (List<Integer> bucket : buckets) {
			for (Integer element : bucket) {
				list[i++] = element;
			}
		}
		
		if(Math.pow(10, position) < list.length) {
			sort(list, ++position);
		}
		
		return list;
		
	}

}
