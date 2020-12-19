# Build
mvn clean package && docker build -t com.elif.javaee/event .

# RUN

docker rm -f event || true && docker run -d -p 8080:8080 -p 4848:4848 --name event com.elif.javaee/event 