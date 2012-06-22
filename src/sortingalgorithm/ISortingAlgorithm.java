package sortingalgorithm;

public interface ISortingAlgorithm {

	void startTimeMeasurement();
	
	void stopTimeMeasurement();
	
	double getResultOfTimeMeasurement();
	
	int[] sort( int[] list);
	
}
