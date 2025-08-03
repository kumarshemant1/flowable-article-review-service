package app.flow.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class PublishArticleService implements JavaDelegate {
	
    @Override
    public void execute(DelegateExecution execution) {
        String title = (String) execution.getVariable("title");
        System.out.println("Publishing article: " + title);
    }
}
