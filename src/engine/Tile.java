/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.awt.Toolkit;
import java.awt.*;

/**
 *
 * @author i13037
 */
public abstract class Tile {

    protected Image img; //gambar untuk setiap objek
    protected Toolkit imgToolKit = Toolkit.getDefaultToolkit();

    /**
     * Method untuk mengetahui apakah tile ini bisa dilewati
     * @return true jika bisa, false jika tidak
     */
    public abstract boolean moveable();

    /**
     * Method untuk mengeset keadaan tile dan Chip saat Chip menginjak tile
     * @param player karakter utama Chip
     */
    public abstract void steppedOn(Chip player);

    /**
     * Method untuk mengembalikan gambar
     * @return gambar
     */
    public Image getImg() {
        return img;
    }
    
    /**
     * Method untuk menggantu status barrier
     * @param s false akan menutup barrierl, open akan membuka barrier
     */
    public void setBarrierStatus(boolean s){
        
    }
}
