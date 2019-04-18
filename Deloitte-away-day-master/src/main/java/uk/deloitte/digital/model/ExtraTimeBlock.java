

/**
 * Class for a group of tasks with a delimited size and extra time
 * 
 * 
 *
 */
public class ExtraTimeBlock extends ActivityBlock {

	private Integer extraTime;

	public ExtraTimeBlock(Integer size, Integer extraTime) {
		super(size);
		this.extraTime = extraTime;
	}
	
	/**
	 * Method to retrieve the available size
	 * 
	 * @return available size
	 */
	@Override
	public Integer getAvailableSize() {
		return super.getAvailableSize() + this.extraTime;
	}

	public Integer getExtraTime() {
		return extraTime;
	}

	public void setExtraTime(Integer extraTime) {
		this.extraTime = extraTime;
	}

}
