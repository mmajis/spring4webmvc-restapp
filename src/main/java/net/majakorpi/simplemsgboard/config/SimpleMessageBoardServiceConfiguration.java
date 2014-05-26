package net.majakorpi.simplemsgboard.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"net.majakorpi.simplemsgboard.service", "net.majakorpi.simplemsgboard.repository"})
@Import({ })
public class SimpleMessageBoardServiceConfiguration {
 

}
