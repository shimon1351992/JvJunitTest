package Process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





public class ProcessRun
{
	private	String std_out;
	
	public String Output() {
		return this.std_out;
	}
	
	private String std_error;
	public String Error() {
		return this.std_error;
	}

	//	provide command and paramaters as an array of strings.
	//	To pring all directory files provide : {"dir", "c:\\"};
	public void Execute(String[] commands) throws IOException
	{
		Runtime rt = Runtime.getRuntime();
		
		Process proc = rt.exec(commands);
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

		// Read the output from the command
		//System.out.println("Here is the standard output of the command:\n");
		String out = null;
		while ((out = stdInput.readLine()) != null) {
			this.std_out += out;
		    System.out.println(out);
		}

		// Read any errors from the attempted command
		//System.out.println("Here is the standard error of the command (if any):\n");
		String error = null;
		while ((error = stdError.readLine()) != null) {
			this.std_error += error;
		    System.out.println(error);
		}
	}
}