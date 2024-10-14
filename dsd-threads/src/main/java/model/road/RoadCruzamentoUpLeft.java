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
public class RoadCruzamentoUpLeft extends PieceModel{

	public RoadCruzamentoUpLeft(int tipo) {
		super(tipo);
	}
	
	@Override
	public String getPathImageIcon() {
		return ImageUtils.createImagePath("/road/cruzamento-left-up");
	}

	@Override
	public String getPathImageCar() {
		String path = "carLeft";
		if(this.getDirection() == Contants.UP) {
			path = "carUp";
		}
		return ImageUtils.createImagePath("/car/" + path);
	}

}