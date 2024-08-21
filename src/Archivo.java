public class Archivo {

    private int nRedactores = 0;
    private int nLectores = 0;

    /*
    Debo crear procedemiento que entre a escribir o entré a leer
    */

    public synchronized  void entroEscribir() throws InterruptedException{
        /*
        Se que puedo usar el recurso cuando hay 0 lectores
        */
        if ((nLectores > 0) || (nRedactores > 0)){
            wait();
        }
        nRedactores++;
        //aca se pueden quedar esperando mucho tiempo 

    }

    public synchronized  void entroLeer() throws InterruptedException{
        if(nRedactores > 0){
            wait();
        }
        nLectores++;
        //aca son educaditos y van entrando lento, es como si hay un guardia 
        
    }

    public synchronized  void salirEscribir() throws InterruptedException{
        
        nRedactores--;
        // podemos despertar a cualquiera entonces hacenos la siguiente instruccion
        notifyAll();
        
    }

    
    public synchronized  void salirLeer() throws InterruptedException{
        
        nLectores--;
        // si hay quedan cero lectores, es decir acaba de salir el ultimo, solo hago notify porque soloo quedan redactores,y esos entran de a uno
        notify();
        
    }
}
