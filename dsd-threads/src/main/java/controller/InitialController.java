/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import observer.ObserverInitialView;
import singleton.MeshRepository;
import utils.ReadFileMesh;

/**
 *
 * @author breno
 */
public class InitialController {
	private ObserverInitialView observer;
	private int[][] malhaViaria;

	public InitialController(ObserverInitialView observer) {
		super();
		this.observer = observer;
	}

	public void updateRoadMesh(File arquivo) {
		try {
			malhaViaria = ReadFileMesh.gerarRoadMesh(arquivo);
			MeshRepository.getInstance().setRoadMesh(malhaViaria);
			MeshRepository.getInstance().initPiece();
			observer.ativedInitialButton();
		} catch (Exception e) {
			observer.notifyErrorFile();
		}
	}

	public void navigateNextView() {
		MeshRepository.getInstance().setRoadMesh(malhaViaria);
		observer.navigateNextView();
	}
}

