package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.InitialController;
import factory.ConcreteFactoryMonitor;
import factory.ConcreteFactorySemaphore;
import observer.ObserverInitialView;
import singleton.MeshRepository;

public class InitialView extends JFrame implements ObserverInitialView {
	private static final long serialVersionUID = 1L;
	private InitialController controller;
	private JFileChooser jfcArquivo;
    private JTextField txtCaminho;
    private JButton btnProcurar;
    private JButton btnSemaphore;
    private JButton btnMonitor;
    
	public InitialView() {
		this.controller = new InitialController(this);
		defineProperties();
		initializeAtions();
	}
	
	private void defineProperties() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel lblTitulo = new JLabel("Escolha o arquivo da malha rodoviaria");

        txtCaminho = new JTextField();
        txtCaminho.setText("Selecione um arquivo");
        txtCaminho.setPreferredSize(new Dimension(310, 26));
        txtCaminho.setMinimumSize(new Dimension(310, 26));
        txtCaminho.setEnabled(false);

        btnProcurar = new JButton("Procurar");
        btnProcurar.setPreferredSize(new Dimension(120, 26));
        btnProcurar.setMinimumSize(new Dimension(120, 26));

        JPanel panLinhaBusca = new JPanel();
        panLinhaBusca.setLayout(layout);
        panLinhaBusca.setSize(400, 50);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 0, 0);
        panLinhaBusca.add(txtCaminho, constraints);
        constraints.gridx = 1;
        constraints.insets = new Insets(0, 10, 0, 0);
        panLinhaBusca.add(btnProcurar, constraints);
        

        btnSemaphore = new JButton("Semaforo");
        btnSemaphore.setPreferredSize(new Dimension(120, 26));
        btnSemaphore.setMinimumSize(new Dimension(120, 26));
        btnSemaphore.setEnabled(false);

        btnMonitor = new JButton("Monitor");
        btnMonitor.setPreferredSize(new Dimension(120, 26));
        btnMonitor.setMinimumSize(new Dimension(120, 26));
        btnMonitor.setEnabled(false);
        

        jfcArquivo = new JFileChooser();
        jfcArquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

        JPanel panLayout = new JPanel();
        panLayout.setLayout(layout);
        panLayout.setSize(700, 250);
        constraints.gridx = 0;
        panLayout.add(lblTitulo, constraints);
        constraints.gridy = 1;
        constraints.insets = new Insets(10, 0, 0, 0);
        panLayout.add(panLinhaBusca, constraints);
        constraints.gridy = 2;
        constraints.insets = new Insets(10, 320, 0, 0);
        panLayout.add(btnSemaphore, constraints);
        constraints.gridy = 4;
        constraints.insets = new Insets(10, 320, 0, 0);
        panLayout.add(btnMonitor, constraints);
        
        setTitle("Escolha a malha rodoviária");
        setVisible(true);
        setSize(600, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panLayout);
	}
	
	private void initializeAtions() {
		btnProcurar.addActionListener(click -> {
            int i= jfcArquivo.showSaveDialog(null);
            if (i==1){
                txtCaminho.setText("Selecione um arquivo de malha rodoviária");
                btnSemaphore.setEnabled(false);
                btnMonitor.setEnabled(false);
            } else {
                this.controller.updateRoadMesh(jfcArquivo.getSelectedFile());
            }
        });
        
		btnSemaphore.addActionListener(click -> {
			MeshRepository.getInstance().setFactory(new ConcreteFactorySemaphore());
        	this.controller.navigateNextView();
        });
		
		btnMonitor.addActionListener(click -> {
			MeshRepository.getInstance().setFactory(new ConcreteFactoryMonitor());
        	this.controller.navigateNextView();
        });
	}

	@Override
	public void ativedInitialButton() {
		btnSemaphore.setEnabled(true);
		btnMonitor.setEnabled(true);
	}

	@Override
	public void updateTxt(String caminho) {
		txtCaminho.setText(caminho);
		
	}

	@Override
	public void notifyErrorFile() {
		JOptionPane.showMessageDialog(null, "O arquivo selecionado não possui o padrão correto de uma malha rodoviária",
                "Erro no arquivo", JOptionPane.ERROR_MESSAGE);
		btnSemaphore.setEnabled(false);
		btnMonitor.setEnabled(false);
	}

	@Override
	public void navigateNextView() {
		TrafficSimulatorView view = new TrafficSimulatorView();
		view.setVisible(true);
		this.dispose();		
	}

}
