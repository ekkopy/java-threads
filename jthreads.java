import java.io.*;
import java.net.*;

public class JThreads extends Testethread {
	
	public JThreads(int a, int b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws UnknownHostException, IOException{
	    
			    
		Testethread trd1, trd2, trd3;
	    
		int a = 2;
	    int b = 51;
	    
		trd1 = new Testethread(a,b);
	    trd2 = new Testethread(a,b);
	    trd3 = new Testethread(a,b);
	   
	    trd1.setName("THREAD_1");
	    trd2.setName("THREAD_2");
	    trd3.setName("THREAD_3");
	    
	    trd1.start();
	    trd2.start();
	    trd3.start();
	    
	}
	   
 
}

class Testethread extends Thread {
	
	int inicio, fim;
	String ip;
	
	public Testethread(int a, int b) {
	  inicio = a;
	  fim = b;
	}
	   
       public void run() {

    	   for(int i = inicio; i<= fim; i++) {
    		 
    		     ip = "10.17.8." + i;
    		         		 
    	   	     InetAddress requisicao = null;
				try {
					requisicao = InetAddress.getByName(ip);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     System.out.println("Enviando pacote para : " + ip);
			     try {
					if (requisicao.isReachable(5000)){
					    System.out.println(getName() + " realizando ping sucedido!");
					 } else {
					    System.out.println("Error");
					 }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     
    	   } 
       }
}



