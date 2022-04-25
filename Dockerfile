FROM openjdk:11

ARG PORT

ENV SERVER_PORT=${SERVER_PORT}
ENV API_URL=${API_URL}

WORKDIR /opt/HomeChallenge_Front

COPY /target/HomeChallenge_FrontEnd-0.0.1-SNAPSHOT.jar HomeChallenge_FrontEnd-0.0.1-SNAPSHOT.jar

SHELL ["/bin/sh", "-c"]

EXPOSE ${SERVER_PORT}

CMD java -jar wiremock-standalone-2.14.0.jar --server.port=${SERVER_PORT} --api.url=${API_URL}