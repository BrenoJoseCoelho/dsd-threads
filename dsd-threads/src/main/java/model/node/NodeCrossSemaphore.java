/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.node;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import model.observer.ObserverNode;
import model.thread.Car;

/**
 *
 * @author breno
 */
public class NodeCrossSemaphore extends AbstractNode {

	private Semaphore semaphore = new Semaphore(1);

	public NodeCrossSemaphore(int x, int y, int type, ObserverNode observer) {
		super(x, y, type, observer, true);
	}

	@Override
	public synchronized void moveCar(Car car) throws InterruptedException {
		throw new InterruptedException();
	}

	@Override
	public AbstractNode getNextNode(Car car) {
		return null;
	}

	@Override
	public boolean tryNext() throws InterruptedException {
		return semaphore.tryAcquire(new Random().nextInt(2001 - 500) + 500, TimeUnit.MILLISECONDS);
	}

	@Override
	public void block() throws InterruptedException {
		semaphore.acquire();
	}

	@Override
	public void release() {
		semaphore.release();
	}

}