
package hello;





import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import task.ScheduledTasks;

import com.mongodb.MongoClient;

@ComponentScan
@Configuration
@EnableMongoRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Stream.of(Application.class, ScheduledTasks.class).toArray(), args);
	}
	
	 public @Bean MongoDbFactory mongoDbFactory() throws Exception {
		  UserCredentials userCredentials = new UserCredentials("pigabo", "password");
		    return new SimpleMongoDbFactory(new MongoClient("ds035740.mongolab.com", 35740), "pigabo", userCredentials);
	  }
}
