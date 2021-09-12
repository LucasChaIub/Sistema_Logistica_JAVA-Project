package projeto_extencao;

public class Projeto_Extencao { 
    public static void main(String[] args) {
        BDSistema BDsis = new BDSistema();
        BDsis.criaTCliente();
        BDsis.criaTEntregador();
        BDsis.criaTEntrega();
        BDsis.mostrarMenu();
    } 
}
