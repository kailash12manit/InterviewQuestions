package amazon_test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	
	static int H;//Height
	static int W;//Width
	static int matrix[][]; //map
	
	static class cell  {  
		int x, y;  
		int dis;  
		public cell(int x, int y, int dis) { 
			this.x = x; 
			this.y = y; 
			this.dis = dis; 
		}
	}
	
	static boolean isInside_Valid(int x, int y)  {  
		if ( (x >= 0 && x < H && y >= 0 && y < W) && (matrix[x][y]==1 || matrix[x][y]==9)) {  
			return true;  
		}
		return false;  
	}
	
	public  static int findMinimumPath(int rowNumber, int ColNumber, List<List<Integer>> list) {
		// TODO Auto-generated method stub
		
		H=rowNumber;
		W=ColNumber;
		matrix = new int[H][W];
		
		int knightPos[]= {0,0};
		
		int targetPos[]=new int[2];
		
		for(int i=0;i<H;i++) {
			List<Integer>al = new ArrayList<>();
			al=list.get(i);
			for(int j=0;j<W;j++) {
				matrix[i][j]=al.get(j);
				if(matrix[i][j]==9) {
					targetPos[0]=i;
					targetPos[1]=j;
				}
			}
		}		
//		System.out.println();
//		for(int []k:matrix) {
//			for(int kk:k) {
//				System.out.print(kk+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		System.out.println("targetPos:" + targetPos[0]+" "+targetPos[1]);
//		System.out.println();
		
		int min_dist = minStepToReachTarget(knightPos,targetPos);

		if(min_dist != Integer.MAX_VALUE) {
			return min_dist;
		}
		return -1;
	}

	private static int minStepToReachTarget(int[] knightPos, int[] targetPos) {
		// TODO Auto-generated method stub
		int dx[] = {1,0,-1,0};  
		int dy[] = {0,1,0,-1};
		Queue<cell> q = new LinkedList<cell>();  

		q.add(new cell(knightPos[0], knightPos[1], 0));  

		int x, y;  
		boolean visit[][] = new boolean[H][W];  

		for (int i = 0; i < H; i++)  {
			for (int j = 0; j < W; j++) {  
				visit[i][j] = false;  
			}
		}

		visit[knightPos[0]][knightPos[1]] = true;  
//		System.out.println("STARTED");
		
		while (!q.isEmpty()) {  
//			System.out.println();
//			System.out.println("q:"+q.size());
			
			cell t = q.remove();  			
//			System.out.println("t:"+t.x+" "+t.y+" "+t.dis);
			
			if ((t.x == targetPos[0]) && (t.y == targetPos[1])) {
//				System.out.println("t.dis:"+t.dis);
				return t.dis;  
			}

			for (int i = 0; i < 4; i++) {  
				x = t.x + dx[i];  
				y = t.y + dy[i];  
				if (isInside_Valid(x, y) && !visit[x][y]) {  
					visit[x][y] = true;  
//					System.out.println("x y: "+x+" "+y);
					q.add(new cell(x, y, t.dis + 1));  
				}  
			}  
		}
//		System.out.println("END");
		return Integer.MAX_VALUE; 
	}
}
