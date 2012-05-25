A maven plugin that implements tinyjar ( https://blog.goeswhere.com/2012/02/tinyjar/ ) as a custom packaging option.

## Usage

Download and install (with mvn install) the tinyjar repository at https://github.com/FauxFaux/tinyjar

Install this plugin (with mvn install)

Add the following to your pom. For packaging: 

    <packaging>clojure</packaging>
    
Under build/plugins:

      <plugin>
        <groupId>uk.co.probablyfine</groupId>
        <artifactId>clojure-maven-plugin</artifactId>
        <version>1.3.10</version>
        <extensions>true</extensions>
      </plugin>


