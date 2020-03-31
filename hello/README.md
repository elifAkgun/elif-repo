# Build
mvn clean package && docker build -t com.elif.javaee/hello .

# RUN

docker rm -f hello || true && docker run -d -p 8080:8080 -p 4848:4848 --name hello com.elif.javaee/hello 