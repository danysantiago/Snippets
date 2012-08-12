
public class Checkers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[][] testTable = new int[][]{{0,0,0,0,0,1},
//				                        {0,0,1,0,0,0},
//				                        {0,0,0,0,1,0},
//				                        {0,1,0,0,0,0},
//				                        {0,0,0,1,0,0},
//				                        {1,0,0,0,0,0}};
		
		//System.out.println(checkAllStones(testTable));
		
		int[][] table = new int[6][6];
		
		int numOfSol = 0;
		
		for(int a = 0; a < 6; a++){
			table[a][5] = 1;
			for(int b = 0; b < 6; b++){
				table[b][4] = 1;
				for(int c = 0; c < 6; c++){
					table[c][3] = 1;
					for(int d = 0; d < 6; d++){
						table[d][2] = 1;
						for(int e = 0; e < 6; e++){
							table[e][1] = 1;
							for(int f = 0; f < 6; f++){
								table[f][0] = 1;

								if(checkAllStones(table)){
									printSol(table);
									numOfSol++;
									
								}
								table[f][0] = 0;
							}
							table[e][1] = 0;
						}
						table[d][2] = 0;
					}
					table[c][3] = 0;
				}
				table[b][4] = 0;
			}
			table[a][5] = 0;
		}

		System.out.println("\nTHERE ARE " + numOfSol + " SOLUTIONS TO THE 6X6 CHECKER CHALLENGE.");
	}
	
	public static void printSol(int[][] table) {
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(table[i][j] == 1)
					System.out.print((j+1) + " ");
			}
		}
		
		System.out.println("");
	}

	public static boolean checkAllStones(int[][] table){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(table[i][j] == 1){
					if(!checkStone(table, i, j)){
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public static boolean checkStone(int[][] table, int fila, int columna){
		//check row
		for(int j = 0; j < 6; j++){
			if(table[fila][j] == 1 && j != columna){
				return false;
			}
		}
		//check west-north diagonal
		for(int i = fila, j = columna; i >= 0 && j >= 0; i--, j--){
			if(table[i][j] == 1 && i != fila && j != columna){
				return false;
			}
		}
		//check west-south diagonal
		for(int i = fila, j = columna; i < 6 && j >= 0; i++, j--){
			if(table[i][j] == 1  && i != fila && j != columna){
				return false;
			}
		}
		//check east-south diagonal
		for(int i = fila, j = columna; i < 6 && j < 6; i++, j++){
			if(table[i][j] == 1  && i != fila && j != columna){
				return false;
			}
		}
		//check east-north diagonal
		for(int i = fila, j = columna; i >= 0 && j < 6; i--, j++){
			if(table[i][j] == 1 && i != fila && j != columna){
				return false;
			}
		}
		return true;
	}

}
