/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author breno
 */
public class ImageIconFactory {

    private static List<String> createdImagesNames = new ArrayList<>();
    private static List<ImageIcon> createdIcons = new ArrayList<>();

    public static ImageIcon create(String imagePath) {
        int imageIndex = createdImagesNames.indexOf(imagePath);
        if(imageIndex >= 0) {
            return createdIcons.get(imageIndex);
        } else {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            createdImagesNames.add(imagePath);
            createdIcons.add(imageIcon);
            return imageIcon;
        }
    }
	
}
