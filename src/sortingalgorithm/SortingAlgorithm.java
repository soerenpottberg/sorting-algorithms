package sortingalgorithm;

abstract public class SortingAlgorithm implements ISortingAlgorithm {

	private long startTime;
	private long resultTime;
	
	@Override
	public void startTimeMeasurement() {

		startTime = System.currentTimeMillis();

	}

	@Override
	public void stopTimeMeasurement() {

		long endTime = System.currentTimeMillis();
		resultTime = endTime - startTime;

	}

	@Override
	public double getResultOfTimeMeasurement() {

		return resultTime / 1000.0;

	}

}
