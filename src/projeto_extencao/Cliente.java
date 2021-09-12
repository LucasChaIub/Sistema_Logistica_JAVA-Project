package projeto_extencao;

import javax.swing.JOptionPane;

public class Cliente {
    int codCliente;
    String nomeCliente;
    int quantEntrega = 0;
    
    void recebeDadosCliente (int codC){
        codCliente = codC;
        
        nomeCliente = JOptionPane.showInputDialog("Digite o nome do Cliente: ");
    } 
    
    void imprimeCliente (){
        System.out.println ("\nCodigo do Cliente: " + codCliente);
        System.out.println ("Nome do Cliente: " + nomeCliente);
        System.out.println ("Quantide de Entregas: " + quantEntrega);
    }
}
