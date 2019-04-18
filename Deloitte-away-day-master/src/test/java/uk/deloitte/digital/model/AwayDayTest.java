

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import uk.deloitte.digital.exception.AwayDayException;

public class AwayDayTest {
	
	@Test
	public void addTasks_ok() throws AwayDayException {
		// Given
		AwayDay awayDay = new AwayDay(
				LocalTime.of(9, 00),
				LocalTime.of(12, 00),
				LocalTime.of(13, 00),
				LocalTime.of(16, 00),
				0,2);
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("prueba1", 60));
		tasks.add(new Task("prueba2", 15));
		tasks.add(new Task("prueba3", 60));
		tasks.add(new Task("prueba4", 30));
		tasks.add(new Task("prueba5", 60));
		tasks.add(new Task("prueba6", 60));
		tasks.add(new Task("prueba7", 30));
		tasks.add(new Task("aprueba8", 60));
		tasks.add(new Task("aprueba9", 60));
		tasks.add(new Task("aprueba10", 15));
		tasks.add(new Task("aprueba11", 60));
		tasks.add(new Task("aprueba12", 60));
		tasks.add(new Task("aprueba13", 60));
		tasks.add(new Task("aprueba14", 60));
		tasks.add(new Task("aprueba15", 30));
		// when
		awayDay.addTasks(tasks);
		// Then -> no exception
	}
	
	@Test(expected = AwayDayException.class )
	public void addTasks_fewTasks() throws AwayDayException {
		// Given
		AwayDay awayDay = new AwayDay(
				LocalTime.of(9, 00),
				LocalTime.of(12, 00),
				LocalTime.of(13, 00),
				LocalTime.of(16, 00),
				0,2);
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("prueba1", 60));
		tasks.add(new Task("prueba2", 15));
		tasks.add(new Task("prueba3", 60));
		tasks.add(new Task("prueba4", 30));
		tasks.add(new Task("prueba5", 60));
		tasks.add(new Task("prueba6", 60));
		tasks.add(new Task("prueba7", 30));
		tasks.add(new Task("aprueba8", 60));
		tasks.add(new Task("aprueba9", 60));
		tasks.add(new Task("aprueba10", 15));
		tasks.add(new Task("aprueba11", 60));
		tasks.add(new Task("aprueba12", 60));
		tasks.add(new Task("aprueba13", 60));
		tasks.add(new Task("aprueba14", 60));
		tasks.add(new Task("aprueba15", 15));
		// when
		awayDay.addTasks(tasks);
		// Then -> exception
	}
	
	@Test(expected = AwayDayException.class )
	public void addTasks_manyTasks() throws AwayDayException {
		// Given
		AwayDay awayDay = new AwayDay(
				LocalTime.of(9, 00),
				LocalTime.of(12, 00),
				LocalTime.of(13, 00),
				LocalTime.of(16, 00),
				0,2);
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("prueba1", 60));
		tasks.add(new Task("prueba2", 15));
		tasks.add(new Task("prueba3", 60));
		tasks.add(new Task("prueba4", 30));
		tasks.add(new Task("prueba5", 60));
		tasks.add(new Task("prueba6", 60));
		tasks.add(new Task("prueba7", 30));
		tasks.add(new Task("aprueba8", 60));
		tasks.add(new Task("aprueba9", 60));
		tasks.add(new Task("aprueba10", 15));
		tasks.add(new Task("aprueba11", 60));
		tasks.add(new Task("aprueba12", 60));
		tasks.add(new Task("aprueba13", 60));
		tasks.add(new Task("aprueba14", 60));
		tasks.add(new Task("aprueba15", 60));
		// when
		awayDay.addTasks(tasks);
		// Then -> exception
	}

}
