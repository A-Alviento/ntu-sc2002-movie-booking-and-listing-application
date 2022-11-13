![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)

# SC2002 Movie Booking and Listing Management Application

A Console-based application to computerize the process of making online booking and purchase of movie tickets, listing of movies and sale reporting.

## Project structure explanation.
`data` stores application data. `doc` contains the generated javadoc. `src` contains the source code for our file.

## Running
### Using IDE (works with Eclipse)
Run `Main.java` for the pogram, `FillDatabaseMain.java` to fill the app database (note that the database has already been filled.). 

### Alternative (make)
Enter the `src` directory and run `make`. Tested with `GNUMake` but other versions should work too.

### FileNotFound 
If a **file not found error** is received, change `MODELDATABASEPATH` in `Main.java` according to the path that you are in.
