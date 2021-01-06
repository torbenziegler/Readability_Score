# Readability 

Readability is a java application to analyze texts to find out the appropriate age of the reader to ensure there are no comprehension problems.
It determines how difficult the text is and for which age it is most suitable.

## Demo

Setting up text and running the program

![Demo](https://github.com/torbenziegler/Readability_Score/blob/master/assets/readability%20demo.gif)


## Background of formulas

The formulas for calculating the results are given below, where characters is the number of letters and numbers, words is the number of spaces, and sentences is the number of sentences.

### Automated readability index (ARI)

![ARI Formula](https://latex.codecogs.com/gif.latex?4.71(\frac{characters}{words})&space;&plus;&space;0.5&space;(\frac{words}{sentences})&space;-&space;21.43)

### Flesch–Kincaid readability tests (FK)

![FK Formula](https://latex.codecogs.com/gif.latex?0.39&space;(\frac{words}{sentences})&space;&plus;&space;11.8&space;(\frac{syllables}{words})&space;-&space;15.59)


### Simple Measure of Gobbledygook (SMOG)

![SMOG Formula](https://latex.codecogs.com/gif.latex?1.043&space;\sqrt{number&space;of&space;polysyllables&space;\times&space;\frac{30}{number&space;of&space;sentences}}&space;&plus;&space;3.1291)

### Coleman–Liau index (CL)

![CL Formula](https://latex.codecogs.com/gif.latex?0.0588&space;L&space;-&space;0.296&space;S&space;-&space;15.8)

> L is the average number of letters per 100 words and S is the average number of sentences per 100 words. 

> ![L Calculation](https://latex.codecogs.com/gif.latex?L&space;=&space;\frac{characters}{words}&space;\times&space;100)

> ![S Calculation](https://latex.codecogs.com/gif.latex?S&space;=&space;\frac{sentences}{words}&space;\times&space;100)

## Usage

1. Import the project to the IDE of your choice.
2. Add your text to the input.txt, it's used to run the application.
3. Run the application and follow the terminal instructions.

> [See the documentation](https://github.com/torbenziegler/Readability_Score/tree/master/src/main/resources/JavaDoc)

> GitHub language distribution doesn't represent the project. The project is written in Java, only the documentation is HTML. 

> The project is based off the [JetBrains Academy](https://hyperskill.org/projects/39). The project idea was given. All code was written and implemented by myself.
