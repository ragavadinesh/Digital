This README file explains how to use the program which is an event organisation App.
This is Version 1.0 of the program

Purpose
-----------

This is a Java event organisation application.
Organisers have provided you with the following useful information:
1. Activities start from 9am until lunch is served at 12 noon
Provided Input
Here is the provided text file that includes list of activities carefully selected by the organisers.
2. Everyone will be divided into various teams and each team will be performing various activities
3. Activities resume from 1pm and must finish in time for a presentation.
4. The presentation can start no earlier than 4:00 and no later than 5:00
5. All activity lengths are either in minutes (not hours) or sprint (15 minutes)
6. Due to high spirit of the team there needs to be no gap between each activity

Installation - RUN IN AN IDE
-----------

Extract the zipped file "Deloitte away day.zip" into your desired location.
Go to your selected IDE, such as Eclipse or IntelliJ, and import the project (extracted zipped file) into your IDE
Run the main class "DeloitteAwayDay.main()" found in path src/main/java/com.uche.deloitte.code

Design
-----------
Two folders were created in src/main
The resource folder contains the text file which is uploaded into the main program
The main package is found in com.uche.deloitte.code and this contains four main parts: Exception handling, the model, the scheduler and the util
The exception handling will handle parse exceptions and other string errors within the program
The Model has an Activity class will splits the file into activities and their respective times, also ensuring sprint is 15mins. 
The Team class calculates the timings and splits them into AM and PM
The scheduler contains an ActivityScheduler class which ensures the the right activities are chosen before lunch and after lunch to ensure correct timings
The util file contains the ActivityFileParser which parses the file, ActivityMapper which splits the file into activity and time, 
DurationCoverter which keeps all timings as minutes, and the ActivityConsolePrinter which prints the output the way we want it.

When the main class (DeloitteAwayDay) runs, starts its timer at 9am, it creates 2 teams, it goes into the file location picks the activities, 
schedules the times from the scheduler,, distributes the activities and times into each team and prints the result.

Assumptions
-----------

Activities cannot be repeated
No two teams can have the same activities at the same time.
Lunch is served at 12 but the teams may begin heading for lunch few minutes before 12

Output
-----------

If program runs successfully, which it should, output should be as below:

Activities for Team 1
09:00 AM Duck Herding 60 mins
10:00 AM Human Table Football 30 mins
10:30 AM Learning Magic Tricks 40 mins
11:10 AM Archery 45 mins
11:55 AM Lunch 60 mins
12:55 PM Arduino Bonanza 30 mins
01:25 PM Cricket 2020 60 mins
02:25 PM Time Tracker sprint
02:40 PM Wine Tasting sprint
02:55 PM Viking Axe Throwing 60 mins
03:55 PM Giant Digital Graffiti 60 mins
04:55 PM Staff Motivation Presentation 60 mins

Activities for Team 2
09:00 AM Salsa & Pickles sprint
09:15 AM Buggy Driving 30 mins
09:45 AM 2-wheeled Segways 45 mins
10:30 AM Laser Clay Shooting 60 mins
11:30 AM Giant Puzzle Dinosaurs 30 mins
12:00 PM Lunch 60 mins
01:00 PM New Zealand Haka 30 mins
01:30 PM Enigma Challenge 45 mins
02:15 PM Monti Carlo or Bust 60 mins
03:15 PM Digital Tresure Hunt 60 mins
04:15 PM Indiano Drizzle 45 mins
05:00 PM Staff Motivation Presentation 60 mins

Development.
-------------

This solution designed and developed by Uche Ojukwu. 


