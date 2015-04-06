package com.samodeika.spring.test;

public class Logger {

	private ConsoleWriter consoleWriter;
	private FileWriter fileWriter;

	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}

	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public void writeFile(String text) {
		this.fileWriter.write(text);
	}

	public void writeConsole(String text) {
		this.consoleWriter.write(text);
	}

}
