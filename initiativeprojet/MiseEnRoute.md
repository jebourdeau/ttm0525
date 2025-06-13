# Mise en route en Local sur un IDE

## Installation coté front :
### placer vous dans le dossier ttm0525/initiativeprojet/initiative-front
- npm install
- npm start
## Installation coté back :
### placer vous dans le dossier ttm0525/initiativeprojet
- mvn boot:run Spring Boot

#### Utilisation :
Pour lancer l'application, il faut lancer les deux serveurs.

Pour se connecter : connecter vous avec identifiant et mot de passe ou sinon créer un compte.

vous aurez accès à votre profil, à votre messagerie et à vos missions.

Le dépot GitHub va évoluér au fur et à mesure de l'avancée du projet.

au démarrage de l'application vous aurez un bandeau de cookie conforme à la RGPD.

Pour prendre un rendez-vous, vous avez un calendrier, date, heure et description.
Pour la messagerie pour le moment elle ne passe que par mail.(à agrémenter version chat par la suite, code créer en Mongo DB mais pas finalisé)

Pour Les profils, afin de les activer en Dynamique il suffira juste de supprimer le code en "Dur" du fichier Profils.jsx.

La Page monProfils c'est à modifier le profil individuel.

Votre base de donnée peut évoluer pour le moment elle ne comporte que 10 tables, en fonction des besoins.


# Mise en route par Docker

docker run -d -p 8080:8080 -p 3306:3306 --name registry.nocturlab.fr/jbourdeau/ttm0525/front .
docker run -d -p 8081:8080 -p 3306:3306 --name registry.nocturlab.fr/jbourdeau/ttm0525/back .