Exemple d'un contrat OpenAPI

Dans les Components, les champs en required sont les champs qui doivent etre obligatoirement non null lors d'un PUT ou d'un POST
Les champs en nullable : false , sont les champs qui ne peuvent pas être NULL lors d'un GET

Dans les exemples, le paramètre TypeUserId est un paramètre envoyé par le header. C'est pour cela qu'il n'apparait pas dans l'URL de l'endpoint