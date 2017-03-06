package jettyJava.server;


public class Server {
    
    public static void start(){
        org.eclipse.jetty.server.Server s = new org.eclipse.jetty.server.Server( 8888 );
        s.setHandler( new Handler() {} );
        try{
            s.start();
            s.join();
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        start();
    }
    
}