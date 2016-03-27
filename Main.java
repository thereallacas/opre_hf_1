package opre_hf_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		try{
			Scheduler sch = new Scheduler();
			SchedulerRR schrr = new SchedulerRR();
			SchedulerSJF schsjf = new SchedulerSJF(); 

			ScheduleType n=null;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line;
			for (int i=0; i<10 && (line = br.readLine()) != null ; i++){
				String[] params = line.split(",");
				Task task = new Task(params[0].charAt(0), Integer.parseInt(params[1]), 
						Integer.parseInt(params[2]), Integer.parseInt(params[3]));
				if (task.schtype == n.SJF) 
					schsjf.addTask(task);
				else 
					schrr.addTask(task);
			}
			schsjf.Sort();
			schsjf.setWaittimes();
			
			schrr.Sort(schsjf.schwait_time);
			schsjf.printAll();
			schrr.printAll();
			System.out.println();
			schsjf.printWaitTimes();
			schrr.printWaitTimes();
		}	
		catch (Exception e){
			e.printStackTrace();
			e.getMessage();
		}

	}

}
