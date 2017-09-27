package config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Shubham Aggarwal
 * @since : 27/09/17
 */
@Configuration
public class DataConfig {

    @Value("${person.data.mongodb.host}")
    private String host;

    @Value("${person.data.mongodb.database}")
    private String connectingDatabase;

    @Value("${person.data.mongodb.authentication-database}")
    private String authenticationDatabase;

    @Value("${person.data.mongodb.username}")
    private String username;

    @Value("${person.data.mongodb.password}")
    private String password;

    @Value("${person.data.mongodb.port}")
    private int port;

    public MongoDbFactory mongoDbFactory() {
        List<MongoCredential> credentialsList = new ArrayList<>();
        MongoCredential creds = MongoCredential.createCredential(username, authenticationDatabase, password.toCharArray());
        credentialsList.add(creds);
        ServerAddress serverAddress = new ServerAddress(host, port);
        return new SimpleMongoDbFactory(new MongoClient(serverAddress, credentialsList), connectingDatabase);
    }

    @Primary
    @Bean
    public MongoTemplate getMongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}
