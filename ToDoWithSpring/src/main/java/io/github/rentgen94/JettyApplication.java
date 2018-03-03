package io.github.rentgen94;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.core.io.PathResource;

import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class JettyApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(JettyApplication.class);

        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        Path path = Paths.get("../rentgen94.github.io/springlearn/config.yml");
        yaml.setResources(new PathResource(path));
        System.out.println(yaml.getObject().getProperty("server.port"));
        app.setDefaultProperties(yaml.getObject());

        app.run(args);
    }
}
