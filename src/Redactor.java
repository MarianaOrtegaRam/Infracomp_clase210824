public class Redactor extends Thread {

    private Archivo archivo; 
    private String modidicaciones;

    public void run(){
        archivo.entroEscribir();
        archivo.escribir(modidicaciones);

    }

}
