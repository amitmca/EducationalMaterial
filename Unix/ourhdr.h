#ifndef _ourhdr_h
#define _ourhdr_h

#include<sys/types.h>
#include<stdio.h>d
#include<stdlib.h>
#include<string.h>
#include<unistd.h>

void TELL_WAIT(void);
void TELL_PARENT(pid_t);
void TELL_CHILD(pid_t);
void WAIT_PARENT(void);
void WAIT_CHILD(void);

#endif

