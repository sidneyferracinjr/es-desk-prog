package view;

import javax.swing.JOptionPane;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.io.IOException;

import config.Config;
import model.StudentModel;
import controller.StudentController;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sidneyferracinjr
 */
public class StudentView extends javax.swing.JFrame {

    private StudentController studentController;
    private Config config = Config.getInstance();
    private String directoryPath = "";
    private int index = 0;
    
    /**
     * Creates new form JAluno
     */
    public StudentView() {
        this.studentController = new StudentController();
        initComponents();
    }
    
    public StudentView(String directoryPath) {
        this.directoryPath = directoryPath;
        this.studentController = new StudentController(directoryPath, this);
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfName = new javax.swing.JTextField();
        tfClass = new javax.swing.JTextField();
        lblRegistration = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblClass = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnClearFields = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        tfRegistration = new javax.swing.JSpinner();
        spStudents = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        mbFile = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        miOpen = new javax.swing.JMenuItem();
        miSave = new javax.swing.JMenuItem();
        miSaveHow = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aluno");

        lblRegistration.setText("Matrícula");

        lblName.setText("Nome");

        lblClass.setText("Turma");

        btnCreate.setText("Criar");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setText("Atualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Excluir");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnPrevious.setText("Anterior");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText("Próximo");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnClearFields.setText("Limpar Campos");
        btnClearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFieldsActionPerformed(evt);
            }
        });

        btnRead.setText("Ler");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Indice", "Nome", "Turma", "Matricula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spStudents.setViewportView(tblStudents);
        if (tblStudents.getColumnModel().getColumnCount() > 0) {
            tblStudents.getColumnModel().getColumn(0).setResizable(false);
            tblStudents.getColumnModel().getColumn(1).setResizable(false);
            tblStudents.getColumnModel().getColumn(2).setResizable(false);
            tblStudents.getColumnModel().getColumn(3).setResizable(false);
        }

        mFile.setText("Arquivo");

        miOpen.setText("Abrir");
        miOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOpenActionPerformed(evt);
            }
        });
        mFile.add(miOpen);

        miSave.setText("Salvar");
        miSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSaveActionPerformed(evt);
            }
        });
        mFile.add(miSave);

        miSaveHow.setText("Salvar Como...");
        miSaveHow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSaveHowActionPerformed(evt);
            }
        });
        mFile.add(miSaveHow);
        mFile.add(jSeparator1);

        miExit.setText("Sair");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        mFile.add(miExit);

        mbFile.add(mFile);

        setJMenuBar(mbFile);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnClearFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblClass))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfClass, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRegistration)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClass)
                    .addComponent(tfClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegistration)
                    .addComponent(tfRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearFields)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnRead)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOpenActionPerformed
        openFile();
    }//GEN-LAST:event_miOpenActionPerformed

    private void miSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSaveActionPerformed
        try {
            saveFile();
        } catch (IOException ex) {
            showMessage(this, "Erro ao salvar o arquivo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_miSaveActionPerformed

    private void miSaveHowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSaveHowActionPerformed
        saveFileHow();
    }//GEN-LAST:event_miSaveHowActionPerformed

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miExitActionPerformed

    private void btnClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFieldsActionPerformed
        cleanFields();
    }//GEN-LAST:event_btnClearFieldsActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if (index > 0) {
            index--;
            fillFields();
        } else {
            showMessage(this, "Não há alunos anteriores.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (index < studentController.getStudents().size() - 1) {
            index++;
            fillFields();
        } else {
            showMessage(this, "Não há mais alunos.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try {
            createStudent();
            tabularData();
            fillFields();
        } catch (Exception e) {
            showMessage(this, "Erro ao criar aluno: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            updateStudent();
            tabularData();
            fillFields();
        } catch (Exception e) {
            showMessage(this, "Erro ao atualizar aluno: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        try {
            readStudent();
        } catch (Exception e) {
            showMessage(this, "Erro ao buscar aluno: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            deleteStudent();
            if (index > 0) {
                index--;
            }
            tabularData();
            fillFields();
        } catch (Exception e) {
            showMessage(this, "Erro ao excluir aluno: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    public void openFile() {
        if (studentController.openFile()) {
            index = 0;
            fillFields();
            tabularData();
        } else {
            showMessage(this, "Erro ao abrir arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void saveFile() throws IOException {
        if (!studentController.saveFile()) {
            throw new IOException("Não foi possível salvar o arquivo.");
        }
    }
    
    public void saveFileHow() {
        studentController.saveFileHow();
    }
    
    public void fillFields() {
        if (studentController.getStudents().isEmpty()) {
            cleanFields();
            showMessage(this, "Não há alunos cadastrados.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        StudentModel studentModel = studentController.getStudents().get(index);
        tfName.setText(studentModel.getNome());
        tfClass.setText(studentModel.getTurma());
        tfRegistration.setValue(studentModel.getMatricula());
        tfName.requestFocus();
    }
    
    public void cleanFields() {
        tfName.setText("");
        tfClass.setText("");
        tfRegistration.setValue(0);
        tfName.requestFocus();
    }
    
    public void createStudent() {
        if (studentController.createStudent(tfName.getText(), tfClass.getText(), tfRegistration.getValue())) {
            showMessage(this, "Aluno criado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            showMessage(this, "Erro ao criar aluno.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void readStudent() {
        int registration = Integer.parseInt(tfRegistration.getValue().toString());
        if (!studentController.readStudent(registration)) {
            showMessage(this, "Aluno não encontrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateStudent() {

        if (studentController.updateStudent(Integer.parseInt(tfRegistration.getValue().toString()),
                                            tfName.getText(),
                                            tfClass.getText())) 
        {
            showMessage(this, "Aluno atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            showMessage(this, "Erro ao atualizar aluno.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteStudent() {
        int registration = Integer.parseInt(tfRegistration.getValue().toString());
        if (studentController.deleteStudent(registration)) {
            showMessage(this, "Aluno excluído com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            showMessage(this, "Erro ao excluir aluno.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void tabularData() {
        final Vector<Vector<Object>> linhas = new Vector<>();
        final Vector<String> colunas = new Vector<>();
        colunas.add("Índice");
        colunas.add("Nome");
        colunas.add("Turma");
        colunas.add("Matrícula");

        for (int i = 0; i < studentController.getStudents().size(); i++) {
            Vector<Object> linha = new Vector<>();
            StudentModel studentModel = studentController.getStudents().get(i);
            linha.add(i);
            linha.add(studentModel.getNome());
            linha.add(studentModel.getTurma());
            linha.add(studentModel.getMatricula());
            linhas.add(linha);
        }

        showTable(linhas, colunas);
    }
    
    private void showTable(Vector<Vector<Object>> linhas, Vector<String> colunas) {
        tblStudents.setModel(new javax.swing.table.DefaultTableModel(linhas, colunas));
        spStudents.setViewportView(tblStudents);
    }
    
    public void showMessage(Component parentComponent, Object message, String title, int messageType) {
        JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearFields;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRegistration;
    private javax.swing.JMenu mFile;
    private javax.swing.JMenuBar mbFile;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miOpen;
    private javax.swing.JMenuItem miSave;
    private javax.swing.JMenuItem miSaveHow;
    private javax.swing.JScrollPane spStudents;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField tfClass;
    private javax.swing.JTextField tfName;
    private javax.swing.JSpinner tfRegistration;
    // End of variables declaration//GEN-END:variables
}
