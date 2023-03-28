# Compte-rendu #1


## Base de donnée
Nous avons d'abord crée une base de donnée simple comprenant matricule, login, mot de passe, nom, prénom dans une table, les secteurs donc les régions dans une autre et type agent qui défini si l'agent est visiteur ou comptable.



## Répartition des tâches:
Grâce à cette base, nous nous sommes réparti les tâches par fenêtre plutôt que par logiciel pour que chacun puisse utiliser chaque logiciel.

Hugo a effetcué la page d'authentification, pour se faire, il a utilisé Java avec Visual Studio Code, javaFX avec SceneBuilder et la base de donnée crée au dessus.
Il a donc d'abord crée un lien entre la base de données et le projet java afin de pouvoir en utiliser les informations (ligne 23-33 AuthentificationController.java). Il a ensuite crée sur JavaFx un fichier FXML qui servira d'interface graphique au système d'authentification. Il y a donc relié les zones de texte et le bouton à java (ligne 35-39 AuthentificationController.Java) afin d'en récuperer le contenu qui est entré et le fait coïncider avec la base de donnée. Si les données entrées sont mauvaise, il ne se passe rien, si elles correspondent à un visiteur, il est dirigé vers une page visiteur et si elles correspondent à un comptable il est dirigé vers une page comptable. (ligne 39-44 AuthentificationController.java). Il a ensuite crée des boutons pour se déplacer entre les fenêtres plus facilement (exemple ligne 10-16 VisiteurControlleur.java)
[- Authentification -](https://github.com/hugobaras/ap/blob/master/authentification.png)  [- Visiteur -](https://github.com/hugobaras/ap/blob/master/visiteur.png) [- Comptable -](https://github.com/hugobaras/ap/blob/master/camptable.png)

Ndoumbe a travaillé sur la fiche de remboursement de frais engagés, elle a utilisé Java, JavaFX, la base de donnée crée préalablement et également le dico de donnée réalisé afin de clarifier les données. Elle a d'abord crée un lien entre la base de données et le projet java puis a travaillé majoritairement sur l'aspect graphique de la fiche afin d'avoir une base propre pour pouvoir ensuite relier les champs de texte et les boutons aux champs associés dans la base de données aux actions qu'ils réalisent. 

De la même façon, Hiba a travaillé sur la fiche d'état des frais en utilisant le même procédé que Ndoumbe 


## Tableau Kanban
Nous avons réalisé un tableau Kanban simple composé de quatres parties comprennant: 
| Tâches | En cours | Test | Terminé |
|:-------|:---------|:----:|--------:|


[Tableau Kanban](https://trello.com/invite/b/rVH7JqII/9b7bd25f2113099189ab73e2ac0586d3/modele-kanban)


## Conception et développement
* Java (VSCode)
* JavaFX (SceneBuilder)
* Mysql (MySQL Workbench)
* Gitbush
* GitHub
* Excel [- Dico de données FDR -](https://github.com/hugobaras/ap/blob/master/Dico%20de%20données.xlsx)
* 
### Difficulté rencontrée
Hiba et Ndoumbe ont eu des diffuculté avec la prise en main de SceneBuilder, celui-ci ayant une interface peu intuitive. Elles ont réussi à les surmonter à force de recherche par elles-mêmes ainsi que sur internet. 
Hugo a éprouvé des difficulté au début avec la connexion de la BDD, ce qu'il a reussi à résoudre par la suite. Il a également stagné pendant un moment sur la réalisation du code pour synchroniser les champs texte avec les données entrées, ce qu'il a reussi à faire grâce à des recherches et de l'aide extérieure.


## Annexe
[- MySQL -](https://github.com/hugobaras/ap/blob/master/gsb.sql)


## Bilan
Après avoir eu du mal à démarrer, dû aux lacunes de chacun, nous avons réussi à trouver notre rythme qui nous permettra d'aller au bout du projet. La prise en main des logiciels a été bien prise par tous. 

# Compte-rendu #2

## Répartition des tâches:
Hiba et Ndoumbe ont terminé la fiche de remboursement de frais engagées et la fiche d'état des frais.

Hugo, sur la page [- Visiteur -](https://github.com/hugobaras/ap/blob/master/visiteur.png), a réalisé le processus permettant de calculer le total des frais forfaitaires en récuprant le montant unitaire dans une base de donnée. Il a également intégré le nom du visiteur afin d'être sur qu'il soit connecté sur le bon compte. 
Il avance maintenant sur la base de données afin de créer une table "fiche" qui contiendra les données entrées dans les champs de frais forfaitaires afin que pouvoir les afficher lorsque le comptable sélectionnera un visiteur. 

## Difficultés rencontrées
Un manque de communication s'est vite fait ressentir ce qui nous a empêché d'avancer efficacement. On essaie donc maintenant de discuter avant et pendant la réalisation d'une tâche afin de ne pas empiéter sur le travail de nos camarades.  


# Compte rendu final

## Equipe de conception
- Hugo BARAS en charge de la majorité de l'aspect développement de l'application
- Hiba en charge de la réalisation JavaFX (Scene builder)
- Ndoumbe en charge de la conception de la base de donnée


## Contexte
Des visites sont effectué dans des centre médicaux afin de mettre à jour les 
connaissances sur le pesonnel médicale et les produits utilisés.
Ces visites sont remboursé par l’entreprise Galaxy, qui souhaite avoir une 
application qui permettrai d’uniformiser le suivit des visites.
Nous avons développé cette application qui permet d'informatiser et d'uniformiser 
le suivit des visites

## Fonctionnalités de l'application

L'application permet l'identification d'un utilisateur avec un login et un mot de passe.

Si l'utilisateur est un ***visiteur***, il pourra remplir des fiches de remboursement contenant le nombre de nuitées, de repas, de kilomètres, les frais exceptionnels qu'il a effectués avant le 10 de chaque mois ainsi que consulter les fiches déjà remplis. 

S'il est ***comptable***, il pourra analyser les fiches de remboursement des visiteurs afin de les valider ou les refuser.

## Outils et langages utilisés

### Base de données

Pour la schématisation, nous avons utilisé Excel pour le dictionnaire de données et MoCoDo pour le MCD
Pour la conception, nous avons utilisé MySQL WorkBench.

### Programmation de l'application

Pour la partie code, nous avons utlisé l'IDE Visual Studio Code puisqu'il permet les "commit" simples sur GitHub
Pour la partie interface, nous avons utlisé SceneBuilder afin de simplifier la mise en place de bouton et zones d'écriture.

## Connexion à l'application
[-Page de connexion-]
![image](https://user-images.githubusercontent.com/98149044/168809580-3b6ee7f2-5e24-48e8-a988-89ac1d522770.png)


En rentrant les ag_login et ag_password du tableau qui correspondent aux données de l'utilisateur, on parvient à se connecter à l'application, dans le cas de l'image, Laurent Dupont est un visiteur, il sera donc redirigé sur la page visiteur. 
### Visiteur
[-Renseigner une fiche-]
![image](https://user-images.githubusercontent.com/98149044/168809659-99a1332f-cb11-4415-b658-b1fe0eeb6242.png)

L'agent arrive donc sur cette page sur laquelle il peut renseigner des nuitées (°1), des repas (°2) et des frais kilométriques (°3) qui sont ensuite calculés par rapport aux prix des frais en vigueur. Il peut également renseigner des autres frais (°4). Il peut ensuite soumettre sa fiche(°5). A la suite de quoi un message s'affiche [-Soumettre la fiche-] ![image](https://user-images.githubusercontent.com/98149044/168809718-0d3fda7e-d715-4f04-8158-b805aabd29c7.png)


[-Consulter une fiche-]![image](https://user-images.githubusercontent.com/98149044/168809816-0ca5b984-7cde-4bbc-8f42-69a569adede0.png)

L'agent peut ici consulter les fiches qu'il a déjà remplis en séléctionnant une date(°1) et peut vérifier si ses autres frais ont été validés où refusés (°2).

### Comptable
[-Valider une fiche-]![image](https://user-images.githubusercontent.com/98149044/168809866-e6c13950-d352-4e37-8533-77054cda8e1b.png)

L'agent peut ici sélectionner un visiteur via son matricule(°1), son nom est affiché en dessous (°3). Il peut également valider un frais en le cochant ou le refuser sans le cocher. Afin de valider la fiche, l'agent appuyera sur le bouton valider et le message suivant apparaitra [-Valider-]
![image](https://user-images.githubusercontent.com/98149044/168809938-091d0d57-6cd3-4304-8d2a-8655abfdf845.png)


[-Consulter une fiche-]![image](https://user-images.githubusercontent.com/98149044/168810244-7c607b22-2a3d-4fa5-9a02-c0a687cb3832.png)


L'agent peut ici sélectionner un visteur via son matricule (°1) ainsi qu'une date de fiche (°2). 

## Base de données

Nous avons donc réalisé un MCD afin d'organiser nos tables dans la base de données [-MoCoDo-](![image](https://user-images.githubusercontent.com/98149044/168809980-bb8a295d-2b41-465f-b916-9ed53693ade3.png)


A la suite de quoi nous avons réalisé les différentes tables de la base de donnée et leur contenus ![image](https://user-images.githubusercontent.com/98149044/168809391-052abd6d-0d4c-489e-85c5-e768b1fd1945.png)
 Dans chacun des tables, nous avons utilisé des clés primaires afin que ca corresponde au MCD
 
 [-Exemple avec table fiche-]
 ![image](https://user-images.githubusercontent.com/98149044/168810635-bec4d6db-d59e-4fc4-ace6-b1603caa3958.png)
 On a également des clés étrangères, ici "fk_etat" qui fait référence à la table "etat".
 Ces clés étrangères sont déterminées par les cardinalités du MCD.
 
 ## Outils de gestion de projet
 
 ### Trello
 ![image](https://user-images.githubusercontent.com/98149044/168811268-4da810bf-3198-4072-a24a-483c2de2418c.png)


## Expérience de travail:
### Hugo:
J'ai beaucoup appris avec de travail notamment sur le développement JAVA. 
  - Base de données:
  J'ai appris comprendre les bdd afin de créer des champs et des clés étrangères que je ne maitrisais pas avant le début du projet.
  -SceneBuilder:
  Je n'ai pas tout de suite compris le but de SceneBuilder mais j'ai au fur et à mesure compris son intérêt, le fait de lier un TextField ou un label simplement en récuperant son code au sein de SceneBuilder pour l'intégrer directement au script JAVA fut difficile a comprendre au début mais est devenu très fluide et logique sur la suite du projet.
  -Java:
  Cette partie a été celle que j'ai le plus apprécié. Etant en grande partie tout seul sur le script, j'ai énormement appris en dehors des cours, grâce à des tutos, à des conseils sur des sites tels que StackOverFlow ou aux indications de Monsieur Gahide. J'ai donc pu découvrir plus en détail un langage complétement différent du Web sur lequel j'ai aimé travailler et qui laisse encore beaucoup de choses à découvrir. 

### Hiba:
...


### Ndoumbe:
...


## Le travail d'équipe
Le travail d'équipe a été le plus gros point noir de notre projet. Ce n'était pas une question d'entente au sein du groupe mais plus d'organisation. Au début chacun avançait sans se consulter ce qui créait des duplications, nous avons donc discuté de cela afin de régler le problème. Nous nous sommes donc consultés légèrement plus mais sans jamais avancer ensemble. 
De plus, certaines absences au sein du groupe ont accentué le travail solitaire. 


## Commit
Nous avons également découvert les avantages des Commit. Le fait de tous travailler sur le même projet, sans avoir à se transmettre les dossiers sur une clé USB ou un disque dur a été un gain de temps énorme. 
Une certaine organisation et rigueur ont été nécessaires égalemment afin de ne pas écraser les commits réalisés précédemments. 
