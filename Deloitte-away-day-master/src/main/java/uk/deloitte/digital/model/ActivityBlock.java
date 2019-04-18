

import java.util.ArrayList;
import java.util.List;

/**
 * Class for a group of tasks with a delimited size
 * 
 * 
 *
 */
public class ActivityBlock {

	private List<Task> tasks;

	private Integer size;

	public ActivityBlock(Integer size) {
		this.tasks = new ArrayList<>();
		this.size = size;
	}

	/**
	 * Method to add a task if there is enough free size
	 * 
	 * @param task the task to add
	 * @return
	 */
	public boolean addTask(Task task) {
		
		if (task != null && task.getDuration() <= this.getAvailableSize()) {
			this.tasks.add(task);
			return true;
		}
		return false;
	}

	/**
	 * Method to retrieve the available size
	 * 
	 * @return available size
	 */
	public Integer getAvailableSize() {
		return this.size - tasks.stream().mapToInt(task -> task.getDuration()).sum();
	}

	/**
	 * Method to retrieve the used size
	 * 
	 * @return used size
	 */
	public Integer getUsedSize() {
		return tasks.stream().mapToInt(task -> task.getDuration()).sum();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("");
		tasks.forEach(task -> buffer.append(task).append(System.getProperty("line.separator")));
		return buffer.toString();
	}

}
