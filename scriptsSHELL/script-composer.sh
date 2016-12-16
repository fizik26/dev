php -r "eval('?>'.file_get_contents('http://getcomposer.org/installer'));"
php composer.phar self-update
php composer.phar create-project slim/slim-skeleton appNum1
cd appNum1; php -S 0.0.0.0:8080 -t public public/index.php