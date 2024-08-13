FROM gradle:8.4-jdk21-alpine AS build

COPY src /app/src
COPY build.gradle /app
COPY settings.gradle /app

WORKDIR /app

RUN gradle build --no-daemon

# Fase de execução
FROM openjdk:21

COPY --from=build /app/build/libs/fastfood-api-1.0.0.jar /app/app.jar

WORKDIR /app

ARG PORT=8080
ARG CURRENT_ENV=dev-local
ARG DATABASE_URL_ARG=jdbc:postgresql://localhost:5432/fastfood_service
ARG DATABASE_USERNAME=admin
ARG DATABASE_PASSWORD=users

ENV FASTFOOD_API_PORT=${PORT}
ENV FASTFOOD_API_ENVIRONMENT=${CURRENT_ENV}
ENV FASTFOOD_DATABASE_URL=${DATABASE_URL_ARG}
ENV FASTFOOD_DATABASE_USER=${DATABASE_USERNAME}
ENV FASTFOOD_DATABASE_PASSWORD=${DATABASE_PASSWORD}

EXPOSE ${PORT}

RUN echo "### Tech Challenge!!! ###"
RUN echo "The application will start on port: ${FASTFOOD_API_PORT};"

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${FASTFOOD_API_ENVIRONMENT}", "app.jar"]
