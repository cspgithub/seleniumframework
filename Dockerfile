FROM adoptopenjdk/maven-openjdk13
WORKDIR /app
ADD . /app
CMD  mvn -f demo/pom.xml clean test
