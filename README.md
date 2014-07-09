Silverbullet
============

1. Description

The following program parses two files, an XML file and a CSV file, containing
 a description of persons and teams, respectively, and outputs a description of
 the team who has the combined oldest age across its members.

2. Installation and execution

Simply navigate to the `src` folder and run
`$ groovy Program.groovy /path/to/Persons.xml /path/to/Groups.txt`

3. Design choices

While the coding example is rather small I deliberately chose a very structured
approach where:

- There is a parser class for each data file that needs parsing. (alternatively
  each of the classes could have been reduced to just a function as no state is
  saved).
- There is a model class for each type of data objects collected from the parsed
  files.
- There are unit tests for every class of the project.
- There are integration tests to test the flow of the application.
