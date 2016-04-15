package utils;

import java.util.ArrayList;
import java.util.Date;

public class TopicGenerator {

	private static String topic;
	private static ArrayList<String> topics;

	public String getTopic() {
		return topic;
	}

	public static String getTopics() {
		topics.get(topics.size() - 1);
		return topic;
	}

	public String generateTopic() {
		topics = new ArrayList<String>();
		Date date = new Date();
		long d = date.getTime();
		topic = "topic" + String.valueOf(d);
		topics.add(topic);
		return topic;
	}

}
