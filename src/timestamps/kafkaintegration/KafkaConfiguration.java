package timestamps.kafkaintegration;

public class KafkaConfiguration {
	private String topic;
	private String brokerAddress;
	private String zookeeperAddress;
	
	public KafkaConfiguration(String topic, String brokerAddress, String zookeeperAddress) {
		
		this.topic = topic;
		this.brokerAddress = brokerAddress;
		this.zookeeperAddress = zookeeperAddress;
		
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getBrokerAddress() {
		return brokerAddress;
	}

	public void setBrokerAddress(String brokerAddress) {
		this.brokerAddress = brokerAddress;
	}

	public String getZookeeperAddress() {
		return zookeeperAddress;
	}

	public void setZookeeperAddress(String zookeeperAddress) {
		this.zookeeperAddress = zookeeperAddress;
	}	
}
