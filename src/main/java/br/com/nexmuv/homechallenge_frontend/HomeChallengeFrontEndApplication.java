package br.com.nexmuv.homechallenge_frontend;

import br.com.nexmuv.homechallenge_frontend.models.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class HomeChallengeFrontEndApplication implements ApplicationRunner {

    @Autowired
    public Environment env;

    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder
                .baseUrl(env.getProperty("api.url"))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean
    @SessionScope
    public Basket sessionBasket(){
        return new Basket();
    }

    public static void main(String[] args) {
        SpringApplication.run(HomeChallengeFrontEndApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("api.url    =" + env.getProperty("api.url"));
        System.out.println("server.port=" + env.getProperty("server.port"));
    }

}
