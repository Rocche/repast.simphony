package repast.simphony.statecharts;

import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ISchedule;

public class AlwaysTrigger extends AbstractTrigger<Object> {

	private final double pollingTime;
	
	public AlwaysTrigger(){
		this(1);
	}
	
	public AlwaysTrigger(double pollingTime){
		this.pollingTime = pollingTime;
	}
	
	private double initializedTickCount;

	@Override
	public void initialize() {
		ISchedule schedule = RunEnvironment.getInstance().getCurrentSchedule();
		initializedTickCount = schedule.getTickCount();
	}

	@Override
	public boolean isTriggered() {
		return isTriggerConditionTrue();
	}

	@Override
	public boolean isTriggerConditionTrue() {
		return true;
	}

	@Override
	public boolean isRecurring() {
		return true;
	}

	@Override
	public double getInterval() {
		return pollingTime;
	}

	@Override
	public double getNextTime() {
		return initializedTickCount + getInterval();
	}

	@Override
	public boolean canTransitionZeroTime() {
		return true;
	}


}
