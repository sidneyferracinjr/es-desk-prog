package JleituraEscritaByteInterfaceGrafica;

import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author fabricio@utfpr.edu.br
 */
public class JanelaClienteAula extends javax.swing.JFrame {

    private ControllerArquivoBinario controller
            = new ControllerArquivoBinario();

    /**
     * Creates new form JanelaCliente
     */
    public JanelaClienteAula() {
        initComponents();
    }

    // O método `limparCampos` redefine os campos de entrada para seus valores padrão (nome e telefone vazios, idade para 0) e coloca o foco no campo de nome.
    public void limparCampos() {
        TFNome.setText("");
        TFFone.setText("");
        jSIdade.setValue(0);
        TFNome.requestFocus();
    }

    // O método `atribuirCampos` preenche os campos da interface com os dados de um objeto `Cliente` e coloca o foco no campo de nome.
    public void atribuirCampos(Cliente cliente) {
        TFNome.setText(cliente.getNome());
        TFFone.setText(cliente.getFone());
        jSIdade.setValue(cliente.getIdade());
        TFNome.requestFocus();
    }

    // O método `criaCliente` cria um novo objeto `Cliente` com os dados fornecidos nos campos de entrada e o define no controlador.
    public void criaCliente() {
        Cliente cliente = new Cliente(
                TFNome.getText(),
                TFFone.getText(),
                (Integer) jSIdade.getValue());
        controller.setCliente(cliente);
    }

    // O método `salvarArquivo` verifica se há um arquivo definido para salvar, cria um cliente, grava os dados no arquivo e retorna `true` se bem-sucedido, ou `false` caso contrário.
    public boolean salvarArquivo() {
        controller.setArquivo("Salvar");
        if (controller.getArquivo() != null) {
            criaCliente();
            controller.escrever(false);
            return true;
        } else {
            return false;
        }
    }

    // O método `abrirArquivo` tenta abrir um arquivo, lê os dados se o arquivo existir, preenche os campos com o cliente lido e retorna `true` se bem-sucedido; caso contrário, retorna `false`.
    public boolean abrirArquivo() {
        controller.setArquivo("Abrir");
        if (controller.getArquivo() != null) {
            if (controller.ler()) {
                atribuirCampos(controller.getCliente());
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // implementado
    // O método `ExibeTabela` cria uma tabela com cabeçalhos ("Nome", "Fone", "Idade") e registros baseados nos dados do cliente no controlador, exibe a tabela na interface e atualiza sua renderização.
    private void ExibeTabela() {
        final Vector cabecalhos = new Vector();
        final Vector registros = new Vector();

        // obtem titulos de coluna
        cabecalhos.addElement("Nome");
        cabecalhos.addElement("Fone");
        cabecalhos.addElement("Idade");

        Vector registro = new Vector();
        registro.addElement(controller.getCliente().getNome());
        registro.addElement(controller.getCliente().getFone());
        registro.addElement(controller.getCliente().getIdade());

        registros.addElement(registro);
        registros.addElement(registro);
        registros.addElement(registro);

        if (jTable2 != null) {
            remove(jTable2);
            remove(jScrollPane2);
        }
        jTable2 = new JTable(registros, cabecalhos);
        // exibe a tabela com conteudos de ResultSet
        jScrollPane2 = new JScrollPane(jTable2);
        add(jScrollPane2);
        jScrollPane2.setBounds(10, 320, 710, 180);
        validate();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TFNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TFFone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSIdade = new javax.swing.JSpinner();
        jBtnProximo = new javax.swing.JButton();
        jBtnFechar = new javax.swing.JButton();
        jBtnAnterior = new javax.swing.JButton();
        jBtnGravar = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(3, 20, 80, 30);
        getContentPane().add(TFNome);
        TFNome.setBounds(90, 20, 220, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fone:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 60, 80, 30);
        getContentPane().add(TFFone);
        TFFone.setBounds(90, 60, 220, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Idade:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 100, 80, 30);

        jSIdade.setModel(new javax.swing.SpinnerNumberModel(0, 0, 110, 1));
        getContentPane().add(jSIdade);
        jSIdade.setBounds(90, 100, 80, 22);

        jBtnProximo.setText("Próximo");
        getContentPane().add(jBtnProximo);
        jBtnProximo.setBounds(300, 220, 100, 40);

        jBtnFechar.setText("Fechar");
        getContentPane().add(jBtnFechar);
        jBtnFechar.setBounds(300, 270, 100, 40);

        jBtnAnterior.setText("Anterior");
        getContentPane().add(jBtnAnterior);
        jBtnAnterior.setBounds(200, 220, 100, 40);

        jBtnGravar.setText("Gravar");
        getContentPane().add(jBtnGravar);
        jBtnGravar.setBounds(110, 220, 90, 40);

        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAlterar);
        jBtnAlterar.setBounds(110, 270, 90, 40);

        jButton1.setText("Remover");
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 270, 100, 40);

        jButton2.setText("Salvar Arquivo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(340, 70, 140, 40);

        jButton3.setText("Abrir Arquivo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(340, 20, 140, 40);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setPreferredSize(new java.awt.Dimension(710, 180));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 320, 710, 180);

        setSize(new java.awt.Dimension(759, 550));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        salvarArquivo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        abrirArquivo();
        ExibeTabela();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JanelaClienteAula().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFFone;
    private javax.swing.JTextField TFNome;
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnAnterior;
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JButton jBtnGravar;
    private javax.swing.JButton jBtnProximo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner jSIdade;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}