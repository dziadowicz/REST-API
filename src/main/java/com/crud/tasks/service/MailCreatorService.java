package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("welcome_message", "New task in Trello");
        context.setVariable("goodbye_message", "Greetings, yours " + adminConfig.getAdminName());
        context.setVariable("company_details", companyConfig.getCompanyName() + ", email: " + companyConfig.getCompanyEmail() + ", phone: " + companyConfig.getCompanyPhone());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildTasksNumberEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("Open url from above");
        functionality.add("Input your task's name and content");
        functionality.add("Click \"Add a task\" button");

        Context context = new Context();
        context.setVariable("tasks_number", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("welcome_message", "Number of tasks info");
        context.setVariable("goodbye_message", "Greetings, yours " + adminConfig.getAdminName());
        context.setVariable("company_details", companyConfig.getCompanyName() + ", email: " + companyConfig.getCompanyEmail() + ", phone: " + companyConfig.getCompanyPhone());
        if (message.equals("0")) {
            context.setVariable("is_null", true);
            context.setVariable("is_singular", false);
        } else if (message.equals("1")){
            context.setVariable("is_null", false);
            context.setVariable("is_singular", true);
        } else {
            context.setVariable("is_null", false);
            context.setVariable("is_singular", false);
        }
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/number-of-tasks-info", context);
    }

}
