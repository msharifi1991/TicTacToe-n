package dooz;
import java.awt.*;
import java.awt.List;
import java.util.*;

public class Tictactoe {
	static int u=0;
	static int e=0;
	static int level = 0;
	static int index=0;
	static int n=0;
	static int score = 0;
	static Scanner in = new Scanner(System.in);
	static boolean pcwithpc = true;
	boolean pcwithhuman = false;
	static boolean Xturn = true;
	static boolean Oturn = false;
	static int k=0;
	static char[] row = new char[3]; //3taii haye satri
	static char[] col = new char[3];// 3taii haye sotooni
	static char[] mov1 = new char[3]; //3taii haye movarrab1
	static char[] mov2 = new char[3]; //3taii haye movarrab2
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		//TODO inja input dialog ro bezar o begoo ke bazi beine ki o ki bashe.		
		getN();
		
	}
	
		public static int getN(){
			System.out.print("Enter your n:");
			int n = in.nextInt();
			createTable(n);
			return n;
		}
	public static char[][] createTable(int n) {
		
		int rowsnum = n;
		int colsnum = n;
		
		char arr[][] = new char[n][n];
		
		for(int i=0; i<n; i++){
			
			for(int j = 0; j<n; j++)
			arr[i][j] = '-';
			
			
		}
		//arr[0][1] = 'x';
		//arr[0][2] = 'o';
		arr[1][2] = 'x';
		arr[1][1] = 'x';
		arr[1][0] = 'x';
		arr[2][2] = 'x';
		arr[0][0] = 'x';
		
		for(int i=0; i<n; i++){
			System.out.print("\n");
			for(int j = 0; j<n; j++){
			System.out.print(arr[i][j] + " "); 
			}
		}
		/*for(int t=0;t<n;t++)
			for(int s=0;s<n;s++)
				if(arr[t][s] == '-')*/
				callMove(arr,n);
		//TODO barande shodan ro ham ezafe kon ke edame nade dige
	//		allOptions(arr, n);
		//priority(arr, row, col, mov1, mov2, n);
		//callMove(arr);
		//alphabeta(arr, row, col, mov1, mov2, n);
		return arr;
		}
	
		private static void callMove(char[][] arr, int n) {
		// TODO Auto-generated method stub
			int e = n*n;
			int node[][] = new int[e][5];
			if(pcwithpc){  //TODO 
				if(Oturn == true){
					move(arr,Oturn, allOptions(arr,n),'o', n, node, e); 
					level++;
				}
				else if(Xturn == true){
					//System.out.print("\nsalam");
			move(arr, Xturn, allOptions(arr,n),'x', n, node, e);
			level++;
				}}
	}

		private static int score(char c, char d, char e) {
		if(c == 'x'){
			score = 1;
			if(d == 'x') score = 10; else if(d == 'o') return 0;
			if(e == 'x'){if(score == 1) score = 10; else if(score == 10) {score = 100;}
				}
			else if(e == 'o') return 0;
			else if(e == '-'){if(score == 1) score = 1; else if(score == 10) score = 10;}
		}
		else if(c == 'o'){ score = -1;
			if(d == 'x') return 0;
			else if(d == '-'){if(e == '-') score = -1; else if(e == 'x') return 0; else if(e == 'o') score = -10;}
			else if(d == 'o'){if(e == '-') score = -10; else if(e == 'o') {score = -100;} else if(e == 'x') return 0;}			
		
		}
		else if(c == '-'){
			score = 0;
			if(d == 'x') score = 1; else if(d == 'o') score = -1;
			if(e == 'x'){if(score == 0) score = 1 ; else if(score == 1) score = 10; else if(score == -1) return 0;}
			if(e == 'o'){if(score == -1) score = -10; else if(score == 1) return 0; else if(score == 0) score =0;}
			if(e == '-'){if(score == 1) score = 1; else if(score == -1) score = -1; else if(d == '-') score = 0;}
		}
		return score;
				}
	
	private static int priority(char[][] arr, char[] row, char[] col, char[] mov1, char[] mov2, int n) {
		int tableScore = 0;
		int b = n - 3;
		int count=0;
	
		 
		for(int i=0; i<n; i++){ 
		for(int j=0; j<=b; j++) 
		{ 
			for(int k=0;k<3;k++){
			
			row[k] = arr[i][j+k];
			col[k] = arr[j+k][i];
			
			}count++;
			tableScore += score(row[0],row[1],row[2]);
			count++;
			tableScore +=score(col[0],col[1],col[2]);
		}
		
		//System.out.println("\nscore:" + tableScore + "\ncount:" + count);
		}
	
		for(int i=0; i<n-2; i++){
			for(int j=0; j<n-2; j++){
				for(int k=0;k<3;k++)
			mov1[k] = arr[i+k][j+k];
				count++;
				tableScore += score(mov1[0],mov1[1],mov1[2]);
				
			//	System.out.println("\nscore:" + tableScore + "\ncount:" + count);	
			}
			
	}
		for(int i=0; i <= n-3; i++){
			for(int j=n-1; j >= 2; j--){
				
				for(int k = 0; k<3; k++)
				mov2[k] = arr[i+k][j-k];
				
		count++;
		tableScore += score(mov2[0],mov2[1],mov2[2]);
		//System.out.println("\nscore:" + tableScore + "\ncount:" + count);
			}
			}
		
		return tableScore;
	}
	private static ArrayList<int[][]> allOptions(char[][] arr, int n ) { 
		
		ArrayList<int[][]> selection = new ArrayList<int[][]>(); 
		for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++){
		         if (arr[i][j] == '-') k++;
		         
		}}
		int m[][] = new int[k][2];
		for (int i = 0; i < n; i++) {
	       for (int j = 0; j < n; j++) {
	         if (arr[i][j] == '-') {
	          	m[u][0] = i; m[u][1] = j;
	        	 selection.add(u,m);
	        	 
	        	 u++;
	         }
	        	       }}
		
	 		 return selection; 
	}
	

	public static char[][] move(char[][] arr, boolean turn, ArrayList<int[][]> selection , char c, int n, int[][] node, int e){
	//	int k = selection.size();
		
		int[] arr2 = new int[2];
		int i=0; 
		while(i < k) { 
			
		arr2[0]  = selection.get(i)[i][0];  
		arr2[1]  = selection.get(i)[i][1]; 
		//System.out.print("salam:" + k); 
	//	newTable(n, arr2[0], arr2[1],arr, c, k, turn); 
		char[][] arr3 = new char[n][n]; 
		for(int p=0;p<n;p++)
			for(int q=0;q<n; q++)
				arr3[p][q]=arr[p][q];
		
		arr3[arr2[0]][arr2[1]] = c;
		makeTree(level, Xturn, arr2[0], arr2[1], score , n, node, e);
		i++;
		}
		return arr; 
		} 
		 
		private static void newTable(int n, int i, int j, char[][] arr, char c, int k2, boolean turn) { 
			
			char[][] arr3 = new char[n][n]; 
			for(int p=0;p<n;p++)
				for(int q=0;q<n; q++)
					arr3[p][q]=arr[p][q];
			//makeTree(level, Xturn, Oturn, i, j, score , n);
			arr3[i][j] = c;
		
			/*System.out.print("\n");
			for(int v=0; v<n; v++){
				System.out.print("\n");
				for(int z = 0; z<n; z++){
				System.out.print(arr3[v][z] + " "); 
				}}	System.out.print(priority(arr3,  row, col,  mov1, mov2,n));*/
		//for(i=0; i<k; i++)
			
			//scores.set(i, priority(arr3,  row, col,  mov1, mov2,n));
	}

		private static ArrayList<int[][]> makeTree(int level, boolean turn,
				int i, int j, int score, int n, int[][] node, int e) {
			int r=0;
			ArrayList<int[][]> tree = new ArrayList<int[][]>(); 
			for(r=0;r<e;r++){
			node[r][0] = level;
			node[r][1] = i;
			node[r][2] = j;
			node[r][3] = score;
			if(Xturn == true) node[r][4] = 1; else node[r][4] = 2;
			tree.add(r, node);
			}
		//	index++; 
			
			return tree; 
		}

		public int minimax(){
			
			return 0;}
		
		private static int bestScore(){
			int bestScore = 0;
			//bestScore = Integer.MAX_VALUE();
			return bestScore;
			
			}	
		/*private static int[] alphabeta(char[][] arr, char[] row, char[] col, char[] mov1, char[] mov2, int n ){

			ArrayList<int[]> allOptions = allOptions(arr, n); 
			//TODO  
			int alpha = 0;
			int beta;
			int tableScore = 0;
			 int depth = 0;
		      int bestRow = -1;
		      int bestCol = -1;
		 boolean max = false;
		 boolean min;
		      if (allOptions.isEmpty() || depth == 0) {
		         // Gameover or depth reached, evaluate score
		         tableScore = priority(arr, row, col, mov1, mov2, n);
		         int maxScore = bestScore();
		         if(max == true){
		         if(alpha <= maxScore)
		        	 alpha = maxScore;
		           }
	 
			
			}
		      return new int[] {tableScore, bestRow, bestCol};

	}

	*/	

	
	private static void win(char c) {
		System.out.printf("\n%c has won!!" , c);
	}

	
}