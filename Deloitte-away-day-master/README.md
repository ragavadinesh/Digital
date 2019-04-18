# Deloitte Away Day

Deloitte Away Day is a maven project to generate a day program to accommodate a list of activities.

### Author
Carlos Lopez (carlos3lb@hotmail.com)

### Tech

Deloitte Away Day uses the following technologies:

* [Java] - Code base language (version 1.8)
* [Apache Maven] - Build automation tool (version 3.3.9)
* [junit] - Library for testing (version 4.12)
* [codehaus mojo] - Execute Java app plugin (version 1.6.0)

### Installation

Deloitte Away Day generates a day program based in an input file stored in the directory `src\main\resources\input.txt`.

These are the allowed formats for tasks:

| Format | example |
| ------ | ------ |
| [task_name] [time_in_minutes]min | Docker master class 60min |
| [task_name] sprint | Docker master class sprint |

Sprint is used for 15 minutes tasks. Find bellow an input example:

>Duck Herding 60min
>Archery 45min
>Learning Magic Tricks 40min
>Laser Clay Shooting 60min
>Human Table Football 30min
>Buggy Driving 30min
>Salsa & Pickles sprint
>2-wheeled Segways 45min
>Viking Axe Throwing 60min
>Giant Puzzle Dinosaurs 30min
>Giant Digital Graffiti 60min
>Cricket 2020 60min
>Wine Tasting sprint
>Arduino Bonanza 30min
>Digital Tresure Hunt 60min
>Enigma Challenge 45min
>Short speach 5min
>Monti Carlo or Bust 60min
>New Zealand Haka 30min
>Time Tracker sprint
>Indiano Drizzle 45min

### Execution

Deloitte Away Day requires [Maven](https://maven.apache.org/) v3+ and [Java](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) v1.8+ to run.

Open a terminal and execute these commands to compile and execute:

```sh
$ mvn clean package
$ mvn exec:java
```

Output will be shown in the terminal. Find bellow an output example:

>Deloitte Away Day:
>Team 1:
>09:00 am : Duck Herding 60min
>10:00 am : Laser Clay Shooting 60min
>11:00 am : Viking Axe Throwing 60min
>13:00 pm : Monti Carlo or Bust 60min
>14:00 pm : Archery 45min
>14:45 pm : 2-wheeled Segways 45min
>15:30 pm : Enigma Challenge 45min
>16:15 pm : Indiano Drizzle 45min
>
>Team 2:
>09:00 am : Giant Digital Graffiti 60min
>10:00 am : Cricket 2020 60min
>11:00 am : Digital Tresure Hunt 60min
>13:00 pm : Learning Magic Tricks 40min
>13:40 pm : Human Table Football 30min
>14:10 pm : Buggy Driving 30min
>14:40 pm : Giant Puzzle Dinosaurs 30min
>15:10 pm : Arduino Bonanza 30min
>15:40 pm : New Zealand Haka 30min
>16:10 pm : Salsa & Pickles sprint
>16:25 pm : Wine Tasting sprint
>16:40 pm : Time Tracker sprint
>16:55 pm : Short speach 5min

### Design

These are the main classes used in this project:

| *uk.deloitte.digital.model* |
| ------------ | 
| Task: *Class to store a task data (name, duration). Start time is calculated using a LocalTime.*  |
| ActivityBlock: *Class to store a list of task and a maximun size. Methods to calculate the available and used size and to add a task (returning true if the task fits correctly) are included.*  |
| ExtraTimeBlock: *ActivityBlock extended class including an extratime. Available size method overwriten to manage extra time.*  |
| DayProgram: *Class to store a morning ActivityBlock and an evening ExtraTimeBlock. Morning and evening start and finish date can be configured (configuration is validated). Methods to include tasks into both blocks are included.*  |
| AwayDay: *Class to strore a list of DayProgram. Morning and evening start and finish time, extra time for evening and number of teams can be configured (configuration is validated). Also a method to add a list of tasks is included.*  |

| *uk.deloitte.digital.file* |
| ------------ | 
| FileUtil: *Class with a method for reading a list of tasks from a file (specific format).*  |

| *uk.deloitte.digital.exception* |
| ------------ | 
| AwayDayException: *Returned exception when a functional or execution error occurs*  |
