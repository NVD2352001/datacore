@ECHO OFF
cd platform/auth-service/target && start java -jar auth-service-0.0.1-SNAPSHOT.jar
cd ../../../
cd microservices/common-category/target && start java -jar common-category-0.0.1-SNAPSHOT.jar
cd ../../../
