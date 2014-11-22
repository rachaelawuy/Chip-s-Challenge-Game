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
public class Wall extends Tile{
    
    /**
     * Constructor kelas Wall
     * Menggambar wall pada tile
     */
    public Wall(){
        String imgFileName= "wall33.jpg";
        URL imgURL= getClass().getResource("/images/wall33.jpg");
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
        return false;
    }

    /**
     * Method untuk mengeset keadaan tile dan Chip saat Chip menginjak tile
     * @param player karakter utama Chip
     */
    @Override
    public void steppedOn(Chip player) {
        //tidak terjadi apa-apa karena Chip tidak bisa menginjak wall
    }
}
