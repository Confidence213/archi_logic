# Projet Architecture Logicielle

## Auteurs

- Kevin Doolaeghe
- Romain Haye
- Quentin Maesen

## Organisation Evénementiel

Workflows :
- Création de compte
- Gestion des évènements
- Participation aux évènements

Fonctionnalités :
- Création de compte
  - Créer un compte
  - Modifier un compte
  - Supprimer un compte
  - Afficher le compte
- Gestion des évènements
  - Ajouter un évènement
  - Modifier un évènement
  - Supprimer un évènement
  - Lister les évènements
  - Reporter un évènement
- Participation aux évènements
  - Ajouter au panier
  - Passer la commande

Domaines :
- Evènement
- Utilisateur
- Participant

Entités :
- Evènement
  - Nom
  - Description
  - Image
  - Lieu
  - Date
  - Durée
  - Nombre de participants maximum
  - Prix
- Utilisateur
  - Nom
  - Prénom
  - Date de naissance
  - Adresse mail
  - Numéro de téléphone
- Participant
  - Numéro billet
  - Date de commande
  - Identifant évènement

## Docker

* Téléchargement de l'image Docker de la BDD MariaDB :
```
docker pull mariadb
```

* Démarrage d'un conteneur Docker pour MariaDB :
```
docker run --detach --name mariadb --env MARIADB_USER=test --env MARIADB_PASSWORD=test --env MARIADB_ROOT_PASSWORD=secret --env MARIADB_DATABASE=db -p 3306:3306 mariadb:latest
```

* Démarrage du serveur REST :
```
java -jar rest.jar
```

## Docker Compose

* Compilation du backend en JAR :
```
mvn clean install
```

* Démarrage du stack :
```
docker-compose up -d
```