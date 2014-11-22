/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.net.URL;

/**
 *
 * @author rachael
 */
public class Fire extends Tile{

    /**
     * Konstruktor kelas Fire
     * Mengeset atribut gambar dengan gambar berupa api
     */
    public Fire() {
        String imgFileName= "fire22.png";
        URL imgURL= getClass().getResource("/images/fire22.png");
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
     * Chip akan mati jika menginjak tile, status Chip akan diubah menjadi false
     * @param player karakter utama Chip
     */
    @Override
    public void steppedOn(Chip player) {
        if(!player.getFireProof()){
            player.setStatus(false);
        }
    }
}
