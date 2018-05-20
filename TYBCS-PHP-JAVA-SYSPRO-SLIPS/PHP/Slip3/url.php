<?
$url='http://www.example.com/php-example/index.php';
$info=parse_url($url);
echo "<br><b>Scheme:</b>".$info['scheme']."<br>";
echo "<br><b>Host:</b>".$info['host']."<br>";
echo "<br><b>Path:</b>".$info['path']."<br>";
?>
