## Star Wars Movie Explorer

A Java console application that connects to the Star Wars API (SWAPI) to allow users to browse and export movie information.

## Features

- Get a specific Star Wars film from SWAPI `/films/:id/`
- The user can type the id to choose a movie
- Displays movie details including title, director, episode ID, and release date
- Exports the selected movie’s data to a .json file

## Requirements

- JSON processing library with Gson. If vscode add the path where you have the gson-2.13.1.jar to Referenced Libraries.

## How to Run

- Clone this repository or download the source files
- Make sure required libraries are included in your project (e.g., gsonxxxx.jar)
- Compile and run the main class

```bash
javac -cp ".;lib/gson-2.13.1.jar" -d out src/Film.java src/FilmQuery.java
java -cp ".;lib/gson-2.13.1.jar;out" FilmQuery
```

## Example
Type the Film number you want to inquire
...

Selected: A New Hope  
Movie data saved to `a_new_hope.json`

## Resources
- SWAPI - The Star Wars API: https://swapi.py4e.com/api
- Jackson JSON library: `gson-2.13.1 jar`

