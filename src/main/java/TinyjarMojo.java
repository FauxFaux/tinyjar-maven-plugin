import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.goeswhere.tinyjar.Packager;

/**
 * Package the jar with tinyjar
 * @goal package
 */
public class TinyjarMojo extends AbstractMojo {
	
	public void execute() throws MojoExecutionException, MojoFailureException {

		System.setErr( new PrintStream( new ByteArrayOutputStream(){

			private StringBuilder record = new StringBuilder();
			
			public void flush() throws IOException { 
				 
					String current;
				
			        synchronized(this) { 
			        	
			        	super.flush(); 
			            
			        	current = this.toString();
			            
			            super.reset(); 
			 
			            if (current.length() == 0 || current.equals(System.getProperty("line.separator"))) {
				            
			            	if (record.toString().length() != 0)		            	
			            		getLog().info(record.toString().replaceAll("\n", ""));
				            
			            	record.setLength(0);		            	
			            } else {
			            	record.append(current);
			            }
			        } 
			    } 
			
		} ,true));
		
		for (final File file : new File("./target/").listFiles()) {
		
			if (file.getName().endsWith(".jar"))
				tinyJar(file);

		}
		
		getLog().info("Done.");
	
	}

	private void tinyJar(final File file) {
		
		log("Generating tinyjar for %s...",file.getName());
		
		try {
			Packager.main(new String[]{ file.getAbsolutePath() });
		} catch (IOException e) {
			log("Unable to create tinyjar for %s", file.getName());
		}
	}
	
	
	private void log(String format, String string) {
		getLog().info(String.format(format, string));
	}
	

}
