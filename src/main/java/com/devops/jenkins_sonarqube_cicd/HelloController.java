
package com.devops.jenkins_sonarqube_cicd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello! My Jenkins CI/CD application is running.";
    }
}
