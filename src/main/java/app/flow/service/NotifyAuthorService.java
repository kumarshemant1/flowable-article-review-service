package app.flow.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class NotifyAuthorService implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		String authorEmail = (String) execution.getVariable("authorEmail");
		System.out.println("Sending rejection email to: " + authorEmail);
	}
}