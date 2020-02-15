# dius_bowling_project
Completed this project based on the problem statement from the below link - 
https://github.com/DiUS/coding-tests/blob/master/dius_bowling.md
This program can calculate a bowling game score for a player


# Problem statement
One player can play the game.
In one match, there would be 10 Frames
In one Frame, there would be 10 pins and player would get 2 chances to knock down the pins

So have to calculate the score for the game.

# Rules
There are few rules stated to calculate the score - 

* All pins down with 2 tries - spare - scoring would be the sum of the number of pins knocked down plus the number of pins knocked down in the next bowl.
E.g, if a bowler rolls, 4,6 | 5, 0
Their score is 20. So that's (4 + 6 + 5) + (5 + 0)

* All the pins are down with 1 try - strike - scoring would be the number of pins knocked down plus the number of pins knocked down in the next two bowls.
E.g, if a bowler rolls, 10 | 5, 4
Their score is 28. So that's (10 + 5 + 4) + ( 5 + 4)

* Spares at last bowl of the 10th frame - bowler gets another bowl. The score of this frame is the sum of the three bowls.

* Strikes at last bowl of 10th frame - bowler gets another 2 bowls. The score of this frame is the sum of the three bowls.

* All the Strikes - score would be 300.

# Data structure and design
I have separated all the domains, interface and util in by thinking of scalability. Following are the path and basic descriptions of the functionalities of those classes.

Domains -> ~/src/main/java/com/bowling/domain/* - All the object models 
Interface -> ~/src/main/java/com/bowling/api/ - Interface to roll data and get the score

Util Class -> ~/src/main/java/com/bowling/utils/ - Main score calculator based on the provided rules. As it's in different class, it's easier to maintain and use.

Implementation -> ~/src/main/java/com/bowling/BowlingGameImpl - This class is the implementation the above mentioned interface to store the 'noOfKnockedPins'and return the 'score' anytime for the current game.

Test Cases -> ~/src/test/java/BowlingGameTest.java - I have also written some unit test cases to do some basic testing of the methods

[No main class has been added at this moment]

# Implementation
I have used Java 8 to implement the solution

# Limitations
* No validation for input so it has been assumed that given input would be always right
* There are scope of imrovement near setting up the data for the games


