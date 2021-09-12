package projeto_extencao;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BDSistema {
    
    ArrayList<Cliente> TCliente;
    int codUnicoCliente = 1;
        
    void criaTCliente (){
        TCliente = new ArrayList<Cliente>();
    }
       
    void cadastraCliente (){
        Cliente C = new Cliente();
        C.recebeDadosCliente(codUnicoCliente);
        TCliente.add(C);
        codUnicoCliente ++;
        JOptionPane.showMessageDialog(null,"CLIENTE CADASTRADO COM SUCESSO!","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
        mostrarMenu();
    }

    void imprimeTCliente (){
        System.out.println("\n_____|* CLIENTES CADASTRADOS *|_____");
        int i;
        for (i = 0; i < TCliente.size(); i++){ 
        TCliente.get(i).imprimeCliente(); 
        }
        System.out.println("____________________________________");
        mostrarMenu();
    }
//________________________________________________________________________________________________________________________________________________________________________
    
    public ArrayList<Entregador> TEntregador;
    int codUnicoEntregador = 1;
        
    void criaTEntregador (){
        TEntregador = new ArrayList<Entregador>();
    }

    void cadastraEntragador (){
        Entregador E = new Entregador();
        E.recebeDadosEntregador(codUnicoEntregador);
        TEntregador.add(E);
        codUnicoEntregador++;
        JOptionPane.showMessageDialog(null,"ENTREGADOR CADASTRADO COM SUCESSO!","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
        mostrarMenu();
    }

    void imprimeTEntregador(){
        System.out.println("\n_____|* ENTREGADORES CADASTRADOS *|_____");
        int i;
        for (i = 0; i < TEntregador.size(); i++){
        TEntregador.get(i).imprimeDadosEntregador();
        }
        System.out.println("________________________________________");
        mostrarMenu();
    }

//________________________________________________________________________________________________________________________________________________________________________

    ArrayList<Entrega> TEntrega;
    int codUnicoEntrega = 1;
        
    void criaTEntrega (){
        TEntrega = new ArrayList<Entrega>();
    } 
    
    public void cadastraEntrega (){
        int k, n, j;
        Entrega G = new Entrega();
        
        G.codReme = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do Cliente Remetente: "));
        for (k = 0; k < TCliente.size(); k++){ 
            if (TCliente.get(k).codCliente == G.codReme) { 
               break;
            }  
        }   
        if (k == TCliente.size()) {
            JOptionPane.showMessageDialog(null,"ERRO!","ERRO",JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        
        G.codDest = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do Cliente Destinatario: "));
        for (j = 0; j < TCliente.size(); j++){ 
            if (TCliente.get(j).codCliente == G.codDest){
                break;
            } else if (j == TCliente.size()) {
                JOptionPane.showMessageDialog(null,"ERRO!","ERRO",JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            } 
        } 
        if (G.codReme == G.codDest){ 
            JOptionPane.showMessageDialog(null,"ERRO! OS CODIGOS DE REMETENTE E DESTINATARIO NÃO PODEM SER IGUAIS!","ERRO",JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        
        G.codEntregadorE = Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo do Entregador que deseja contratar: "));
        for (n = 0; n < TEntregador.size(); n++){ 
            if (TEntregador.get(n).codEntregador == G.codEntregadorE){
                break;
            }     
        }
        if (n == TEntregador.size()) {
            JOptionPane.showMessageDialog(null,"ERRO!","ERRO",JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        
        G.valorEntrega = Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor da Entrega - R$"));
        
        double addComissao = 0.0;
        for (n = 0; n < TEntregador.size(); n++){
            if (TEntregador.get(n).codEntregador == G.codEntregadorE){
                addComissao = G.valorEntrega * 0.10;
                TEntregador.get(n).comissao = TEntregador.get(n).comissao + addComissao; 
            }
        }
        
        G.recebeCodEntrega(codUnicoEntrega);
        TEntrega.add(G);
        codUnicoEntrega++;
        TCliente.get(k).quantEntrega++;
        JOptionPane.showMessageDialog(null,"ENTREGA CADASTRADA COM SUCESSO!","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
        mostrarMenu();
    }
          
    void imprimeTEntrega(){
        System.out.println("\n_____|* ENTREGAS CADASTRADAS *|_____");
        int e;
        for (e = 0; e < TEntrega.size(); e++){
            TEntrega.get(e).imprimeDadosEntrega();
        }
        System.out.println("____________________________________");
        mostrarMenu();
    }

//________________________________________________________________________________________________________________________________________________________________________
    
    void calculaBalanco (){
        int b;
        double balanco = 0.0;
        for (b = 0; b < TEntrega.size(); b++){
            balanco += TEntrega.get(b).valorEntrega; 
        }
        balanco = balanco - balanco * 0.10;
        JOptionPane.showMessageDialog(null,"Este é o Balanço Atual - R$" + balanco);
        mostrarMenu();
    }
    
//________________________________________________________________________________________________________________________________________________________________________    
    
    void mostrarMenu(){  
    
    int escolha;
    
    escolha = Integer.parseInt(JOptionPane.showInputDialog (null,"[1] - Cadastrar Cliente"+
                                                            "\n[2] - Cadastrar Entregador"+ 
                                                            "\n[3] - Cadastrar Entrega"+
                                                            "\n[4] - Imprimir Clientes"+
                                                            "\n[5] - Imprimir Entregadores"+ 
                                                            "\n[6] - Imprimir Entregas"+
                                                            "\n[7] - Imprimir Balanço"+
                                                            "\n[0] - Fechar Sistema"+
                                                            "\nEscolha uma das opções acima e confirme com ENTER: ", "SISTEMA DE LOGÍSTICA",JOptionPane.INFORMATION_MESSAGE));
        switch (escolha) {
            case 1 -> {
                cadastraCliente();
            }
            case 2 -> {
                cadastraEntragador();
                break;
            }   
            case 3 -> {
                cadastraEntrega();
                break;
            }
            case 4 -> {
                imprimeTCliente();
                break;
            }
            case 5 -> {
                imprimeTEntregador();
                break;
            }
            case 6 -> {
                imprimeTEntrega();
                break;
            }
            case 7 -> {
                calculaBalanco();
                break;
            }
            case 0 -> {
                System.exit(0);
            }
            default -> {
                comandoInvalido();
                break;
            }
        }
    }
 
//________________________________________________________________________________________________________________________________________________________________________   
    
    void comandoInvalido (){
        JOptionPane.showMessageDialog(null, "Comando Inválido!");
        mostrarMenu();
    }
}
