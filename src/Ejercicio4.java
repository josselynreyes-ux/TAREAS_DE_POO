import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        double pago;
        System.out.println("----- Banco de Joss -----");
        System.out.println("Ingrese el pago de su producto: ");
        pago = sc.nextDouble();

        try {
            if (pago<=0 || pago >5000){
                throw new PagoInvalidoException("El pago es invalido.");
            }else{
                System.out.println("Pago realizado exitosamente.");
            }
        }catch(PagoInvalidoException e){
            System.out.println("----- ¡ERROR! -----");
            System.out.println(e.getMessage());
        }
    }
}
