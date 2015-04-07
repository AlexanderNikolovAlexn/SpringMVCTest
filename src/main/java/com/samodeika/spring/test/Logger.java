package com.samodeika.spring.test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Logger {

	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;

	@Resource
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}

	@Resource(name = "fileWriter")
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public void writeFile(String text) {
		this.fileWriter.write(text);
	}

	public void writeConsole(String text) {
		if (this.consoleWriter != null) {
			this.consoleWriter.write(text);
		}
	}

	@PostConstruct
	public void init() {
		System.out.println("init");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("destroy");
	}
	
}
