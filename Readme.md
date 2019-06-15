# Computer Vision Project (IM520 |  MC50)

This project adds Gradle support to the skeleton project for the Computer Vision Course offered at the University of Applied Sciences Upper Austria.

## Why?

A lot of students, including me, struggled in the beginning to get the project working properly with other IDEs than Eclipse.  
With the support of Gradle most modern IDEs with Gradle support can easily be used.

## Project Structure

```
| src/                              # Main source set.
  --- | **/*.java                   # Main Java source files for custom plugins .
| ImageJ/
  --- | ij.jar                      # Runable JAR file of ImageJ.
      | plugins/                    # Output directory.
        --- | **/*.class            # Compiled plugin classes. These will be loaded automatically, once IJ is restarted.
      | jar/                        # Folder for external libraries.
```

## Working with Gradle

To run the program and have all custom plugins loaded the plugins need to be compiled first.
Then ImageJ can be started.

### Compilation of plugins

During the compilation the plugins will also be copied to the proper path in `ImageJ/plugins`.

```
./gradlew assemble
```

### Start 

This command starts ImageJ which will automatically reload all plugins.

```
./gradlew run
```