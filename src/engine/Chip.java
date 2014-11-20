/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author i13037
 */
public class Chip extends JPanel{

    private Point location; //lokasi Chip
    private boolean isAlive; //status chip 
    private int icTaken; //jumlah chip yang telah diambil
    private boolean finish; //status yang menunjukkan apakah chip sudah sampai ke finish point
    private Image img; //gambar Chip
    private boolean waterProof;
    private boolean fireProof;
    
    /**
     * Constructor Kelas Chip Menginisiasikan status Chip menjadi true dan
     * jumlah IC yg diambil dengan 0
     * @param x koordinat x posisi Chip
     * @param y koordinat y posisi Chip
     */
    public Chip(int x, int y) {
        location = new Point(x, y);
        isAlive = true;
        icTaken = 0;
        fireProof=false;
        waterProof=false;
        finish = false;
        String imgFileName = "chip kiri.gif";
        URL imgURL = getClass().getResource("/images/chip kiri.gif");
        if (imgURL == null) {
            System.err.println("Couldn't find the file " + imgFileName);
        } else {
            img = Toolkit.getDefaultToolkit().getImage(imgURL);
        }
    }

    /**
     * Method untuk mengembalikan lokasi Chip
     *
     * @return lokasi Chip berupa point
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Method untuk mengeset lokasi Chip
     * @param x koordinat x lokasi Chip yg baru
     * @param y koordinat y lokasi Chip yg baru
     */
    public void setLocation(int x, int y) {
        Point location = new Point(x, y);
        this.location = location;
    }

    /**
     * Method untuk mengecek apakah Chip masih hidup
     * @return true jika Chip masih hidup, false jika Chip sudah mati
     */
    public boolean getStatus() {
        return this.isAlive;
    }

    /**
     *Method untuk mengeset status finish milik Chip
     * @param isFinished true berarti Chip sudah sampai finish point, false jika belum
     */
    public void isFinished(boolean isFinished) {
        this.finish = isFinished;
    }

    /**
     * Method untuk mengecek apakah Chip sudah sampai ke finish point
     * @return true jika Chip sudah sampai, false jika belum
     */
    public boolean isFinish() {
        return finish;
    }

    /**
     * Method untuk mengubah status Chip
     * @param isAlive false berarti Chip mati, true berarti Chip hidup
     */
    public void setStatus(boolean isAlive) {
        this.isAlive = isAlive;
    }

    /**
     * Method untuk mengambil IC Jika lokasi Chip tidak sama dengan lokasi IC
     * maka tidak akan terjadi apa-apa
     * @param x koordinat x posisi IC
     * @param y koordinat y posisi IC
     */
    public void take(int x, int y, Object o) {
        Point ic = new Point(x, y);
        if(o instanceof IntegratedCircuit){
            icTaken+=1;
        } else if(o instanceof FireproofShoes){
            fireProof=true;
        } else if(o instanceof WaterproofShoes){
            waterProof=true;
        }
    }

    /**
     * Method untuk menggerakkan Chip
     *
     * @param x 2 berarti kebawah, 4 berarti kekiri, 8 berarti keatas, 6 berarti
     * kekanan
     */
    public void move(int x) {
        Point newLocation;
        URL imgURL=null;
        if (x == 2) {
            newLocation = new Point((this.location.x + 1), this.location.y);
            setLocation(newLocation);
            imgURL=getClass().getResource("/images/chip bawah.gif");
        } else if (x == 4) {
            newLocation = new Point(this.location.x, (this.location.y - 1));
            setLocation(newLocation);
            imgURL=getClass().getResource("/images/chip kiri.gif");
        } else if (x == 6) {
            newLocation = new Point(this.location.x, (this.location.y + 1));
            setLocation(newLocation);
            imgURL=getClass().getResource("/images/chip kanan.gif");
        } else if (x == 8) {
            newLocation = new Point((this.location.x - 1), this.location.y);
            setLocation(newLocation);
            imgURL=getClass().getResource("/images/chip atas.gif");
        } else {

        }
        if (imgURL == null) {
            System.err.println("Couldn't find the file");
        } else {
            img = Toolkit.getDefaultToolkit().getImage(imgURL);
        }
    }

    /**
     * Method untuk mengembalikan jumlah IC yang telah diambil
     *
     * @return jumlah IC yang telah diambil
     */
    public int getIcTaken() {
        return icTaken;
    }

    /**
     * Method untuk mengembalikan gambar Chip
     * @return gambar Chip
     */
    public Image getImg() {
        return img;
    }

    public boolean getWaterProof() {
        return waterProof;
    }

    public void setWaterProof(boolean waterProof) {
        this.waterProof = waterProof;
    }

    public boolean getFireProof() {
        return fireProof;
    }

    public void setFireProof(boolean fireProof) {
        this.fireProof = fireProof;
    }
}
