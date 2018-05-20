<?php
	$name = $_POST['name'];
	$media_type = $_POST['media_type'];
	$filename = $_POST['filename'];
	$tried = ($_POST['tried'] == 'yes');
	if($tried)
	{
		$validated = (!empty($name) && !empty($media_type) && !empty($filename));
  		if (!$validated)
		{ 
?>
			<p>
				The name, media type, and filename are required fields. 
				Please fill them out to continue.
			</p>
<?php
		}
	}
	if ($tried && $validated)
	{
		echo '<p>The item has been created.</p>';
	}
  
	function media_selected ($type)
	{
		global $media_type;
		if($media_type == $type)
		{
			echo "selected";
		}
	}
?>
  
<form action="<?= $PHP_SELF ?>" method="POST">
File: 	<input type="text" name="filename" value="<?= $filename ?>"><br>
Media: 	<select name="media_type">
	<option value="">Choose one</option>
	<option value="picture" <?php media_selected('picture')?>>Picture</option>
	<option value="audio" <?php media_selected('audio') ?>>Audio</option>
	<option value="movie" <?php media_selected('movie') ?>>Movie</option>
  	</select><br>
Name: <input type=text name="name" value="<?= $name ?>" /><br />
<input type="hidden" name="tried" value="yes" />
<input type="submit" value="<?php echo $tried ? 'Continue' : 'Create'; ?>">
</form>
