

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExtraTimeBlockTest {

	@Test
	public void addTask_ok() {
		// Given
		ExtraTimeBlock block = new ExtraTimeBlock(60, 10);
		Task task = new Task("test", 60);
		// when
		boolean result = block.addTask(task);
		// Then
		assertTrue("Result must be true", result);
	}
	
	@Test
	public void addTask_overSize() {
		// Given
		ExtraTimeBlock block = new ExtraTimeBlock(30, 10);
		Task task = new Task("test", 60);
		// when
		boolean result = block.addTask(task);
		// Then
		assertFalse("Result must be false", result);
	}
	
	@Test
	public void addTask_nullTask() {
		// Given
		ExtraTimeBlock block = new ExtraTimeBlock(30, 10);
		// when
		boolean result = block.addTask(null);
		// Then
		assertFalse("Result must be false", result);
	}
	
	@Test
	public void getAvailableSize_empy() {
		// Given
		ExtraTimeBlock block = new ExtraTimeBlock(30, 10);
		// when
		Integer result = block.getAvailableSize();
		// Then
		assertTrue("Result must be 40", result == 40);
	}
	
	@Test
	public void getAvailableSize_half() {
		// Given
		ExtraTimeBlock block = new ExtraTimeBlock(30, 10);
		block.addTask(new Task("test", 20));
		// when
		Integer result = block.getAvailableSize();
		// Then
		assertTrue("Result must be 10", result == 20);
	}
	
	@Test
	public void getAvailableSize_full() {
		// Given
		ExtraTimeBlock block = new ExtraTimeBlock(30, 10);
		block.addTask(new Task("test", 40));
		// when
		Integer result = block.getAvailableSize();
		// Then
		assertTrue("Result must be 0", result == 0);
	}
	
	
	@Test
	public void getUsedSize_empy() {
		// Given
		ExtraTimeBlock block = new ExtraTimeBlock(30, 10);
		// when
		Integer result = block.getUsedSize();
		// Then
		assertTrue("Result must be 0", result == 0);
	}
	
	@Test
	public void getUsedSize_half() {
		// Given
		ExtraTimeBlock block = new ExtraTimeBlock(30, 10);
		block.addTask(new Task("test", 20));
		// when
		Integer result = block.getUsedSize();
		// Then
		assertTrue("Result must be 20", result == 20);
	}
	
	@Test
	public void getUsedSize_full() {
		// Given
		ExtraTimeBlock block = new ExtraTimeBlock(30, 10);
		block.addTask(new Task("test", 30));
		// when
		Integer result = block.getUsedSize();
		// Then
		assertTrue("Result must be 30", result == 30);
	}
	
}
