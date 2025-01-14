package com.capgemini.coins;

import java.util.List;

/**
 * Created by ldrygala on 2015-02-06.
 * <p/>
 * Consider N coins aligned in a row. Each coin is showing either heads or tails. 
 * The adjacency of these coins is the number of adjacent pairs of coins with the same side facing up.
 * <p/>
 * It must return the maximum possible adjacency that can be obtained 
 * by reversing exactly one coin (that is, one of the coins must be reversed). 
 * Consecutive elements of array A represent consecutive coins in the row. Array A contains 
 * only 0s and/or 1s: 0 represents a coin with heads facing up; 1 represents a coin with tails facing up. 
 * For example, given array A consisting of six numbers, such that:
 * <p/>
 * A[0] = 1
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 0
 * A[5] = 0
 * <p/>
 * the function should return 4. The initial adjacency is 2, as there are two pairs of adjacent coins 
 * with the same side facing up, namely (0, 1) and (4, 5). After reversing the coin represented by A[2], 
 * the adjacency equals 4, as there are four pairs of adjacent coins with the same side facing up, 
 * namely: (0, 1), (1, 2), (2, 3) and (4, 5), and it is not possible to obtain a higher adjacency. 
 * The same adjacency can be obtained by reversing the coin represented by A[3].
 */

public class Coins {

	protected static int adjacency(List<Integer> AList){
		int last = -1, adj = 0;
		for (Integer i : AList) {
			if (last == i) adj++;
			last = i;
		}
		return adj;
	}
	
	private static int flipCoin(Integer coin){
		return (coin == 1)? 0 : 1;
	}
	
	private static int max(int a, int b) {
		return ( a > b )? a : b;
	} 
	
    public static int solution(List<Integer> coins) {
    	int maxAdj = 0;
    	int actuall = adjacency(coins);
    	for ( int i=0; i<coins.size(); i++ ) { 
    		coins.set(i, flipCoin(coins.get(i)));
    		maxAdj = max(maxAdj, adjacency(coins));
    		coins.set(i, flipCoin(coins.get(i)));
    		if (maxAdj - actuall == 2) 
    			break; // there won't be more;
    	}
        return maxAdj;
    }
 
}
