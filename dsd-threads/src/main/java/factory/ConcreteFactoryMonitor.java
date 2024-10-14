/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import model.node.AbstractNode;
import model.node.NodeCrossMonitor;
import model.node.NodeMonitor;
import model.observer.ObserverNode;

/**
 *
 * @author breno
 */
public class ConcreteFactoryMonitor extends AbstractFactoryThreads{

	@Override
	public AbstractNode createNode(int x, int y, int type, ObserverNode observer) {
		return new NodeMonitor(x, y, type, observer);
	}

	@Override
	public AbstractNode createCrossNode(int x, int y, int type, ObserverNode observer) {
		return new NodeCrossMonitor(x, y, type, observer);
	}
}
