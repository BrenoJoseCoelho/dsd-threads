/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.road;

import model.Contants;
import utils.ImageUtils;

/**
 *
 * @author breno
 */
public class RoadCruzamentoDownLeft extends PieceModel{

	public RoadCruzamentoDownLeft(int tipo) {
		super(tipo);
	}
	
	@Override
	public String getPathImageIcon() {
		return ImageUtils.createImagePath("/road/cruzamento-down-left");
	}

	@Override
	public String getPathImageCar() {
		String path = "carDown";
		if(this.getDirection() == Contants.LEFT) {
			path = "carLeft";
		}
		return ImageUtils.createImagePath("/car/" + path);
	}

}
