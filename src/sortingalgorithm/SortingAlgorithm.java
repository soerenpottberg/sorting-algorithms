package sortingalgorithm;

abstract public class SortingAlgorithm implements ISortingAlgorithm {

	private long startTime;
	private long resultTime;
	
	@Override
	public void startTimeMeasurement() {

		startTime = System.nanoTime();

	}

	@Override
	public void stopTimeMeasurement() {

		long endTime = System.nanoTime();
		resultTime = endTime - startTime;

	}

	@Override
	public double getResultOfTimeMeasurement() {

		return resultTime / 1000000000.0;

	}

}
