// class:=>
//     syntax is=>      class  class_name
//          		{
//			Public\Private:
// 			member declaration ;
//			};
// for e.g:->
//Public members are accessable for all
#include<iostream.h>
#include<conio.h>
	class emp
	{
	public:
	int id;
	};
int main(void)
{
emp x;
x.id=12;
cout<<x.id;
return(0);
}