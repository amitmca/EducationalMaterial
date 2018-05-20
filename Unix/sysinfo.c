       #include <sys/sysinfo.h>

 struct sysinfo1 {
                   long uptime;             /* Seconds since boot */
                   unsigned long loads[3];  /* 1, 5, and 15 minute load averages */
                   int totalram;  /* Total usable main memory size */
                   unsigned long freeram;   /* Available memory size */
                   unsigned long sharedram; /* Amount of shared memory */
                   unsigned long bufferram; /* Memory used by buffers */
                   unsigned long totalswap; /* Total swap space size */
                   unsigned long freeswap;  /* swap space still available */
                   unsigned short procs;    /* Number of current processes */
                   char _f[22];             /* Pads structure to 64 bytes */
              };
struct sysinfo1 mys;
main()
	{
	system("clear");
	printf("%d\t%d\n",mys.uptime,mys.totalram);
	}
