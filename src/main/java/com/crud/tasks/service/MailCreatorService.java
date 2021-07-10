package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

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
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("welcome_message", "New task in Trello");
        context.setVariable("goodbye_message", "Greetings, yours " + adminConfig.getAdminName());
        context.setVariable("company_details", companyConfig.getCompanyName() + ", email: " + companyConfig.getCompanyEmail() + ", phone: " + companyConfig.getCompanyPhone());
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

}
