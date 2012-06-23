package sortingalgorithm;

public class ShellSort extends SortingAlgorithm {

	@Override
	public int[] sort(int[] list) {

		int maxColumns = (int)(Math.log(list.length)/Math.log(3)) - 1;
		maxColumns = maxColumns > 0 ? maxColumns : 1;
		int[] columns = new int[maxColumns];
		
		columns[0] = 1;
		for (int i = columns.length - 2; i >= 0; i--) {
			columns[i] = columns[i + 1] * 3 + 1;
		}
		
		startTimeMeasurement();

		for (int column : columns) {
			int h = column;
			for (int i=h; i<list.length; i++) {
				int x = list[i];
				int j=i;
				while (j>=h && list[j-h]>x) {
					list[j] = list[j-h];
					j=j-h;
				}
				list[j]=x;
			}
		}
		
		stopTimeMeasurement();
		
		return list;
		
	}

}
