package skaza.core.models.map;

import javax.inject.Inject;

import skaza.core.math.calculators.MapConstants;

public class Grid {
	public Cell[][] matrix; 
	public Integer height;
	public Integer width;
	
	@Inject
	MapConstants mapConstants = new MapConstants();
	
	public Grid(){
		height = mapConstants.gridHeight;
		width = mapConstants.gridWidth;
		
		matrix = new Cell[height][width];		
		initializeMatrixCells();
		initializeNeighbours();
	}
	
	private void initializeMatrixCells() {
		initializeUpperCornerCells();
		initializeOuterBaseCells();
		initializeSideRowCells();
		initializeInnerBaseCells();
		initializeInnerCells();
	}	
	
	private void initializeUpperCornerCells() {
		matrix[0][0] = new Cell( mapConstants.numberOfUpperCornerNeighbours );
		matrix[0][width-1] = new Cell( mapConstants.numberOfUpperCornerNeighbours );
		matrix[height-1][0] = new Cell( mapConstants.numberOfLowerCornerNeighbours );
		matrix[height-1][width-1] = new Cell( mapConstants.numberOfLowerCornerNeighbours );
	}

	private void initializeOuterBaseCells() {
		for (int w = 2 ; w < width-1 ; w+=2 ){
			matrix[0][w] = new Cell( mapConstants.numberOfOuterBaseNeighbours );
			matrix[height-1][w] = new Cell( mapConstants.numberOfOuterBaseNeighbours );
		}
	}

	private void initializeSideRowCells() {
		for (int h = 2 ; h < height-1 ; h++){			
			matrix[h][0] = new Cell( mapConstants.numberOfSideRowNeighbours );
			matrix[h][width-1] = new Cell( mapConstants.numberOfSideRowNeighbours );
		}
	}

	private void initializeInnerBaseCells() {
		for (int w = 1 ; w < width-1 ; w+=2 ){
			matrix[0][w] = new Cell( mapConstants.numberOfInnerBaseNeighbours );
		}		
		for (int w = 2 ; w < width-1 ; w+=2 ){
			matrix[height-1][w] = new Cell( mapConstants.numberOfInnerBaseNeighbours );
		}
	}

	private void initializeInnerCells() {
		for (int h = 0 ; h < height-1 ; h++){
			for (int w = 0 ; w < width-1 ; w++){
				if( matrix[h][w] == null )
					matrix[h][w] = new Cell( mapConstants.numberOfNormalCellNeighbours );
			}
		}		
	}

	private void initializeNeighbours(){
		initializeUpperCornerNeighbours();
		initializeOuterBaseNeighbourss();
		initializeSideRowNeighbours();
		initializeInnerBaseNeighbours();
		initializeInnerNeighbours();
	}

	private void initializeUpperCornerNeighbours() {
		// TODO Auto-generated method stub
		
	}

	private void initializeOuterBaseNeighbourss() {
		// TODO Auto-generated method stub
		
	}

	private void initializeSideRowNeighbours() {
		// TODO Auto-generated method stub
		
	}

	private void initializeInnerBaseNeighbours() {
		// TODO Auto-generated method stub
		
	}

	private void initializeInnerNeighbours() {
		// TODO Auto-generated method stub
		
	}

}
