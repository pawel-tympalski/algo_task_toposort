
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {
    public static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        int[] used = new int[adj.length];
        for(int i=0;i<used.length;i++){
        	used[i]= -1;
        }
        
        int sink = -4;
        for(int i=0; i<adj.length;i++){
        	if(adj[i].size() == 0){
        		sink = i;
        		break;
        	}
        }
        
        ArrayList<Integer>[] newAdj = (ArrayList<Integer>[])new ArrayList[adj.length];
        for(int position = 0; position < newAdj.length;position++){
        	newAdj[position] = new ArrayList<Integer>();
        }
        ArrayList<Integer> order = new ArrayList<Integer>();
        //write your code here
        for(int i=0;i<adj.length;i++){
        	int current = i;
        	ArrayList<Integer> arr = adj[i];
        	
        	for(int j=0; j< arr.size();j++){
        		int number = arr.get(j).intValue();
        		newAdj[number].add(new Integer(current));		
        	}
        }
        
        dfs(newAdj,used,order,sink);
        
        
        return order;
    }

    public static void dfs(ArrayList<Integer>[] newAdj, int[] used, ArrayList<Integer> order, int sink) {
    
    	int value = sink;
    	
    	boolean check = false;
      
      for(int j=0; j< used.length; j++ ){
    	  if(used[j] == value){
    		  check = true;
    		  break;
    	  }
      }
      
      if(!check){
    	  ArrayList<Integer> list = newAdj[value];
    	  for(int i=0;i< list.size();i++){
    		  dfs(newAdj, used,order, list.get(i).intValue());
    	  }
    	  
    	  for(int k=0;k<used.length;k++){
    		  if(used[k] == -1){
    			  used[k] = value;
    			  break;
    		  }
    	  }
    	  
    	  order.add(new Integer(value));
      }
    	
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n < 1 || n > 100000){
        	n = scanner.nextInt();
        }
        int m = scanner.nextInt();
        while(m < 0 || m > 100000){
        	m = scanner.nextInt();
        }
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            while(x < 0 || x > 100000){
            	x = scanner.nextInt();
            }
            y = scanner.nextInt();
            while(y < 0 || y > 100000){
            	y = scanner.nextInt();
            }
            adj[x - 1].add(y - 1);
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}