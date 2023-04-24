package com.attendence.processor;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class EventStreamProcessor {

	@Autowired
	private StreamsBuilder streamsBuilder;

	@PostConstruct
	public void streamTopology() {

		int empId = 101;
System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");

		// check-in
		KStream<String, String> kstreamin = streamsBuilder.stream("spring.kafka.input.checkin",
				Consumed.with(Serdes.String(), Serdes.String()));

		// kstreamin.mapValues((k,v) -> ).collect();
		/*
		 * KTable<String, Long> kstreamin1 = kstreamin.flatMapValues(value ->
		 * Arrays.asList(value.split("##"))) .groupBy((key, word) -> word).count();
		 */
		  
		  final KStream<String, String> kstreamin1 = kstreamin.map((k, v) -> {
			  Syste,.out.println("aqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		  String strArr[] = v.split("##");
		  
		  return KeyValue.pair(strArr[0], strArr[1]);
		  
		  
		  });
		 

		// }*/
		/*
		 * private Object toMap(Object object, Object object2) { // TODO Auto-generated
		 * method stub return null; }
		 */

		/*
		 * // check-out KStream<String, String> kstreamout =
		 * streamsBuilder.stream("spring.kafka.input,checkout",
		 * Consumed.with(Serdes.String(), Serdes.String()));
		 * 
		 * KStream<String, String> kstreamin2 = kstreamout.filter((key, value) ->
		 * value.equals(empId));
		 */

		// List<KStream<String, String>> a = Arrays.asList(kstreamin1, kstreamin2);

		// a.stream().flatMap(a-> a);

		
		  kstreamin1.mapValues((k, v) -> v)) .peek((k, v) ->
		  System.out.println("Key : " + k + " Value : " + v))
		  .to("spring.boot.kafka.stream.output", Produced.with(Serdes.String(),
		  Serdes.String()));
		 
	}
}
