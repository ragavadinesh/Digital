

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ActivityBlockTest {

	@Test
	public void addTask_ok() {
		// Given
		ActivityBlock block = new ActivityBlock(60);
		Task task = new Task("test", 60);
		// when
		boolean result = block.addTask(task);
		// Then
		assertTrue("Result must be true", result);
	}
	
	@Test
	public void addTask_overSize() {
		// Given
		ActivityBlock block = new ActivityBlock(30);
		Task task = new Task("test", 60);
		// when
		boolean result = block.addTask(task);
		// Then
		assertFalse("Result must be false", result);
	}
	
	@Test
	public void addTask_nullTask() {
		// Given
		ActivityBlock block = new ActivityBlock(30);
		// when
		boolean result = block.addTask(null);
		// Then
		assertFalse("Result must be false", result);
	}
	
	@Test
	public void getAvailableSize_empy() {
		// Given
		ActivityBlock block = new ActivityBlock(30);
		// when
		Integer result = block.getAvailableSize();
		// Then
		assertTrue("Result must be 30", result == 30);
	}
	
	@Test
	public void getAvailableSize_half() {
		// Given
		ActivityBlock block = new ActivityBlock(30);
		block.addTask(new Task("test", 20));
		// when
		Integer result = block.getAvailableSize();
		// Then
		assertTrue("Result must be 10", result == 10);
	}
	
	@Test
	public void getAvailableSize_full() {
		// Given
		ActivityBlock block = new ActivityBlock(30);
		block.addTask(new Task("test", 30));
		// when
		Integer result = block.getAvailableSize();
		// Then
		assertTrue("Result must be 0", result == 0);
	}
	
	
	@Test
	public void getUsedSize_empy() {
		// Given
		ActivityBlock block = new ActivityBlock(30);
		// when
		Integer result = block.getUsedSize();
		// Then
		assertTrue("Result must be 0", result == 0);
	}
	
	@Test
	public void getUsedSize_half() {
		// Given
		ActivityBlock block = new ActivityBlock(30);
		block.addTask(new Task("test", 20));
		// when
		Integer result = block.getUsedSize();
		// Then
		assertTrue("Result must be 20", result == 20);
	}
	
	@Test
	public void getUsedSize_full() {
		// Given
		ActivityBlock block = new ActivityBlock(30);
		block.addTask(new Task("test", 30));
		// when
		Integer result = block.getUsedSize();
		// Then
		assertTrue("Result must be 30", result == 30);
	}
	
}
