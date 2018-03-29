# Getting started

1. Clone project from git:
```
git clone https://gitlab.com/imzukov/getext.git
```

2. Then open as Maven Project from IntellijIdea:
    * Open getext
    * Open pom.xml
    * Open As Project
    * Open Existing Project
    <br/>
    <br/>
    ![Open_Maven_Project](/Docs_readme/Open_Maven_Project.gif)
    <br/>

3. Change working direcory in configuration to GET-R1 path

    <br/>
    ![Open_Configuration](/Docs_readme/Open_Configuration.gif)

    <br/>
    ![Change_Dir](/Docs_readme/change_path_to_get.png)
    <br/>

4. At some maven modules you can see missing dependencies.

    <br/>
    ![Missing_libs](/Docs_readme/missing_lib.png)
    <br/>
    * **Warning!** If something went wrong see next paragraph.
    <br/>
    <br/>
    * Check them in your Maven repository (~/.m2/repository/...) where ~ path 
    to your User.<br/> Example: C:/Users/{Your_User_Name}/.m2/repository
    <br/>
    <br/>
    * Library jar must be at groupId folder, then artifactId folder, then version
    folder. <br/>Example:<br/> 
    java_cup:java_cup:1.1b **will be at** m2_path/java_cup/java_cup/1.1b/<br/>
    ru.mephi:graphics:2.0 **will be at** m2_path/ru/mephi/graphics/2.0/
    <br/>
    <br/>
    * Move missing lib in mvn_repo from ```getext/libraries``` with creation of path.
        * Or download them from internet [MVN_Repo](http://mvnrepository.com)
        * Or try to find ```.bat``` file usually it install needed library
        * Check all folders maybe them consist lib folders too!<br/><br/>
Example for missing lib: org.freehep:freehep:freehep-util:2.1.2
        * find ```freehep-util-2.1.2.jar``` at ```/libraries```
        * go to ~/.m2/repository
        * create directory org
        * create directoty freehep
        * create directory freehep-util
        * create directory 2.1.2
        * move freehep-util-2.1.2.jar to last created folder
5. **Tip**: If ALL not working, try reload IntellijIdea :smiley: or check [Fix_Errors](#fix-errors) section.
    <br/>
6. Some libs must be build yourself:
    <br/>
    * Open Maven Projects at upper-right corner in IntellijIdea.
    * Choose project -> Lifesycle -> Install
    * What projects to build first of all:
        * commons

# Fix Errors

### If you have any error write it here.

#### Error: Module can't resolve library, but I move it to mvnrepository completely.
Sometimes project can't be builded because haven't ```pom.xml``` at lib path. 
Add ```$lib_name_pom$.xml``` to lib folder.
Example of ```freehep-util-2.1.2.pom```:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
    xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>
    <modelVersion>2.1.2</modelVersion>
    <groupId>org.freehep</groupId>
    <artifactId>freehep-util</artifactId>
    <version>2.1.2</version>
    <description>POM was created from install:install-file</description>
</project>
```
