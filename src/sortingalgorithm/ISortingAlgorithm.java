package sortingalgorithm;

public interface ISortingAlgorithm {

	void startTimeMeasurement();
	
	void stopTimeMeasurement();
	
	long getResultOfTimeMeasurement();
	
	Object[] sort( Object[] list);
	
}
