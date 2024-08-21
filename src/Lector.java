public class Lector extends Thread {

    private Archivo archivo;

    public void run(){
        archivo.entroLeer();
        archivo.leer();
        archivo.salirLeer();
        
    }

}
