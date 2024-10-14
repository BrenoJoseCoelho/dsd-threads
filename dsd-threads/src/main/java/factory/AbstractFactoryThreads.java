/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import model.node.AbstractNode;
import model.observer.ObserverNode;

/**
 *
 * @author breno
 */
public abstract class AbstractFactoryThreads {
	public abstract AbstractNode createNode(int x, int y, int type, ObserverNode observer);
	public abstract AbstractNode createCrossNode(int x, int y, int type, ObserverNode observer);
}
