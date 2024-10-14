/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.observer;

import model.thread.Car;

/**
 *
 * @author breno
 */
public interface ObserverNode {

    void notifyStartCar(int line, int column);
    void notifyMoveCar(int pastLine, int pastColumn, int newLine, int newColumn);
    void notifyEndCar(int line, int column, Car car);
}