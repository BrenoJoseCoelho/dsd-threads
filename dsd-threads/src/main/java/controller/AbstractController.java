/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.observer.ObserverNode;
import model.thread.Car;

/**
 *
 * @author breno
 */
public interface AbstractController {
	
	public void addObserver(ObserverNode observer);	
    public void notificarInicioCarro(int linha, int coluna);
    public void notificarMovimentoCarro(int linhaAntiga, int colunaAntiga, int linhaNova, int colunaNova);
    public void notificarFimCarro(int linha, int coluna, Car carro);
}

