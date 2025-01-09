# Utiliser une image de base Java
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR généré dans l'image Docker
COPY target/app.jar app.jar

# Exposer le port de l'application
EXPOSE 8080

# Commande pour exécuter l'application
CMD ["java", "-jar", "app.jar"]
