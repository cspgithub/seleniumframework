
FROM adoptopenjdk/maven-openjdk11
WORKDIR /app
ADD . /app
CMD  mvn -f demo/pom.xml clean test





