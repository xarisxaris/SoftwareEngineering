package model.strategies;

public class VersionsStrategyFactory {

	public VersionsStrategy createStrategy(String strategyName) {
		if(strategyName.equals("stable")) {
			return new StableVersionsStrategy();
		}
		else if(strategyName.equals("volatile")) {
			return new VolatileVersionsStrategy();
		}
		return null;
	}
}
