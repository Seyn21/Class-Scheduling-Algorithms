/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import java.util.Arrays;
import java.util.Comparator;

class Process {
    int ccode;     // course code
    int duration;  // class duration
    int priority;  // priority
    int arrival_time; // preferred arrival time

    public Process(int ccode, int duration, int priority, int arrival_time) {
        this.ccode = ccode;
        this.duration = duration;
        this.priority = priority;
        this.arrival_time = arrival_time;
    }
}

public class ClassScheduling {

    // FCFS Scheduling Algorithm
    public static void fcfs(Process[] proc) {
        int n = proc.length;
        int[] wait_time = new int[n];
        int[] turnaround_time = new int[n];
        
        // Waiting time for first process is 0
        wait_time[0] = 0;
        
        // Calculating waiting time for each process
        for (int i = 1; i < n; i++) {
            wait_time[i] = proc[i-1].duration + wait_time[i-1];
        }
        
        // Calculating turnaround time for each process
        for (int i = 0; i < n; i++) {
            turnaround_time[i] = proc[i].duration + wait_time[i];
        }
        
        printResults("FCFS", proc, wait_time, turnaround_time);
    }

    // Priority Scheduling Algorithm
    public static void priorityScheduling(Process[] proc) {
        int n = proc.length;
        int[] wait_time = new int[n];
        int[] turnaround_time = new int[n];
        
        // Sort processes based on priority
        Arrays.sort(proc, Comparator.comparingInt(p -> p.priority));
        
        // Waiting time for first process is 0
        wait_time[0] = 0;
        
        // Calculating waiting time for each process
        for (int i = 1; i < n; i++) {
            wait_time[i] = proc[i-1].duration + wait_time[i-1];
        }
        
        // Calculating turnaround time for each process
        for (int i = 0; i < n; i++) {
            turnaround_time[i] = proc[i].duration + wait_time[i];
        }
        
        printResults("Priority Scheduling", proc, wait_time, turnaround_time);
    }
    
    // Method to print results
    public static void printResults(String algorithmName, Process[] proc, int[] wait_time, int[] turnaround_time) {
        int n = proc.length;
        int total_waiting_time = 0;
        int total_turnaround_time = 0;
        
        System.out.println(algorithmName + " Order of Scheduling:");
        for (Process p : proc) {
            System.out.print(p.ccode + " ");
        }
        System.out.println();
        
        System.out.println("\nCourse Code\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            total_waiting_time += wait_time[i];
            total_turnaround_time += turnaround_time[i];
            System.out.println(proc[i].ccode + "\t\t" + wait_time[i] + "\t\t" + turnaround_time[i]);
        }
        
        System.out.println("\nAverage Waiting Time: " + (double) total_waiting_time / n);
        System.out.println("Average Turnaround Time: " + (double) total_turnaround_time / n);
        System.out.println();
    }

    public static void main(String[] args) {
        Process[] proc = {
            new Process(2201, 3, 2, 1), 
            new Process(3401, 2, 3, 2), 
            new Process(1103, 1, 1, 3)
        };

        // FCFS Scheduling
        fcfs(proc);

        // Priority Scheduling
        priorityScheduling(proc);
    }
}
