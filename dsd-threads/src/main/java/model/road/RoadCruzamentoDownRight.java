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
public class RoadCruzamentoDownRight extends PieceModel{

	public RoadCruzamentoDownRight(int tipo) {
		super(tipo);
	}
	
	@Override
	public String getPathImageIcon() {
		return ImageUtils.createImagePath("/road/cruzamento-right-down");
	}

	@Override
	public String getPathImageCar() {
		String path = "carRight";
		if(this.getDirection() == Contants.DOWN) {
			path = "carDown";
		}
		return ImageUtils.createImagePath("/car/" + path);
	}

}