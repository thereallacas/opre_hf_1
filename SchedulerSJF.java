package opre_hf_01;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SchedulerSJF extends Scheduler{
	void Sort(){
		Collections.sort(tasks, Task.SJFTaskComparator);
		int ready=0;
		int time=0;
		List<Task> newlist = new ArrayList<Task>();
		while (ready!=tasks.size()){
		for (Task task : tasks) {
			if (task.start_time==time){
				newlist.add(task);
				ready++;
			}
		}
		time++;
		}
		tasks=newlist;
	}
	int schwait_time=0;
	void setWaittimes(){
		for (int i=0; i<tasks.size(); i++){
				Task act = tasks.get(i); 
			act.wait_time = (schwait_time - act.start_time<=0) ? 0 : schwait_time - act.start_time;
			schwait_time+=act.CPU_burst;
		}
	}
}
