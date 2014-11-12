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
public class Barrier extends Tile {

    private boolean open; //status barrier apakah terbuka atau tertutup

    /**
     * Constructor kelas Barrier
     * Status barrier tertutup
     */
    public Barrier() {
        open = false;
        String imgFileName = "barrierr.png";
        URL imgURL = getClass().getResource("/images/barrierr.png");
        if (imgURL == null) {
            System.err.println("Couldn't find the file " + imgFileName);
        } else {
            img = imgToolKit.getImage(imgURL);
        }
    }

    /**
     * Method untuk mendapatkan status barrier
     * @return status barrier saat ini, true jika terbuka, false jika tertutup
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * Method untuk menggantu status barrier
     * @param status false akan menutup barrierl, open akan membuka barrier
     */
    @Override
    public void setBarrierStatus(boolean status) {
        open = status;
    }

    /**
     * Method untuk mengetahui apakah suatu tile dapat dilewati atau tidak
     * @return true jika dapat dilewati, false jika tidak bisa dilewati
     */
    @Override
    public boolean moveable() {
        if (open==true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method untuk mengeset keadaan tile dan Chip saat Chip menginjak tile
     * @param player karakter utama Chip
     */
    @Override
    public void steppedOn(Chip player) {
        if (open==true) {
            String imgFileName = "tilefix.jpg";
            URL imgURL = getClass().getResource("/images/tilefix.jpg");
            if (imgURL == null) {
                System.err.println("Couldn't find the file " + imgFileName);
            } else {
                img = imgToolKit.getImage(imgURL);
            }
        }
    }

}
