package my.example.service;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.filter.ThresholdFilter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerService {
    private static final Logger logger = LoggerFactory.getLogger(LoggerService.class);
    private static final String ROOT_LOGGER_NAME = "root";
    private static final String CONSOLE_APPENDER_NAME = "console";
    private static final String FILE_APPENDER_NAME = "file";

    private static final String LOGGER_LEVEL_CHANGE_MESSAGE = "Logger level changed to {} in {} appender";

    public void changeConsoleLogLevel(String level) {
        changeLogLevel(level, CONSOLE_APPENDER_NAME);
    }

    public void changeFileLogLevel(String level) {
        changeLogLevel(level, FILE_APPENDER_NAME);
    }

    private void changeLogLevel(String level, String appenderName) {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        ch.qos.logback.classic.Logger root = context.getLogger(ROOT_LOGGER_NAME);
        Appender<ILoggingEvent> appender = root.getAppender(appenderName);
        appender.clearAllFilters();
        ThresholdFilter thresholdFilter = new ThresholdFilter();
        thresholdFilter.setLevel(level);
        thresholdFilter.start();
        appender.addFilter(thresholdFilter);
        logger.info(LOGGER_LEVEL_CHANGE_MESSAGE, level, appender);
    }
}