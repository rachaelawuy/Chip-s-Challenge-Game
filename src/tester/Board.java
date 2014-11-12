/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import engine.*;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author i13037
 */
public class Board extends JPanel {

    private Tile[][] tiles; //papan permainan
    private Chip player; //pemain
    private int amountOfIC; //jumlah IC yang harus diambil

    /**
     * Constructor kelas Chip
     *
     * @param size luas papan size*size
     */
    public Board(int size) {
        tiles = new Tile[size][size];
        int x = size / 2;
        this.player = new Chip(x, x);
        this.amountOfIC = 4;
        generateTile();
    }

    /**
     * Method untuk membuat masing2 tile
     */
    public void generateTile() {
        Point[] wall = new Point[19];
        wall[0] = new Point(0, 1);
        wall[1] = new Point(0, 3);
        wall[2] = new Point(0, 4);
        wall[3] = new Point(0, 5);
        wall[4] = new Point(0, 6);
        wall[5] = new Point(1, 0);
        wall[6] = new Point(1, 6);
        wall[7] = new Point(2, 1);
        wall[8] = new Point(2, 2);
        wall[9] = new Point(2, 4);
        wall[10] = new Point(3, 0);
        wall[11] = new Point(3, 6);
        wall[12] = new Point(4, 2);
        wall[13] = new Point(4, 4);
        wall[14] = new Point(5, 0);
        wall[15] = new Point(5, 2);
        wall[16] = new Point(6, 2);
        wall[17] = new Point(6, 4);
        wall[18] = new Point(6, 6);
        int wallCounter = 0;
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[0].length; j++) {
                if (i == 2 && j == 3) {
                    this.tiles[i][j] = new Fire();
                } else if (i == 6 && j == 0) {
                    this.tiles[i][j] = new FinishPoint();
                } else if (i == 6 && j == 1) {
                    this.tiles[i][j] = new Barrier();
                } else if ((i == 0 && j == 2) || (i == 1 && j == 5) || (i == 4 && j == 1) || (i == 6 && j == 5)) {
                    this.tiles[i][j] = new IntegratedCircuit();
                } else if (wall[wallCounter].x == i && wall[wallCounter].y == j) {
                    tiles[i][j] = new Wall();
                    wallCounter += 1;
                } else {
                    this.tiles[i][j] = new Floor();
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
    public void play(int input){
        if (!canMove(input) || player.isFinish()) {
            
        } else {
            if (player.getStatus()) {
                if (player.getIcTaken() == this.amountOfIC) {
                    tiles[6][1].setBarrierStatus(true);
                }
                player.move(input);
                tiles[player.getLocation().x][player.getLocation().y].steppedOn(player);
                IntegratedCircuit c= new IntegratedCircuit();
                if (tiles[player.getLocation().x][player.getLocation().y].getClass()==c.getClass()){
                    tiles[player.getLocation().x][player.getLocation().y]=new Floor();
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
}
