/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.AbstractTrafficSimulatorTableController;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author breno
 */
public class TrafficSimulatorTableModel extends AbstractTableModel{
	
	private AbstractTrafficSimulatorTableController tableController;	
	private static final long serialVersionUID = 1L;

	public TrafficSimulatorTableModel(AbstractTrafficSimulatorTableController tableController) {
		super();
		this.tableController = tableController;
	}

	@Override
	public int getRowCount() {
		return tableController.getRowCount();
	}

	@Override
	public int getColumnCount() {
		return tableController.getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableController.getValueAt(rowIndex, columnIndex);
	}

}