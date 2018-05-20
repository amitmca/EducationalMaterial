<?php
$target_path="uploads/";
$target_path=$target_path.basename($_FILES['uploadedFile']['name']);

if(move_uploaded_file($_FILES['uploadedFile']['tmp_name'],$target_path))
	{
	echo "The File".basename($_FILES['uploadedFile']['tmp_name'])."has been uploaded";
	}
else
	{
	echo "There was an error uploading the file,please try again!";
	}
?>
