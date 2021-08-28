package com.PhilosopherProblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PhilosopherMain {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executorService = null;
		Philosopher[] philosophers = null;
		
		try{
			
			philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHERS];
			ChopStick[] chopSticks = new ChopStick[Constants.NUMBER_OF_PHILOSOPHERS];
			
			for(int i=0;i<Constants.NUMBER_OF_CHOPSTICKS;i++){
				chopSticks[i] = new ChopStick(i);
			}
			
			executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);
			
			for(int i=0;i<Constants.NUMBER_OF_PHILOSOPHERS;i++){
				philosophers[i] = new Philosopher(i, chopSticks[i], chopSticks[(i+1) % Constants.NUMBER_OF_PHILOSOPHERS]);
				executorService.execute(philosophers[i]);
			}
			
			Thread.sleep(Constants.SIMULATION_RUNNING_TIME);
			
			for(Philosopher philosopher : philosophers){
				philosopher.setFull(true);
			}		
		}finally{
			
			executorService.shutdown();
			
			while(!executorService.isTerminated()){
				Thread.sleep(1000);
			}
			
			for(Philosopher philosopher : philosophers ){
				System.out.println(philosopher+" eat #"+philosopher.getEatingCounter());
			}
			
		}
		
	}
}
/*
OUTPUT
--------
Philosopher-0 is thinking...
Philosopher-3 is thinking...
Philosopher-4 is thinking...
Philosopher-2 is thinking...
Philosopher-1 is thinking...
Philosopher-1 picked up LEFT Chopstick-1
Philosopher-1 picked up RIGHT Chopstick-2
Philosopher-1 is eating...
Philosopher-2 is thinking...
Philosopher-4 picked up LEFT Chopstick-4
Philosopher-4 picked up RIGHT Chopstick-0
Philosopher-4 is eating...
Philosopher-0 is thinking...
Philosopher-3 picked up LEFT Chopstick-3
Philosopher-3 put down Chopstick-3
Philosopher-3 is thinking...
Philosopher-2 is thinking...
Philosopher-1 put down Chopstick-2
Philosopher-1 put down Chopstick-1
Philosopher-1 is thinking...
Philosopher-4 put down Chopstick-0
Philosopher-4 put down Chopstick-4
Philosopher-4 is thinking...
Philosopher-2 picked up LEFT Chopstick-2
Philosopher-2 picked up RIGHT Chopstick-3
Philosopher-2 is eating...
Philosopher-1 picked up LEFT Chopstick-1
Philosopher-1 put down Chopstick-1
Philosopher-1 is thinking...
Philosopher-3 is thinking...
Philosopher-0 picked up LEFT Chopstick-0
Philosopher-0 picked up RIGHT Chopstick-1
Philosopher-0 is eating...
Philosopher-4 picked up LEFT Chopstick-4
Philosopher-4 put down Chopstick-4
Philosopher-4 is thinking...
Philosopher-4 picked up LEFT Chopstick-4
Philosopher-2 put down Chopstick-3
Philosopher-2 put down Chopstick-2
Philosopher-2 is thinking...
Philosopher-4 put down Chopstick-4
Philosopher-4 is thinking...
Philosopher-0 put down Chopstick-1
Philosopher-0 put down Chopstick-0
Philosopher-0 is thinking...
Philosopher-2 picked up LEFT Chopstick-2
Philosopher-2 picked up RIGHT Chopstick-3
Philosopher-2 is eating...
Philosopher-4 picked up LEFT Chopstick-4
Philosopher-4 picked up RIGHT Chopstick-0
Philosopher-4 is eating...
Philosopher-3 is thinking...
Philosopher-4 put down Chopstick-0
Philosopher-4 put down Chopstick-4
Philosopher-4 is thinking...
Philosopher-1 picked up LEFT Chopstick-1
Philosopher-1 put down Chopstick-1
Philosopher-1 is thinking...
Philosopher-3 is thinking...
Philosopher-1 picked up LEFT Chopstick-1
Philosopher-1 put down Chopstick-1
Philosopher-1 is thinking...
Philosopher-3 is thinking...
Philosopher-0 picked up LEFT Chopstick-0
Philosopher-0 picked up RIGHT Chopstick-1
Philosopher-0 is eating...
Philosopher-2 put down Chopstick-3
Philosopher-2 put down Chopstick-2
Philosopher-2 is thinking...
Philosopher-2 picked up LEFT Chopstick-2
Philosopher-2 picked up RIGHT Chopstick-3
Philosopher-2 is eating...
Philosopher-4 picked up LEFT Chopstick-4
Philosopher-4 put down Chopstick-4
Philosopher-4 is thinking...
Philosopher-1 is thinking...
Philosopher-3 is thinking...
Philosopher-0 put down Chopstick-1
Philosopher-0 put down Chopstick-0
Philosopher-0 is thinking...
Philosopher-2 put down Chopstick-3
Philosopher-2 put down Chopstick-2
Philosopher-2 is thinking...
Philosopher-1 picked up LEFT Chopstick-1
Philosopher-1 picked up RIGHT Chopstick-2
Philosopher-1 is eating...
Philosopher-4 picked up LEFT Chopstick-4
Philosopher-4 picked up RIGHT Chopstick-0
Philosopher-4 is eating...
Philosopher-4 put down Chopstick-0
Philosopher-4 put down Chopstick-4
Philosopher-4 is thinking...
Philosopher-0 picked up LEFT Chopstick-0
Philosopher-0 put down Chopstick-0
Philosopher-0 is thinking...
Philosopher-3 picked up LEFT Chopstick-3
Philosopher-3 picked up RIGHT Chopstick-4
Philosopher-3 is eating...
Philosopher-1 put down Chopstick-2
Philosopher-1 put down Chopstick-1
Philosopher-1 is thinking...
Philosopher-2 picked up LEFT Chopstick-2
Philosopher-2 put down Chopstick-2
Philosopher-2 is thinking...
Philosopher-4 is thinking...
Philosopher-2 picked up LEFT Chopstick-2
Philosopher-2 put down Chopstick-2
Philosopher-2 is thinking...
Philosopher-0 picked up LEFT Chopstick-0
Philosopher-0 picked up RIGHT Chopstick-1
Philosopher-0 is eating...
Philosopher-3 put down Chopstick-4
Philosopher-3 put down Chopstick-3
Philosopher-3 is thinking...
Philosopher-4 picked up LEFT Chopstick-4
Philosopher-4 put down Chopstick-4
Philosopher-4 is thinking...
Philosopher-0 put down Chopstick-1
Philosopher-0 put down Chopstick-0
Philosopher-0 is thinking...
Philosopher-1 picked up LEFT Chopstick-1
Philosopher-1 picked up RIGHT Chopstick-2
Philosopher-1 is eating...
Philosopher-0 picked up LEFT Chopstick-0
Philosopher-0 put down Chopstick-0
Philosopher-3 picked up LEFT Chopstick-3
Philosopher-3 picked up RIGHT Chopstick-4
Philosopher-3 is eating...
Philosopher-3 put down Chopstick-4
Philosopher-3 put down Chopstick-3
Philosopher-4 picked up LEFT Chopstick-4
Philosopher-4 picked up RIGHT Chopstick-0
Philosopher-4 is eating...
Philosopher-4 put down Chopstick-0
Philosopher-4 put down Chopstick-4
Philosopher-1 put down Chopstick-2
Philosopher-1 put down Chopstick-1
Philosopher-0 eat #3
Philosopher-1 eat #3
Philosopher-2 eat #3
Philosopher-3 eat #2
Philosopher-4 eat #4

* */