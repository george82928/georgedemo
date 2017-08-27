# georgedemo
# Prerequisites to build and run this application #
- Please make sure java is installed and configured properly
- Please make sure maven is installed in your machine
- Please make sure you have internet access
- Please make sure git is installed in your machine so that you can checkout the code
# Steps to run this application #
- Open your command line and follow steps below:
- Run the following command to checkout the source code from the following url:  
  `git clone git@github.com:george82928/georgedemo.git`
- Enter georgedemo folder you just checked out, run the following command:
  `mvn clean install`
- Enter target folder just generated after running above command, run the following command:  
  `java -jar georgedemo-1.0.jar`
- Open your web browser and access to the following url:  
  http://localhost:8080/georgedemo/
## Notes ##
- User manual and design doc are in the **doc** folder.  
- Class diagram is generated by plantuml, scripts to generate the class diagram is in the doc folder too.