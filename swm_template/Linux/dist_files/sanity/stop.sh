#!/bin/sh

id
pwd
PID=`ps -fe | grep  OMXSanityDashBoard | grep -v grep | awk '{ print $2 }'`
echo "Killing PID: $PID"
kill -9 $PID || kill -s 9 $PID