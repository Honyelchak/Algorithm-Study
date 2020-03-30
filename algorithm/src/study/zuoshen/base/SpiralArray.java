package study.zuoshen.base;

/**
 * 螺旋数组， 补充：该题不局限于螺旋数组，更是一种思想。 给定一个左上角的坐标和右下角的坐标，可以确定一个框。 
 * 1 2 3 
 * 8 9 4
 * 7 6 5
 * 
 * @author Honyelchak
 * @date 2020年3月30日
 *
 */
public class SpiralArray {
	// public static int count = 0;
	
	public static int[][] generateMatrix(int n){
		int[][] arr = new int[n][n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = ++count; 
			}
		}
		return arr;
	}
	
	public static void printMatrix(int[][] arr){
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int[][] matrix = generateMatrix(5);
		// 打印生成的数组
		printMatrix(matrix);
		// 打印螺旋数组
		printSpiralMatrix(matrix);
		
	}
	
	public static void printSpiralMatrix(int[][] arr){
		if (arr.length == 0)return ;
		int colSize = arr.length;
		for (int i = 0; i < colSize; i++) {
			printCycleByCoordinate(arr, i, i, colSize - i - 1, colSize - i - 1);
		}
	}

	private static void printCycleByCoordinate(int[][] arr, int leftRow,
			int leftCol, int rightRow, int rightCol) {

		if (leftRow == rightRow && leftCol == rightCol) {
			System.out.print(arr[leftRow][leftCol]);
			return ;
		}
			
		if (leftRow == rightRow) {
			for (int i = leftCol; i <= rightCol; i++) {
				System.out.print(arr[leftRow][i] + " ");
			}
			return;
		}

		if (leftCol == rightCol) {
			for (int i = leftRow; i <= rightRow; i++) {
				System.out.print(arr[i][leftCol] + " ");
			}
			return;
		}
		int i = leftRow, j = leftCol;
		while (j < rightCol) {
			System.out.print(arr[leftRow][j++] + " ");
		}
		while (i < rightRow) {
			System.out.print(arr[i++][rightCol] + " ");
		}
		while (j <= rightCol && j > leftCol) {
			System.out.print(arr[rightRow][j--] + " ");
		}

		while (i <= rightRow && i > leftRow) {
			System.out.print(arr[i--][leftCol] + " ");
		}

	}
}
