/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.node;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import model.observer.ObserverNode;
import model.thread.Car;

/**
 *
 * @author breno
 */
public class NodeCrossMonitor extends AbstractNode{

	private ReentrantLock lock = new ReentrantLock();

	public NodeCrossMonitor(int x, int y, int type, ObserverNode observer) {
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
		return lock.tryLock(new Random().nextInt(2001 - 500) + 500, TimeUnit.MILLISECONDS);
	}

	@Override
	public void block() throws InterruptedException {
		lock.lock();
	}

	@Override
	public void release() {
		if (lock.isHeldByCurrentThread()) {
			lock.unlock();
		}
	}
}

