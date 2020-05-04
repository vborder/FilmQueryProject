## Film Query Project - Week 7 Skill Distillery

### Overview

The Film Query Project is designed to:

- Allow a user to search a database and find a film either by (1) its film ID or (2) keyword search;
- Allow a user to view key information about a film, including title, description, release year, and language;
- Allow a user to view actors and actresses that starred in the selected film.

### Technologies Used
- Java
- Eclipse
- MySQL
- Maven
- MAMP
- GitHub

### Lessons Learned
- It is important that you test SELECT statements in MySQL to see their results before implementing them in your Java program. The results are easier to see in the table format MySQL provides, and in cases where multiple results are returned for one search, the MySQL tables can help you determine whether your Java program is printing the results correctly.
- It is also important for database retrieval that you ensure the arguments for the methods in your Java code match the columns of the MySQL tables EXACTLY.
- When printing out an ArrayList, the default implementation includes a beginning and ending bracket, with the elements in the ArrayList seperated by commas. To print out the list without these defaults, you can iterate over the list with a foreach loop and print each item.
- You can use a foreach loop to iterate through a list and add each item to a toString!

