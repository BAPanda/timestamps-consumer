package timestamps.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import timestamps.dao.impl.StatisticsDAOImpl;
import timestamps.kafkaintegration.Consumer;
import timestamps.task.ConsumerTask;

@Controller
public class StatisticsController {
	private StatisticsDAOImpl statisticsDAOImpl;
	private Consumer consumer;

	@Autowired
	public void setStatisticsDAOImpl(StatisticsDAOImpl statisticsDAOImpl) {
		this.statisticsDAOImpl = statisticsDAOImpl;		
	}

	@Autowired
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	
	@RequestMapping("/")
	public String hello() throws FileNotFoundException, IOException {
		//Consumer cons = new Consumer();
		//cons.run();
		ConsumerTask task = new ConsumerTask(statisticsDAOImpl, consumer);
		task.run();
		return "OK";
	}
}
