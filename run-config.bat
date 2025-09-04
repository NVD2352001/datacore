@ECHO OFF
set PJDIR=///%cd%
set CONFIG_SERVER=http://localhost:10002
set CONFIG_PROFILE=dev
cd platform/config-service/target && start java -jar config-service-0.0.1-SNAPSHOT.jar
cd ../../../
