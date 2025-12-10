Digital Recipe Book
Project Title:

Digital Recipe Book

Authors:

Gianluca Zambito
Jeet Jadav

Project Description:

This project is a simple digital recipe book written in Java.
It lets the user view recipes, add new ones, scale servings, and manage ingredients and instructions.
The goal is to imitate what a real paper recipe book does, but in a small console program.


Features:

View All Recipes
When the program starts, it prints a welcome message and shows all recipes in the book.

Choose and View a Recipe
Users can pick a recipe by name and author using the command:

choose recipe

The program then prints:

ingredients

instructions

total time

servings

Add a New Recipe
From the main recipe book (not inside a recipe), the user can add a new recipe using:

add recipe

The program asks for the name, number of servings, and total time.

Add Ingredients
Inside a recipe, the user can add an ingredient using:

add ingredient

The program asks for the ingredient name, amount, and unit.

Add Instructions
Inside a recipe, the user can add a step using:

add instruction

Remove Ingredients or Instructions
Inside a recipe, the user can remove items using:

remove ingredient
remove instruction

Remove a Recipe
From the recipe book, the user can remove a recipe using:

remove recipe

Scale a Recipe
Inside a recipe, the user can temporarily scale the servings using:

scale recipe

The recipe resets to its original values after printing the scaled version.

Set Owner Name
The user can change the recipe book owner using:

set owner

Help and Quit Commands
help
quit

How to Run the Project:

Running in BlueJ

Open the project in BlueJ.

Create an object of RecipeBook.

Create an object of RecipeBookMenu and pass the RecipeBook object to it.

Call the open() method on the menu object.

Running Outside BlueJ

Open a terminal in the project folder.

Compile all files using:

javac *.java

Run the program using:

java RecipeBookMenu

Valid Commands:

The program accepts the following commands:

return
choose
help
quit
scale
add
remove
set

Project Structure:

RecipeBookMenu.java - main program menu
RecipeBook.java - stores list of recipes
Recipe.java - each recipe’s data
Ingredients.java - one ingredient
Unit.java - enum for ingredient units
CommandWords.java - valid command list
Parser.java, Command.java - input handling
Appetizer.java, Entree.java, Dessert.java - recipe types

License:

MIT License