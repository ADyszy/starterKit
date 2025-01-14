package com.capgemini.fibonacci;

/**
 * Created by ldrygala on 2015-01-23.
 * F1	F2	F3	F4	F5	F6	F7	F8	F9	F10	F11	F12	F13	F14	F15	F16	F17	  F18	F19
 	1	1	2	3	5	8	13	21	34	55	89	144	233	377	610	987	1597  2584	4181
 */
public class Fibonacci {
	
	// TODO: testing: Check if natural integer, if not too big.. many tests
    public static long fib(int n) throws FibException {
    	if(n < 1) 
    		throw new FibException("Illegal number for Fibonacci function.");
        if(n == 1 || n == 2)  
        	return 1;
        return fib(n-1)+fib(n-2);
    }
}
 