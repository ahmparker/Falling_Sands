
import edu.princeton.cs.algs4.StdRandom;

public class FallingSandModel {
	public static final int MODEL_SIZE = 200;
	public static final int METAL = 1;
	public static final int EMPTY = 0;
	public static final int SAND = 2;
	public static final int WATER = 3;
	public static final int ACID = 4; 
	
	private int[][] grid;
	private int mode;

	public FallingSandModel() {
		grid = new int[MODEL_SIZE][MODEL_SIZE];
		mode = METAL;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int i) {
		mode = i;
	}

	public int get(int i, int j) {
		return grid[i][j];
	}

	public boolean inGrid(int i, int j) {
		return i >= 0 && i < MODEL_SIZE && j >= 0 && j < MODEL_SIZE;
	}

	public void placeParticle(int i, int j) {
		grid[i][j] = mode;
	}

	public void step() {
		int row = StdRandom.uniform(MODEL_SIZE);
		int column = StdRandom.uniform(MODEL_SIZE);
		if (grid[row][column] > 0) {
			if (grid[row][column] == SAND) {
				sandStep(row, column);
			}

			if (grid[row][column] == WATER) {
				waterStep(row, column);
			}
			if (grid[row][column] == ACID) {
				acidStep(row, column);
			}
			
		}
	}

	public void sandStep(int i, int j) {
		if (inGrid(i, j - 1)) {
			if (grid[i][j - 1] == EMPTY) {
				grid[i][j - 1] = SAND;
				grid[i][j] = EMPTY;
			}
			if (grid[i][j - 1] == WATER) {
				grid[i][j - 1] = SAND;
				grid[i][j] = WATER;
			}
			
		}

	}

	public void waterStep(int i, int j) {
		int direction = StdRandom.uniform(3);
		// down = 0, left=1, right=2
		// down
		if (direction == 0 && inGrid(i, j - 1)) {
			if (grid[i][j - 1] == EMPTY) {
				grid[i][j - 1] = WATER;
				grid[i][j] = EMPTY;
			}
			
		}
		// left
		if (direction == 1 && inGrid(i - 1, j)) {
			if (grid[i - 1][j] == EMPTY) {
				grid[i - 1][j] = WATER;
				grid[i][j] = EMPTY;
			}
			
		}
		// right
		if (direction == 2 && inGrid(i + 1, j)) {
			if (grid[i + 1][j] == EMPTY) {
				grid[i + 1][j] = WATER;
				grid[i][j] = EMPTY;
			}
		}
			
		}
		public void acidStep(int i, int j) {
			int direction = StdRandom.uniform(3);
			// down = 0, left=1, right=2
			// down
			if (direction == 0 && inGrid(i, j - 1)) {
				if ((grid[i + 1][j] == EMPTY) || (grid[i + 1][j] == METAL) || (grid[i + 1][j] == SAND)) {
					grid[i][j - 1] = ACID;
					grid[i][j] = EMPTY;
				}
				

			}
			// left
			if (direction == 1 && inGrid(i - 1, j)) {
				if ((grid[i + 1][j] == EMPTY) || (grid[i + 1][j] == METAL) || (grid[i + 1][j] == SAND)) {
					grid[i - 1][j] = ACID;
					grid[i][j] = EMPTY;
				}
				

			}
			// right
			if (direction == 2 && inGrid(i + 1, j)) {
				if ((grid[i + 1][j] == EMPTY) || (grid[i + 1][j] == METAL) || (grid[i + 1][j] == SAND)) {
					grid[i + 1][j] = ACID;
					grid[i][j] = EMPTY;
				}
				
			}

	}

	
}
