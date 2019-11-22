# projetJava

HALLAY Valentin, CHRETIEN Romain, HASSED Ulrich, BROCHARD Allan


Le MCD présent sur le github est en version 1, il manque l'email. 

Utiliser le jeu de donnée joint. script : 
-   init_database.sql


Page de départ : login (http://localhost:8080/gestionCR/login)
Utilisé un des utilisateurs présent de base pour se connecter. peut importe le quel 

Possibilitées : 


- Ajout d'un collaborateur
- Ajout d'une réunion (Avec un ou plusieurs collaborateur (ctrl + clic))
- Ajout d'un role
- Affichage liste collaborateurs 
- Affichage liste réunion 
- Affichage liste roles 
- Maj d'une réunion -> Créer une tache dessus 
                    -> Ajouter un compte rendu
- Affichage détails réunion (Infos réunion, taches associées)




Dans la methode addReunion servlet pour l'envoi de mail, 
renseigner l'username avec l'adresse email expeditrice ainsi que le mot de passe. 

Configurer les propriétés du serveur smtp. et renseignez les adresses mails de collaborateurs en base 