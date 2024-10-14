/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import model.node.AbstractNode;
import model.node.NodeCrossSemaphore;
import model.node.NodeSemaphore;
import model.observer.ObserverNode;

/**
 *
 * @author breno
 */
public class ConcreteFactorySemaphore extends AbstractFactoryThreads{

	@Override
	public AbstractNode createNode(int x, int y, int type, ObserverNode observer) {
		return new NodeSemaphore(x, y, type, observer);
	}

	@Override
	public AbstractNode createCrossNode(int x, int y, int type, ObserverNode observer) {
		return new NodeCrossSemaphore(x, y, type, observer);
	}

}
