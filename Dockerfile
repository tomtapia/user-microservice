FROM openjdk:8-jre

MAINTAINER Tomás Tapia <ttapia@kaisanetwork.net>

VOLUME /tmp

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
ADD target/lib /usr/share/myservice/lib
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/microservice/${JAR_FILE}

ENTRYPOINT ["/usr/bin/java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/usr/share/microservice/${JAR_FILE}"]