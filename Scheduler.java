package opre_hf_01;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
	List<Task> tasks;
	public Scheduler(){
		tasks = new ArrayList<Task>();
	}
	public void addTask(Task a){
		tasks.add(a);
	}
	void printAll(){
		for (Task task : tasks) {
			System.out.print(task.name);
		}
	}
	void printWaitTimes(){
		for (Task task : tasks) {
			System.out.print(task.name + ":" + task.wait_time + ",");
		}
	}
	
}
