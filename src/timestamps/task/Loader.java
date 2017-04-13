package timestamps.task;


import timestamps.dao.impl.StatisticsDAOImpl;
import timestamps.kafkaintegration.Consumer;

public class Loader {

//	private StatisticsDAOImpl statisticsDAOImpl;
//	private Consumer consumer;
//
//	@Autowired
//	public void setStatisticsDAOImpl(StatisticsDAOImpl statisticsDAOImpl) {
//		this.statisticsDAOImpl = statisticsDAOImpl;
//		statisticsDAOImpl.init();
//	}
//
//	@Autowired
//	public void setConsumer(Consumer consumer) {
//		this.consumer = consumer;
//	}

	public Loader(StatisticsDAOImpl statisticsDAOImpl, Consumer consumer) {
		System.out.println(consumer);

		ConsumerTask task = new ConsumerTask(statisticsDAOImpl, consumer);
		task.run();

	}

}
