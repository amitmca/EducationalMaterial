a=20
STDOUT.flush
def mtd
a=10
print(a=a+5)
printf("\n")
end
print(a=a+5)
print("\n")
alias newmtd mtd 
def mtd
a=25
print(a=a+25)
print("\n")
end
mtd
newmtd 