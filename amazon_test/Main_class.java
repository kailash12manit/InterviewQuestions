package amazon_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_class {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		List<List<Integer>>list = new ArrayList<List<Integer>>();
		for(int i=0;i<n;i++) {
			ArrayList<Integer>al = new ArrayList<>();
			for(int j=0;j<m;j++) {
				al.add(sc.nextInt());
			}
			list.add(al);	
		}
		int res= Solution.findMinimumPath(n,m,list);
		System.out.println(res);		
	}
}

/*

3 3
1 0 0
1 0 0
1 9 1


5 4
1 1 1 1
0 1 1 1
0 1 0 1
1 1 9 1
0 0 1 1

*/