package projeto_extencao;

public class Entrega {
    int codEntrega;
    int codDest;
    int codReme;
    int codEntregadorE;
    double valorEntrega;
       
    void recebeCodEntrega (int codG){
        codEntrega = codG;
    }
    
    void imprimeDadosEntrega (){
        System.out.println ("\nCodigo da Entrega: " + codEntrega); 
        System.out.println ("Codigo do Cliente Destinatário: " + codDest); 
        System.out.println ("Codigo do Cliente Remetente: " + codReme);  
        System.out.println ("Código do Entregador: " + codEntregadorE);  
        System.out.println ("Valor do Entrega - R$" + valorEntrega);  
    }
}
