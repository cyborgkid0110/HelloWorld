# End To End developer setup to get a working Spigot plugin up and running in no time

## Expectations

* You are familiar with IntelliJ
* You are familiar with Java
* You are familiar with Spigot

## Prerequisites

Install Spigot:  https://www.spigotmc.org/wiki/spigot-installation/
A

### Fast Install and Test Instructions

curl https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar --output BuildTools.jar
export MAVEN_OPTS="-Xmx2G"
java -Xmx2G -jar BuildTools.jar
echo "eula=true" > eula.txt
set "gamemode" in "server.properties" to "1" to set world to creative mode

git clone https://github.com/jaguth/spigotpluggin.helloworld.git
cd spigotpluggin.helloworld/
./gradlew build
cd ..
mkdir plugins
cp spigotpluggin.helloworld/build/libs/spigotpluggin.helloworld-1.0.jar plugins/spigotpluggin.helloworld-1.0.jar

java -Xms512M -Xmx1G -XX:+UseConcMarkSweepGC -jar spigot-1.13.2.jar


## Versions used for this example project

Spigot v1.13.2
Spigot API: 1.13.2-R0.1-SNAPSHOT
IntelliJ Community 2018.3
Gradle v4.10

## Download example plugin java project and compile jar

1) Run: git clone  https://github.com/jaguth/spigotpluggin.helloworld
2) Open in IntelliJ Community. Verify gradle has downloaded all dependencies and project builds
3) Run the gradle task "jar". the jar file will be built to build/libs

## Run in Spigot

1) Copy build/libs/blah.SNAP to your Spigot plugin directory
2) Start Spigot: java -Xms1G -Xmx1G -XX:+UseConcMarkSweepGC -jar spigot-1.13.2.jar
3) Watch for the text "[HelloWorld] Enabling HelloWorld v1.0" to appear in the console output

## Test the plugin

1) Open a client and connect to your Spigot server
2) Once the world loads, type "/echo hi there". The server will respond with your user name, the command name, and the supplied arguments.
