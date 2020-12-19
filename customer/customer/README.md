# Build
mvn clean package && docker build -t com.elif/customer .

# RUN

docker rm -f customer || true && docker run -d -p 8080:8080 -p 4848:4848 --name customer com.elif/customer 