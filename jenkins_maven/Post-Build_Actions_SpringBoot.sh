#!/bin/bash

pwd;
ls -lh ./SanityDashBoard_WL/target/ ;
echo "Create SWM Package with Revision=$SVN_REVISION";
cp -pv ./SanityDashBoard_WL/target/SanityDashBoard_WL-1.0.0-RELEASE.war ./SanityDashBoard_WL/swm_template/Linux/dist_files/sanity/;
ls -l ./SanityDashBoard_WL/swm_template/Linux/dist_files/sanity/;
id ; 
chmod -Rv 775 ./SanityDashBoard_WL/swm_template/Linux/dist_files/sanity;
/opt/app/swm/aftswmcli/bin/swmcli component pkgcreate -d ./SanityDashBoard_WL/swm_template -c com.att.athena.infra:SanityDashBoard_WL:$SVN_REVISION
