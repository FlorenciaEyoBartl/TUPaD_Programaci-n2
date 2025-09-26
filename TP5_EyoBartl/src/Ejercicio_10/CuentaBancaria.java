
package Ejercicio_10;


// Clase CuentaBancaria (Composición y Asociación Bidireccional)
public class CuentaBancaria {
    private String cbu;
    private double saldo;
    private Titular titular;         // Asociación bidireccional
    private ClaveSeguridad clave;    // Composición

    public CuentaBancaria(String cbu, double saldo, String codigoClave, String ultimaModificacion) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.clave = new ClaveSeguridad(codigoClave, ultimaModificacion); // composición
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
        if (titular != null && titular.getCuenta() != this) {
            titular.setCuenta(this); // mantiene coherencia evitando bucles infinitos
        }
    }

    public Titular getTitular() {
        return titular;
    }

    public String getCbu() {
        return cbu;
    }

    public double getSaldo() {
        return saldo;
    }

    public ClaveSeguridad getClave() {
        return clave;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public boolean retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}
