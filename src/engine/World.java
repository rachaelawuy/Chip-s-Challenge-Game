/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rachae
 */
public class World extends JPanel{
    private Tile[][] tiles;
    private ArrayList res=new ArrayList();
    int xBarrier, yBarrier;
    int amountOfIC;
    
    public World(){
        tiles= new Tile[10][10];
    }
    
    public void generateTile1(){
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
    
    public void loadFromFile(String fileName){
        try{
            FileReader reader=new FileReader(fileName);
            BufferedReader buffered= new BufferedReader(reader);
            String temp= buffered.readLine();
            while (temp!=null){
                res.add(temp);
                temp=buffered.readLine();
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void generateTile(){
        xBarrier=0;
        yBarrier=0;
        amountOfIC=0;
        for (int i=0; i<tiles.length; i++){
            for (int j=0; j<tiles.length; j++){
                if(res.get(i).toString().charAt(j)=='.'){
                    tiles[j][i]=new Floor();
                } else if(res.get(i).toString().charAt(j)=='x'){
                    tiles[j][i]=new Wall();
                } else if(res.get(i).toString().charAt(j)=='B'){
                    tiles[j][i]=new Barrier();
                    xBarrier=i;
                    yBarrier=j;
                } else if(res.get(i).toString().charAt(j)=='F'){
                    tiles[j][i]=new Fire();
                } else if(res.get(i).toString().charAt(j)=='P'){
                    tiles[j][i]=new FinishPoint();
                } else if(res.get(i).toString().charAt(j)=='I'){
                    tiles[j][i]=new IntegratedCircuit();
                    this.amountOfIC+=1;
                } else if(res.get(i).toString().charAt(j)=='C'){
                    tiles[j][i]=new Floor();
                    //player=new Chip(i,j);
                }
            }
        }
    }
    
    
    public void printFile(String fileName){
        loadFromFile(fileName);
        generateTile();
        int counter=0;
        while(counter<res.size()){
            System.out.println(res.get(counter));
            counter+=1;
        }
    }

    
    public static void main(String[] args) {
        World t=new World();
        t.printFile("src\\level 1.txt");
        JFrame j= new JFrame();
        j.getContentPane().add(t);
        j.pack();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(228, 248);
        j.setVisible(true);
    }
}
