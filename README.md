# Class-Scheduling-Algorithms

This repository contains a Java implementation of class scheduling algorithms as part of my Operating Systems (OS) Class Assignment. The project compares the First-Come, First-Served (FCFS) scheduling algorithm with another scheduling algorithm of choice (e.g., Priority Scheduling) to find the best class scheduling solution. The implementation evaluates the algorithms based on key metrics like average waiting time and turnaround time. An analysis of the algorithms' performance is also included.

The Question:

Introduction

In many aspects, trying to schedule a class time is very similar to CPU scheduling. For example
1.	Each class has a duration class time, similar to a process having a process burst time.
2.	In some cases, high level courses has higher priority than others. Similarly, process with much more importance, has higher priority than others.
3.	For some classes, lecturers prefer to have morning classes instead of afternoon classes because they come to the office much earlier than other lecturers. Similarly, some algorithms in CPU scheduling has specific arrival time, thus processes that arrives first usually gets to run first.
However, there are significant difference between class scheduling and CPU scheduling. In CPU scheduling, an algorithm can be pre-emptive. Meaning a process can be stopped, and put on the waiting queue/ready queue until it gets scheduled again. In Class scheduling, it is non-preemptive. We cannot stop a class from running to allow another process to run.
Additionally, we do not assume new classes to be introduced during scheduling, meaning, the scheduling would be final with the input given, and no new courses are introduced after the scheduling have been made.

Assignment
Your job is to propose the best scheduling algorithm to implement in finding the best Class Scheduling solution. Your choices of algorithms are using Round-Robin, SJF, SRTF, or Priority Scheduling.
As a hint, you can't use some algorithms, because they are pre-emptive scheduling algorithms. Which ones are non-preemptive?
Input
Similar to a process, each class, will have the following members of integer values to consider, its course code, duration, preferred started time and priority. We consider each course can be in the duration of 1 hour, 2 hours, or 3 hours at a time. We can therefore represent a course/class as a structure like the code given as follows.

using namespace std;

struct Process
{
int ccode;     // course code
int duration;      // class duration
int priority;  //priority
int arrival_time;   //preferred arrival time
};

We can therefore, represent all the courses in an array and initialize them such as the code given below.
// courses CSC2201 with priority 2 for 3 hours with preferred to start first, 
// CSC3401 with priority 3 for 2 hours preferred to start second, 
// and CSC1103 with priority 1 for 1 hour 
Process proc[] = {{2201,3,2,1}, {3401, 2, 3,2}, {1103, 1,1,3}};

You can access each member in the process by using the dot operator in C++. An example is given below.
cout << proc[0].ccode;  //prints out the course code in the first element of the array

Your job is to write the code for two algorithms i.e. FCSF and another one (1) algorithm that you can consider using to schedule courses. Note that in FCFS, you can ignore the priority parameter, and preferred start time (arrival) because the algorithm only cares about what is in the queue (array).

Output
Your output has to display out
•	Output the order of scheduling for the courses, in FCFS, and another 1 algorithm that you propose.
•	average waiting time
•	average turnaround time
Analysis
Include in text file called analysis.txt, your analysis of the algorithm, the input that you have given and the output that your algorithm has produced. Give an explanation as to why this is better or worse than other algorithms you've have considered.
