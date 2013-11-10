import java.util.ArrayList;
import java.util.HashSet;


public class EPI_6dot14 {

	
	public static void main(String[] args) {
		int[][] matrix = {	{5,3,4,6,7,8,9,1,2},
							{6,7,2,1,9,5,3,4,8},
							{1,9,8,3,4,2,5,6,7},
							
							{8,5,9,7,6,1,4,2,3},
							{4,2,6,8,5,3,7,9,1},
							{7,1,3,9,2,4,8,5,6},
							
							{9,6,1,5,3,7,2,8,4},
							{2,8,7,4,1,9,6,3,5},
							{3,4,5,2,8,6,1,7,9}	};
		
		System.out.println(checkSudoku(matrix));

	}
	
	public static boolean checkSudoku(int[][] matrix) {
		
		ArrayList<HashSet<Integer>> rowsSets = new ArrayList<HashSet<Integer>>(9);
		ArrayList<HashSet<Integer>> columnsSets = new ArrayList<HashSet<Integer>>(9);
		ArrayList<HashSet<Integer>> subSets = new ArrayList<HashSet<Integer>>(9);
		
		for(int i = 0; i < 9; i++) {
			rowsSets.add(new HashSet<Integer>());
			columnsSets.add(new HashSet<Integer>());
			subSets.add(new HashSet<Integer>());
		}
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				int num = matrix[i][j];
				
				if(num == 0) {
					continue;
				}
				
				if(rowsSets.get(i).contains(num)) {
					return false;
				} else {
					rowsSets.get(i).add(num);
				}
				
				if(columnsSets.get(j).contains(num)) {
					return false;
				} else {
					columnsSets.get(j).add(num);
				}
				
				int subGridi = (i/3)*3 + j/3;
				if(subSets.get(subGridi).contains(num)) {
					return false;
				} else {
					subSets.get(subGridi).add(num);
				}
			}
		}
		
		return true;		
	}

}
