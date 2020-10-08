
public class RatMazeProblem {
	int no =4;
	public boolean printMazePath(int[][] maze) {
		// initialize matrix with value 0
		int [][] finalPath = new int[no][no];
		//
		if(!printMazePathUtil(finalPath, 0, 0, maze)) {
			System.out.println();
		}
		printPath(finalPath);
		return true;
	}
	boolean printMazePathUtil(int[][] finalPath, int xPath, int yPath, int[][] maze) {
		// if we reach till final destination then return true
		// check if xpath and ypath reach till the end and also ckeck 
		// the last path maze[4][4] is 1 or 0. if it 1 then in finalPath mark
		// as 1 then return true.
		if(xPath == no -1 && yPath == no -1 && maze[xPath][yPath] == 1) {
			finalPath[xPath][yPath] = 1;
			return true;
		}
		// now in perticular index first check the position is safe or not
		if(isSafe(xPath, yPath, maze)) {
			// if true mark the vlaue as 1 in finalPath
			finalPath[xPath][yPath] = 1;
			// then it will check down side of the graph
			// as rat maze problem rat first go to down side then right side
			// as this path is true then rat will go to downside
			if(printMazePathUtil(finalPath, xPath+1, yPath, maze)){
				return true;
			}
			if(printMazePathUtil(finalPath, xPath, yPath+1, maze)){
				return true;
			}
			// if printMazePathUtil return false
			// then finalPath will be 0
			finalPath[xPath][yPath] = 0;
			
		}
		
		return false;
	}
	boolean isSafe(int x, int y, int[][] maze) {
		// here it will check if x and y is greater than 0 or not and smaller than 4. if
		// yes then return true.
		if(x< no && x >= 0 && y < no && y >= 0 && maze[x][y] == 1) {
			return true;
		}
		return false;
	}
	void printPath(int[][] finalPath) {
		for(int i=0 ; i< no; i++) {
			for(int j=0; j< no; j++) {
				System.out.print(finalPath[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		RatMazeProblem rat = new RatMazeProblem();
		// initialize the matrix
		 int maze[][] = {{1, 0, 0, 0}, 
		                 {1, 1, 1, 0}, 
		                 {1, 0, 1, 1}, 
		                 {0, 0, 0, 1} 
		                }; 
		 rat.printMazePath(maze);
		 
	}
}
