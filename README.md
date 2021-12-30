# What it is
Parenthesis\
Exponents\
Multiplication\
Division\
Addition\
Subtraction<br>
This is a basic order of operations calculator where one inputs a String and it goes through order of operations and this solves it\
Eventually will branch into a legit scientific calculator and eventually a graphing one (like a TI-84 plus)\
If anyone has any changes/advice feel free to because there is probably an easier way to write this

# Usage
This is just the class and it contains two constructors and 3 other visible methods (the 4th is private and used just for readability of code)\
\
Constructors:
- new PEMDAS()
  - default constructor
- new PEMDAS(String equation)
  - used to set the equation

Methods:
- void setEquation(String equation)
  - used to set the equation if you haven't already, or to set a new equation
- String solveEquation(String equation)
  - returns the answer as a String but the String is in the form of a Double
  - you input a String and it does PEMDAS on that, not on the previously saved equation (if there is one)
- String solveEquation()
  - returns the answer as a String but the String is in the form of a Double
  - performs PEMDAS on the previously saved equation
  - will return null if there is not saved equation  


