JavaForce SDK
=============

Version 17.2.0

What is it?
===========
JavaForce is a Java library extending the capabilities of Java.

The main library includes a VoIP stack and bindings for FFMPEG, OpenGL and Camera.

Includes many apps built around the library such as jfPhone, jfVideo Creator, jfAudio, jfMusic, etc.

JF is also the core library in the Java infused Linux Operating system : http://jfLinux.sourceforge.net

JF is also used to create jfCraft, a Minecraft clone : http://pquiring.github.io/jfcraft

Projects
========
jfPhone - Java VoIP soft phone

jfVideo Creator - video production

jfPaint - multi-tabbed image editor

jfPBX - Java VoIP PBX

jfBroadcast - VoIP Auto Dialer System

jfTerm - Telnet client application that includes scripting support

jfEdit - multi-tabbed text editor.

jfHex - multi-tabbed hex editor.

and many more...

Folders
=======
 /          - main folder (run ant here to build /src)
 /src       - the javaforce source files
 /jars      - 3rd party files
 /stubs     - native launcher stubs
 /native    - native JNI bindings for FFMPEG, OpenGL, Camera
 /classes   - javaforce compiled files
 /projects  - source for all sub-projects

Building
========
All projects are built with Apache Ant (http://ant.apache.org).
Make sure to run ant in the main folder to build the /src folder and then in any of the apps in /projects.
If building on Windows make sure to copy /native/*.dll to /windows/system32 since some of the
build tools require them.

Common Ant tasks:
-----------------
compile : compile projects java files
jar : build the projects main jar file
depjars : copy dependant jar files into project folder
install : install files into proper folders (Linux only)
 - for the main JavaForce library you MUST specify -Dbits=32|64
 - requires root access
 - example : "sudo ant install -Dbits=32"
deb : build Ubuntu deb file (after install)
rpm : build Fedora rpm file (after install)
msi : build Windows msi file with JRE bundled (64bit)
msinojre : build Windows msi file without JRE bundled (64bit)
dmg : build Mac dmg file using hdiutil (mac only)
genisodmg : build Mac dmg file using geniso (cygwin/linux/mac) (uncompressed)
  - dmg generation requires 
    - /projects/jfdmg installed (sudo ant install)
    - Info.plist, ${app}.icns and macfiles.lst
    - see projects/jfedit for only example
    - jimgconvert can convert to .icns file format
javadoc : create javadoc api help files (open ./javadoc/index.html)

License
=======
JavaForce itself is licensed under the LGPL license which can be read in license.txt.
The MSI installers show the Common Public License 1.0 which is acceptable as well.
The other jars in /jars each have their own licensing.
  filters.jar - Apache License 2.0 (http://www.jhlabs.com)
  bouncycastle.jar - MIT license? (http://www.bouncycastle.org)
  derby.jar - Apache License 2.0 (http://db.apache.com/derby)
  jcifs.jar - LGPL (http://jcifs.samba.org)
  jsp-api.jar & servlet-api.jar - Apache License 2.0 (http://tomcat.apache.com)
  jsch.jar & jzlib.jar - BSD license (http://www.jcraft.com)

Enjoy!

Peter Quiring
pquiring@gmail.com

Web : pquiring.github.io/javaforce

Git : github.com/pquiring/javaforce

Released : Sept 26, 2018
