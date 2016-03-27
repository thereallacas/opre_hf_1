package opre_hf_01;

import java.util.ArrayList;
import java.util.List;

public class SchedulerRR extends Scheduler{
	List<Task> final_list;
	boolean end = false;
	int ready=0;
	void Sort(int time){
		final_list = new ArrayList<Task>();
		while (!end){
			for (int i=0; i<tasks.size(); i++){
				Task act = tasks.get(i);
				if (act.start_time<time){
					if (act.wait_time==0) 
						act.wait_time=time-act.start_time;
					else{
						act.wait_time+=2;
					}
					tasks.get(i).wait_time=act.wait_time;
					if (act.CPU_burst>0){
						act.CPU_burst-=2;
						final_list.add(act);
						time+=2;
					}
					if (act.CPU_burst<=0)
						ready++;
				}
			}
			if (ready==tasks.size())
				end=true;
		}
	}
	void printAll(){
		for (Task task : final_list) {
			System.out.print(task.name);
		}
	}
}
