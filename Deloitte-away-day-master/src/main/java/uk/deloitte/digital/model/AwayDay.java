

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import uk.deloitte.digital.exception.AwayDayException;


/**
 * Class to manage an away day 
 * 
 * 
 *
 */
public class AwayDay {

	List<DayProgram> programs = new ArrayList<>();

	public AwayDay(LocalTime morningStart, LocalTime morningEnd, LocalTime eveningStart, LocalTime eveningEnd,
			Integer eveningExtraTime, Integer numberOfPrograms) throws AwayDayException {

		for (int i = 0; i < numberOfPrograms; i++) {
			programs.add(new DayProgram(morningStart, morningEnd, eveningStart, eveningEnd, eveningExtraTime));
		}
	}

	/**
	 * Method to add a list of tasks into the away day
	 * 
	 * @param tasks The list of tasks to be added
	 * @throws AwayDayException 
	 */
	public void addTasks(List<Task> tasks) throws AwayDayException {

		this.checkTasks(tasks);

		List<Task> orderedTasks = tasks.stream().sorted((t1, t2) -> t2.getDuration() - t1.getDuration()).collect(Collectors.toList());;
		for (Task task : orderedTasks) {
			boolean result = this.addSingleTask(task);
			if (!result) {
				throw new AwayDayException("AwayDay.addTasks: There was a problem inserting task (" + task.getName() + ")");
			}
		}
	}

	/**
	 * Method to check tasks before insert
	 * 
	 * @param tasks The tasks to be checked
	 * @throws AwayDayException 
	 */
	private void checkTasks(List<Task> tasks) throws AwayDayException {

		Integer tasksTime = tasks.stream().mapToInt(task -> task.getDuration()).sum();
		Integer minTime = programs.stream().mapToInt(program -> program.getMinDuration()).sum();
		Integer maxTime = programs.stream().mapToInt(program -> program.getMaxDuration()).sum();
		if (tasksTime < minTime || tasksTime > maxTime) {
			throw new AwayDayException("AwayDay.checkTasks: The list of tasks has not the proper duration");
		}

	}

	/**
	 * Method to add a task to one of the programs
	 * 
	 * @param task Task to add
	 * @return
	 */
	private boolean addSingleTask(Task task) {
		boolean result = false;
		Iterator<DayProgram> iterator = programs.iterator();
		while (result != true && iterator.hasNext()) {
			result = ((DayProgram) iterator.next()).insertMorningTask(task);
		}
		iterator = programs.iterator();
		while (result != true && iterator.hasNext()) {
			result = ((DayProgram) iterator.next()).insertEveningTask(task);
		}
		return result;
	}

	public List<DayProgram> getPrograms() {
		return programs;
	}

	public void setPrograms(List<DayProgram> programs) {
		this.programs = programs;
	}

	@Override
	public String toString() {

		StringBuffer buffer = new StringBuffer("");
		Integer count = 1;
		for (DayProgram dayProgram : programs) {
			buffer
			.append("Team " + count + ":")
			.append(System.getProperty("line.separator"))
			.append(dayProgram)
			.append(System.getProperty("line.separator"));
			count ++;
		}
		return buffer.append(System.getProperty("line.separator")).toString();
	}

}
