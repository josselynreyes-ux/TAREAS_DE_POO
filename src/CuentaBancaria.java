public class CuentaBancaria {
    private double saldo = 0;
    private String titular;

    public CuentaBancaria(double saldo, String titular){
        setSaldo(saldo);
        this.titular=titular;
    }

    public void setSaldo(double nuevoSaldo){
        if(nuevoSaldo<=0){
            System.out.println("El saldo ingresado no puede ser menor a cero.");
        }else{
            this.saldo= nuevoSaldo;
            System.out.println("Saldo ingresado correctamente.");
        }
    }
    public double getSaldo(){
        return saldo;
    }

    public void depositarSaldo(double monto){
        if (monto<=0){
            System.out.println("Su deposito de "+ monto +" no se puede procesar por ser cero o negativo.");
        }else{
            saldo += monto; /*saldo = saldo + monto*/
            System.out.println("Su deposito de "+ monto +" esta realizado.");
        }
    }

    public void retirarSaldo(double monto){
        if(monto <= 0){
            System.out.println("Su retiro de " + monto +" no se puede procesar por ser cero o negativa.");
        } else if(monto > saldo){
            System.out.println("Su retiro de " + monto+ " no se puede procesar por saldo insuficiente.");
        } else {
            saldo -= monto;
            System.out.println("Retiro de "+monto+" exitoso.");
        }
    }


    public void mostrarDatos(){
        System.out.println("----Datos bancarios----");
        System.out.println("Nombre del titular: "+ titular);
        System.out.println("Saldo actual: "+ saldo);
        System.out.println("-----------------------");
    }

    public static void main(String[]args ){
        CuentaBancaria objeto1=new CuentaBancaria(300,"Josselyn");

        objeto1.depositarSaldo(200.50);
        objeto1.mostrarDatos();

        objeto1.depositarSaldo(-10);

        objeto1.retirarSaldo(50.50);
        objeto1.mostrarDatos();

        objeto1.retirarSaldo(8000);

        objeto1.retirarSaldo(-24);

    }

}
