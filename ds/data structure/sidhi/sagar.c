#include<stdio.h>
#include<conio.h>
#include<math.h>
    main()
    {
     int CHOISE,CH;
    clrscr();
    while(1)
    {
    printf("\n\t\t      ****Shree Sidhivinayak Computer Center****");
    printf("\n\t\t      ****Sagar Dhumal****");
    printf("\n\t\t      ****STATISTICAL MAIN MENU****");
    printf("\n\t\t 1 :CALCULATION OF ARITHMATIC MEAN");
    printf("\n\t\t 2 :CALCULATION OF MEDIUN");
    printf("\n\t\t 3 :CALCULATION OF MODE");
    printf("\n\t\t 4 :CALCULATION OF SKEWNESS");
    printf("\n\t\t 5 :CALCULATION OF CORRELATION COEFFICIENT");
    printf("\n\t\t 6 :CALCULATION REGRESSION EQUETION");
    printf("\n\t\t 7 :CALCULATION OF POISSON DISTRIBUTION");
    printf("\n\t\t 8 :CALCULATIN OF BINOMIAL DISTRIBUTION");
    printf("\n\t\t 9 :CALCULATION OF STANDERD DAVIATION");
    printf("\n\t\t 10:CALCULATION OF EXPONTIAL CUREVE");
    printf("\n\t\t11 :SHUT-DOWN THIS PROGRAM");
    printf("\n ENTER YOUR CHOISE:->");
    scanf("%d",&CHOISE);
    switch(CHOISE)


       {  case 1: {

		  float l[20],u[20],x[20],h,i,n,freq[20],fx[20],F=0,FX=0,am;


		  printf("ARITHMATIC MEAN");
		    printf("\n1:ROW DATA");
		    printf("\n2:DISCREAT FREQUENCY DISTRIBUTION");
		    printf("\n3:CONTINEUS FREQUENCY DISTRIBUTION");
		    printf("\n4:EXIT");
		    printf("\nFOR WHICH DATA YOU ARE INTERESTED TO CALCULATE ARITHMATIC MEAN:");
		    scanf("%d",&CH);
		   switch(CH)
		    {
		       case 1: {

				 printf("\nCALCULATION FOR ROW DATA:");
				 printf("\nhow many values you want to store:");
				 scanf("%f",&n);
				 printf("\nX:->");
				 for(i=0;i<n;i++)
				  { scanf("%f",&x[i]);
				    F=F+x[i];
				  }
				  am=F/n;
				  printf("\narithmatic mean for this distribution is %f",am);
				 }break;
			case 2:{ printf("\nCALCIATION FOR DISCREAT FREQUENCY DISTRIBUTION");
				  printf("\nhow many values you want to store:");
				  scanf("%f",&n);
				  printf("\nX:->");
				  for(i=0;i<n;i++)
				    { scanf("%f",&x[i]);
				    }
				    printf("\nfrequency:");
				    for(i=0;i<n;i++)
				     { scanf("%f",&freq[i]);
				       F=F+freq[i];
				       FX=FX+freq[i]*x[i];
				      }
				      printf("\narithamatic mean for this data is: %f",FX/F);
				   }break;
			 case 3:{ printf("\nCALCULATION FOR CONTINEUS FREQUENCY DISTRIBUTION");
				  printf("\nhow many classes you want to store:");
				  scanf("%f",&n);
				  printf("what is your lower limit:");
				  scanf("%f",&l[0]);
		  printf("what is your classwidth:");
		  scanf("%f",&h);
		  printf("\nclasses");
		  for(i=0;i<n;i++)
		    { u[i]=l[i]+h;
		      printf("\n%f %f",l[i],u[i]);
		      x[i]=(l[i]+u[i])/2;
		      l[i+1]=u[i];
		    }
		  printf("\nfrequency");
		  for(i=0;i<n;i++)
		   { scanf("%f",&freq[i]);
		     fx[i]=freq[i]*x[i];
		     FX=FX+fx[i];
		     F=F+freq[i];
		   }
		   am=FX/F;
		   printf("\narithmatic mean for this distribution is %f",am);
		   } break;



		}break;
	   case 2 :{
		     float l[20],u[20],x[20],freq[20],lcf[20],i,h,me,F=0,cf,f,ll;
		     int n;
		     printf("\nCALCULATION OF MEDIUN");
		     printf("\n1:ROW DATA");
		     printf("\n2:DISCREAT FREQUENCY DISTRIBUTION");
		     printf("\n3:CONTINEUS FREQUENCY DISTRIBUTION");
		     printf("\nFOR WHICH DATA YOU ARE INTERESTED TO CALCULATE MEDIAN");
		     scanf("%d",&CH);
		     switch(CH)
		     { case 1: {
			       printf("\nCALCULATION FOR ROW DATA");
			       printf("\nhow many values you want to store:");
			       scanf("%d",&n);
			       printf("\nX:->");
			       for(i=0;i<n;i++)
				{ scanf("%f",&x[i]);
				}
				if(n%2!=0)
				{
				  printf("MEDIAN FOR THIS DATA IS %f",x[(n+1)/2]);
				 }
				else
				 if(n%2==0)
				  { printf("MEDIAN FOR THIS DATA IS %f",(x[n/2]+x[n/2+1])/2);
				  }
				}break;
		      case 2:  { printf("\nCALCULATION FOR DISCREAT DATA");
				 printf("\nhow many values you want to store:");
				 scanf("%d",&n);
				 printf("\nX:->");
				 for(i=0;i<n;i++)
				  { scanf("%f",&x[i]);
				  }
				 printf("\nfrequency:");
				 for(i=0;i<n;i++)
				 {
				 scanf("%f",&freq[i]);
				 F=F+freq[i];
				 }
		      for(i=0;i<n;i++)
		       { lcf[0]=freq[0];
			 lcf[i+1]=freq[i+1]+lcf[i];
		       }
		       for(i=0;i<n;i++)
		       { if(lcf[i]>F/2)
			  {
			 h=x[i];
			 }
		       }

		       printf("\nMEDIAN FOR THIS DISTRIBUTION IS %f",h);
		       }break;
		    case 3:{
			    printf("\nCALCULATION FOR CONTINEUS FREQUENCY DISTRIBUTION:");
		     printf("\nhow many classes you want to store:");
		     scanf("%d",&n);
		     printf("what is your classwidth:");
		     scanf("%f",&h);
		     printf("what is your lower limit:");
		     scanf("%f",&l[0]);
		     printf("\nclasse:");
		     for(i=0;i<n;i++)
		      {  u[i]=l[i]+h;
			 printf("\n%f  %f",l[i],u[i]);
			 l[i+1]=u[i];
		      }
		      printf("\nfrequency");
		      for(i=0;i<n;i++)
		       { scanf("%f",&freq[i]);
			 F=F+freq[i];

		       }
		       for(i=0;i<n;i++)
			{ lcf[0]=freq[0];
			  lcf[i+1]=freq[i+1]+lcf[i];
			}
		       for(i=0;i<n;i++)
		       { if(lcf[i]>(F/2))
			   {  cf=lcf[i-1];
			      f=freq[i];
			      ll=l[i];break;
			   }
		       }
		       me=ll+(((F/2)-cf)/f)*h;
		       printf("\nmediun for this distribution is %f",me);
		       }                    break;
		    }break;
		    }
	       case 3:{ float n,h,i,l[20],u[20],freq[20],mo,f1,f2,f0,ll;
			printf("\nCALCULATION OF MODE");
			printf("\nhow many classes you wantb to store:");
			scanf("%f",&n);
			printf("what is your classwidth:");
			scanf("%f",&h);
			printf("what is your lower limit:");
			scanf("%f",&l[0]);
			printf("\nclasses");
			for(i=0;i<n;i++)
			 { u[i]=l[i]+h;
			  printf("\n%f  %f",l[i],u[i]);
			  l[i+1]=u[i];
			 }
			 printf("\nfrequency");
			 for(i=0;i<n;i++)
			 { scanf("%f",&freq[i]);
			 }
			 for(i=0;i<n;i++)
			 { if(freq[i]>freq[i+1])
			    { f1=freq[i];
			      f0=freq[i-1];
			      f2=freq[i+1];
			      ll=l[i];break;
			    }
			 }
			 mo= (ll+((f1-f0)/(2*f1-f0-f2))*h);
			 printf("\nmode=%f",mo);
			 }break;
		 case 4:  {
			  float l[20],u[20],x[20],freq[20],fx[20],i,n,h,mo,am,sk,f1,f0,f2,F=0,FX=0,FXX=0,sigma,ll;
			  printf("\nCALCULATION OF SKEWNESS");
			  printf("\nhow many classes you want to store:");
			  scanf("%f",&n);
			  printf("what is your classwidth:");
			  scanf("%f",&h);
			  printf("what is your lower limit:");
			  scanf("%f",&l[0]);
			  printf("\nclasses");
			  for(i=0;i<n;i++)
			  { u[i]=l[i]+h;
			    printf("\n%f  %f",l[i],u[i]);
			    x[i]=(l[i]+u[i])/2;
			    l[i+1]=u[i];
			  }
			  printf("\nfrequency");
			  for(i=0;i<n;i++)
			  { scanf("%f",&freq[i]);
			     F=F+freq[i];
			     FX=FX+(freq[i]*x[i]);
			     FXX=FXX+(freq[i]*x[i]*x[i]);
			    }
			  am=FX/F;
			  sigma=sqrt((FXX/F)-am*am);
			  for(i=0;i<n;i++)
			   { if(freq[i]>freq[i+1])
			      { f1=freq[i];
				f0=freq[i-1];
					f2=freq[i+1];
				ll=l[i];break;
			      }
			   }
			   mo=(ll+((f1-f0)/(2*f1-f0-f2))*h);
			   sk=(am-mo)/sigma;
			   printf("\ncoifficient of skewness for this distribution is %f",sk);
			   if(sk>0)
			   printf("\ndistribution is positively skewed");
			   else
			   if(sk<0)
			   printf("\ndistribution is negatively skewed");
			   else
			   if(sk==0)
			   printf("\ndistribution is symmetric");
			   }break;

		case 5: {
			  float x[20],y[20],i,n,CoV,sigmax,sigmay,r,X=0,Y=0,xx=0,yy=0,xy=0;
			  printf("CALCULATION OF CORRELATION COEFFICIENT");
			  printf("\nhow many values of x & y you want to store:");
			  scanf("%f",&n);
			  printf("\nX:->");
			  for(i=0;i<n;i++)
			   { scanf("%f",&x[i]);
			     X=X+x[i];
			     xx=xx+x[i]*x[i];
			   }
			   printf("\nY:->");
			   for(i=0;i<n;i++)
			    { scanf("%f",&y[i]);
			      Y=Y+y[i];
			      yy=yy+y[i]*y[i];
			      xy=xy+x[i]*y[i];
			    }
			   sigmax=sqrt((xx/n)-(X/n)*(X/n));
			   sigmay=sqrt((yy/n)-(Y/n)*(Y/n));
			   CoV=((xy/n)-(X/n)*(Y/n));
			   r=CoV/(sigmax*sigmay);
			   printf("\ncorrelation coefficiant between X & Y is %f",r);
			   }break;
		 case 6:  {
			  float x[20],y[20],xx=0,CoV,i,n,X=0,Y=0,sigmaxx,xy=0;
			  printf("\nFITTING OF REGRESSION EQUETION");
			  printf("\nhow many values of X &Y you want to store:");
			  scanf("%f",&n);
			  printf("\nX:->");
			  for(i=0;i<n;i++)
			  {
			  scanf("%f",&x[i]);
			  xx=xx+(x[i]*x[i]);
			  X=X+x[i];
			  }
			  printf("\nY:->");
			  for(i=0;i<n;i++)
			  { scanf("%f",&y[i]);
			    Y=Y+y[i];
			    xy=xy+(x[i]*y[i]);
			  }
			  CoV=((xy/n)-(X/n)*(Y/n));
			  sigmaxx=((xx/n)-(X/n)*(X/n));
			  printf("\nregression eqaution of Y on X is as followes:");
			  printf("\nY=%fX+%f",CoV/sigmaxx,(-(CoV/sigmaxx)*(X/n)+(Y/n)));
			  }break;
		 case 7: {
			  float n,s,i,pr[20],x[20],freq[20],F=0,FX=0,lambda;
			  printf("\nFITTING OF POISSON DISTRIBUTION");
			  printf("\nhow many times exeperiment is to be reapeted:");
			  scanf("%f",&n);
			  printf("\nX:->");
			  for(i=0;i<n;i++)
			   { scanf("%f",&x[i]);
			   }
			   printf("\nfrequency");
			   for(i=0;i<n;i++)
			    { scanf("%f",&freq[i]);
			      FX=FX+(x[i]*freq[i]);
			      F=F+freq[i];
			    }
			    lambda= FX/F;
			    pr[0]=exp(-lambda);
			    printf("\nX=x");
			    printf("\t\tp[X=x]");
			    printf("\t\tN*p[X=x]");
			    for(i=0;i<n;i++)
			     { printf("\n%f",i);
			       printf("\t%f",pr[i]);
			       printf("\t%f",F*pr[i]);
			       s=(lambda/(i+1))*pr[i];
			       pr[i+1]=s;
			     }
			     }break;
		 case 8:
			 { float x[20],freq[20],pr[20],n,i,s,p,FX=0,F=0;
			   printf("\nFITTING OF BINOMIAL DISTRIBUTION");
			   printf("\nhow many times exeperiment is to be repeated:");
			   scanf("%f",&n);
			   printf("\nX:->");
			   for(i=0;i<n;i++)
			    {
			      scanf("%f",&x[i]);
			    }
			    printf("\nfrequency:");
			    for(i=0;i<n;i++)
			     { scanf("%f",&freq[i]);
			       FX=FX+freq[i]*x[i];
			       F=F+freq[i];
			     }
			     p=(FX/F)/n;
			     pr[0]=pow((1-p),n);
			     printf("\nX=x");
			     printf("\t\t\tp[X=x]");
			     printf("\t\t\tN*p[X=x]");
			     for(i=0;i<n;i++)
			      { printf("\n%f",i);
				printf("\t\t%f",pr[i]);
				printf("\t\t%f",F*pr[i]);
				s=((n-i)/(i+1))*(p/(1-p))*pr[i];
				pr[i+1]=s;
			      }

			      }break;
		 case 9: {
			   float l[20],u[20],fx[20],fxx[20],x[20],FX=0,F=0,FXX=0,n,i,h,freq[20];
			   printf("\nCALCULATION OF STANDERD DAVIATION:");
			   printf("\nhow many classes you want to print:");
			   scanf("%f",&n);
			   printf("what is your classwidth:");
			   scanf("%f",&h);
			   printf("what is your lower limit:");
			   scanf("%f",&l[0]);
			   printf("\nclasses");
			   for(i=0;i<n;i++)
			    { u[i]=l[i]+h;
			      printf("\n%f  %f",l[i],u[i]);
			      x[i]=(l[i]+u[i])/2;
			      l[i+1]=u[i];
			    }
			    printf("\nfrequency:");
			    for(i=0;i<n;i++)
			     { scanf("%f",&freq[i]);
			       F=F+freq[i];
			       FX=FX+(freq[i]*x[i]);
			       FXX=FXX+(freq[i]*x[i]*x[i]);
			     }
			     printf("\nstanderd daviation for this data is :");
			     printf("\t%f",sqrt(((FXX/F)-(FX/F)*(FX/F))));
			     }break;


		 case 11: {
			   printf("`SORRY YOU ARE EXIT FROM THIS PROGRAMM`");
			   exit(0);
			   }break;
			  }
			}
		  getch();
		  }
		  }