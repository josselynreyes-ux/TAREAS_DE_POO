import java.util.ArrayList;
import java.util.Scanner;
public class GestionPrecios {
    //Creamos el array donde se guardaran o almacenaran todos los precios
    ArrayList<Double> precios = new ArrayList<>();

    //creamos el objeto scanner
    Scanner sc = new Scanner(System.in);

    //METODOS PARA LOS PRECIOS

    //metodo para ingresar un precio
    public void ingresarPrecio(){
        double precio;
        System.out.println("Ingrese un precio: ");
        precio = sc.nextDouble();
        sc.nextLine();
        if (precio <= 0){
            System.out.println("No puede ingresar precios negativos o igual a cero.");
        }else{
            precios.add(precio);
            System.out.println("El precio se agrego correctamente.");
        }
    }

    //metodo para mostrar los precios
    public void mostrarPrecios(){

        if (precios.isEmpty()){
            System.out.println("No hay precios agregados.");
            return;
        }else{
            System.out.println("---- Precios registrados ----");
            for(double precio : precios){
                System.out.println(precio);
            }
        }
    }

    //metodo para mostrar el precio mas alto
    public void precioAlto(){
        if (precios.isEmpty()){
            System.out.println("No hay precios agregados.");
            return;
        }else{
            //se inicializa la variable max con el primer elemento (posicion 0)
            // de la lista para poder recorrer
            double maximo=precios.get(0);
            for (double precio : precios){
                if (precio > maximo){
                    maximo = precio;
                }
            }
            System.out.println("El precio más alto de la lista es: $" + maximo);
        }
    }

    //metodo para mostrar el precio mas bajo
    public void precioBajo(){
        if (precios.isEmpty()){
            System.out.println("No hay precios agregados.");
        }else{
            double minimo = precios.get(0);
            for(double precio : precios){
                if (precio<minimo){
                    minimo = precio;
                }
            }
            System.out.println("El precio más bajo de la lista es: $" +minimo);

        }
    }

    //metodo para mostrar precios iguales en la lista
    public void preciosIguales(){
        //pondremos un dato de tipo booleano para poder marcar
        //true cuando se encuentre un precio duplicado
        boolean duplicado = false;
        if (precios.isEmpty()){
            System.out.println("No hay precios agregados.");
        }else{
            //usuaremos un for anidado para poder recorrer los indices
            // y asi podeer encontrar los numeros similares
            for (int i = 0; i < precios.size(); i ++){
                //usamos j = i +1 para evitar comparar el mismo precio
                //consigo mismo
                for (int j = i + 1; j < precios.size(); j ++){
                    //aqui hacemos la validacion de si son iguales con .equals()
                    if (precios.get(i).equals(precios.get(j))){
                        System.out.println("Los precios iguales en la lista son: $"+ precios.get(i));
                        duplicado = true;
                    }
                }
            }
            if(!duplicado){
                System.out.println("No existen precios duplicados.");
            }
        }
    }

    //metodo para buscar un elemento en especifico
    public void buscarPrecio(){
        //usamos de igual manera un booleano para poder demostrar
        //que se ha encontrado el precio a buscar
        boolean encontrado = false;
        if (precios.isEmpty()){
            System.out.println("No hay precios agregados.");
        }else{
            double precioB;
            System.out.println("Ingrese el precio a buscar: ");
            precioB=sc.nextDouble();
            sc.nextLine();
            if (precioB<=0){
                System.out.println("No puede ingresar un numero negativo o cero.");
            }else {
                for (double precio : precios){
                    if (precio == precioB){
                        System.out.println("El precio que usted busca se encuentra en la lista.");
                        encontrado = true;
                        break;
                    }
                }
            }
            if (!encontrado){
                System.out.println("El precio que busca no se encuentra en la lista.");
            }
        }
    }

    //creamos un metodo para guardar el menu principal
    public void menu(){
        int opcion;
        while(true){
            System.out.println("---- El menu de Joss ----");
            System.out.println("1. Ingresar precio");
            System.out.println("2. Mostrar todos los precios");
            System.out.println("3. Mostrar precio mas alto");
            System.out.println("4. Mostrar precios mas bajo");
            System.out.println("5. Mostrar precios iguales");
            System.out.println("6. Buscar un precio en especifico");
            System.out.println("7. Salir");
            System.out.println("Selecciona una opcion: ");
            opcion=sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    ingresarPrecio();
                    break;
                case 2:
                    System.out.println("Registro de precios");
                    mostrarPrecios();
                    break;
                case 3:
                    System.out.println("Precio más alto en la lista");
                    precioAlto();
                    break;
                case 4:
                    System.out.println("Precio más bajo en la lista");
                    precioBajo();
                    break;
                case 5:
                    System.out.println("Precio duplicado en la lista");
                    preciosIguales();
                    break;
                case 6:
                    buscarPrecio();
                    break;
                case 7:
                    System.out.println("Saliendo del menu de Joss.");
                    return;
                default:
                    System.out.println("Ingrese una opción valida");
                    break;
            }
        }
    }

    public static void main (String [] args){
        System.out.println("----- BIENVENID@ AL SISTEMA DE JOSS ----");
        // creamos el objeto para poder ejecutar el programa
        //esto es porque los metodos NO SON ESTATICOS, entonces requieren
        //obligatoriamente de un objeto.
        GestionPrecios objeto1 = new GestionPrecios();
        objeto1.menu();
    }

}
