package service;

import service.impl.ExampleServiceBean;

public class ExampleServiceFacade implements ExampleService {

    private ExampleService exampleService = new ExampleServiceBean();

    @Override
    public void changeConsoleLogLevel(String level) {
        exampleService.changeConsoleLogLevel(level);
    }
}
