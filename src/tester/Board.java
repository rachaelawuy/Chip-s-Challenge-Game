/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import engine.*;
import java.awt.Graphics;
import java.awt.Point;
import java.io.*;
import java.util.*;
import javax.swing.JPanel;

/**
 *
 * @author i13037
 */
public class Board extends JPanel {

    private Tile[][] tiles; //papan permainan
    private Chip player; //pemain
    private int amountOfIC; //jumlah IC yang harus diambil
    private ArrayList res = new ArrayList();
    private int level;
    private int xBarrier, yBarrier;

    /**
     * Constructor kelas Chip
     *
     */
    public Board(String fileName) throws FileNotFoundException {
        this.level=0;
        this.amountOfIC = 0;
        tiles = new Tile[10][10];
        addLevel(fileName);
        //generateTile();
    }

    public void addLevel(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader buffered = new BufferedReader(reader);
            String temp = buffered.readLine();
            while (temp != null) {
                res.add(temp);
                temp = buffered.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        generateTile();
    }

    public void generateTile() {
        xBarrier = 0;
        yBarrier = 0;
        amountOfIC = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (res.get(i).toString().charAt(j) == '.') {
                    tiles[i][j] = new Floor();
                } else if (res.get(i).toString().charAt(j) == 'x') {
                    tiles[i][j] = new Wall();
                } else if (res.get(i).toString().charAt(j) == 'B') {
                    tiles[i][j] = new Barrier();
                    xBarrier = i;
                    yBarrier = j;
                } else if (res.get(i).toString().charAt(j) == 'F') {
                    tiles[i][j] = new Fire();
                } else if (res.get(i).toString().charAt(j) == 'P') {
                    tiles[i][j] = new FinishPoint();
                } else if (res.get(i).toString().charAt(j) == 'I') {
                    tiles[i][j] = new IntegratedCircuit();
                    this.amountOfIC += 1;
                } else if (res.get(i).toString().charAt(j) == 'C') {
                    tiles[i][j] = new Floor();
                    player = new Chip(i, j);
                } else if (res.get(i).toString().charAt(j) == 'V'){
                    tiles[i][j]= new FireproofShoes();
                } else if (res.get(i).toString().charAt(j) == 'W'){
                    tiles[i][j]= new Water();
                } else if (res.get(i).toString().charAt(j) == 'S'){
                    tiles[i][j]= new WaterproofShoes();
                }
            }
        }
    }

    /**
     * Method untuk mengecek apakah suatu tile bisa dilewati
     *
     * @param direction
     * @return
     */
    public boolean canMove(int direction) {
        boolean res = false;
        int x = 0;
        int y = 0;
        if (direction == 2) {
            x = (this.player.getLocation().x) + 1;
            y = this.player.getLocation().y;
            if (this.tiles[x][y].moveable()) {
                res = true;
            }
        }
        if (direction == 4) {
            x = this.player.getLocation().x;
            y = (this.player.getLocation().y) - 1;
            if (this.tiles[x][y].moveable()) {
                res = true;
            }
        }
        if (direction == 6) {
            x = this.player.getLocation().x;
            y = (this.player.getLocation().y) + 1;
            if (this.tiles[x][y].moveable()) {
                res = true;
            }
        }
        if (direction == 8) {
            x = (this.player.getLocation().x) - 1;
            y = this.player.getLocation().y;
            if (this.tiles[x][y].moveable()) {
                res = true;
            }
        }
        if (x > tiles.length || y > tiles.length) {
            res = false;
        }
        return res;
    }

    /**
     * Method untuk memindahkan Chip
     *
     * @param input arah Chip bergerak
     */
    public void play(int input) {
        if (!canMove(input) || player.isFinish()) {

        } else {
            if (player.getStatus()) {
                if (player.getIcTaken() == this.amountOfIC) {
                    tiles[xBarrier][yBarrier].setBarrierStatus(true);
                }
                player.move(input);
                tiles[player.getLocation().x][player.getLocation().y].steppedOn(player);
                IntegratedCircuit c = new IntegratedCircuit();
                if (tiles[player.getLocation().x][player.getLocation().y] instanceof IntegratedCircuit) {
                    tiles[player.getLocation().x][player.getLocation().y] = new Floor();
                } else if (tiles[player.getLocation().x][player.getLocation().y] instanceof FireproofShoes) {
                    tiles[player.getLocation().x][player.getLocation().y] = new Floor();
                } else if (tiles[player.getLocation().x][player.getLocation().y] instanceof WaterproofShoes) {
                    tiles[player.getLocation().x][player.getLocation().y] = new Floor();
                }
            }
        }
    }

    /**
     * Method untuk mengembalikan player
     *
     * @return Chip
     */
    public Chip getPlayer() {
        return player;
    }

    /**
     * Method untuk menggambar papan
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[0].length; y++) {
                g.drawImage(tiles[y][x].getImg(), x * tiles[y][x].getImg().getWidth(this), y * tiles[y][x].getImg().getHeight(this), this);
            }
        }
        g.drawImage(this.player.getImg(), tiles[0][0].getImg().getWidth(this) * player.getLocation().y, tiles[0][0].getImg().getHeight(this) * player.getLocation().x, this);
    }

    public int getAmountOfIC() {
        return amountOfIC;
    }
}
