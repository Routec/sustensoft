package br.com.sustensoft.visao;

import br.com.sustensoft.dao.AguaDAO;
import br.com.sustensoft.dao.EnergiaDAO;
import br.com.sustensoft.dao.PrincipalDAO;
import br.com.sustensoft.dao.ResiduosDAO;
import br.com.sustensoft.modelo.AguaDTO;
import br.com.sustensoft.modelo.EnergiaDTO;
import br.com.sustensoft.modelo.PrincipalDTO;
import br.com.sustensoft.modelo.ResiduosDTO;
import java.text.DateFormat;
import java.util.Date;

public class PrincipalTela extends javax.swing.JFrame {

    PrincipalDAO objPrincipalDAO;
    CadastroUsuarioTela telaCad;
    PrincipalDTO objPrincipalDTO;
    AguaDTO objAguaDTO;
    AguaDAO objAguaDAO;
    EnergiaDTO objEnergiaDTO;
    EnergiaDAO objEnergiaDAO;
    ResiduosDTO objResiduosDTO;
    ResiduosDAO objResiduosDAO;
    
    
    
    private String login, senha;
    private int celesc, proprio;   //Energia
    private int organico, composteira, separacao, descarte;   //Residuos
    private int scoreTotalPos;
    
    public PrincipalTela(PrincipalDTO objPrincipalDTO) {
        initComponents();

        login = objPrincipalDTO.getLogin();
        senha = objPrincipalDTO.getSenha1();

        objPrincipalDAO = new PrincipalDAO();
        lblUsu.setText(objPrincipalDTO.getNome()); //setando label Usuario (lblUsu) para o nome do usuário cadastrado.
        
        
        
    }
    
        
    public void somaScoreTotal(String login){
        
        objAguaDAO = new AguaDAO();
        objAguaDTO = new AguaDTO();
        objAguaDTO = objAguaDAO.exibirAgua(login);
        
        objEnergiaDAO = new EnergiaDAO();
        objEnergiaDTO = new EnergiaDTO();
        objEnergiaDTO = objEnergiaDAO.exibirEnergia(login);
        
        objResiduosDAO = new ResiduosDAO();
        objResiduosDTO = new ResiduosDTO();
        objResiduosDTO = objResiduosDAO.exibirResiduos(login);
        
        scoreTotalPos = objAguaDTO.getSoma() + objEnergiaDTO.getSoma() + objResiduosDTO.getSoma();
        
        lblScore.setText(Integer.toString(scoreTotalPos));  //setando label Score (lblScore) para o socre do usuário cadastrado.
        
            if ((scoreTotalPos < -1300)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score25.png"));
            } else if((scoreTotalPos > -1300) && (scoreTotalPos <-1200)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score24.png"));
            } else if((scoreTotalPos > -1200) && (scoreTotalPos <-1100)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score23.png"));
            } else if((scoreTotalPos > -1100) && (scoreTotalPos <-1000)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score22.png"));
            } else if((scoreTotalPos > -1000) && (scoreTotalPos <-900)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score21.png"));        
            } else if((scoreTotalPos > -900) && (scoreTotalPos <-800)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score20.png"));
            } else if((scoreTotalPos > -800) && (scoreTotalPos <-700)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score19.png"));
            } else if((scoreTotalPos > -700) && (scoreTotalPos <-600)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score18.png"));
            } else if((scoreTotalPos > -600) && (scoreTotalPos <-500)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score17.png"));
            } else if((scoreTotalPos > -500) && (scoreTotalPos <-400)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score16.png"));
            } else if((scoreTotalPos > -400) && (scoreTotalPos <-300)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score15.png"));
            } else if((scoreTotalPos > -300) && (scoreTotalPos <-200)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score14.png"));
            } else if((scoreTotalPos > -200) && (scoreTotalPos <-100)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score13.png"));
            } else if((scoreTotalPos > -100) && (scoreTotalPos <0)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score12.png"));
            } else if((scoreTotalPos > 0) && (scoreTotalPos <100)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score11.png"));
            } else if((scoreTotalPos > 000) && (scoreTotalPos <200)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score10.png"));
            } else if((scoreTotalPos > 200) && (scoreTotalPos <300)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score09.png"));
            } else if((scoreTotalPos > 300) && (scoreTotalPos <400)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score08.png"));
            } else if((scoreTotalPos > 400) && (scoreTotalPos <500)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score07.png"));
            } else if((scoreTotalPos > 500) && (scoreTotalPos <600)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score06.png"));
            } else if((scoreTotalPos > 600) && (scoreTotalPos <700)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score05.png"));
            } else if((scoreTotalPos > 700) && (scoreTotalPos <800)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score04.png"));
            } else if((scoreTotalPos > 800) && (scoreTotalPos <900)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score03.png"));
            } else if((scoreTotalPos > 900) && (scoreTotalPos < 1000)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score02.png"));
            } else if((scoreTotalPos > 1000)){
            lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score01.png"));
            }
    }
    
    
    public void setarAgua(String login){
        objAguaDAO = new AguaDAO();
        objAguaDTO = new AguaDTO();                         //Carrega dados do MySQL
        objAguaDTO = objAguaDAO.exibirAgua(login);
        spnAgua.setValue(objAguaDTO.getBanho());
        spnSanitario.setValue(objAguaDTO.getSanitario());
        spnRoupa.setValue(objAguaDTO.getRoupa());
        spnPlanta.setValue(objAguaDTO.getPlanta());
        spnCarro.setValue(objAguaDTO.getCarro());
    }
    
    public void setarEnergia(String login){
        objEnergiaDAO = new EnergiaDAO();
        objEnergiaDTO = new EnergiaDTO();                   //Carrega dados do MySQL
        objEnergiaDTO = objEnergiaDAO.exibirEnergia(login);
        
        txtConsumo.setText(Integer.toString(objEnergiaDTO.getConsumo()));
        
        if(objEnergiaDTO.getCelesc() != 0){
            rdbCelesc.setSelected(true);
        } else {
            rdbCelesc.setSelected(false);
        }
        
        if(objEnergiaDTO.getProprio() != 0){
            rdbProprio.setSelected(true);
        } else {
            rdbProprio.setSelected(false);
        }
        
        txtPessoas.setText(Integer.toString(objEnergiaDTO.getPessoas()));
        
    }
    
    public void setarResiduos(String login){
        objResiduosDAO = new ResiduosDAO();
        objResiduosDTO = new ResiduosDTO();                   //Carrega dados do MySQL
        objResiduosDTO = objResiduosDAO.exibirResiduos(login);
        
        if(objResiduosDTO.getOrganico() !=0){
            cbxResiduoOrganico.setSelected(true);
        } else {
            cbxResiduoOrganico.setSelected(false);
        }
        
        if(objResiduosDTO.getComposteira() !=0){
            cbxResiduoCompostagem.setSelected(true);
        } else {
            cbxResiduoCompostagem.setSelected(false);
        }
        
        if(objResiduosDTO.getSeparacao() !=0){
            cbxResiduoSeco.setSelected(true);
        } else {
            cbxResiduoSeco.setSelected(false);
        }
        
        if(objResiduosDTO.getDescarte() !=0){
            cbxResiduoTriagem.setSelected(true);
        } else {
            cbxResiduoTriagem.setSelected(false);
        }        
        
    }
    
    
    public void setarUsuario(String login, String senha) {

        objPrincipalDTO = new PrincipalDTO();
        objPrincipalDTO = objPrincipalDAO.exibirUsuario(login);

        txtCadNome.setText(objPrincipalDTO.getNome());
        txtCadSobre.setText(objPrincipalDTO.getSobrenome());
        txtCadCpf.setText(objPrincipalDTO.getCpf());
        txtCadFon.setText(objPrincipalDTO.getFone());
        txtCadMail.setText(objPrincipalDTO.getEmail());
        txtCadEnd.setText(objPrincipalDTO.getEndereco());
        txtCadCep.setText(objPrincipalDTO.getCep());
        txtCadUser.setText(objPrincipalDTO.getLogin());
        txtCadPass1.setText(objPrincipalDTO.getSenha1());
        
    }

    public void alterar(String login) {
        
        objPrincipalDTO.setNome(txtCadNome.getText());
        objPrincipalDTO.setSobrenome(txtCadSobre.getText());
        objPrincipalDTO.setCpf(txtCadCpf.getText());
        objPrincipalDTO.setFone(txtCadFon.getText());
        objPrincipalDTO.setEmail(txtCadMail.getText());
        objPrincipalDTO.setEndereco(txtCadEnd.getText());
        objPrincipalDTO.setCep(txtCadCep.getText());
        objPrincipalDTO.setLogin(txtCadUser.getText());
        objPrincipalDTO.setSenha1(txtCadPass1.getText());

        objPrincipalDTO = objPrincipalDAO.alterarUsuario(login);
    }
    
    public void deletarUsuario(){
        objPrincipalDTO = objPrincipalDAO.deletarUsuario(login);
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        spnPlanta1 = new javax.swing.JSpinner();
        lblUsu = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        abaAgua = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spnAgua = new javax.swing.JSpinner();
        spnRoupa = new javax.swing.JSpinner();
        spnPlanta = new javax.swing.JSpinner();
        spnCarro = new javax.swing.JSpinner();
        btnAguaAplicar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        spnSanitario = new javax.swing.JSpinner();
        abaEner = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtConsumo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        rdbCelesc = new javax.swing.JRadioButton();
        rdbProprio = new javax.swing.JRadioButton();
        txtPessoas = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnEnergiaAplicar = new javax.swing.JButton();
        abaRes = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cbxResiduoOrganico = new javax.swing.JCheckBox();
        cbxResiduoSeco = new javax.swing.JCheckBox();
        btnResiduoAplicar = new javax.swing.JButton();
        cbxResiduoCompostagem = new javax.swing.JCheckBox();
        cbxResiduoTriagem = new javax.swing.JCheckBox();
        abaUsu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCadNome = new javax.swing.JTextField();
        txtCadSobre = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtCadMail = new javax.swing.JTextField();
        txtCadEnd = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtCadUser = new javax.swing.JTextField();
        txtCadPass1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnUsuAlterar = new javax.swing.JButton();
        btnUsuExcluir = new javax.swing.JButton();
        txtCadCpf = new javax.swing.JFormattedTextField();
        txtCadFon = new javax.swing.JFormattedTextField();
        txtCadCep = new javax.swing.JFormattedTextField();
        btnSair = new javax.swing.JButton();
        lblScore = new javax.swing.JLabel();
        lblData2 = new javax.swing.JLabel();
        lblUsuqlq = new javax.swing.JLabel();
        lblScoreImg = new javax.swing.JLabel();

        spnPlanta1.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SustenSoft - Gerenciador Pessoal de Sustentabilidade");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblUsu.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblUsu.setForeground(new java.awt.Color(102, 153, 255));
        lblUsu.setText("Nome Usuário");

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(153, 153, 153));
        lblData.setText("Data");

        jTabbedPane5.setForeground(new java.awt.Color(102, 153, 255));
        jTabbedPane5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        abaAgua.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaAguaComponentShown(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel2.setText("Uso Consciente do Recurso Água.");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Banho");

        jLabel5.setText("minutos por dia");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Lavar Carro ou Calçada");

        jLabel7.setText("minutos por dia");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Rega de Plantas");

        jLabel9.setText("minutos por dia");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Descarga Sanitário");

        jLabel11.setText("vezes por dia");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Lavar Roupas");

        jLabel13.setText("vezes ao dia");

        spnAgua.setModel(new javax.swing.SpinnerNumberModel());
        spnAgua.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CatchValueFromSpinnerBanho(evt);
            }
        });

        spnRoupa.setModel(new javax.swing.SpinnerNumberModel());
        spnRoupa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CatchValueFromSpinnerRoupa(evt);
            }
        });

        spnPlanta.setModel(new javax.swing.SpinnerNumberModel());
        spnPlanta.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CatchValueFromSpinnerPlantas(evt);
            }
        });

        spnCarro.setModel(new javax.swing.SpinnerNumberModel());
        spnCarro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CatchValueFromSpinnerCarro(evt);
            }
        });

        btnAguaAplicar.setText("Aplicar");
        btnAguaAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAguaAplicarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Preencha abaixo os campos, conforme forem sendo incrementados diariamente.");

        spnSanitario.setModel(new javax.swing.SpinnerNumberModel());
        spnSanitario.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CatchValueFromSpinnerSanitario(evt);
            }
        });

        javax.swing.GroupLayout abaAguaLayout = new javax.swing.GroupLayout(abaAgua);
        abaAgua.setLayout(abaAguaLayout);
        abaAguaLayout.setHorizontalGroup(
            abaAguaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaAguaLayout.createSequentialGroup()
                .addGroup(abaAguaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaAguaLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(abaAguaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(abaAguaLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnSanitario, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addGroup(abaAguaLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnRoupa, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addComponent(jLabel2)
                            .addGroup(abaAguaLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))))
                    .addGroup(abaAguaLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnAguaAplicar)))
                .addContainerGap(326, Short.MAX_VALUE))
        );
        abaAguaLayout.setVerticalGroup(
            abaAguaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaAguaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(abaAguaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(spnSanitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaAguaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(spnRoupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(abaAguaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(spnPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(spnCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(50, 50, 50)
                .addComponent(btnAguaAplicar)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Água", abaAgua);

        abaEner.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaEnerComponentShown(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel14.setText("Esta aba trata do uso consciente da Energia Elétrica.");

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel15.setText("Preencha abaixo os campos, conforme forem sendo incrementados diariamente.");

        txtConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsumoActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Consumo");

        jLabel17.setText("kWh mensal conforme consta na fatura de energia elétrica");

        jLabel18.setText("Sistema de geração de energial que você usa");

        buttonGroup1.add(rdbCelesc);
        rdbCelesc.setText("CELESC");
        rdbCelesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbCelescActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbProprio);
        rdbProprio.setText("Próprio (Ex: Energia Solar)");
        rdbProprio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbProprioActionPerformed(evt);
            }
        });

        txtPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPessoasActionPerformed(evt);
            }
        });

        jLabel19.setText("Pessoas Habitantes no Local do Consumo");

        btnEnergiaAplicar.setText("Aplicar");
        btnEnergiaAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnergiaAplicarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout abaEnerLayout = new javax.swing.GroupLayout(abaEner);
        abaEner.setLayout(abaEnerLayout);
        abaEnerLayout.setHorizontalGroup(
            abaEnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaEnerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(abaEnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(abaEnerLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17))
                    .addComponent(jLabel18)
                    .addGroup(abaEnerLayout.createSequentialGroup()
                        .addComponent(rdbCelesc)
                        .addGap(18, 18, 18)
                        .addComponent(rdbProprio))
                    .addGroup(abaEnerLayout.createSequentialGroup()
                        .addComponent(txtPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19))
                    .addComponent(jLabel14)
                    .addGroup(abaEnerLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnEnergiaAplicar)))
                .addContainerGap(322, Short.MAX_VALUE))
        );
        abaEnerLayout.setVerticalGroup(
            abaEnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaEnerLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(abaEnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaEnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbCelesc)
                    .addComponent(rdbProprio))
                .addGap(18, 18, 18)
                .addGroup(abaEnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(31, 31, 31)
                .addComponent(btnEnergiaAplicar)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Energia", abaEner);

        abaRes.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaResComponentShown(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel28.setText("Preencha abaixo os campos, conforme forem sendo incrementados diariamente.");

        jLabel29.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel29.setText("Esta aba trata do descarte consciente dos resíduos..");

        cbxResiduoOrganico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxResiduoOrganico.setText("Meu Lixo orgânico é separado do restante do lixo seco.");
        cbxResiduoOrganico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxResiduoOrganicoActionPerformed(evt);
            }
        });

        cbxResiduoSeco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxResiduoSeco.setText("Realizo a separação do lixo seco em associação de itens (vidros, embalagens plásticas, latas e metais, lixo inutilizável, etc).");
        cbxResiduoSeco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxResiduoSecoActionPerformed(evt);
            }
        });

        btnResiduoAplicar.setText("Aplicar");
        btnResiduoAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResiduoAplicarActionPerformed(evt);
            }
        });

        cbxResiduoCompostagem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxResiduoCompostagem.setText("Possuo uma composteira caseira para meu lixo orgânico.");
        cbxResiduoCompostagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxResiduoCompostagemActionPerformed(evt);
            }
        });

        cbxResiduoTriagem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxResiduoTriagem.setText("Costumo descartar meu lixo seco e reciclável em um centro de triagem de resíduos.");
        cbxResiduoTriagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxResiduoTriagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout abaResLayout = new javax.swing.GroupLayout(abaRes);
        abaRes.setLayout(abaResLayout);
        abaResLayout.setHorizontalGroup(
            abaResLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaResLayout.createSequentialGroup()
                .addGroup(abaResLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaResLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(abaResLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaResLayout.createSequentialGroup()
                                .addComponent(cbxResiduoOrganico)
                                .addGap(18, 18, 18)
                                .addComponent(cbxResiduoCompostagem))
                            .addComponent(cbxResiduoSeco)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(cbxResiduoTriagem)))
                    .addGroup(abaResLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnResiduoAplicar)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        abaResLayout.setVerticalGroup(
            abaResLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaResLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addGroup(abaResLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxResiduoOrganico)
                    .addComponent(cbxResiduoCompostagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxResiduoSeco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxResiduoTriagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(btnResiduoAplicar)
                .addGap(77, 77, 77))
        );

        jTabbedPane5.addTab("Resíduos", abaRes);

        abaUsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abaUsuMouseEntered(evt);
            }
        });
        abaUsu.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaUsuComponentShown(evt);
            }
        });

        jLabel1.setText("Nome");

        txtCadNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadNomeActionPerformed(evt);
            }
        });

        txtCadSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadSobreActionPerformed(evt);
            }
        });

        jLabel20.setText("Sobrenome");

        jLabel21.setText("CPF");

        jLabel22.setText("Fone");

        jLabel23.setText("email");

        jLabel24.setText("CEP");

        jLabel25.setText("Endereço");

        jLabel26.setText("Nome Usuário");

        jLabel27.setText("Senha");

        btnUsuAlterar.setText("Alterar");
        btnUsuAlterar.setToolTipText("Alterar Dados Usuário");
        btnUsuAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuAlterarActionPerformed(evt);
            }
        });

        btnUsuExcluir.setText("Exluir");
        btnUsuExcluir.setToolTipText("Excluir Usuário");
        btnUsuExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuExcluirActionPerformed(evt);
            }
        });

        try {
            txtCadCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCadCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadCpfActionPerformed(evt);
            }
        });

        try {
            txtCadFon.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCadFon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadFonActionPerformed(evt);
            }
        });

        try {
            txtCadCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout abaUsuLayout = new javax.swing.GroupLayout(abaUsu);
        abaUsu.setLayout(abaUsuLayout);
        abaUsuLayout.setHorizontalGroup(
            abaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaUsuLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(abaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(abaUsuLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCadEnd)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCadCep, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(abaUsuLayout.createSequentialGroup()
                        .addGroup(abaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(abaUsuLayout.createSequentialGroup()
                                .addComponent(btnUsuAlterar)
                                .addGap(66, 66, 66)
                                .addComponent(btnUsuExcluir))
                            .addGroup(abaUsuLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCadPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(abaUsuLayout.createSequentialGroup()
                        .addGroup(abaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(abaUsuLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCadCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCadFon, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(abaUsuLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCadNome)))
                        .addGap(18, 18, 18)
                        .addGroup(abaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaUsuLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCadSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaUsuLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCadMail, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(23, 23, 23))
        );
        abaUsuLayout.setVerticalGroup(
            abaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaUsuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(abaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCadNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtCadSobre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(txtCadMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCadCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCadFon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtCadEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txtCadCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtCadPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(abaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuAlterar)
                    .addComponent(btnUsuExcluir))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Usuário", abaUsu);

        btnSair.setText("Sair");
        btnSair.setToolTipText("Sair do aplicativo.");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblScore.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblScore.setForeground(new java.awt.Color(102, 153, 255));
        lblScore.setText("Score");

        lblData2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblData2.setForeground(new java.awt.Color(153, 153, 153));
        lblData2.setText("Seu Score é:");

        lblUsuqlq.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblUsuqlq.setForeground(new java.awt.Color(153, 153, 153));
        lblUsuqlq.setText("Bem vindo");

        lblScoreImg.setIcon(new javax.swing.ImageIcon("D:\\__Entra21\\JAVA Swing\\SustenSoft\\SustenSoft\\img\\score13.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblUsuqlq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsu)
                .addGap(60, 60, 60)
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblData2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScore)
                .addGap(18, 18, 18)
                .addComponent(lblScoreImg)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblScoreImg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblScore)
                            .addComponent(lblData2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblUsu)
                                .addComponent(lblUsuqlq)
                                .addComponent(lblData)))
                        .addGap(27, 27, 27)))
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsumoActionPerformed
        // TODO add your handling code here:
                
    }//GEN-LAST:event_txtConsumoActionPerformed

    private void rdbProprioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbProprioActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rdbProprioActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // As linhas abaixo substituem a label lblData pela data atual do sistema
        //ao inicializar o form
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));

        lblUsu.setText(objPrincipalDTO.getNome()); //setando label Usuario (lblUsu) para o nome do usuário cadastrado.
    }//GEN-LAST:event_formWindowActivated

    private void txtCadNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadNomeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCadNomeActionPerformed

    private void txtCadSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadSobreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCadSobreActionPerformed

    private void abaUsuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abaUsuMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_abaUsuMouseEntered

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAguaAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAguaAplicarActionPerformed
        objAguaDTO = new AguaDTO();
        objAguaDAO = new AguaDAO();
                
        objAguaDTO.setLogin(login);
        objAguaDTO.setBanho((Integer)spnAgua.getValue());
        objAguaDTO.setSanitario((Integer)spnSanitario.getValue());
        objAguaDTO.setRoupa((Integer)spnRoupa.getValue());
        objAguaDTO.setPlanta((Integer)spnPlanta.getValue());
        objAguaDTO.setCarro ((Integer)spnCarro.getValue());
             
        objAguaDAO.conferirExistencia(objAguaDTO);
        somaScoreTotal(login);
                                        
    }//GEN-LAST:event_btnAguaAplicarActionPerformed

    private void cbxResiduoSecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxResiduoSecoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbxResiduoSecoActionPerformed

    private void cbxResiduoCompostagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxResiduoCompostagemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbxResiduoCompostagemActionPerformed

    private void cbxResiduoTriagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxResiduoTriagemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbxResiduoTriagemActionPerformed

    private void txtCadCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCadCpfActionPerformed

    private void txtCadFonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadFonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCadFonActionPerformed

    private void btnUsuAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuAlterarActionPerformed
        alterar(login);
    }//GEN-LAST:event_btnUsuAlterarActionPerformed

    private void abaUsuComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaUsuComponentShown
        // TODO add your handling code here:
        setarUsuario(login, senha);

    }//GEN-LAST:event_abaUsuComponentShown

    private void btnUsuExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuExcluirActionPerformed
        // TODO add your handling code here:
        deletarUsuario();
    }//GEN-LAST:event_btnUsuExcluirActionPerformed

    private void CatchValueFromSpinnerBanho(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CatchValueFromSpinnerBanho
        //banho = (Integer)spnAgua.getValue();
               
    }//GEN-LAST:event_CatchValueFromSpinnerBanho

    private void CatchValueFromSpinnerSanitario(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CatchValueFromSpinnerSanitario
                               
    }//GEN-LAST:event_CatchValueFromSpinnerSanitario

    private void CatchValueFromSpinnerRoupa(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CatchValueFromSpinnerRoupa
        
    }//GEN-LAST:event_CatchValueFromSpinnerRoupa

    private void CatchValueFromSpinnerPlantas(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CatchValueFromSpinnerPlantas
                        
    }//GEN-LAST:event_CatchValueFromSpinnerPlantas

    private void CatchValueFromSpinnerCarro(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CatchValueFromSpinnerCarro
        
    }//GEN-LAST:event_CatchValueFromSpinnerCarro

    private void rdbCelescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbCelescActionPerformed
        // TODO add your handling code here:
            
    }//GEN-LAST:event_rdbCelescActionPerformed

    private void btnEnergiaAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnergiaAplicarActionPerformed
        // TODO add your handling code here:
                
        if(rdbCelesc.isSelected()){    
           celesc = 1;
           proprio = 0;
        } 
        
        if(rdbProprio.isSelected()){    
           celesc = 0;
           proprio = 1;
        }
        
        objEnergiaDTO = new EnergiaDTO();
        objEnergiaDAO = new EnergiaDAO();
        objEnergiaDTO.setLogin(login);
        objEnergiaDTO.setConsumo(Integer.parseInt(txtConsumo.getText()));
        objEnergiaDTO.setCelesc(celesc);
        objEnergiaDTO.setProprio(proprio);
        objEnergiaDTO.setPessoas(Integer.parseInt(txtPessoas.getText()));
        objEnergiaDAO.conferirExistencia(objEnergiaDTO);
        
        somaScoreTotal(login);
        
    }//GEN-LAST:event_btnEnergiaAplicarActionPerformed

    private void txtPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPessoasActionPerformed
        // TODO add your handling code here:
                
    }//GEN-LAST:event_txtPessoasActionPerformed

    private void cbxResiduoOrganicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxResiduoOrganicoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbxResiduoOrganicoActionPerformed

    private void btnResiduoAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResiduoAplicarActionPerformed
        // TODO add your handling code here:
        
        if (cbxResiduoSeco.isSelected()){
            separacao = 1;
        } else {
            separacao = 0;
        }
        if (cbxResiduoOrganico.isSelected()){
            organico = 1;
        } else {
            organico = 0;    
        }
        if (cbxResiduoTriagem.isSelected()){
            descarte = 1;
        } else {
            descarte = 0;
        }
        if (cbxResiduoCompostagem.isSelected()){
            composteira = 1;
        } else {
            composteira = 0;
        }
                
        objResiduosDTO = new ResiduosDTO();
        objResiduosDAO = new ResiduosDAO();
        objResiduosDTO.setLogin(login);
        objResiduosDTO.setOrganico(organico);
        objResiduosDTO.setComposteira(composteira);
        objResiduosDTO.setSeparacao(separacao);
        objResiduosDTO.setDescarte(descarte);
        objResiduosDAO.conferirExistencia(objResiduosDTO);
        somaScoreTotal(login);
        
    }//GEN-LAST:event_btnResiduoAplicarActionPerformed

    private void abaAguaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaAguaComponentShown
        // TODO add your handling code here:
     
        setarAgua(login);
        //somaScoreTotal(login);
                
    }//GEN-LAST:event_abaAguaComponentShown

    private void abaEnerComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaEnerComponentShown
        // TODO add your handling code here:
        
        setarEnergia(login);
        //somaScoreTotal(login);
        
    }//GEN-LAST:event_abaEnerComponentShown

    private void abaResComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaResComponentShown
        // TODO add your handling code here:
        setarResiduos(login);
        //somaScoreTotal(login);
    }//GEN-LAST:event_abaResComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        somaScoreTotal(login);
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abaAgua;
    private javax.swing.JPanel abaEner;
    private javax.swing.JPanel abaRes;
    private javax.swing.JPanel abaUsu;
    private javax.swing.JButton btnAguaAplicar;
    private javax.swing.JButton btnEnergiaAplicar;
    private javax.swing.JButton btnResiduoAplicar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnUsuAlterar;
    private javax.swing.JButton btnUsuExcluir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbxResiduoCompostagem;
    private javax.swing.JCheckBox cbxResiduoOrganico;
    private javax.swing.JCheckBox cbxResiduoSeco;
    private javax.swing.JCheckBox cbxResiduoTriagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblData2;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblScoreImg;
    public static javax.swing.JLabel lblUsu;
    public static javax.swing.JLabel lblUsuqlq;
    private javax.swing.JRadioButton rdbCelesc;
    private javax.swing.JRadioButton rdbProprio;
    public javax.swing.JSpinner spnAgua;
    private javax.swing.JSpinner spnCarro;
    private javax.swing.JSpinner spnPlanta;
    private javax.swing.JSpinner spnPlanta1;
    private javax.swing.JSpinner spnRoupa;
    private javax.swing.JSpinner spnSanitario;
    public javax.swing.JFormattedTextField txtCadCep;
    public javax.swing.JFormattedTextField txtCadCpf;
    public javax.swing.JTextField txtCadEnd;
    public javax.swing.JFormattedTextField txtCadFon;
    public javax.swing.JTextField txtCadMail;
    public javax.swing.JTextField txtCadNome;
    public javax.swing.JTextField txtCadPass1;
    public javax.swing.JTextField txtCadSobre;
    public javax.swing.JTextField txtCadUser;
    private javax.swing.JTextField txtConsumo;
    private javax.swing.JTextField txtPessoas;
    // End of variables declaration//GEN-END:variables
}
