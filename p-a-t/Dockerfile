# Utiliser une image de base avec Java
FROM openjdk:17-jdk-alpine

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY target/*.jar app.jar

# Exposer le port sur lequel l'application Spring Boot écoute
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]