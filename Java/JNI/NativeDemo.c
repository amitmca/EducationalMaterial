#include<jni.h>
#include "NativeDemo.h"
#include<stdio.h>

JNIEXPORT void JNICALL Java_NativeDemo_test(JNIEnv *env,jobject obj)
	{
	jclass cls;
	jfieldID fld;
	jint i;
	
	printf("Starting the native method:\n");
	cls=(*env)->GetObjectClass(env,obj);
	fld=(*env)->GetFieldID(env,cls,"i","I");

	if(fld==0)
		{
		printf("\n Could not get field\n");
		return;
		}	
	i=(*env)->GetIntField(env,obj,fld);
	printf("i=%d\n",i);
	(*env)->SetIntField(env,ob,fld,2*i);
	printf("Ending the native method:\n");		
	}