/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author rachael
 */
public class Water extends Tile {

    /**
     * Konstruktor kelas Water
     * Mengeset atribut gambar dengan gambar berupa air
     */
    public Water() {
        String imgFileName = "water.png";
        URL imgURL = getClass().getResource("/images/water.png");
        if (imgURL == null) {
            System.err.println("Couldn't find the file " + imgFileName);
        } else {
            img = imgToolKit.getImage(imgURL);
        }
    }

    /**
     * Method untuk mengetahui apakah tile ini bisa dilewati
     *
     * @return true jika bisa, false jika tidak
     */
    @Override
    public boolean moveable() {
        return true;
    }

    /**
     * Method untuk mengeset keadaan tile dan Chip saat Chip menginjak tile Chip
     * akan mati jika menginjak tile, status Chip akan diubah menjadi false
     *
     * @param player karakter utama Chip
     */
    @Override
    public void steppedOn(Chip player) {
        if(!player.getWaterProof()){
            player.setStatus(false);
        }
    }
}
