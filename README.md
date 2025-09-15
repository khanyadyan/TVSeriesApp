# Assignment - TVSeriesApp and GameApp

This project contains two parts required by the assignment:

1. **TVSeriesApp** (Section A + Section B tests)
   - Console application to capture, search, update, delete TV series.
   - `SeriesModel` uses public fields (school style).
   - `Series` class contains methods: `CaptureSeries`, `SearchSeries`, `UpdateSeries`, `DeleteSeries`, `SeriesReport`, `PopulateModel`.
   - JUnit tests in `src/test/java/tvseries/SeriesTest.java` (JUnit 5 style, assertions as taught).

2. **GameApp** (Section B Question 1)
   - Simple Quiz Game demonstrating arrays, inheritance (`Person` -> `Player`), constructors, and information hiding.
   - `QuizGame` uses arrays for questions/options and a `Player[]` array to store players.
   - JUnit test in `src/test/java/game/QuizGameTest.java`.

## How to run (IntelliJ recommended)

- Import the project as a plain Java project in IntelliJ.
- Mark `src/test/java` directories as **Test Sources Root** if needed.
- To run the console apps:
  - Run `tvseries.Main` for the TV Series app.
  - Run `game.GameMain` for the Quiz game.
- To run tests:
  - Ensure JUnit 5 is on the classpath (IntelliJ usually adds it when running tests).
  - Run the test classes `tvseries.SeriesTest` and `game.QuizGameTest`.

## Notes
- Code is written in the style requested (PopulateModel, public fields in model, tests formatted like the example).
- No setters used; updates replace the object in the collection.