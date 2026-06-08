package com.walter.task_api;

import com.walter.task_api.model.Task;
import com.walter.task_api.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class TaskApiApplication {

    private final Logger logger = LoggerFactory.getLogger(TaskApiApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(TaskApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(TaskRepository taskRepository) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            taskRepository.save(new Task("Homework", "About maths"));
            taskRepository.save(new Task("Maths", "About maths"));
            taskRepository.save(new Task("Cocking", "Make a sandwich"));
            taskRepository.save(new Task("Maths", "About maths"));

            this.logger.info("Customer found with all()");
            this.logger.info("-----------------------------------");
            var tasks = taskRepository.findAll();
            for (var task : tasks) {
                this.logger.info(task.toString());
            }
            this.logger.info("-----------------------------------");
        };
    }

}
