# End To End developer workstation setup

## Expectations

* You are familiar with IntelliJ
* You are familiar with Java
* You are familiar with Spigot

## Prerequisites

Install Spigot:  https://www.spigotmc.org/wiki/spigot-installation/

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
