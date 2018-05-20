<?
        $colors = array('black' => '#000000',
                        'white' => '#ffffff',
                        'red' => '#ff0000',
                        'blue' => '#0000ff');
                                                                                 
        $bg_name = $_POST['background'];
        $fg_name = $_POST['foreground'];
        $font = $_POST['font'];
	$size = $_POST['size'];
	$mess = $_POST['logmessage'];                                                                                            
?>
<html>
<body bgcolor="<?= $bg_name?>"  text="<?= $fg_name?>" >
<font face="<?= $font?>" size="<?= $size?>"<h1>Welcome to Store</h1>
Background : <?= $bg_name?><br>
Foreground : <?= $fg_name?><br>
Message : <?= $mess?><br>                                                                                                    
Click <a href="11_1pref.html">here</a> to see the preferences
</html>

