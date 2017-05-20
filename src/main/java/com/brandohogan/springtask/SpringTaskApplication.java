package com.brandohogan.springtask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTaskApplication.class, args);
	}

	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}

	/*
		Parameters:
			stationid,
			license plate,
			timestamp
	 */
	public class TollProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {

			if (strings != null) {
				System.out.println("parameter length is " + strings.length);

				String stationId = strings[0];
				String licensePlate = strings[1];
				String timeStamp = strings[2];

				System.out.println("Station ID :" + stationId + "  plate :" + licensePlate + "  timestamp :" + timeStamp);

			}

		}
	}
}
