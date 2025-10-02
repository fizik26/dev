# Exemple d'un fichier de configuration Jenkins utilisant OpenShift

Définitiion d'un pipeline

Le pipeline se compose de paramètres initiaux (cluster, project, namespace ...)

Ensuite vient la description des Jobs (Build Source, Build Runtime, Deploy Image to Dev, Deploy Availability of dev)

Il y a également un exemple de Job nécecssitant l'approbation d'un utilisateur. Le job `Confirm Deployement`