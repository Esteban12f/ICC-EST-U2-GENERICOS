import models.Persona;
import models.genericos.Caja;
import models.genericos.Par;

public class App {
    public static void main(String[] args) throws Exception {
        Caja<String> cajaString = new Caja<>();
        Caja<Integer> cajaInteger = new Caja<>();
        Caja<Persona> cajaPersona = new Caja<>();

        Par<Integer,String> parIntegerString = new Par<>();
        Par<String,Integer> parStringInteger = new Par<>();

        Persona[] personas = { new Persona("Vicente", 15),
        new Persona("Sofia", 23),
        new Persona("Javier", 31),
        new Persona("Beatriz", 9),
        new Persona("Marcos", 28),
        new Persona("Carmen", 17),
        new Persona("Roberto", 33),
        new Persona("Patricia", 29),
        new Persona("Fernando", 11),
        new Persona("Elena", 22) 
                            };

        

        Persona persona = new Persona();
        persona.setNombre("Esteban");
        persona.setEdad(18);

        cajaString.guardar("Guardado un String");
        cajaInteger.guardar(10);
        cajaPersona.guardar(persona);

        System.out.println(cajaString.obtener());
        System.out.println(cajaInteger.obtener());
        System.out.println(cajaPersona.obtener().getNombre());

        parIntegerString.establecerClave(1);
        parIntegerString.establecerValor("o");

        parStringInteger.establecerClave("i");
        parStringInteger.establecerValor(2);
        
        System.out.println(parIntegerString.obtenerValor() + parIntegerString.obtenerClave());
        System.out.println(parStringInteger.obtenerValor() + parStringInteger.obtenerClave());


        /////////////////////////////////////////////////////////////////////////////////////////

        int personasMayores = 0;
        int personasMenores = 0;
        for (int i = 0; i < personas.length; i++){
            if (personas[i].getEdad() < 18){
                personasMenores ++;
            } else {
                personasMayores ++;
            }
        }

        Par<String, Integer>[] mayores = new Par[personasMayores];
        Par<Integer, String>[] menores = new Par[personasMenores];

        int contadorMayores = 0;
        int contadorMenores = 0;

        for (int i = 0; i < personas.length; i++){
            if (personas[i].getEdad() < 18){
                menores[contadorMenores] = new Par<Integer, String>();
                menores[contadorMenores].establecerClave(personas[i].getEdad());
                menores[contadorMenores].establecerValor(personas[i].getNombre());
                contadorMenores ++;
            } else {
                mayores[contadorMayores] = new Par<String, Integer>();
                mayores[contadorMayores].establecerClave(personas[i].getNombre());
                mayores[contadorMayores].establecerValor(personas[i].getEdad());
                contadorMayores ++;
            }
        }


        System.out.println("Mayores de edad: ");
        for(Par<String, Integer> par : mayores){
            System.out.println(par.obtenerClave() + "  - " + par.obtenerValor());
        }

        System.out.println("");

        System.out.println("Menores de edad:");
        for(Par<Integer, String> par : menores){
            System.out.println(par.obtenerClave() + "  - " + par.obtenerValor());
        }


    }
}
