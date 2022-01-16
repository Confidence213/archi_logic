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

## Installation

```
chmod +x install.sh
./install.sh
```
