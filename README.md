# DSA521S Group Mini-Project 2026

## Project Title
NUST Service Centre Simulation: Designing and Evaluating Data Structures and Algorithms

## members 
- Johannes Silas 226043908
- Nuunyango Lovemore 226073831
- Shikongo Martin 226098133

## proof
- GtHub repository link > https://github.com/226043908-johannes/DSA_Project
## Files
- Student.java
- ServiceQueue.java
- StudentList.java
- PostfixStack.java
- ArrayStatistics.java
- SelectionSort.java
- InsertionSort.java
- MergeSort.java
- QuickSort.java
- SortingExperiment.java
- Main.java

## How to run in Visual Studio Code
1. Install Java JDK.
2. Open this DSA_Project folder in Visual Studio Code.
3. Open Main.java.
4. Click Run.
5. Use the menu.


## GitHub
https://github.com/226043908-johannes/DSA_Project

## Description of the files added in this update

### Main.java
The entry point of the program. It shows the Campus Service Centre menu (options 1 to 11) and calls the other classes:
1. Add a student to the waiting queue (ServiceQueue).
2. Serve the next student. The student is removed from the queue, saved in the student list, and their service time is stored in the `serviceTimes` array.
3. Display the waiting students.
4. Add a student service record directly.
5. Display all student service records.
6. Search for a student record by student number.
7. Remove a student record.
8. Display daily statistics (ArrayStatistics).
9. Sort the service times with Selection, Insertion, Merge or Quick Sort. The sort runs on a copy, so the original data is not changed.
10. Run the sorting experiment (SortingExperiment).
11. Exit.

### ArrayStatistics.java
Takes the array of service times and the number of records, then prints the total students served, total service time, average, highest, lowest, and how many services took longer than 10 minutes. If there are no records it prints a message instead.

### InsertionSort.java
Insertion Sort on an int array. It counts comparisons and shifts, and prints the array after the first three passes so the sorting steps can be seen.

### MergeSort.java
Merge Sort on an int array. It splits the array in halves recursively (using a temporary array) and merges the sorted halves back together. It counts comparisons for the algorithm analysis.

## How the files were pushed from VS Code to GitHub (step by step)
1. Open the DSA_Project folder in VS Code (File > Open Folder).
2. Put the Java files (Main.java, ArrayStatistics.java, InsertionSort.java, MergeSort.java) inside the folder.
3. Click the Source Control icon on the left (or press Ctrl+Shift+G). The new files appear under Changes with a U (untracked) mark.
4. Stage the files by clicking the + next to each file, or the + next to Changes to stage all of them. They move to Staged Changes.
5. Type a commit message in the message box, for example: `Add Main menu, ArrayStatistics, InsertionSort and MergeSort`.
6. Click Commit.
7. Click Sync Changes (or Push) to send the commit to the `main` branch on GitHub.
8. Open the repository page on GitHub and refresh to check that the files and the commit are there.

The same steps in the VS Code terminal:
```
git add .
git commit -m "Add Main menu, ArrayStatistics, InsertionSort and MergeSort"
git push origin main
```
