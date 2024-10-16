/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author breno
 */
public class ImageUtils {
    
    public static String getImagePath() {
        return "./src/main/java/imagens/";
    }
	
    public static String createImagePath(String image) {
        return createImagePath(image, "png");
    }

    public static String createImagePath(String image, String extensao) {
        return getImagePath()+"/"+image+"."+extensao;
    }
}
