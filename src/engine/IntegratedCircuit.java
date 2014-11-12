/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.net.URL;

/**
 *
 * @author rachae
 */
public class IntegratedCircuit extends Tile {
    
    public IntegratedCircuit() {
        String imgFileName= "ic31.png";
        URL imgURL= getClass().getResource("/images/ic31.png");
        if(imgURL==null){
            System.err.println("Couldn't find the file "+ imgFileName);
        } else {
            img= imgToolKit.getImage(imgURL);
        }
    }

    /**
     * Method untuk mengetahui apakah tile ini bisa dilewati
     * @return true jika bisa, false jika tidak
     */
    @Override
    public boolean moveable() {
        return true;
    }

    /**
     * Method untuk mengeset keadaan tile dan Chip saat Chip menginjak tile
     * Chip mengambil IC
     * @param player karakter utama Chip
     */
    @Override
    public void steppedOn(Chip player) {
        player.take(player.getLocation().x, player.getLocation().y);
        String imgFileName= "tilefix.jpg";
        URL imgURL= getClass().getResource("/images/tilefix.jpg");
        if(imgURL==null){
            System.err.println("Couldn't find the file "+ imgFileName);
        } else {
            img= imgToolKit.getImage(imgURL);
        }
    }
    
}
