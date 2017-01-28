<?php
	header("Content-Type: text/xml");
	echo "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
	echo "<list>";

	$idEditor = (isset($_POST["IdEditor"])) ? htmlentities($_POST["IdEditor"]) : NULL;
	if ($idEditor != 0) {
		$requete=$bdd->query("SELECT id_ville, nom_ville FROM xx_ville WHERE nom_region = '$idEditor'");

		while ($back = $requete->fetch()) {
			echo "<item id=\"" . $back['id_ville'] . "\" name=\"" . $back['nom_ville']. "\" />";
		}
	}

	echo "</list>";

?>