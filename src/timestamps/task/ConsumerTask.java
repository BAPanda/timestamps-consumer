package timestamps.task;

import java.math.BigInteger;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import timestamps.dao.impl.StatisticsDAOImpl;
import timestamps.kafkaintegration.Consumer;
import timestamps.models.Statistics;

public class ConsumerTask implements Runnable {

	private StatisticsDAOImpl statisticsDAOImpl;

	private Consumer consumer;

	public ConsumerTask() {

	}

	public ConsumerTask(StatisticsDAOImpl statisticsDAOImpl, Consumer consumer) {
		this.consumer = consumer;
		this.statisticsDAOImpl = statisticsDAOImpl;
	}

	public void run() {
		KafkaConsumer<String, String> cnsmr = consumer.getConsumer();
		System.out.println("IN RUN");

		// cnsmr.subscribe(Arrays.asList("test"));
		while (true) {
			ConsumerRecords<String, String> records = cnsmr.poll(1);
			for (ConsumerRecord<String, String> record : records) {
				String data = record.value();
				System.out.println(data);

				Statistics stat = new Statistics();
				stat.setEntityID(new BigInteger(record.key()));

				String[] params = data.split(":");

				stat.sethDDSpace(Double.parseDouble(params[0]));
				stat.setrAMLoad(Double.parseDouble(params[1]));
				stat.setTemperature(Double.parseDouble(params[2]));
				stat.setTimestamp(Long.parseLong(params[3]));

				statisticsDAOImpl.write(stat);

			}

		}
	}

}
