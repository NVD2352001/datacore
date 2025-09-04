### Tool + App
+ VSCODE
+ WINDOW 10
+ CMDER (https://cmder.app/)

### Dev full project
```bash
mvnw clean install
run-config.bat
run-gateway.bat
run.bat
```

### Dev only microservices service
```bash
set CONFIG_PROFILE=dev
# PowerShell $env:CONFIG_PROFILE = 'dev'
mvnw -pl microservices\common-category\ -amd spring-boot:run
```

### Deploy
```bash
mvnw clean install
docker compose up -d
```


### Ref from:
+ https://github.com/aenesgur/springboot-microservice-boilerplate
+ https://github.com/rajithd/spring-cloud-security-jwt

### Curl
```bash
curl --location 'http://localhost:8080/auth/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "a@a.com",
    "password": "password",
    "name": "name"
}'

curl --location 'http://localhost:8080/api/products' \
--header 'Authorization: Bearer {{TOKEN}}'

curl --location 'http://localhost:8080/auth/infor' \
--header 'Authorization: Bearer {{TOKEN}}'

```# datacore
