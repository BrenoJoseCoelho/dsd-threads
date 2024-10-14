/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.thread;

import java.util.List;
import java.util.Random;
import model.node.AbstractNode;
import singleton.MeshRepository;

/**
 *
 * @author breno
 */
public class CarGenerator extends Thread{
	private List<Car> cars;
	private int quantidade;
	private int maxThread;
	
	public CarGenerator(int quantidade, List<Car> cars, int maxThread) {
		this.quantidade = quantidade;
		this.cars = cars;
		this.maxThread = maxThread;
	}
	
    private void geraCarro(){
        int posicao = new Random().nextInt(MeshRepository.getInstance().getNodeInit().size());
        AbstractNode choose = MeshRepository.getInstance().getNodeInit().get(posicao);
        Car car = new Car(choose);
        cars.add(car);
        car.start();
    }
	
	@Override
	public void run() {
		if(cars.size() < maxThread) {
			for(int i= 0; i < quantidade; i++) {
				geraCarro();
			}
			Thread.currentThread().interrupt();
		}
	}
}
