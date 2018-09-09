package com.training.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CreateHTMLReport {
	
	protected String title;
	protected String status;
	protected String time;
	protected String destination;
	protected String templateName;
	protected String log;
	
	@SuppressWarnings("deprecation")
	protected String createReport(String tableBody) throws IOException
	{
		File htmlTemplateFile = new File("htmlreports\\templates\\" + templateName + ".html");
		String htmlString = FileUtils.readFileToString(htmlTemplateFile);
		
//		Replace Template tags
		htmlString = htmlString.replace("$title", title);
		htmlString = htmlString.replace("$tableBody", tableBody);
		htmlString = htmlString.replace("$executionTime", time);
		htmlString = htmlString.replace("$status", status);
		
		if(status.equalsIgnoreCase("FAILED"))
		{
			htmlString = htmlString.replace("$colorofstatus", "red");
			htmlString = htmlString.replace("$failurelog", log);
		}
		else
		{
			htmlString = htmlString.replace("$colorofstatus", "green");
			htmlString = htmlString.replace("$failurelog", "");
		}	
		
		File newHtmlFile = new File("HTMLReports\\RunReports\\"+ destination + ".html");
		newHtmlFile.getParentFile().mkdirs();
		FileUtils.writeStringToFile(newHtmlFile, htmlString);
		return status;
	}
	
	public void setTemplate(String template)
	{
		this.templateName=template;
	}
	
	public void prepareReport(String title, String status, String time, long destination, int count,String log) throws IOException
	{
		this.title=title;
		this.status=status;
		this.time=time;
		this.destination=String.valueOf(destination);
		this.log=log;
		
		String chunk="<tr><td>Step_REPLACEWITHCOUNT</td><td><center><img  style=\"width:90%\" src=\"C:\\Users\\KillZone\\SeleniumGIT\\SeleniumTraining\\Screenshots\\REPLACEWITHDESTINATION\\REPLACEWITHCOUNT.png\"/></center></td></tr>";
		String tbody="";
		
		for(int i = 1; i<=count;i++)
		{
			String temp = chunk;
			temp=temp.replaceAll("REPLACEWITHCOUNT", String.valueOf(i));
			temp=temp.replaceAll("REPLACEWITHDESTINATION", this.destination);
			tbody+=temp+"\n";
			
		}
		
		createReport(tbody);
		
	}

}
