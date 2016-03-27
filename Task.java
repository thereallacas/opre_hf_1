package opre_hf_01;

import java.util.Comparator;

public class Task {
	char name;
	public Integer priority;
	public Integer start_time;
	public Integer CPU_burst;
	public Integer wait_time=0;
	public ScheduleType schtype;
	public Task(char n, int p, int s, int c) throws InvalidTaskException{
		if (!Character.isAlphabetic(n) || p>9 ||p<0 || s<0 || c<1)
			throw new InvalidTaskException("rekt with :"+n+" "+p+" "+s+" "+c);
		name=n;
		priority=p;
		start_time=s;
		CPU_burst=c;
		schtype = priority > 4 ? ScheduleType.RR : ScheduleType.SJF;
	}
	public Task(Task t){
		name=t.name;
		priority=t.priority;
		start_time=t.start_time;
		CPU_burst=t.CPU_burst;
		schtype = priority > 4 ? ScheduleType.RR : ScheduleType.SJF;
		wait_time = t.wait_time;
	}

	public static Comparator<Task> SJFTaskComparator 
	= new Comparator<Task>() {

		public int compare(Task t1, Task t2) {
			//ascending order
			return t1.CPU_burst.compareTo(t2.CPU_burst);
		}
	};
}
