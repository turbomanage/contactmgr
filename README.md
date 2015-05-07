# contactmgr #

A sample mobile Web app using Google App Engine for Java, Objectify, and Jersey on the server along
with GWT Activities & Places and Resty-GWT on the client.

### Community ###

Use the [issue tracker](https://github.com/turbomanage/contactmgr/issues) to report bugs or request enhancements.

### Download the sample ###
 1. ```git clone https://github.com/turbomanage/contactmgr.git```
 1. If you don't already have it, [install Maven 3](http://maven.apache.org/download.cgi).

### Run the sample ###
 1. ```mvn -Prelease clean package appengine:devserver```
 2. Browse to http://localhost:8080/contactmgr/login

### Run the sample in GWT super dev mode ###
 1. ```mvn -Prelease clean package appengine:devserver_start``` (starts in background)
 1. ```mvn gwt:run-codeserver```
 1. Wait for the message "Listening for transport dt_socket at address: 8000"
 1. Configure a Java remote debugger in your IDE on port 8000 and launch it to attach.
 1. The standalone GWT console will appear and you can launch the browser from there.
 
 Alternatively, you can run GWT dev mode directly with Google Plugin
 for Eclipse or IntelliJ full edition (see further instructions).
 
### Setup with IntelliJ ###
 1. Import the project into IntelliJ as a Maven project.
 1. If you have IntelliJ full edition, you can run GWT dev mode in the IDE as usual.

 Note: In the IntelliJ run configuration, you may want to add the following VM options:
 * ```-Xmx2g``` Give dev mode more RAM
 * ```-Ddatastore.backing_store=path/to/contactmgr/local_db.bin``` Prevent the datastore getting wiped from the target dir

 In addition, the following Dev Mode parameter will allow you to browse from a mobile device on the same wifi network:
 * ```-bindAddress 0.0.0.0```

 Finally, in the run configuration dialog, select the specific Server version in the POM; for example, App Engine 1.9.18.

 The start page is contactmgr/login.

### Setup with Eclipse ###
 1. Install the [Google Plugin for Eclipse](https://developers.google.com/eclipse/docs/download).
 1. Import the project into Eclipse as an existing Maven project.

### Optional ###
The sample includes G+ and Facebook login integration. The buttons are found in src/main/webapp/index.html. Simply
look for the TODOs where you need to replace the CLIENT_IDs and secrets with those found in the respective developer
consoles.
   
### Upload to App Engine ###
Before uploading to App Engine, replace the application ID and version in src/main/webapp/WEB-INF/appengine-web.xml.
To obfuscate the GWT code, making it smaller, build with the maven "release" profile.

Example:
```mvn -P release clean package appengine:update```
