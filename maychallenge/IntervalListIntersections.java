package maychallenge;

import java.util.ArrayList;

public class IntervalListIntersections {

	public int[][] intervalIntersection(int[][] A, int[][] B) {
		
		int lengthA = A.length;
		int lengthB = B.length;
		int i = 0, j = 0;
		
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
		
		while(i < lengthA && j < lengthB) {
			if(checkForIntersection(A[i], B[j])) {
				ArrayList<Integer> row = new ArrayList<>();
				row.add(Math.max(A[i][0], B[j][0]));
				row.add(Math.min(A[i][1], B[j][1]));
				resultList.add(row);
			}
			
			if(A[i][1] < B[j][1]) {
				i++;
			} else if(A[i][1] > B[j][1]) {
				j++;
			} else {
				i++;
				j++;
			}
		}	
		
		int[][] result = new int[resultList.size()][2];
		for(i = 0; i < resultList.size(); i++) {
			for(j = 0; j < 2; j++) {
				result[i][j] = resultList.get(i).get(j);
			}
		}
				
		return result;
		
   }

	public boolean checkForIntersection(int[] A, int[] B) {
		return (A[1] >= B[0] && B[1] >= A[0]);
	}

}
