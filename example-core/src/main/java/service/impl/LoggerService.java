package service.impl;

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

    public void changeConsoleLogLevel(String level) {
        logger.info("Console logger level changed to {}", level);
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        ch.qos.logback.classic.Logger root = context.getLogger(ROOT_LOGGER_NAME);
        Appender<ILoggingEvent> console = root.getAppender(CONSOLE_APPENDER_NAME);
        console.clearAllFilters();
        ThresholdFilter thresholdFilter = new ThresholdFilter();
        thresholdFilter.setLevel(level);
        thresholdFilter.start();
        console.addFilter(thresholdFilter);
    }
}