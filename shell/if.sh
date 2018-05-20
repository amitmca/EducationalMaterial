echo 'Enter a number:'
read n
if [ $n -lt 0 ] 
then echo 'Negative'
elif [ $n -eq 0 ]
then echo 'Zero'
else echo 'Positive'
fi
