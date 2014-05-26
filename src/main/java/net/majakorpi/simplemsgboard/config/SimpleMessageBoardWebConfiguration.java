package net.majakorpi.simplemsgboard.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.majakorpi.simplemsgboard.rest")
@Import({ })
public class SimpleMessageBoardWebConfiguration {
 

}
