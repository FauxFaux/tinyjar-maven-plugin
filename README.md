A maven plugin that implements tinyjar ( https://blog.goeswhere.com/2012/02/tinyjar/ ) as a custom packaging option.

Note: Not fully tested (my attempt at writing a maven plugin)

## Usage

Download and install (with mvn install) the tinyjar repository at https://github.com/FauxFaux/tinyjar

Install this plugin (with mvn install)

Under build/plugins:

      <plugin>
        <groupId>uk.co.probablyfine</groupId>
        <artifactId>tinyjar-maven-plugin</artifactId>
        <version>0.0.1</version>
        <extensions>true</extensions>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>package</goal>
            </goals>
          </execution>
        <executions>
      </plugin>

(Or under whichever phase you like)
