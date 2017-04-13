package timestamps.kafkaintegration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	private KafkaConsumer<String, String> consumer;

	public Consumer(String topic) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		Resource resource = new ClassPathResource("kafkaconsumer.properties");
		props.load(resource.getInputStream());	
		
		consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(topic));
	}
	
	public KafkaConsumer<String, String> getConsumer() {
		return consumer;
	}
	
}
