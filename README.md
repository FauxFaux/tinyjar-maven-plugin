A maven plugin that implements tinyjar ( https://blog.goeswhere.com/2012/02/tinyjar/ ) as a custom packaging option.

Note: Not fully tested, use at your own risk

## Usage

Download and install (with mvn install) the tinyjar repository at https://github.com/FauxFaux/tinyjar

Install this plugin (with mvn install)

Add the following to your pom. For packaging: 

    <packaging>tinyjar</packaging>
    
Under build/plugins:

      <plugin>
        <groupId>uk.co.probablyfine</groupId>
        <artifactId>tinyjar-maven-plugin</artifactId>
        <version>0.0.1</version>
        <extensions>true</extensions>
      </plugin>


