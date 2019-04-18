

import java.time.LocalTime;
import java.util.List;

import uk.deloitte.digital.exception.AwayDayException;
import uk.deloitte.digital.file.FileUtils;
import uk.deloitte.digital.model.AwayDay;
import uk.deloitte.digital.model.Task;

/**
 * Main class. Reads a file and generates the away day
 * 
 * 
 *
 */
public class App {
	
	static String INPUT = "input.txt";

	public static void main(String[] args) {

		FileUtils fileUtils = new FileUtils();
		List<Task> tasks;
		try {
			
			tasks = fileUtils.loadTasksFromResources(INPUT);
			AwayDay awayDay = new AwayDay(
					LocalTime.of(9, 00), 
					LocalTime.of(12, 00), 
					LocalTime.of(13, 00),
					LocalTime.of(16, 00), 
					60, 2);
			awayDay.addTasks(tasks);
			System.out.println("Deloitte Away Day:");
			System.out.println(awayDay);
			
		} catch (AwayDayException e) {
			System.out.println("There was an error executing away day:" + e.getLocalizedMessage());
		}
	}
}
