public class Archivo {


    //ejeuctando
    //dormido
    //listo para ejecutar
    private int nRedactores = 0;
    private int nLectores = 0;

    /*
    en bloquyes sincronos hay exclusion mutua, pero cuando entra a uyn wait
     el thread queda dormido, y libera el monitor y deja cualquier thread a entrar a los metodos sincronos
    */


    /*
    Debo crear procedemiento que entre a escribir o entré a leer
    */

    public synchronized  void entroEscribir(){

        /* 
        
    
        Se que puedo usar el recurso cuando hay 0 lectores
    
        if ((nLectores > 0) || (nRedactores > 0)){
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        nRedactores++;
        //aca se pueden quedar esperando mucho tiempo 

        */



        while ((nLectores > 0) || (nRedactores > 0)){
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        nRedactores++;
        //aca se pueden quedar esperando mucho tiempo 

        
    }

    public synchronized  void entroLeer() {
        /*
        if (nRedactores > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        nLectores++;
        //aca son educaditos y van entrando lento, es como si hay un guardia 
        Habrá alhuno que llegue primero, si por ejemplo es iun lector, le suma uno a los lectores, y los otros 
        threads esperando quedaron despiertos, entonces por ejemplo si entra un redactor se los suma,entonces hay redactors sy lectores en el mismo archivo
        
        */


        //Ahora si uso el while, evito que se despierten los demas, entonces cuando entren los demas threads van a tener que revisar la condición 
        while (nRedactores > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        nLectores++;
        //aca son educaditos y van entrando lento, es como si hay un guardia 
        
        
    }

    public synchronized  void salirEscribir() {
        
        nRedactores--;
        // podemos despertar a cualquiera entonces hacenos la siguiente instruccion
        notifyAll();
        
    }

    
    public synchronized  void salirLeer() {
        
        nLectores--;
        // si hay quedan cero lectores, es decir acaba de salir el ultimo, solo hago notify porque soloo quedan redactores,y esos entran de a uno
        notify();
        
    }

    public void escribir(String texto){
    /*
    Cuando entra aca, es porque uno está escribiendo y los demas están obligatoriamente dormidos, entonces nadie va apoder entrar
    por el wait (linea 25 )
    */
     //TODO DE LO QUE SE HACE PARA CAMBIAR EL ARCHIVO ... 

    }

    public void leer(){
        
    }
}
