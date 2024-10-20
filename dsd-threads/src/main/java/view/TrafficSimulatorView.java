package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import component.TrafficSimulatorTableView;
import controller.TrafficSimulatorController;
import model.Contants;
import model.observer.ObserverNode;
import model.road.PieceModel;
import model.thread.Car;
import singleton.MeshRepository;

public class TrafficSimulatorView extends JFrame implements ObserverNode {

    private static final long serialVersionUID = 1L;
    private TrafficSimulatorController controller;
    private JLabel lblNumeroThreadAtual;
    private TrafficSimulatorTableView board;

    public TrafficSimulatorView() {
        super();
        controller = new TrafficSimulatorController();
        controller.addObserver(this);
        init();
    }

    private void init() {
        setProperties();
        addComponents();
    }

    private void setProperties() {
        setTitle("Simulador de Tráfico");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(Contants.LARGURA_TELA, Contants.ALTURA_TELA));
        setLayout(new BorderLayout());
        pack();
    }

    private void addComponents() {
        board = new TrafficSimulatorTableView(controller);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();

        // Labels
        JLabel lblTituloNumeroThread = new JLabel("N° Threads");
        lblTituloNumeroThread.setPreferredSize(new Dimension(Contants.LARGURA_TELA / 6, Contants.LARGURA_COLUNA_GRID));

        JLabel lblTituloThreadAtual = new JLabel("Threads em funcionamento");
        lblTituloThreadAtual.setPreferredSize(new Dimension(Contants.LARGURA_TELA / 6, Contants.LARGURA_COLUNA_GRID));

        // Buttons
        JButton btnIniciar = new JButton("INICIAR");
        btnIniciar.setPreferredSize(new Dimension(Contants.LARGURA_TELA / 6, Contants.LARGURA_COLUNA_GRID));

        JButton btnEncerrar = new JButton("ENCERRAR");
        btnEncerrar.setPreferredSize(new Dimension(Contants.LARGURA_TELA / 6, Contants.LARGURA_COLUNA_GRID));
        btnEncerrar.setEnabled(false);

        JButton btnStopInsercao = new JButton("PARAR INSERCAO");
        btnStopInsercao.setPreferredSize(new Dimension(Contants.LARGURA_TELA / 6, Contants.LARGURA_COLUNA_GRID));
        btnStopInsercao.setEnabled(false);
        // TextField
        JTextField txtNumeroThreads = new JTextField();
        txtNumeroThreads.setPreferredSize(new Dimension(Contants.LARGURA_TELA / 6, Contants.LARGURA_COLUNA_GRID));

        // Labels
        lblNumeroThreadAtual = new JLabel();
        lblNumeroThreadAtual.setText("0");
        lblNumeroThreadAtual.setPreferredSize(new Dimension(Contants.LARGURA_TELA / 6, Contants.LARGURA_COLUNA_GRID));

        // JPanel panLinhasBotoes
        JPanel panLinhasBotoes = new JPanel();
        panLinhasBotoes.setLayout(layout);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 10, 0, 10);
        panLinhasBotoes.add(lblTituloNumeroThread, constraints);

        constraints.gridx = 1;
        panLinhasBotoes.add(lblTituloThreadAtual, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(10, 10, 0, 10);
        panLinhasBotoes.add(txtNumeroThreads, constraints);

        constraints.gridx = 3;
        constraints.gridx = 1;
        panLinhasBotoes.add(lblNumeroThreadAtual, constraints);

        constraints.insets = new Insets(0, 0, Contants.MARGEM_BOTOES, 0);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panLinhasBotoes.add(btnIniciar, constraints);
        constraints.insets = new Insets(0, Contants.MARGEM_BOTOES, Contants.MARGEM_BOTOES, 0);
        constraints.gridx = 1;
        panLinhasBotoes.add(btnEncerrar, constraints);
        constraints.gridx = 2;
        panLinhasBotoes.add(btnStopInsercao, constraints);
        constraints.gridx = 3;

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 10, 10, 10);
        panLinhasBotoes.add(btnIniciar, constraints);

        constraints.gridx = 1;
        panLinhasBotoes.add(btnEncerrar, constraints);
        constraints.gridx = 2;
        panLinhasBotoes.add(btnStopInsercao, constraints);

        // JPanel jpTraffic
        JPanel jpTraffic = new JPanel();
        jpTraffic.setLayout(layout);
        jpTraffic.add(board, constraints);

        // JPanel panLayout
        JPanel panLayout = new JPanel();
        panLayout.setLayout(layout);
        panLayout.setSize(Contants.LARGURA_TELA, Contants.ALTURA_TELA);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panLayout.add(panLinhasBotoes, constraints);

        constraints.gridy = 1;
        panLayout.add(jpTraffic, constraints);
        // JScrollPane scpScroll
        JScrollPane scpScroll = new JScrollPane(panLayout);
        setTitle("Malha rodoviaria");
        setVisible(true);
        setSize(Contants.LARGURA_TELA, Contants.ALTURA_TELA);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(scpScroll);

        btnIniciar.addActionListener(e -> {
            controller.onIniciar(txtNumeroThreads.getText().toString());
            btnEncerrar.setEnabled(true);
            btnStopInsercao.setEnabled(true);
            btnIniciar.setEnabled(false);
        });
        btnEncerrar.addActionListener(e -> {
            controller.onEncerrarCarros();
            btnIniciar.setEnabled(true);
            btnStopInsercao.setEnabled(false);
            btnEncerrar.setEnabled(false);
        });

        btnStopInsercao.addActionListener(e -> {
            controller.onInsercaoCarros();
            btnIniciar.setEnabled(true);
            btnEncerrar.setEnabled(false);
            btnStopInsercao.setEnabled(false);
        });
    }

    public synchronized void atualizarThread() {
        lblNumeroThreadAtual.setText(String.valueOf(controller.getCars().size()));
        lblNumeroThreadAtual.repaint();
    }

    @Override
    public void notifyStartCar(int line, int column) {
        TableModel model = board.getModel();
        PieceModel pieceAtual = (PieceModel) model.getValueAt(line, column);
        pieceAtual.setPossuiCar(true);
        model.setValueAt(pieceAtual, line, column);
        controller.pieces[line][column] = pieceAtual;
        board.repaint();
        atualizarThread();
    }

    @Override
    public void notifyMoveCar(int pastLine, int pastColumn, int newLine, int newColumn) {
        TableModel model = board.getModel();
        PieceModel pieceAtual = (PieceModel) model.getValueAt(pastLine, pastColumn);
        PieceModel pieceNext = (PieceModel) model.getValueAt(newLine, newColumn);
        pieceAtual.setPossuiCar(false);
        pieceNext.setPossuiCar(true);
        model.setValueAt(pieceAtual, pastLine, pastColumn);
        model.setValueAt(pieceNext, newLine, newColumn);
        controller.pieces[pastLine][pastColumn] = pieceAtual;
        controller.pieces[newLine][newColumn] = pieceNext;
        board.repaint();
    }

    @Override
    public void notifyEndCar(int line, int column, Car car) {
        TableModel model = board.getModel();
        PieceModel pieceAtual = (PieceModel) model.getValueAt(line, column);
        pieceAtual.setPossuiCar(false);
        model.setValueAt(pieceAtual, line, column);
        controller.pieces[line][column] = pieceAtual;
        board.repaint();
        atualizarThread();
    }
}
