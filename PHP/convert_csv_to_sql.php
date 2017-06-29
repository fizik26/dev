<?php
$file = fopen('directory\file.csv', 'r+');
$fileWritting = fopen('directory\file.sql' , 'w+');  // w+ create the .sql file

while(!feof($file))
{
	$sort = fgets($file); // read line
	$information = explode("," , $sort); // sort out datas
	$lineInsert = "INSERT INTO table VALUES ('$information[0]' , '$information[1]')"; // creation of SQL request with insertion of two elements ( for example )
	fputs($fileWritting, $lineInsert); // write on file
	fputs($fileWritting, "\n"); // change line for next request
}
// close files
fclose($fileWritting);
fclose($file);
?>