

import org.junit.Test;

import uk.deloitte.digital.exception.AwayDayException;

public class FileUtilsTest {
	

	@Test
	public void loadTasks_ok() throws AwayDayException {
		// Given
		String fileName = "input_test.txt";
		FileUtils fileUtils = new FileUtils();
		// when
		fileUtils.loadTasksFromResources(fileName);
		// Then -> no exception
	}
	
	@Test(expected = AwayDayException.class)
	public void loadTasks_no_file() throws AwayDayException {
		// Given
		String fileName = "input_tes_no_file.txt";
		FileUtils fileUtils = new FileUtils();
		// when
		fileUtils.loadTasksFromResources(fileName);
		// Then -> exception
	}
	
	@Test(expected = AwayDayException.class)
	public void loadTasks_wrong_1() throws AwayDayException {
		// Given
		String fileName = "input_test_wrong_1.txt";
		FileUtils fileUtils = new FileUtils();
		// when
		fileUtils.loadTasksFromResources(fileName);
		// Then -> exception
	}
	
	@Test(expected = AwayDayException.class)
	public void loadTasks_wrong_2() throws AwayDayException {
		// Given
		String fileName = "input_test_wrong_2.txt";
		FileUtils fileUtils = new FileUtils();
		// when
		fileUtils.loadTasksFromResources(fileName);
		// Then -> exception
	}
	
	@Test(expected = AwayDayException.class)
	public void loadTasks_wrong_3() throws AwayDayException {
		// Given
		String fileName = "input_test_wrong_3.txt";
		FileUtils fileUtils = new FileUtils();
		// when
		fileUtils.loadTasksFromResources(fileName);
		// Then -> exception
	}
	
	@Test(expected = AwayDayException.class)
	public void loadTasks_wrong_4() throws AwayDayException {
		// Given
		String fileName = "input_test_wrong_4.txt";
		FileUtils fileUtils = new FileUtils();
		// when
		fileUtils.loadTasksFromResources(fileName);
		// Then -> exception
	}
	
	@Test(expected = AwayDayException.class)
	public void loadTasks_wrong_5() throws AwayDayException {
		// Given
		String fileName = "input_test_wrong_5.txt";
		FileUtils fileUtils = new FileUtils();
		// when
		fileUtils.loadTasksFromResources(fileName);
		// Then -> exception
	}

}
