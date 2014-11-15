/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author rachae
 */
public abstract class Shoes {
    protected Image img; //gambar untuk setiap objek
    protected Toolkit imgToolKit = Toolkit.getDefaultToolkit();
    protected Point location;
    
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

    public abstract void use(Chip player);
    
    /**
     * Method untuk mengembalikan gambar
     * @return gambar
     */
    public Image getImg() {
        return img;
    }

    public Point getLocation() {
        return location;
    }
}
