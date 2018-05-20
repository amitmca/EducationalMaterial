#include <curses.h>
int main(void)
{

   /* initialize the curses library */
    initscr();      
    printf("\nPresss....");	
    cbreak();       /* take input chars one at a time, no wait for \n */
    echo();         /* echo input - in color */
   
 /* now put rest of logic below */
   
       endwin();       /* must be called when done */
}
