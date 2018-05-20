echo 'Enter a Number:'
read n
sum=0
i=1
while [ $i -le $n ]
do
	sum='expr $sum + $i'
	i='expr $i + 1'
done	
echo 'The Sum is:'$sum
