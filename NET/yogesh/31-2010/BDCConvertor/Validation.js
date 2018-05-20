// JScript File

 function disablebtn()
{ 
    hu = window.location.search.substring(1);
    gy = hu.split("&");
    for (i=0;i<gy.length;i++)
    {
        ft = gy[i].split("=");
    }
    if (ft[1]==1) 
    {
        location.reload("index.aspx")
        window.history.forward(1);
    }
}
  function validate()
    { 
        var flag=0;
        var Checkbol=0;
        var bool=0;
        for(j=0;j<grd_cb.length;j++)
        {
            var obj = document.getElementById(grd_cb[j]);
            if(obj.checked == true)
            {
                Checkbol=1;
                bool=1;
                break;
            }
        }
       if(bool==0)
       {
          alert(" please, Select Atleast one Field to Generate Screen");
          return false;
       }
       if (Checkbol==1)
         {
           for(i=0;i<grd_cb.length;i++)
            { 
                 var Obj1 = document.getElementById(grd_cb[i]);
                 
                    if(Obj1.checked ==true)
                    {
                        var objDescription=document.getElementById(grddes_txt[i]).value;
                       if(objDescription=="")
                        {
                            alert("Row No : "+ [parseInt(i)+1]+ " Discription Can not be Blank");
                            //objDescription.focus();
                            return false;
                        }
                        else
                        {
                             var val= document.getElementById(grddes_txt[i]).value;
                             var len=val.length;
                             var c="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890-_";
                             for(var j=0;j<len;j++)
                             {      
                                 var subStr=val.substring(j,j+1);
                                 var s=c.indexOf(subStr);
                                 if(s<0)
                                        flag=1;
                                        break;                                                         
                             } 
                             if(flag==1)
                             {
                                 alert("Row No : "+ [parseInt(i)+1]+ " Discription Should contains Numbers,Characters.");  
                                 return false;
                             }                              
                        }
                        
                        var objSize=document.getElementById(grdsiz_txt[i]);
                        if(objSize.value=="")
                        {
                            alert("Row No : "+ [parseInt(i)+1]+ " Size field can not be blank.");
                          //  objSize.focus();
                            return false;
                        } 
                        else
                        {
                             var val= document.getElementById(grdsiz_txt[i]).value;
                             var len=val.length;
                             var c="1234567890";
                             for(var k=0;k<len;k++)
                             {      
                                 var subStr=val.substring(k,k+1);
                                 var s=c.indexOf(subStr);
                                 if(s<0)
                                        flag=1;
                                        break;                                        
                             }   
                             if(flag==1)
                             {
                              alert("Row No : "+ [parseInt(i)+1]+ " Invalid size");
                              return false;
                             }  
                        }
                        var objIndex=document.getElementById(grdindex_txt[i]);
                        if(objIndex.value=="")
                        {
                            alert("Row No : "+ [parseInt(i)+1]+ " Field Sequence field Can not be Blank");
                           // objIndex.focus();
                            return false;
                        }
                        else
                        {
                             var val= document.getElementById(grdindex_txt[i]).value;
                             var len=val.length;
                             var c="1234567890";
                             for(var l=0;l<len;l++)
                             {      
                                 var subStr=val.substring(l,l+1);
                                 var s=c.indexOf(subStr);
                                 if(s<0)
                                        flag=1;
                                        break;                                        
                             }   
                             if(flag==1)
                             {
                              alert("Row No : "+ [parseInt(i)+1]+ " Invalid Field Sequence");
                              return false;
                             }  
                        }                        
                        var objDType=document.getElementById(grddtype_txt[i]);
                        if(objDType.value=="--Select--")
                        {
                            alert("Row No : "+ [parseInt(i)+1]+ " Please, Select Datatype.");
                            //objDType.focus();
                            return false;
                        }
                    }
             }
           }
        return true;
    }

