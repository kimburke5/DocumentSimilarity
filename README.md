# Document_Similarity
Kimberly Burke

G00269948

Contains a description of the application

A Java API for Measuring Document Similarity Efficient Detection of Duplication using Jaquard Similarity algorithm. 
Input files are read into Shingles and kMers and pre-processed before being compared with Jaccard Similarity algorithm.

Included with this project:
- A UML diagram of API design. Shows the relationships between the key classes in the project
- A directory containing the JavaDocs for your application. 
- You can generate JavaDocs using Ant or with the following command from inside the “src” folder 
of the Eclipse project: javadoc -d [path  to javadoc destination directory] ie.gmit.sw

# File Structure
- Runner.java which contains the main() method. It calls the UI class.
- UI.java is the user menu. It calls the Launcher class.
- Launcher.java starts the Threads, calls documentParser class and performs the jaccard calculation.
- documentParser.java Implements Runnable. Parses the text files.
- Consumer.java also Implements Runnable. It creates the mini hashes.
- Shingle.java provides the Shingle Getters, setters and constructors.
- Poisin.java extends Shingles

When this application is executed the menu will prompt user to enter two
txt files. The two files are then compared for similarity. The user
is then presented with the percentage of similarity between these two files.

