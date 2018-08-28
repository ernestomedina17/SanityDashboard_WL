#!/bin/sh

id
pwd
cd ~/sanity
if [ -e nohup.out ] ; then rm -v nohup.out ; fi
/opt/app/athadm/java/jdk/jdk180-64bit/jre/bin/java -version
nohup /opt/app/athadm/java/jdk/jdk180-64bit/jre/bin/java -jar SanityDashBoard_WL-1.0.0-RELEASE.war &