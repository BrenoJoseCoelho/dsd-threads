/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author breno
 */
public interface AbstractTrafficSimulatorTableController {

	public int getRowCount();

	public int getColumnCount();

	public Object getValueAt(int rowIndex, int columnIndex);
}

