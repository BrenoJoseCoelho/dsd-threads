/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.road;

import utils.ImageUtils;
/**
 *
 * @author breno
 */
public class RoadRight extends PieceModel {

	public RoadRight(int tipo) {
		super(tipo);
	}

	@Override
	public String getPathImageIcon() {
		return ImageUtils.createImagePath("/road/right");
	}

	@Override
	public String getPathImageCar() {
		return ImageUtils.createImagePath("/car/carRight");
	}

}
