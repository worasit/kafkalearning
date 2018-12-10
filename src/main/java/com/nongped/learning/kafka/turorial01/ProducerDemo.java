package com.nongped.learning.kafka.turorial01;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {
        // Create producer properties
        Properties properties = new Properties();
        String bootstrapServer = "localhost:9092";
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // Create producer records
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(
                "first_topic",
                "key1",
                "java producer"
        );

        // Send data - asynchronous
        producer.send(record);

        // flush data
        producer.flush();

        // flush data and close
        producer.close();
    }
}
