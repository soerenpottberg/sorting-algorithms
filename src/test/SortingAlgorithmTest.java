package test;

import java.util.Arrays;

import main.Universum;
import sortingalgorithm.ISortingAlgorithm;
import junit.framework.TestCase;

public class SortingAlgorithmTest extends TestCase{
	
	ISortingAlgorithm algorithm;

	public void testSort1() {
		
		if(algorithm == null) {
			return;
		}
		
		int[] list = {1, 2, 3, 4};
		
		algorithm.sort(list);
		
		assertEquals(1, list[0]);
		assertEquals(2, list[1]);
		assertEquals(3, list[2]);
		assertEquals(4, list[3]);
		
	}
	
    public void testSort2() {
    	
    	if(algorithm == null) {
			return;
		}
		
		int[] list = {4, 3, 2, 1};
		
		algorithm.sort(list);
		
		assertEquals(1, list[0]);
		assertEquals(2, list[1]);
		assertEquals(3, list[2]);
		assertEquals(4, list[3]);
		
	}
    
    public void testSort3() {
    	
    	if(algorithm == null) {
			return;
		}
		
		int[] list = {3, 4, 1, 2};
		
		algorithm.sort(list);
		
		assertEquals(1, list[0]);
		assertEquals(2, list[1]);
		assertEquals(3, list[2]);
		assertEquals(4, list[3]);
		
	}
    
    public void testSort4() {
    	
    	if(algorithm == null) {
			return;
		}
		
    	int[] list = Universum.createRandomList(1000);
		int[] copy = list.clone();
    	algorithm.sort(list);
    	Arrays.sort(copy);
		
    	for (int i = 0; i < list.length; i++) {
    		assertEquals(copy[i], list[i]);
		}
		
	}
	
}
