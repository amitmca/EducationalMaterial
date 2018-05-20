/* Copyright (c) Oracle Corporation 1997, 1998, 1999. All Rights Reserved. */


/*

   NAME
     extproc.c - C function to illustrate the External Procedures.

   DESCRIPTION
     This file contains 'C' functions which are called from extproc.sql

*/


/*************************************************************************
 *
 * This file has 'C' functions for external procedures in demopack procedure
 * in extproc.sql.
 *
 *
 ***************************************************************************/



#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <time.h>

#ifndef OCI_ORACLE
# include <oci.h>
#endif

#define BUFLEN 256

struct ocictx
{
  OCIEnv     *envhp;                           /* For OCI Environment Handle */
  OCISvcCtx  *svchp;                               /* For OCI Service Handle */
  OCIError   *errhp;                                /* For OCI Error Handle  */
  OCIStmt    *stmtp;                             /* For OCI Statement Handle */
  OCIStmt    *stm1p;                             /* For OCI Statement Handle */
  OCIBind    *bnd1p;                                  /* For OCI Bind Handle */
  OCIBind    *bnd2p;                                  /* For OCI Bind Handle */
  OCIBind    *bnd3p;                                  /* For OCI Bind Handle */
  OCIDefine  *dfn1p;                                /* For OCI Define Handle */
  OCIDefine  *dfn2p;                                /* For OCI Define Handle */
  OCIDefine  *dfn3p;                                /* For OCI Define Handle */
};
typedef struct ocictx ocictx;


void check_err( str, err, errbuf, oci_ctxp )
char    *str;
int     err;
char    *errbuf;
ocictx  *oci_ctxp;
{
    if ( err ) 
    { 
      OCIErrorGet( (dvoid *)oci_ctxp->errhp, (ub4) 1, (text *)0, (sb4 *)&err, 
         (text *)errbuf, (ub4)sizeof( errbuf ), (ub4)OCI_HTYPE_ERROR ); 
      fprintf(stdout,"%s returned errno: %d\nerrstr: %s\n", str, err, errbuf);
      return; 
    } 
    else 
      fprintf(stdout,"%s returned: 0\n", str);
}


/* ----------------------------- UpdateSalary ----------------------------- */
/* UpdateSalary - This function updates the sal column of emp table 
 *   corresponding to the given rowid.
 * 
 */
#ifdef WIN32COMMON
__declspec(dllexport)
#endif
void UpdateSalary(with_context, r_id, r_len)
OCIExtProcContext *with_context;                         /* With Context ptr */
char              *r_id;                                            /* rowid */
sb4                r_len;                            /* length of rowid r_id */
{

  char    *sql_stmt = 
    "UPDATE emp SET sal = sal+20 WHERE rowid = chartorowid(:1)";
  int      err;
  ocictx   oci_ctx;
  ocictx  *oci_ctxp = &oci_ctx;
  char     errbuf[512];
 
  /* Obtain OCI handle for SQL statement using the context passed. */
  err = OCIExtProcGetEnv(with_context,                       /* With context */
                         &oci_ctxp->envhp,
                         &oci_ctxp->svchp,
                         &oci_ctxp->errhp);
  check_err("OCIExtProcGetEnv", err, errbuf, oci_ctxp);
  
  /* Obtain the Statement handle. */
  err = OCIHandleAlloc(oci_ctxp->envhp, 
                       (dvoid **)&oci_ctxp->stmtp,
                       OCI_HTYPE_STMT, 
                       0, 
                       0);
  check_err("OCIHandleAlloc(stmth)", err, errbuf, oci_ctxp);

  /* Prepare the Statement for execution. */
  err = OCIStmtPrepare(oci_ctxp->stmtp, 
                       oci_ctxp->errhp, 
                       (text *) sql_stmt,
                       strlen(sql_stmt), 
                       OCI_NTV_SYNTAX, 
                       OCI_DEFAULT);
  check_err("OCIStmtPrepare", err, errbuf, oci_ctxp);
  
  /* Bind the variable by Position. */
  err = OCIBindByPos(oci_ctxp->stmtp, 
                     &oci_ctxp->bnd1p, 
                     oci_ctxp->errhp, 
                     1,
                     r_id, 
                     r_len, 
                     SQLT_CHR, 
                     0,
                     0,
                     0,
                     0,
                     0, 
                     OCI_DEFAULT);
  check_err("ocibndp(rowid)", err, errbuf, oci_ctxp);
  
  /* Execute the Statement. */
  err = OCIStmtExecute(oci_ctxp->svchp, 
                       oci_ctxp->stmtp, 
                       oci_ctxp->errhp, 
                       1, 
                       0, 
                       NULL, 
                       NULL, 
                       OCI_DEFAULT);
  check_err("OCIStmtExecute", err, errbuf, oci_ctxp);
  
  /* Free the SQL statement handle. */
  err = OCIHandleFree(oci_ctxp->stmtp, 
                      OCI_HTYPE_STMT);
  check_err("OCIHandleFree", err, errbuf, oci_ctxp);
  
} /* UpdateSalary */







/* ------------------------------ PercentComm ------------------------------ */
/* PercentComm -  This function calculates the percentage of commission with 
 *  respect to salary and return the commission. If commission indicator is 
 *  OCI_IND_NULL it returns (float)0.0.
 * 
 */
#ifdef WIN32COMMON
__declspec(dllexport)
#endif

float PercentComm(salary, salary_ind, comm, comm_ind, return_ind)
float  salary;                                     /* salary passed by value */
short  salary_ind;                                   /* INDICATOR for salary */
float  comm;                                   /* commission passed by value */
short  comm_ind;                                 /* INDICATOR for commission */
short *return_ind;                               /* INDICATOR to return NULL */
{
  float tmpcomm;

  /* Check if salary or commission is NULL 
   */
  if ((salary_ind == OCI_IND_NULL) || (comm_ind == OCI_IND_NULL))
  {
    tmpcomm     = (float)0.0;
    *return_ind = (short)OCI_IND_NULL;
  }
  else
  {
    tmpcomm     = (float)(comm * 100 / salary); 
    *return_ind = (short)OCI_IND_NOTNULL;
  }

  return(tmpcomm);

} /* PercentComm */





/* --------------------------- PercentComm_ByRef --------------------------- */
/* PercentComm_ByRef -  This function is the same as function PercentComm 
 *  but uses doubles instead of  floats and the parameters are passed 
 *  By Reference.
 * 
 */
#ifdef WIN32COMMON
__declspec(dllexport)
#endif

double *PercentComm_ByRef(with_context, salary, salary_ind, 
                          comm, comm_ind, return_indicator)
OCIExtProcContext *with_context;                             /* With Context */
double            *salary;                           /* salary passed by ref */
short              salary_ind;                       /* INDICATOR for salary */
double            *comm;                         /* commission passed by ref */
short             *comm_ind;       /* INDICATOR for commission passed by ref */
short             *return_indicator;                     /* RETURN indicator */
{
  double *tmpdoubleptr;

  /* Allocate a double for the return. PL/SQL will free this
   * memory upon return from this function.
   *
   * CAUTION : You should not allocate an automatic variable ( on the
   *   C stack and return its address, since that memory location 
   *   is not guranteed to exist with valid data once this function
   *   returnns to PL/SQL
   */
  tmpdoubleptr = OCIExtProcAllocCallMemory(with_context, sizeof(double));
 
  if ((salary_ind == (short)OCI_IND_NULL) || 
      (*comm_ind == (short)OCI_IND_NULL) )
  {
    *tmpdoubleptr     = (double)0.0;
    *return_indicator = (short)OCI_IND_NULL;    /* Indicator NULL for return */
  }
  else
  { 
    *tmpdoubleptr     = (double)(*comm) * 100.0 / (double)(*salary);
    *return_indicator = (short)OCI_IND_NOTNULL;  /* Indicate not null return */
  }

  return(tmpdoubleptr);

} /* PercentComm_ByRef */





/* -------------------------------- EmpExp -------------------------------- */
/* EmpExp - This function finds the difference between hiredate and 
 *   current date and returns the number of years an employee worked 
 *   with the company.
 * 
 */
#ifdef WIN32COMMON
__declspec(dllexport)
#endif

void EmpExp(hiredate, hiredate_len, hiredate_ind, 
            num_experience, num_experience_ind)
char  *hiredate;
int    hiredate_len;                                   /* length of hiredate */
short  hiredate_ind;                               /* indicator for hiredate */
long  *num_experience;                        /* out : # years of experience */
int   *num_experience_ind;             /* out : indicator for num_experience */
{
  struct tm  *hire_date;
  double      diff;   /* variable to store the difference in time in seconds */
  double      diff_day;
  int         dd; 
  int         mm;
  int         yy;
  time_t      curr_time;                               /* store current time */
  char       *tok;

  /* Allocate some memory for hire_date. NOTE, since calloc is being
   * used to allocate the memory, PL/SQL has no knowledge of its
   * allocation and hence the meory thus allocated will not be freed
   * by PL/SQL. It is this functions responsibility to free such memory.
   *
   * After an alloc, typically, the program should check for errors !!
   */
  hire_date = (struct tm  *)calloc(1, sizeof(struct tm ));

  /* Parse the input date string which is in DD-MM-YY format 
   */
  tok = strtok(hiredate, "-");                             /* Get day string */
  dd = atoi(tok);                                      /* Convert to integer */
  tok = strtok(NULL, "-");                               /* Get month string */
  mm = atoi(tok);                                      /* Convert to integer */
  tok = strtok(NULL, "\0");                               /* Get Year String */
  yy = atoi(tok);                                      /* Convert to integer */

  hire_date->tm_mday = dd;
  hire_date->tm_mon  = mm;
  hire_date->tm_year = yy;

  /* Get the difference in seconds. */
  diff = (double)difftime( time(&curr_time), mktime(hire_date) );

  /* Free the memory previously allocated */
  free(hire_date);

  /* Convert seconds to years. */
  *num_experience = (long)(diff/(double)(60.0 * 60.0 * 24.0 * 365.0));
  *num_experience_ind = (int)OCI_IND_NOTNULL;     /* indicate not null value */

} /* EmpExp */






/* ----------------------------- CheckEmpName ----------------------------- */
/* CheckEmpName -  This function checks if the source (src_ename) 
 *    employee's name can be copied over to the destination (dst_ename). 
 *    If the copy can be made, it copies the src_ename to the dst_ename 
 *    else it raises the Numeric or value error.
 * 
 */
#ifdef WIN32COMMON
__declspec(dllexport)
#endif

int CheckEmpName(dst_ename, dst_ename_maxlen, 
                 src_ename, src_ename_length, with_context)
char *dst_ename;
sb4  *dst_ename_maxlen;                                            /* Maxlen */
char *src_ename;
sb4   src_ename_length;                                            /* Length */
OCIExtProcContext *with_context;                         /* With context ptr */
{

#define NUMERIC_OR_VALUE_ERROR  (int)(6502)

  if (src_ename_length < *dst_ename_maxlen)
  {
    /* Since the src_ename string length is less than the maxlength of 
     * the dst_ename string buffer, copy the src_ename into the dst_ename 
     */
    strcpy(dst_ename, src_ename);
    return((int)0);
  }
  else
  {
    /* Raise the numeric or value error */
    OCIExtProcRaiseExcp(with_context, NUMERIC_OR_VALUE_ERROR);

    /* immediately return back to PL/SQL */
    return((int)-1);
  }

  return((int)-1);   /* This code will never be executed, unless someone 
                        changes the above logic */

#undef NUMERIC_OR_VALUE_ERROR

} /* CheckEmpName */



/* ----------------------------- LobDemo -------------------------------- */
/* LobDemo -  This function demonstrates the usage of various OCI functions 
 *   on lob locators passed as IN, INOUT & OUT and returns a locator.
 *   It executes following OCI Lob functions:
 *   1. OCIDescriptorAlloc.
 *   2. OCILobAssign.
 *   3. OCILobCopy.
 *   4. OCILobGetLength.
 *   5. OCILobTrim.
 *   6. OCILobRead.
 *   7. OCILobWrite.
 */

#ifdef WIN32COMMON
__declspec(dllexport)
#endif

OCILobLocator *LobDemo ( with_context, lob_in, lob_inout, lob_out, ind_in, 
                          ind_inout, ind_out, ind_ret )
OCIExtProcContext *with_context;                             /* With Context */
OCILobLocator      *lob_in;                      /* Lob Locator passed as IN */
OCILobLocator     **lob_inout;               /* Lob Locator passed as IN OUT */
OCILobLocator     **lob_out;                    /* Lob Locator passed as OUT */
sb4                 ind_in;                           /* Indicator for lob_in*/
sb4                *ind_inout;                    /* Indicator for lob_inout */
sb4                *ind_out;                        /* Indicator for lob_out */
sb4                *ind_ret;                 /* Indicator for RETURN locator */
{
  ocictx         oci_ctx;
  ocictx         *oci_ctxp = &oci_ctx;
  OCILobLocator  *lob_ret;
  int            err;
  char           errbuf[512];
  ub1            local_buf[BUFLEN];
  ub4            len_in;
  ub4            len_inout;
  ub4            len_out;
  ub4            offset;
  ub4            amount;
  ub4            local_buflen;

 
  /* Obtain OCI handle for SQL statement using the context passed. */
  err = OCIExtProcGetEnv(with_context,                       /* With context */
                         &oci_ctxp->envhp,
                         &oci_ctxp->svchp,
                         &oci_ctxp->errhp);
  check_err("OCIExtProcGetEnv", err, errbuf, oci_ctxp);
  
  /*****  Test Assign lob_in to lob_inout *****/

  err = (int) OCILobAssign(oci_ctxp->envhp, 
                           oci_ctxp->errhp, 
                           lob_in, 
                           lob_inout);
  check_err("OCILobAssign", err, errbuf, oci_ctxp);

  /* Set indicator of lob_inout */
  *ind_inout = ind_in;


  /*****  Test Read from lob_in and Write to lob_out *****/

  /* Allocate a new lob descriptor for lob_out */
  err = OCIDescriptorAlloc(oci_ctxp->envhp, 
                           (dvoid **) lob_out,
                           (ub4) OCI_DTYPE_LOB,       /* Type of Descriptor */
                           (size_t) 0, 
                           (dvoid **) 0);
  check_err("OCIDescriptorAlloc", err, errbuf, oci_ctxp);

  /* Intialize the locator lob_ret by assigning lob_in to it */
  /* We can also initialize it by selecting a valid locator from the database */ 
  err = (int) OCILobAssign(oci_ctxp->envhp, 
                           oci_ctxp->errhp, 
                           lob_in, 
                           lob_out);
  check_err("OCILobAssign", err, errbuf, oci_ctxp);

  /* Trim lob_out to have length = 1 */
  err = (int) OCILobTrim(oci_ctxp->svchp, 
                         oci_ctxp->errhp, 
                         *lob_out,
                         (ub4)1);
  check_err("OCILobTrim", err, errbuf, oci_ctxp);

  /* Read the first 15 bytes of lob_in to local_buf. */
  amount = 15;
  offset = 1;
  local_buflen = BUFLEN;
  err = OCILobRead(oci_ctxp->svchp, 
                   oci_ctxp->errhp, 
                   lob_in, 
                   &amount, 
                   offset, 
                   (dvoid *) local_buf,
                   local_buflen, 
                   (dvoid *) 0, 
                   (sb4 (*)(dvoid *, CONST dvoid *, ub4, ub1 )) 0,
                   (ub2) 0, 
                   (ub1) SQLCS_IMPLICIT);
  check_err("OCILobRead", err, errbuf, oci_ctxp);

  /* Write to lob_out first 15 bytes from local_buf. */
  err = OCILobWrite(oci_ctxp->svchp, 
                    oci_ctxp->errhp, 
                    *lob_out, 
                    &amount, 
                    offset, 
                    (dvoid *) local_buf, 
                    (ub4) local_buflen, 
                    OCI_ONE_PIECE, 
                    (dvoid *)0, 
                    (sb4 (*)(dvoid *, dvoid *, ub4 *, ub1 * )) 0, 
                    (ub2)0, (ub1)SQLCS_IMPLICIT); 
  check_err("OCILobWrite", err, errbuf, oci_ctxp);

  /* Set indicator of lob_out */
  *ind_out = ind_in;

  /*****  Test Copy lob_inout to lob_ret *****/

  /* Allocate a new lob descriptor for lob_ret */
  err = OCIDescriptorAlloc(oci_ctxp->envhp, 
                           (dvoid **) &lob_ret,
                           (ub4) OCI_DTYPE_LOB,       /* Type of Descriptor */
                           (size_t) 0, 
                           (dvoid **) 0);
  check_err("OCIDescriptorAlloc", err, errbuf, oci_ctxp);

  /* Intialize the locator lob_ret by assigning lob_in to it */
  err = (int) OCILobAssign(oci_ctxp->envhp, 
                           oci_ctxp->errhp, 
                           lob_in, 
                           &lob_ret);
  check_err("OCILobAssign", err, errbuf, oci_ctxp);

  /* Copy first 25 bytes from lob_inout to lob_ret with source and destination */
  /* offsets set to 1 */
  amount = 25;
  err = OCILobCopy(oci_ctxp->svchp,
                   oci_ctxp->errhp,
                   lob_ret,
                   *lob_inout, 
                   amount,
                   (ub4) 1,
                   (ub4) 1);
  check_err("OCILobCopy", err, errbuf, oci_ctxp);

  /* Set indicator of lob_ret */
  *ind_ret = *ind_inout;

  /* Return lob_ret locator back to PL/SQL */
  return(lob_ret);
}

/* end of file extproc.c */
