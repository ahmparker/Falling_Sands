public class FallingSandModel {

	public static final int MODEL_SIZE = 200;
	public static final int METAL = 0;
	public static final int EMPTY = 1;
	public static final int SAND = 2;
	public static final int WATER = 3;
	public static final int ACID = 4;

	private int [][] grid;
	private int mode;
	
	public int getMode() {
		return mode;
		
	}
	
	public FallingSandModel() {
		grid = new int [MODEL_SIZE][MODEL_SIZE]; //intializes our 200 x 200 grid
		mode = METAL;
	}

	public int get(int x, int y) {
		return grid[x][y]; //returns our x y coordination
	}

	public boolean inGrid(int x, int y) {
		return (x >=0 && x < MODEL_SIZE && y >=0 && y < MODEL_SIZE); //returns true if both x and y values are at least 0 and smaller than the MODEL_SIZE we define
	}

	public void placeParticle(int x, int y) {
		
		grid[x][y] = mode;
		
	}
      
	public void setMode(int i) {
		mode = i;
		
	}

	public void step() {
		// TODO Auto-generated method stub
		
	}

	public void acidStep(int i, int j){
		if ((grid[i][j-1] == METAL) || (grid[i][j-1] == SAND)){
			grid[i][j] = EMPTY;
			grid[i][j-1] = ACID;
		}
		else if (grid[i][j-1] == WATER) {
			grid[i][j] = WATER;
			grid[i][j-1] = ACID;
			}
		else {
			grid[i][j] = EMPTY;
			grid[i][j-1] = ACID;
		}
	}
	
	public void waterStep(int i, int j) {
		if ((grid[i][j-1] != SAND) || (grid[i][j-1] != METAL)) {
			grid[i][j] = EMPTY;
			grid[i][j-1] = WATER;
			}
		if ((grid[i][j-1] == SAND) || (grid[i][j-1] == METAL)) {
			grid[i][j] = WATER;
		}
	}

	public void sandStep(int i, int j) {
		if (grid[i][j-1] == METAL) {
			grid[i][j] = SAND;
			grid[i][j-1] = METAL;
			}
		else if (grid[i][j-1] == WATER) {
			grid[i][j] = WATER;
			grid[i][j-1] = SAND;
			}
		else  {
			grid[i][j] = EMPTY;
			grid[i][j-1] = SAND;
			}
	}

}
