package model;

public class Wallet {

    public static final int CAPACIDAD_MAXIMA = 1000000;

    private int saldo; 
    private boolean tieneLimite;
    private int meta;

    public Wallet() {
        super();
        saldo = 0;
        tieneLimite = true;
        meta = 0;
    }

    public int getSaldo(){
        return saldo;
    }

    public boolean getTieneLimite(){
        return tieneLimite;
    }

    public void setTieneLimite(boolean newTieneLimite) { 
        tieneLimite = newTieneLimite;
    }

    public String saveMoney(int value){
        if (saldo + value > CAPACIDAD_MAXIMA && tieneLimite) {
            return "No se puede superar el limite " + CAPACIDAD_MAXIMA;
        }
        saldo += value;
        if(verificarMeta()){System.out.println("Has cumpledo la meta!");}
        return "Transacción exitosa, nuevo saldo " + saldo;
    }

    public String getMoney(int value){
        if (value > saldo){
            return "Fondos Insuficientes";
        }
        saldo = saldo - value;
            return "Transacción exitosa, retiraste: "+ value + "Tu nuevo saldo es: " + saldo;
    }

    public String breakLimits() {
        if(!tieneLimite){
            return "La cuenta no tiene limites";
        }
        if (saldo >= 10000){
            saldo = saldo - 10000;
            setTieneLimite(false);
            return "Transacción exitosa, su cuenta ahora no tiene limites, su nuevo saldo es: " + saldo;
        }
        return "No tiene saldo suficiente para realizar esta transacción";
    }

    public boolean establecerMeta(int value){
        if(value == 0){
            meta = value;
            return true;
        }
        if(value < 0 || value <= saldo || (value > CAPACIDAD_MAXIMA && tieneLimite)){
            return false;       
        }
        meta = value;
        return true;
    }

    public boolean verificarMeta() {
        //Antes de cambiarlo a boolean
        //if(value > 0 && value > saldo && tieneLimite == false){
          //  return "Su meta se estableció en: " + value + "su saldo es: " + saldo ;
        if (meta == 0 || meta > saldo){
            return false;
        }
        return true;
        


    }
}
