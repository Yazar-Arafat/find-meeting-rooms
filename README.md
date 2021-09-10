# Find how many meeting rooms are required

Input: a local file, containing several lines and each line is the start time/end time of a meeting (24-hour
format). A meeting will NOT end after midnight, ie, the End time will not be later than 23:59)

filename as the 1st parameter command-line argument and output the number of meeting rooms required.

### How to run
 - mvn clean install
 - java -jar target\meetingrooms-0.0.1-SNAPSHOT.jar input.txt
  sample reponse : Output 2 
