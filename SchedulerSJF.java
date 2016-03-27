package opre_hf_01;

import java.util.Collections;

public class SchedulerSJF extends Scheduler{
	void Sort(){
		Collections.sort(super.tasks, Task.SJFTaskComparator);
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
