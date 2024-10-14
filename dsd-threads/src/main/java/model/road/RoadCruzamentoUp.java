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
public class RoadCruzamentoUp extends PieceModel{

	public RoadCruzamentoUp(int tipo) {
		super(tipo);
	}
	
	@Override
	public String getPathImageIcon() {
		return ImageUtils.createImagePath("/road/cruzamento-up");
	}

	@Override
	public String getPathImageCar() {
		return ImageUtils.createImagePath("/car/carUp");
	}

}