class Counter implements Runnable {
    
    //method where the thread execution will start 
    public void run(){
        System.out.println("hello");
    }
 
    //let’s see how <span id="IL_AD4" class="IL_AD">to start</span> the threads
    public static void main(String[] args){
       Thread t1 = new Thread(new Counter());
       Thread t2 = new Thread(new Counter());
       t1.start();  //start the first thread. This calls the run() method.
       t2.start(); //this starts the 2nd thread. This calls the run() method.  
    }
}