package my.example.service;

import my.example.api.ExampleService;

public class ExampleServiceFacade implements ExampleService {

    private ExampleService exampleService = new ExampleServiceBean();

    @Override
    public void changeConsoleLogLevel(String level) {
        exampleService.changeConsoleLogLevel(level);
    }

    @Override
    public void changeFileLogLevel(String level) {
        exampleService.changeFileLogLevel(level);
    }
}