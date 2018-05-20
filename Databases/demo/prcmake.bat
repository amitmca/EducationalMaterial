@echo off 
REM
REM Copyright (c) 1999 by Oracle Corporation. All Rights Reserved.
REM

Rem Use this script to create executables for the demo scripts with PL/SQL
Rem blocks embedded in C code.  To create all executables, at the prompt type:


Rem Environment Check:
if (%MSVCDir%) == () goto msvcdir_error

if (%1) == () goto usage
echo This makefile assumes demos are installed as user scott

proc iname=%1.pc sqlcheck=full CHAR_MAP=VARCHAR2, DBMS=V7 ireclen=132 parse=full sqlcheck=SEMANTICS user=scott/tiger 
cl -I%ORACLE_HOME%\oci\include -I%MSVCDir%\include -I%MSVCDir%\mfc\include -D_MT -Zi %1.c /link %ORACLE_HOME%\oci\lib\msvc\oci.lib %ORACLE_HOME%\precomp\lib\msvc\orasql9.lib /libpath:%MSVCDir%\lib msvcrt.lib /nod:libcmt 
goto end


:msvcdir_error 
echo .
echo Environment variable MSVCDIR must be set before running this batch file.
echo Please run vcvars32.bat from MS Visual Studio directory.
echo .
goto end

:usage
echo .
echo usage prcmake filename.pc [i.e. prcmake examp10]
echo .
:end
