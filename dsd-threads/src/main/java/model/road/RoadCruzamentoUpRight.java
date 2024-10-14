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
public class RoadCruzamentoUpRight extends PieceModel{

	public RoadCruzamentoUpRight(int tipo) {
		super(tipo);
	}
	
	@Override
	public String getPathImageIcon() {
		return ImageUtils.createImagePath("/road/cruzamento-up-right");
	}

	@Override
	public String getPathImageCar() {		
		String path = "carUp";
		if(this.getDirection() == Contants.RIGHT) {
			path = "carRight";
		}
		return ImageUtils.createImagePath("/car/" + path);
	}

}
