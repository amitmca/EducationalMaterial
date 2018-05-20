
<?
	foreach($_POST['controls'] as $choice)
	{
		switch($choice)
		{
		case 'RB':
			echo "<input type='reset'><br>";
			break;
		case 'SB':
                        echo "<input type='submit'><br>";
                        break;
		case 'T':
                        echo "<input type='text' size='20'><br>";
                        break;
		case 'P':
                        echo "<input type='password' size='20'><br>";
                        break;
		case 'S':
                        echo "<select>";
			echo "<option>Option1</option>";
                        echo "<option>Option2</option>";
                        echo "<option>Option3</option>";
			echo "</select><br>";
                        break;
		case 'TA':
			echo "<textarea rows='3' cols='40'>Type Message</textarea><br>";
			break;
                case 'R':
                        echo "<input type='radio'>Radio Button<br>";
                        break;
                case 'CB':
                        echo "<input type='checkbox'>CheckBox<br>";
                        break;

		}
	}
?>
