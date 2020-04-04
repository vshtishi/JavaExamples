package com.github.vshtishi;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample extends RecursiveTask<Double>{
	 private static final int THRESHOLD=5;
     private int start;
     private int end;
     private Double[] results;
     
     public ForkJoinExample(Double[] results, int start, int end){
    	 this.start=start;
    	 this.end=end;
    	 this.results=results;
     }
     
     @Override
     protected Double compute(){
    	 if(end-start<=THRESHOLD){
    		 double sum=0;
    		 for(int i=start; i<end; i++){
    			 results[i]=(double)new Random().nextInt(100);
    			 sum+=results[i];
    		 }
    		 return sum;
    	 }
    	 else{
    		 int middle=start+((end-start)/2);
    		  RecursiveTask<Double> task=new ForkJoinExample(results,start,middle);
    		  task.fork();
    		  return new ForkJoinExample(results,middle,end).compute()+ task.join();
    	 }
     }
    
     
     public static void main(String[] args){
    	 Double[] results= new Double[22];
    	 ForkJoinTask<Double> task= new ForkJoinExample(results,0,results.length);
    	 ForkJoinPool pool= new ForkJoinPool();
    	 Double sum=pool.invoke(task);
    	 System.out.println("Sum: "+sum);
     }

}
