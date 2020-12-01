package com.aegle.monitor;

import java.util.concurrent.Callable;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "aeglemon", mixinStandardHelpOptions = true, version = "aeglemon 1.0",
description = "Monitoring using Aeglemon Dashboard")
public class AegleMonitorMain implements Callable { 
	
    private static final Logger logger = LoggerFactory.getLogger(AegleMonitorMain.class);

	
    @Option(names = { "-e",  "--env"},defaultValue = "develop",  description = "Specify the environment")
    private Environment env;
 
    @Parameters(index = "0", description = "Command to run with aeglemon")
    private AeglemonCommand command;
    
    public static int mainCommand(String [] args) {
    	int exitCode = new CommandLine(new AegleMonitorMain()).execute(args);
        logger.info("Exit Code: " + exitCode);
        logger.info(System.getProperty("logdir"));
    	return exitCode;
    }
	
    @lombok.Generated
	public static void main(String[] args) {
        System.exit(mainCommand(args));		
	}

	@Override
	public Integer call() throws Exception {
    	logger.info("environment:" + env);
		return 0;
	}

}
