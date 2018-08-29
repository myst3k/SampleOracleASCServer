# Sample Oracle ASC Auth Callouts

You need to add in your Oracle ASC Jar file to the local Maven repo.

    mvn install:install-file -Dfile=$HOME/covwsezsdk.jar -DgroupId=covwsezsdk -DartifactId=covwsezsdk -Dversion=E3.7.0.M3P10 -Dpackaging=jar
    
You can now hit endpoint http://localhost:8080/ws/GetAuthSessionPolicy and get a response.