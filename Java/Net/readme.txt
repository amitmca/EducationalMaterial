                             Java PortListener 0.11
                             ----------------------
                     By Matteo Baccan (baccan@infomedia.it)
                     --------------------------------------

Java port Listener is a command line port listener written in Java 1.3.
I think that this program may also works with all JDK version, you must only
recompile it.

I have written this program to allow programmer to have one port listener to
use in all operating system that use, and not one port listener for every
system.

Use this program in Linux, Windows, AIX, AS/400 or all environment you want.

How To use:
-----------
Usage: java portListener [<ip>]

<ip>

Is possible to specifie an ip where lock the port
ex.
java portListener 194.168.0.1
java portListener localhost

Update:
-------

You may find the new version of Java PortScanner at:

http://www.infomedia.it/artic/Baccan

Please e-mail any comments, suggestions, or ideas to Matteo Baccan at:

baccan@infomedia.it

History
-------
0.10
First release

0.11
Decrease the number of concurrent client for each port from 50 to 5
