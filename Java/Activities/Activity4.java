package Activities;

import java.util.Arrays;

public class Activity4 {
	public static void main(String[] args) {
		int[] numArray = {1, 2, 5, 3, 10, 4, 8, 6, 7, 9};
		System.out.println("Array before sort: "+ Arrays.toString(numArray));
		ascendingSort(numArray);
		System.out.println("Array after sort: "+ Arrays.toString(numArray));
	}

	
	static void ascendingSort(int numArray[]) {
		int size = numArray.length, i;
		
		for(i=1; i < size; i++) {
			int key = numArray[i];
			int j= i-1;
			
			while(j>0 && key<numArray[j]) {
				numArray[j+1] = numArray[j];
				--j;
			}
			numArray[j+1] = key;
		}
	}
}
