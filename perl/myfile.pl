open(FH,"records.txt");

$line=<FH>;
$count=0;
my @words;
$chk="pune";

while($line ne "")
	{

	@words=split(/\t/,$line);
	print @words[3];
	$chk1=@words[3];
	if($chk ne $chk1)
		{
		$count++;
		}
	$line=<FH>;
	}
print $count;

close(FH);