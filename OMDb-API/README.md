# OMDb Movie Finder Console App

This Java console application allows users to search for one or more movies using the [OMDb API](http://www.omdbapi.com/), retrieves detailed information, and saves the results in a structured JSON file. It's a perfect learning project for working with APIs, JSON parsing (via Gson), and file handling in Java.

---

## Features

- Search for one or multiple movies by name via console input
- Retrieves movie data using the OMDb API
- Maps JSON responses to a record (`TitleOMdb`) and converts to a domain model (`Title`)
- Writes all movie details to a local JSON file (e.g., `movies.json`)
- Keeps results in a reusable Java list

---

## Requirements

- Java 17+ (records require Java 16 or later)
- Gson library ([Download](https://mvnrepository.com/artifact/com.google.code.gson/gson))
- An [OMDb API key](http://www.omdbapi.com/apikey.aspx)

---

## How to Run

### Compile the Program

```bash
javac -cp ".;lib/gson-2.13.1.jar" -d out src/*.java

java -cp ".;lib/gson-2.13.1.jar;out" Main

## Example Interaction

Enter movie name (or 'exit' to finish): The Matrix
Enter movie name (or 'exit' to finish): Inception
Enter movie name (or 'exit' to finish): Interstellar
Enter movie name (or 'exit' to finish): exit
📄 All movie details saved to movies.json!

```json

## Contents of movies.json (example):

[
  {
    "Name": "Matrix",
    "ReleaseDate": 1993,
    "IncludedInPlan": false,
    "SumOfRatings": 0.0,
    "EvaluationCount": 0,
    "RunTime": 60
  },
  {
    "Name": "El Encanto",
    "ReleaseDate": 2020,
    "IncludedInPlan": false,
    "SumOfRatings": 0.0,
    "EvaluationCount": 0,
    "RunTime": 73
  }
  ...
]
```