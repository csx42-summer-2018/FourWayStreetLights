"# csx42-s18-assign-2-amit031190" 


Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf amit_kumar_assign_2.tar.gz amit_kumar_assign_2

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 06/28/2018]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

-----------------------------------------------------------------------
Assumptions taken:
1. No yellow light.
2. vehicles are only passing from intersection, code does not take care of any right or left turn.
3. There is default flow in-between lights when turning green if not interupted- North -> East -> South -> West -> North.
4. If input specify which direction to turn green. then that is turned green and and other is made red and the flow starts from that direction. 
5. By Deafult there is no vehicle on any side and All lights are red. vehicle are added by the input file.
6. Atmost one Light could be green at a time.
7. vehicle can be added in any direction in any state.

-----------------------------------------------------------------------
Input File format:
Easy to understand as in plain english commands like.

Add 2 vehicles on east. (this will add the 2 vehicles on east side, here 2 should be numeric valule)
Turn north green. (this change the current state to north green and try to pass vehicle if any)
Turn all red. (this will change the current state to StartStateImpl which means all lights are turned red and no vehicle can pass from any side)
The default State flow if not interupted by Turn command is North Green -> East green -> South green-> West greeen-> North green 

-----------------------------------------------------------------------
Error check for command line arguments:
1. "Please provide three args for input.txt, output.txt file and debugging level respectively"
2. "Input file doesnot exit in specified path".
3. "(.txt) formats are only supported for input file"
4. "(.txt) formats are only supported for output file"

