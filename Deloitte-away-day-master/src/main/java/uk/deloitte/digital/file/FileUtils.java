

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import uk.deloitte.digital.exception.AwayDayException;
import uk.deloitte.digital.model.Task;

/**
 * Class to manage file load and save
 * 
 * 
 *
 */
public class FileUtils {

	static String REGEX = "^[a-zA-Z0-9][a-zA-Z0-9& -]* (([0-9]+min)|sprint)$";
	static String SPRINT = "sprint";

	/**
	 * Method to generate a list of tasks from a file stored in resources
	 * 
	 * @param fileName File name in resources
	 * @return List of tasks
	 * @throws AwayDayException
	 */
	public List<Task> loadTasksFromResources(String fileName) throws AwayDayException {
		List<Task> tasks = new ArrayList<>();
		try {
			Path path = Paths.get(this.getClass().getClassLoader().getResource(fileName).toURI());
			Stream<String> lines;
			lines = Files.lines(path);
			Iterator<String> iterator = lines.iterator();
			while (iterator.hasNext()) {
				String line = iterator.next();
				if (Pattern.matches(REGEX, line)) {
					Integer duration = this.getMinutes(line.substring(line.lastIndexOf(" ") + 1));
					tasks.add(new Task(line.substring(0, line.lastIndexOf(" ")), duration));
				}else{
					lines.close();
					throw new AwayDayException("FileUtils:loadTasksFromResources: File line " + line + " has not a valid format");
				}
			}
			lines.close();
		} catch (Exception ex) {
			throw new AwayDayException("FileUtils:loadTasksFromResources: there was a problem loading tasks from file:" + ex.getLocalizedMessage());
		}
		return tasks;
	}

	/**
	 * Method to get minutes value
	 * 
	 * @param value
	 * @return
	 * @throws AwayDayException 
	 */
	private Integer getMinutes(String value) throws AwayDayException {
		Integer result = 0;
		if (SPRINT.equals(value))
			result = 15;
		else
			result = Integer.valueOf(value.substring(0, value.length() - 3));
		
		if (result <=0 || result > 60){
			throw new AwayDayException("FileUtils:getMinutes: invalid task duration: " + result);
		}
		return result;
	}

}
