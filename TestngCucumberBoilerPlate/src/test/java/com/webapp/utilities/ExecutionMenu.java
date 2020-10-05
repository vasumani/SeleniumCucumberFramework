package com.webapp.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;

import org.testng.annotations.Test;
/**
 * ExecutionMenu - End User - Front End UI for Test Case Execution.
 * @author Prabhuling Kalshetti
 *
 */

public class ExecutionMenu extends ComponentsLoader
{
	public ExecutionMenu () {
		super();
	}

		public static void main(String[] args) throws Exception 
	{
		final JFrame f = new JFrame("Test Case Execution Portal ");
		ExecutionMenu apl = new ExecutionMenu();
		apl.setFrame(f);
		apl.getFrame().setSize(700, 600);
		apl.getFrame().setLayout(null);
		apl.buildForm();
		apl.getFrame().setVisible(true);
		apl.getFrame().setResizable(false);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyyHHmmss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
		File consoleLogFile= new File("Console/consoleLog_"+dtf.format(now)+".log");
		System.out.println(consoleLogFile.getAbsolutePath());
		consoleLogFile.createNewFile();
		System.setOut(new PrintStream(new FileOutputStream(consoleLogFile))); 

}
}
