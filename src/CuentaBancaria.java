public class CuentaBancaria {

    private String nombreTitular;
    private double saldo;

    public CuentaBancaria(String nombreTitular, double saldo){

        this.nombreTitular= nombreTitular;
        this.saldo= saldo;

    }

    public void mostrarInformacion(){

        System.out.println("--------------------------------------------");
        System.out.println("Nombre del titular:  "+nombreTitular);
        System.out.println("Saldo actual:  "+saldo);
        System.out.println("--------------------------------------------");
    }

    public void depositar(double monto){
        if (monto<=0){
            System.out.println("El monto no puede ser menos o igual a cero.");
        }else{
            saldo += monto;
            System.out.println("Se han agregado $ "+ monto + " a su cuenta bancaria.");
        }
    }

    public void retirar(double monto){
        if (monto >0 ){
            if (saldo >= monto){
                saldo-=monto;
                System.out.println("Retiro de $ "+ monto +" exitoso.");
            }else{
                System.out.println("Saldo insuficiente.");
            }
        }else {
            System.out.println("El monto no puede ser menos o igual a cero.");
        }
    }

    public static void main(String [] args ){

        CuentaBancaria objeto1= new CuentaBancaria("Josselyn", 800.0);
        objeto1.mostrarInformacion();
        objeto1.depositar(200.0);
        objeto1.mostrarInformacion();
        /*caso 1 saldo suficiente*/
        objeto1.retirar(150.0);
        objeto1.mostrarInformacion();
        /*caso 2 saldo insuficiente*/
        objeto1.retirar(2000.0);
        objeto1.mostrarInformacion();

    }

}
