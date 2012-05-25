import java.io.File;
import java.io.IOException;

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

		for (final File file : new File("./target/").listFiles()) {
		
			if (file.getName().endsWith(".jar"))
				tinyJar(file);

		}
	
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
