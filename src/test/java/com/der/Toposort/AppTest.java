package com.der.Toposort;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	@Test
    public void goodOrderingSmallDataInput()
    {
    	
    	String input = "4 3 1 2 4 1 3 1";
		Scanner scanner = new Scanner(input).useDelimiter(" ");
		
		
		
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        ArrayList<Integer> order = Toposort.toposort(adj);
        
        StringBuilder output = new StringBuilder();
        
        for (int x : order) 
        {
        	//System.out.println(x);
            output.append((x + 1) + " ");
        }
		
		
       assertEquals("3 4 1 2 ",output.toString());
    }
    
	@Test
    public void good2OrderingSmallDataInput()
    {
    	
    	String input = "5 7 2 1 3 2 3 1 4 3 4 1 5 2 5 3";
		Scanner scanner = new Scanner(input).useDelimiter(" ");
		
		
		
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        ArrayList<Integer> order = Toposort.toposort(adj);
        
        StringBuilder output = new StringBuilder();
        
        for (int x : order) 
        {
        	//System.out.println(x);
            output.append((x + 1) + " ");
        }
		
		
       assertEquals("4 5 3 2 1 ",output.toString());
    }
	
	@Test
    public void massiveDAtaInput()
    {
		
		StringBuilder sb = new StringBuilder();
		sb.append("100000 ");
		sb.append("99999 ");
		
		for(int i = 1; i <= 99999; i++){
			int j = i;
			sb.append(i + " ");
			++j;
			sb.append(j + " ");
		}
		
		
		
		
    	
    	String input = sb.toString();
		Scanner scanner = new Scanner(input).useDelimiter(" ");
		
		
		
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        ArrayList<Integer> order = Toposort.toposort(adj);
        
        StringBuilder output = new StringBuilder();
        
        for (int x : order) 
        {
        	//System.out.println(x);
            output.append((x + 1) + " ");
        }
		
        StringBuilder sb2 = new StringBuilder();
        for(int i = 1; i <= 100000; i++){
			
			sb2.append(i + " ");
			
		}
		
       assertEquals(sb2.toString(),output.toString());
    }
}
