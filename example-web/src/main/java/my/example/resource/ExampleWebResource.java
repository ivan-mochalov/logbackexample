package my.example.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import my.example.service.ExampleServiceFacade;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/logger")
public class ExampleWebResource {
    private static final Logger logger = LoggerFactory.getLogger(ExampleWebResource.class);
    private ExampleServiceFacade exampleServiceFacade = new ExampleServiceFacade();

    @POST
    @Path("/file/{level}")
    public Response getRootLogLevel(@PathParam("level") String level) {
        exampleServiceFacade.changeFileLogLevel(level);
        checkThisOut();
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/console/{level}")
    public Response setConsoleLoggerLevel(@PathParam("level") String level) {
        exampleServiceFacade.changeConsoleLogLevel(level);
        checkThisOut();
        return Response.status(Response.Status.OK).build();
    }

    private void checkThisOut() {
        for (int i = 0; i < 100; i++) {
            doLogging(i);
        }
    }

    private void doLogging(int i) {
        logger.error("{} error message", i);
        logger.warn("{} warn message", i);
        logger.info("{} info message", i);
        logger.debug("{} debug message", i);
        logger.trace("{} trace message", i);
    }
}