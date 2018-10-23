package my.example.service;

import my.example.api.ExampleService;

public class ExampleServiceBean implements ExampleService {

    private LoggerService loggerService = new LoggerService();

    @Override
    public void changeConsoleLogLevel(String level) {
        loggerService.changeConsoleLogLevel(level);
    }

    @Override
    public void changeFileLogLevel(String level) {
        loggerService.changeFileLogLevel(level);
    }
}