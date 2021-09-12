package projeto_extencao;

import javax.swing.JOptionPane;

public class Entregador {
    int codEntregador;
    String nomeEntregador;
    double comissao = 0;
    
    void recebeDadosEntregador (int codE){
        codEntregador = codE;
        
        nomeEntregador = JOptionPane.showInputDialog("Digite o nome do Entregador: "); 
    }
    
    void imprimeDadosEntregador (){
        System.out.println ("\nCodigo do Entregador: " + codEntregador);  
        System.out.println ("Nome do Entregador: " + nomeEntregador);
        System.out.println ("Comissão Atual: " + comissao); 
    }
}
