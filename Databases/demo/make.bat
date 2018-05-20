@echo off

Rem Environment Check:
if (%MSVCDir%) == () goto msvcdir_error

cl -I%ORACLE_HOME%\oci\include -I%MSVCDir%\include -I%MSVCDir%\mfc\include -D_DLL -D_MT /LD -Zi extproc.c /link %ORACLE_HOME%\oci\lib\msvc\oci.lib msvcrt.lib /nod:libcmt /DLL /EXPORT:UpdateSalary /EXPORT:PercentComm /EXPORT:PercentComm_ByRef /EXPORT:EmpExp /EXPORT:CheckEmpName /EXPORT:LobDemo

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