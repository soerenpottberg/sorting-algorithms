package sortingalgorithm;

public interface ISortingAlgorithm {

	void startTimeMeasurement();
	
	void stopTimeMeasurement();
	
	long getResultOfTimeMeasurement();
	
	int[] sort( int[] list);
	
}
