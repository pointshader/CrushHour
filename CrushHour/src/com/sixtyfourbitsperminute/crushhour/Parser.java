package com.sixtyfourbitsperminute.crushhour;

import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
	
	String gridString;
	String[] gridLines;
	int gridSize;
	char[][] grid;

	public Parser (String gridString){
		this.gridString = gridString;
	}
	
	public boolean isSquareGrid(){
		String[] gridLines = this.gridString.split("\n");
		for(int i = 0; i < gridLines.length; i++){
			gridLines[i].trim();
		}
		if(gridLines[0].length() == gridLines.length){
			this.gridLines = gridLines;
			this.gridSize = gridLines.length;
			readStringInto2DArray();
			return true;
		} else {
			return false;
		}
	}
	
	public void readStringInto2DArray(){
		this.grid = new char[this.gridSize][this.gridSize];
		for(int i = 0; i < this.gridSize; i++){
			for(int j = 0; j < this.gridSize; j++){
				char current = this.gridLines[i].charAt(j);
				this.grid[i][j] = current;
			}
		}
	}
	
	public boolean allVehiclesAreLegal(){
		HashMap<Character, Integer[]> listOfChars = new HashMap<Character, Integer[]>();
		for(int row = 0; row < this.gridSize; row++){
			for(int column = 0; column < this.gridSize; column++){
				char current = this.grid[row][column];
				int[] position = {row, column};
				char[] neighbors = {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'};
				neighbors = readInNeighbors(neighbors, row, column);
				if(current == 'x'){
					continue;
				}
			}
		}
		return false;
	}
	
	public boolean isTruck(char current, char[] neighbors, int[] position){
		if(current == neighbors[0] && current == neighbors[1]){
			int[] positionTwo = {(position[0]-1), position[1]};
			int[] positionThree = {(position[0]-2), position[1]};
			if(!letterExistsElsewhere(current, position, positionTwo, positionThree)){
				return true;
			}
		} else if (current == neighbors[2] && current == neighbors[3]){
			int[] positionTwo = {(position[0]+1), position[1]};
			int[] positionThree = {(position[0]+2), position[1]};
			if(!letterExistsElsewhere(current, position, positionTwo, positionThree)){
				return true;
			}
		} else if (current == neighbors[0] && current == neighbors[2]){
			int[] positionTwo = {(position[0]-1), position[1]};
			int[] positionThree = {(position[0]+1), position[1]};
			if(!letterExistsElsewhere(current, position, positionTwo, positionThree)){
				return true;
			}
		} else if (current == neighbors[4] && current == neighbors[5]){
			int[] positionTwo = {position[0], (position[1]-1)};
			int[] positionThree = {position[0], (position[1]-2)};
			if(!letterExistsElsewhere(current, position, positionTwo, positionThree)){
				return true;
			}
		} else if (current == neighbors[6] && current == neighbors[7]){
			int[] positionTwo = {position[0], (position[1]+1)};
			int[] positionThree = {position[0], (position[1]+2)};
			if(!letterExistsElsewhere(current, position, positionTwo, positionThree)){
				return true;
			}
		} else if (current == neighbors[4] && current == neighbors[6]){
			int[] positionTwo = {position[0], (position[1]-1)};
			int[] positionThree = {position[0], (position[1]+1)};
			if(!letterExistsElsewhere(current, position, positionTwo, positionThree)){
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
	
	public boolean isCar(char current, char[] neighbors, int[] position){
		if(current == neighbors[0]){
			int[] positionTwo = {(position[0]-1), position[1]};
			if(!letterExistsElsewhere(current, position, positionTwo, null)){
				return true;
			}
		} else if (current == neighbors[2]){
			int[] positionTwo = {(position[0]+1), position[1]};
			if(!letterExistsElsewhere(current, position, positionTwo, null)){
				return true;
			}
		} else if (current == neighbors[4]){
			int[] positionTwo = {position[0], (position[1]-1)};
			if(!letterExistsElsewhere(current, position, positionTwo, null)){
				return true;
			}
		} else if (current == neighbors[6]){
			int[] positionTwo = {position[0], (position[1]+1)};
			if(!letterExistsElsewhere(current, position, positionTwo, null)){
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
	
	public boolean letterExistsElsewhere(char current, int[] positionOne, int[] positionTwo, int[] positionThree){
		for(int i = 0; i < this.grid.length; i++){
			for(int j = 0; j < this.grid.length; j++){
				if((i == positionOne[0] && j == positionOne[1]) || (i == positionTwo[0] && j == positionTwo[1])){
					if(positionThree == null){
						continue;
					} else {
						if(i == positionThree[0] && j == positionThree[1]){
							continue;
						}
					}
				} else if (this.grid[i][j] == current){
					return true;
				}
			}
		}
		return false;
	}
	
	public char[] readInNeighbors(char[] neighbors, int row, int column){
		if(row-1 > 0){
			neighbors[0] = this.grid[row-1][column];
		}
		if(row-2 > 0){
			neighbors[1] = this.grid[row-1][column];
		}
		if(row+1 < this.gridSize){
			neighbors[2] = this.grid[row+1][column];
		}
		if(row+2 < this.gridSize){
			neighbors[3] = this.grid[row+2][column];
		}
		if(column-1 > 0){
			neighbors[4] = this.grid[row][column-1];
		}
		if(column-2 > 0){
			neighbors[5] = this.grid[row][column-2];
		}
		if(column+1 > 0){
			neighbors[6] = this.grid[row][column+1];
		}
		if(column+2 > 0){
			neighbors[7] = this.grid[row][column+2];
		}
		return neighbors;
	}
	
	public void addVehicleToMap(){
		
	}
	
	public Vehicle findUserCar(){
		
		return null;
	}
	
	public boolean gridHasUserCar(){
		
		return false;
	}
	
	public boolean fileCanCreateGrid(){
		
		return false;
	}
	
	public Grid createGrid(){
		
		return null;
	}
}