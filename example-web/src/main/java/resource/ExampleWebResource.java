package resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ExampleServiceFacade;

public class ExampleWebResource {
    private static final Logger logger = LoggerFactory.getLogger(ExampleWebResource.class);

    public static void setUpLevel(String level) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            if (i % 5 == 0) {
                try {
                    throw new Exception("Exception message");
                } catch (Exception e) {
                    logger.error("{} caught exception! {}", i, e.getMessage());
                }
            }
            logger.warn("{} warn message", i);
            logger.info("{} info message", i);
            logger.debug("{} debug message", i);
            logger.trace("{} trace message", i);
            Thread.sleep(1000);
            if (i == 4) {
                new ExampleServiceFacade().changeConsoleLogLevel(level);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        setUpLevel("debug");
    }
}
