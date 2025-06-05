FROM node:latest-alpine as build

WORKDIR /app

COPY package*.json ./
COPY . .

RUN npm install && npm run build

FROM temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/dist ./dist
COPY . .
COPY --from=frontend /app/dist ./dist

RUN mvn clean package -DskipTests

RUN chmod +x ./initiativedevelopement

EXPOSE 8080

CMD ["./initiativedevelopement"]

ENTRYPOINT ["java", "-jar", "target/initiativeprojet-0.0.1-SNAPSHOT.jar"]