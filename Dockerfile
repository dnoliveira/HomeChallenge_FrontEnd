FROM openjdk:11

ARG PORT

ENV PORT=${PORT}

WORKDIR /opt/wiremock

COPY /wiremock-standalone-2.14.0.jar wiremock-standalone-2.14.0.jar

RUN mkdir -p ./mappings

COPY ./mappings/* ./mappings

SHELL ["/bin/sh", "-c"]

EXPOSE ${PORT}

CMD java -jar wiremock-standalone-2.14.0.jar --port ${PORT} --verbose