package TestRunners;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.runner.Result;

public class TestRunner{
	//test comment
	private static int key = 1;
	static String className;
	private static String reportHeader = "<html>\r\n" + 
			"    <head>\r\n" + 
			"        <link href=\"https://fonts.googleapis.com/css?family=Anton|Bungee\" rel=\"stylesheet\">\r\n" + 
			"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\" integrity=\"sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ\" crossorigin=\"anonymous\">\r\n" + 
			"        <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n" + 
			"        <style>\r\n" + 
			"            body{\r\n" + 
			"                font-family: Anton;\r\n" + 
			"            }\r\n" + 
			"            h1{\r\n" + 
			"                font-family: Bungee;\r\n" + 
			"            }\r\n" + 
			"            span{\r\n" + 
			"                color: blue;\r\n" + 
			"            }\r\n" + 
			"        </style>\r\n" + 
			"    </head>\r\n" + 
			"    <body>\r\n" + 
			"        <h1><span>QATOOL</span>DEMO STORE TEST</h1>\r\n" + 
			"        <br>\r\n" + 
			"        <br>\r\n" + 
			"        <div>\r\n" + 
			"            <h2>Result Summary</h2>\r\n" + 
			"            <p>Duration: ";
	private static String reportFirstPartOfTable = "</p>\r\n" + 
			"            <table class=\"table\" style=\"width:30%;\">\r\n" + 
			"                <thead class=\"thead-inverse\">\r\n" + 
			"                    <tr>\r\n" + 
			"                        <th>STATUS</th>\r\n" + 
			"                        <th>#</th>\r\n" + 
			"                        <th>%</th>\r\n" + 
			"                    </tr>\r\n" + 
			"                </thead>\r\n" + 
			"                <tbody>\r\n" + 
			"                    <tr>\r\n" + 
			"                        <th scope=\"row\"><i class=\"fa fa-check\" aria-hidden=\"true\" style=\"color:green;\"></i></th>\r\n" + 
			"                        <td>";
	private static String reportSecondPartOfTable = "</td>\r\n" + 
			"                        <td>";
	private static String reportThirdPartOfTable = "</td>\r\n" + 
			"                    </tr>\r\n" + 
			"                    <tr>\r\n" + 
			"                        <th scope=\"row\"><i class=\"fa fa-times\" aria-hidden=\"true\" style=\"color:red;\"></i></th>\r\n" + 
			"                        <td>";
	private static String reportFourthPartOFTable = "</td>\r\n" + 
			"                    </tr>\r\n" + 
			"                    <tr>\r\n" + 
			"                        <th scope=\"row\">SUM</th>\r\n" + 
			"                        <td>";
	private static String reportFivthPartOFTable = "</td>\r\n" + 
			"                        <td>100</td>\r\n" + 
			"                    </tr>\r\n" + 
			"                </tbody>\r\n" + 
			"            </table>\r\n" + 
			"        </div>\r\n" + 
			"        <br><br>\r\n" + 
			"        <div>\r\n" + 
			"            <h2>Failed Test Scenarios Overview</h2>\r\n" + 
			"            <table class=\"table\">\r\n" + 
			"                <thead class=\"thead-inverse\">\r\n" + 
			"                    <tr>\r\n" + 
			"                        <th>#</th>\r\n" + 
			"                        <th>Result</th>\r\n" + 
			"                        <th>Name</th>\r\n" + 
			"                        <th>Error</th>\r\n" + 
			"                    </tr>\r\n" + 
			"                </thead>\r\n" + 
			"                <tbody>\r\n";
	 
	static File junitReport;
	static BufferedWriter junitWriter;
	//create html document with header etc
	public static  void setUp(Result result, String className) throws IOException {
		long runTime = result.getRunTime();
		String time = String.format("%d min, %d sec", 
			    TimeUnit.MILLISECONDS.toMinutes(runTime),
			    TimeUnit.MILLISECONDS.toSeconds(runTime) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(runTime))
			);

			
		Date date = new Date();
		DateFormat dateForName = new SimpleDateFormat("dd_MM_yyyy");
		
		String junitReportFile = System.getProperty("user.dir")
				+ "\\"+ className  +dateForName.format(date)+".html";
		
		junitReport = new File(junitReportFile);
		junitWriter = new BufferedWriter(new FileWriter(junitReport, true));
		junitWriter.write(reportHeader + time);

	}
	//add to html results summary
	public static void succeedCases(Result result) throws IOException {
		int allTests = result.getRunCount();
		int failedTests = result.getFailureCount();
		int failTestsPercent = failedTests * 100 / allTests;
		System.out.println("failed % " + failTestsPercent);
		int passedTests = allTests - failedTests;
		int passedTestsPercent = passedTests * 100 / allTests;
		System.out.println("passed % " + passedTestsPercent);
		
		junitWriter.write( reportFirstPartOfTable + passedTests + reportSecondPartOfTable + passedTestsPercent + reportThirdPartOfTable + failedTests + reportSecondPartOfTable + failTestsPercent + reportFourthPartOFTable + allTests + reportFivthPartOFTable);

	}
	
	//close html
	public static  void tearDown() throws IOException {

		junitWriter.write("</tbody></table></body></html>");
		junitWriter.close();
		Desktop.getDesktop().browse(junitReport.toURI());

	}
	//add failures to html
	public static void reportFailure(String testCaseName,  String failureMessage) throws IOException{
		junitWriter.write("<tr><th>" + key + "</th><th><span style=\"color:red;\">FAILED</span></th><th>" + testCaseName + "</th><th>" + failureMessage + "</th></tr>");
		key++;
	}
	


}

