# openrndr-examples

This repository contains runnable examples from the
[OPENRNDR guide](https://guide.openrndr.org).

The programs are generated from the documentation sources.
In case you run into issues please report them in the
[`openrndr-guide`](https://github.com/openrndr/openrndr-guide) repository

The Gradle build scripts for this project are based on
[`openrndr-template`](https://github.com/openrndr/openrndr-template), which is also
the best place to start from when you want to write your own OPENRNDR based programs.

## Usage 

Clone this repository and import in IntelliJ IDEA as a Gradle project. 
Individual programs can be run by opening their source files
and clicking on the green triangular icon next to the `main` function.

If you prefer to run the programs from the command line, you can type commands like these:

```
# Linux / Mac
./gradlew run -Popenrndr.application=examples.50_Animation.C100_InteractiveAnimations000Kt

# Windows
gradlew.bat run -Popenrndr.application=examples.40_Interaction.C140_UserInterfaces000Kt
```