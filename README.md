Groovy example
============

1. Description

The following program parses two files, an XML file and a CSV file, containing a
description of persons and teams, respectively, and outputs a description of
the team who has the combined oldest age across its members.

2. Installation and execution

Simply navigate to the `src/main/groovy/` folder and run,
`$ groovy Program.groovy /path/to/Persons.xml /path/to/Groups.txt`
e.g.,
`$ groovy Program.groovy ../../../test-data/Persons.xml ../../../test-data/Groups.txt`

3. Design choices

While the coding example is rather small I deliberately chose a very structured
approach to reflect the way I would deal with a 'real world' problem:

- There is a parser class for each data file that needs parsing. Alternatively,
  each of the classes could have been reduced to just a function as no state is
  saved when parsing.
- There is a model class for each type of data objects collected from the parsed
  files.
- There are unit tests for every class of the project. Some of these are a bit
  contrived due to the size of the classes.
- There are integration/system tests to test the flow of the application.
- I use gradle to build the project and manage its dependencies as it is also
  written in groovy and works great for both Java/Groovy and Android development.
