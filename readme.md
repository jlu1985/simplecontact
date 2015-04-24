## Development Environment Settings
* Linux/Fedora
* Oracle JDK 8
* Tomcat 8
* Servlet 3.0

## JNDI Resource Name
Context file is located in META-INF
jdbc url is set to use relative path "jdbc:sqlite:scDb"
It was needed to add 
`factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"`
In order to work on tomcat 8

## Sql Schema File
A file named sqlite.sql under src/main/resources 