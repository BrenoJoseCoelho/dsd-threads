/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Contants;
import model.node.AbstractNode;
import model.observer.ObserverNode;
import model.road.PieceModel;
import model.thread.Car;
import model.thread.CarGenerator;
import singleton.MeshRepository;

/**
 *
 * @author breno
 */
public class TrafficSimulatorController implements AbstractTrafficSimulatorTableController, ObserverNode{
	private ObserverNode observerNode;
	private int[][] roadMesh;
	private boolean interruptClick;
	private AbstractNode[][] nodeMesh;
	public PieceModel[][] pieces;
	private List<Car> cars;
	private int numThreads = 0;
        private boolean stopAndWait = false;

	public TrafficSimulatorController() {
		super();
		interruptClick = false;
		this.roadMesh = MeshRepository.getInstance().getRoadMesh();
		pieces = MeshRepository.getInstance().getPiieces();
	}

	@Override
	public int getRowCount() {
		return roadMesh.length;
	}

	@Override
	public int getColumnCount() {
		return roadMesh[0].length;
	}

	@Override
	public PieceModel getValueAt(int rowIndex, int columnIndex) {
		return pieces[rowIndex][columnIndex];		
	}	
	
	public boolean hasElementAt(int linha, int coluna, int[][] state) {
		if (state[linha][coluna] == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public List<Car> getCars(){
		return cars;
	}
	
    public void onIniciar(String s) {
        interruptClick = false;
        nodeMesh = MeshRepository.getInstance().createNodeMesh(this);
        mapeaEntrada();
        cars = new ArrayList<>();
        if(s.matches("^\\d+$")){
            int numThreads = Integer.parseInt(s);
            this.numThreads = numThreads;
            CarGenerator generator = new CarGenerator(numThreads, cars, numThreads);
            generator.start();
        }
    }
    
    public void geraCarro(){
    	CarGenerator generator = new CarGenerator(1, cars, numThreads);
		generator.start();
    }
    
    public void onInsercaoCarros(){
        interruptClick = true;
       
        cars.clear();
    }
     
    public void onEncerrarCarros(){
        interruptClick = true;
        for (Car carro: cars) {
            carro.setBlockedTrue();
        }
        cars.clear();
    }
    
	private void mapeaEntrada() {
		for (int coluna = 0; coluna < roadMesh[0].length; coluna++) {
			if (roadMesh[0][coluna] == Contants.DOWN) {
				MeshRepository.getInstance().addInitNode(nodeMesh[0][coluna]);
			}
			if (roadMesh[roadMesh.length - 1][coluna] == Contants.UP) {
				MeshRepository.getInstance().addInitNode(nodeMesh[roadMesh.length - 1][coluna]);
			}
		}
		for (int linha = 0; linha < roadMesh.length - 1; linha++) {
			if (roadMesh[linha][0] == Contants.RIGHT) {
				MeshRepository.getInstance().addInitNode(nodeMesh[linha][0]);
			}
			if (roadMesh[linha][roadMesh[0].length - 1] == Contants.LEFT) {
				MeshRepository.getInstance().addInitNode(nodeMesh[linha][roadMesh[0].length - 1]);
			}
		}
	}

	public void addObserver(ObserverNode observer) {
		observerNode = observer;
	}


	@Override
	public void notifyStartCar(int line, int column) {
		observerNode.notifyStartCar(line, column);
	}

	@Override
	public void notifyMoveCar(int pastLine, int pastColumn, int newLine, int newColumn) {
		observerNode.notifyMoveCar(pastLine, pastColumn, newLine, newColumn);
	}

	@Override
	public void notifyEndCar(int line, int column, Car car) {
		observerNode.notifyEndCar(line, column, car);
		if (!interruptClick) {
			cars.remove(car);
			geraCarro();
		}
	}
}

