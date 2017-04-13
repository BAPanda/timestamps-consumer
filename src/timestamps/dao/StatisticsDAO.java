package timestamps.dao;

import java.math.BigInteger;
import java.util.List;

import timestamps.models.Statistics;

public interface StatisticsDAO {
	
	public List<Statistics> getForEntity(BigInteger ID);
	
	public void write(Statistics stat);

}
