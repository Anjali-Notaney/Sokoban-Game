

//Name: Anjali Notaney
//Last Update: Jan 22, 2018
//Game: Sokoban

//importing libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class game extends Applet implements ActionListener
{
	// Declaring the global widgets
    JButton level, undo, redo, winner;
    JLabel gold, result, moves, level_num, pic1, ins1;

    // Initializing global variables
    int l = 1;
    int k = 0;
    int z = 0;
    int x = 7;
    int y = 8;
    int M = 0;
    int s = -1;
    int r = 0;
    int p = 1;
    
    //screen information
    Panel p_screen;
    Panel screen1, screen2, screen3, screen4, screen5;
    CardLayout cdLayout = new CardLayout ();
    
    //grid for game
    int row = 17;
    int col = 20;
    
    //array that will be printed on the screen
    int map[] [] [] = {{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 2, 4, 4, 4, 1, 4, 4, 4, 2, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 2, 2, 2, 3, 2, 3, 2, 2, 2, 1, 0, 0, 0, 0, 8, 0}, {0, 0, 0, 1, 2, 3, 3, 1, 1, 1, 3, 3, 2, 1, 0, 0, 0, 5, 0, 7}, {0, 0, 0, 1, 2, 2, 2, 1, 0, 1, 2, 2, 2, 1, 0, 0, 0, 0, 6, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //0
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 1, 2, 1, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 1, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 3, 3, 3, 2, 1, 2, 1, 0, 0, 0, 0, 0, 8, 0}, {0, 0, 0, 0, 1, 2, 3, 2, 3, 2, 2, 2, 1, 0, 0, 0, 0, 5, 0, 7}, {0, 0, 0, 0, 1, 2, 3, 3, 3, 1, 1, 2, 1, 0, 0, 0, 0, 0, 6, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //5
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 3, 3, 3, 1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 3, 2, 3, 2, 2, 2, 1, 0, 0, 0, 0, 0, 8, 0}, {0, 0, 0, 0, 1, 2, 3, 3, 3, 2, 2, 2, 1, 0, 0, 0, 0, 5, 0, 7}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 6, 0}, {0, 0, 0, 0, 1, 2, 1, 1, 1, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //6
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 2, 2, 1, 2, 2, 1, 1, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 2, 2, 1, 2, 2, 1, 4, 4, 4, 1, 1, 1, 0, 0, 0, 0, 0}, {0, 1, 2, 2, 3, 1, 2, 2, 1, 4, 4, 4, 2, 2, 1, 0, 0, 0, 0, 0}, {0, 1, 2, 3, 2, 1, 3, 3, 2, 4, 4, 4, 2, 2, 1, 0, 0, 0, 0, 0}, {0, 1, 2, 2, 3, 1, 2, 2, 1, 4, 1, 4, 2, 4, 1, 0, 0, 0, 8, 0}, {0, 1, 2, 2, 2, 1, 2, 3, 1, 1, 2, 1, 1, 1, 1, 1, 0, 5, 0, 7}, {0, 1, 1, 3, 2, 2, 2, 2, 2, 2, 3, 3, 2, 3, 2, 1, 0, 0, 6, 0}, {0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 1, 2, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 3, 3, 2, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //3
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 4, 4, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 1, 4, 4, 2, 2, 1, 2, 3, 2, 2, 3, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 4, 4, 2, 2, 1, 3, 1, 1, 1, 1, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 4, 4, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 1, 0, 0, 8, 0}, {0, 0, 1, 4, 4, 2, 2, 1, 2, 1, 2, 2, 3, 2, 1, 1, 0, 5, 0, 7}, {0, 0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 3, 2, 3, 2, 1, 0, 0, 6, 0}, {0, 0, 0, 0, 1, 2, 3, 2, 2, 3, 2, 3, 2, 3, 2, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //4
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 3, 3, 1, 3, 3, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 2, 3, 2, 2, 3, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 2, 2, 3, 1, 2, 3, 1, 2, 1, 0, 0, 0, 0, 0, 8, 0}, {0, 0, 0, 1, 2, 3, 2, 2, 3, 2, 2, 2, 1, 0, 0, 0, 0, 5, 0, 7}, {0, 0, 0, 1, 2, 3, 2, 2, 3, 2, 2, 2, 1, 0, 0, 0, 0, 0, 6, 0}, {0, 0, 0, 1, 2, 3, 3, 1, 3, 3, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //2
            {{0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0}, {1, 2, 3, 2, 3, 2, 3, 3, 1, 1, 1, 1, 1, 2, 2, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 3, 2, 2, 2, 1, 2, 2, 2, 1, 3, 2, 1, 0, 0, 0, 0}, {1, 2, 2, 1, 2, 2, 3, 3, 1, 3, 3, 2, 1, 2, 2, 1, 0, 0, 0, 0}, {1, 2, 3, 1, 2, 2, 2, 2, 2, 2, 1, 2, 1, 3, 1, 1, 0, 0, 0, 0}, {1, 2, 2, 1, 1, 1, 1, 2, 3, 2, 3, 2, 2, 2, 1, 1, 0, 0, 8, 0}, {1, 2, 3, 2, 3, 2, 3, 2, 3, 1, 2, 2, 3, 2, 1, 1, 0, 5, 0, 7}, {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 0, 0, 6, 0}, {1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {0, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 2, 1, 4, 4, 4, 1, 2, 2, 2, 1, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}}}; //1

    //same array as map[][][] but without diamonds (i.e. without 3) 
    int underMap[] [] [] = {{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 2, 4, 4, 4, 1, 4, 4, 4, 2, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 8, 0}, {0, 0, 0, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 0, 0, 0, 5, 0, 7}, {0, 0, 0, 1, 2, 2, 2, 1, 0, 1, 2, 2, 2, 1, 0, 0, 0, 0, 6, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //0
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 1, 2, 1, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 1, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 1, 2, 1, 0, 0, 0, 0, 0, 8, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 5, 0, 7}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 1, 1, 2, 1, 0, 0, 0, 0, 0, 6, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //5
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 2, 2, 2, 1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 8, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 5, 0, 7}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 6, 0}, {0, 0, 0, 0, 1, 2, 1, 1, 1, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //6
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 2, 2, 1, 2, 2, 1, 1, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 2, 2, 1, 2, 2, 1, 4, 4, 4, 1, 1, 1, 0, 0, 0, 0, 0}, {0, 1, 2, 2, 2, 1, 2, 2, 1, 4, 4, 4, 2, 2, 1, 0, 0, 0, 0, 0}, {0, 1, 2, 2, 2, 1, 2, 2, 2, 4, 4, 4, 2, 2, 1, 0, 0, 0, 0, 0}, {0, 1, 2, 2, 2, 1, 2, 2, 1, 4, 1, 4, 2, 4, 1, 0, 0, 0, 8, 0}, {0, 1, 2, 2, 2, 1, 2, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0, 5, 0, 7}, {0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 6, 0}, {0, 1, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 2, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //3
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 1, 2, 1, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 1, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 1, 2, 1, 0, 0, 0, 0, 0, 8, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 5, 0, 7}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 1, 1, 2, 1, 0, 0, 0, 0, 0, 6, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //4
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 2, 2, 1, 2, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 2, 2, 2, 1, 2, 2, 1, 2, 1, 0, 0, 0, 0, 0, 8, 0}, {0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 5, 0, 7}, {0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 6, 0}, {0, 0, 0, 1, 2, 2, 2, 1, 2, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //2
            {{0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0}, {1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 0, 0, 0, 0}, {1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 0, 0, 0, 0}, {1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 1, 0, 0, 0, 0}, {1, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0, 8, 0}, {1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 1, 0, 5, 0, 7}, {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 0, 0, 6, 0}, {1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {0, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 4, 1, 4, 4, 4, 1, 4, 4, 4, 1, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 2, 4, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}}}; //1

    //array for storing  all original positions for undo, redo and reset functions
    int newMap[] [] [] = {{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 2, 4, 4, 4, 1, 4, 4, 4, 2, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 2, 2, 2, 3, 2, 3, 2, 2, 2, 1, 0, 0, 0, 0, 8, 0}, {0, 0, 0, 1, 2, 3, 3, 1, 1, 1, 3, 3, 2, 1, 0, 0, 0, 5, 0, 7}, {0, 0, 0, 1, 2, 2, 2, 1, 0, 1, 2, 2, 2, 1, 0, 0, 0, 0, 6, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //0
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 1, 2, 1, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 1, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 3, 3, 3, 2, 1, 2, 1, 0, 0, 0, 0, 0, 8, 0}, {0, 0, 0, 0, 1, 2, 3, 2, 3, 2, 2, 2, 1, 0, 0, 0, 0, 5, 0, 7}, {0, 0, 0, 0, 1, 2, 3, 3, 3, 1, 1, 2, 1, 0, 0, 0, 0, 0, 6, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //5
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 3, 3, 3, 1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 3, 2, 3, 2, 2, 2, 1, 0, 0, 0, 0, 0, 8, 0}, {0, 0, 0, 0, 1, 2, 3, 3, 3, 2, 2, 2, 1, 0, 0, 0, 0, 5, 0, 7}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 6, 0}, {0, 0, 0, 0, 1, 2, 1, 1, 1, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //6
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 2, 2, 1, 2, 2, 1, 1, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 2, 2, 1, 2, 2, 1, 4, 4, 4, 1, 1, 1, 0, 0, 0, 0, 0}, {0, 1, 2, 2, 3, 1, 2, 2, 1, 4, 4, 4, 2, 2, 1, 0, 0, 0, 0, 0}, {0, 1, 2, 3, 2, 1, 3, 3, 2, 4, 4, 4, 2, 2, 1, 0, 0, 0, 0, 0}, {0, 1, 2, 2, 3, 1, 2, 2, 1, 4, 1, 4, 2, 4, 1, 0, 0, 0, 8, 0}, {0, 1, 2, 2, 2, 1, 2, 3, 1, 1, 2, 1, 1, 1, 1, 1, 0, 5, 0, 7}, {0, 1, 1, 3, 2, 2, 2, 2, 2, 2, 3, 3, 2, 3, 2, 1, 0, 0, 6, 0}, {0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 1, 2, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 3, 3, 2, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //3
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 4, 4, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 1, 4, 4, 2, 2, 1, 2, 3, 2, 2, 3, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 4, 4, 2, 2, 1, 3, 1, 1, 1, 1, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 4, 4, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 1, 0, 0, 8, 0}, {0, 0, 1, 4, 4, 2, 2, 1, 2, 1, 2, 2, 3, 2, 1, 1, 0, 5, 0, 7}, {0, 0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 3, 2, 3, 2, 1, 0, 0, 6, 0}, {0, 0, 0, 0, 1, 2, 3, 2, 2, 3, 2, 3, 2, 3, 2, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //4
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 3, 3, 1, 3, 3, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 2, 3, 2, 2, 3, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 2, 2, 3, 1, 2, 3, 1, 2, 1, 0, 0, 0, 0, 0, 8, 0}, {0, 0, 0, 1, 2, 3, 2, 2, 3, 2, 2, 2, 1, 0, 0, 0, 0, 5, 0, 7}, {0, 0, 0, 1, 2, 3, 2, 2, 3, 2, 2, 2, 1, 0, 0, 0, 0, 0, 6, 0}, {0, 0, 0, 1, 2, 3, 3, 1, 3, 3, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},  //2
            {{0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0}, {1, 2, 3, 2, 3, 2, 3, 3, 1, 1, 1, 1, 1, 2, 2, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 3, 2, 2, 2, 1, 2, 2, 2, 1, 3, 2, 1, 0, 0, 0, 0}, {1, 2, 2, 1, 2, 2, 3, 3, 1, 3, 3, 2, 1, 2, 2, 1, 0, 0, 0, 0}, {1, 2, 3, 1, 2, 2, 2, 2, 2, 2, 1, 2, 1, 3, 1, 1, 0, 0, 0, 0}, {1, 2, 2, 1, 1, 1, 1, 2, 3, 2, 3, 2, 2, 2, 1, 1, 0, 0, 8, 0}, {1, 2, 3, 2, 3, 2, 3, 2, 3, 1, 2, 2, 3, 2, 1, 1, 0, 5, 0, 7}, {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 0, 0, 6, 0}, {1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {0, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 2, 1, 4, 4, 4, 1, 2, 2, 2, 1, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}}}; //1


    //arrays for storing information regarding moves
    int steps[] [] [] = new int [400] [17] [20];
    int curx[] = new int [400]; // storing the x-coordinates of the each move
    int cury[] = new int [400]; // storing the y-coordinates of the each move

    /*creating an array of buttons with names corresponding to their
    x and y coordinates in the grid */
    JButton pics[] = new JButton [row * col];
    
    // init method, starting point of the program
    public void init ()
    {
        p_screen = new Panel ();
        p_screen.setLayout (cdLayout);

        // creating the screens
        splash ();
        instructions ();
        game ();
        closing ();
        
        // resizing the screen
        resize (500, 620);
        
        setLayout (new BorderLayout ());
        add ("Center", p_screen);
    }

    // customizing the splash screen
    public void splash ()
        {
        screen1 = new Panel ();
        screen1.setBackground (new Color (4, 13, 28));
        JLabel title1 = new JLabel (createImageIcon("TITLE.jpg"));
        
        // setting up the play button
        JButton next = new JButton ("Play");
        next.setFont(new Font ("Arial", Font.PLAIN, 28));
        next.setBackground(new Color (57, 194, 216));
        next.setPreferredSize (new Dimension (400, 50));
        next.setActionCommand ("s2");
        next.addActionListener (this);
        
        // adding widgets to the screen
        screen1.add (title1);
        screen1.add (next);
        
        // adding screen 1 to the main panel, p_screen
        p_screen.add ("1", screen1);
        }
        
    // customizing the instructions screen
    public void instructions ()
    { 
        screen2 = new Panel ();
        screen2.setBackground (new Color (4, 13, 28));
        
        // creating a title label on the instruction screen
        JLabel heading = new JLabel ("    Instructions");
        heading.setPreferredSize (new Dimension (200, 60));
        heading.setFont (new Font ("Impact", Font.PLAIN, 30));
        heading.setForeground (new Color (57, 194, 216));
        
        // creating an image label and scaling it
        pic1 = new JLabel (createImageIcon ("ins1.jpg"));
        pic1.setPreferredSize (new Dimension (420, 190));
        
        // creating another image label and scaling it
        ins1 = new JLabel (createImageIcon ("ins-1.jpg"));
        ins1.setPreferredSize (new Dimension (500, 190));
        
        //initializing some more buttons on the screen 
        JButton game = new JButton ("Game");
        game.setActionCommand ("s3");
        game.addActionListener (this);
        game.setPreferredSize (new Dimension (400, 40));
        game.setBackground ((new Color (57, 194, 216)));
        
        JButton back = new JButton ("Back");
        back.setActionCommand ("s1");
        back.addActionListener (this);
        back.setPreferredSize (new Dimension (400, 40));
        back.setBackground ((new Color (57, 194, 216)));

        JButton one = new JButton ("1");
        one.setActionCommand ("I1");
        one.addActionListener (this);
        one.setPreferredSize (new Dimension (40, 40));
        one.setFont (new Font ("Arial", Font.PLAIN, 10));
        one.setBackground ((new Color (57, 194, 216)));
        
        JButton two = new JButton ("2");
        two.setActionCommand ("I2");
        two.addActionListener (this);
        two.setPreferredSize (new Dimension (40, 40));
        two.setFont (new Font ("Arial", Font.PLAIN, 10));
        two.setBackground ((new Color (57, 194, 216)));
        
        JButton three = new JButton ("3");
        three.setActionCommand ("I3");
        three.addActionListener (this);
        three.setPreferredSize (new Dimension (40, 40));
        three.setFont (new Font ("Arial", Font.PLAIN, 10));
        three.setBackground ((new Color (57, 194, 216)));
        
        JButton four = new JButton ("4");
        four.setActionCommand ("I4");
        four.addActionListener (this);
        four.setPreferredSize (new Dimension (40, 40));
        four.setFont (new Font ("Arial", Font.PLAIN, 10));
        four.setBackground ((new Color (57, 194, 216)));
        
        JButton five = new JButton ("5");
        five.setActionCommand ("I5");
        five.addActionListener (this);
        five.setPreferredSize (new Dimension (40, 40));
        five.setFont (new Font ("Arial", Font.PLAIN, 10));
        five.setBackground ((new Color (57, 194, 216)));
        
        JButton six = new JButton ("6");
        six.setActionCommand ("I6");
        six.addActionListener (this);
        six.setPreferredSize (new Dimension (40, 40));
        six.setFont (new Font ("Arial", Font.PLAIN, 10));
        six.setBackground ((new Color (57, 194, 216)));

        // adding all the widgets on the screen
        screen2.add (heading);
        screen2.add (pic1);
        screen2.add (ins1);
        screen2.add (one);
        screen2.add (two);
        screen2.add (three);
        screen2.add (four);
        screen2.add (five);
        screen2.add (six);
        screen2.add (game);
        screen2.add (back);
        
        // adding screen 2 to the main panel, p_screen
        p_screen.add ("2", screen2);
    }

    public void game ()
    { 
    	
        screen3 = new Panel ();
        screen3.setBackground (new Color (4, 13, 28));
        gold = new JLabel ("        "); // padding 
        gold.setPreferredSize (new Dimension (60, 50));

        result = new JLabel (createImageIcon ("diamonds.jpg"));
        result.setPreferredSize (new Dimension (80, 50));

        // creating the title
        JLabel title1 = new JLabel ("SOKOBAN");
        title1.setPreferredSize (new Dimension (120, 60));
        title1.setFont (new Font ("Impact", Font.PLAIN, 30));
        title1.setForeground ((new Color (57, 194, 216)));
        
        // creating a label to display moves 
        moves = new JLabel ("        moves: " + M);
        moves.setPreferredSize (new Dimension (120, 20));
        moves.setFont (new Font ("Arial", Font.PLAIN, 16));
        moves.setForeground (new Color (228, 244, 244));

        // creating a button to go to closing screeen
        JButton closing = new JButton ("Closing Screen");
        closing.setBackground (new Color (57, 194, 216));
        closing.setActionCommand ("s4");
        closing.addActionListener (this);
        closing.setPreferredSize (new Dimension (120, 28));

        // creating a button to go back to instructions page
        JButton instr = new JButton ("Instructions");
        instr.setBackground (new Color (57, 194, 216));
        instr.setActionCommand ("s10");
        instr.addActionListener (this);
        instr.setPreferredSize (new Dimension (120, 28));

        // initializing reset, undo, save, open, next level and redo buttons
        JButton reset = new JButton ("Reset");
        reset.setBackground (new Color (57, 194, 216));
        reset.setActionCommand ("s11");
        reset.addActionListener (this);
        reset.setPreferredSize (new Dimension (120, 28));

        undo = new JButton ("Undo");
        undo.setBackground (new Color (57, 194, 216));
        undo.setActionCommand ("s5");
        undo.addActionListener (this);
        undo.setPreferredSize (new Dimension (120, 28));
        undo.setEnabled (false);

        JButton save = new JButton ("Save");
        save.setBackground (new Color (57, 194, 216));
        save.setActionCommand ("s6");
        save.addActionListener (this);
        save.setPreferredSize (new Dimension (120, 28));

        JButton open = new JButton ("Open");
        open.setBackground (new Color (57, 194, 216));
        open.setActionCommand ("s7");
        open.addActionListener (this);
        open.setPreferredSize (new Dimension (120, 28));

        level = new JButton ("Next Level");
        level.setBackground (new Color (57, 194, 216));
        level.setActionCommand ("s8");
        level.addActionListener (this);
        level.setPreferredSize (new Dimension (120, 28));
        level.setEnabled (false);

        redo = new JButton ("Redo");
        redo.setBackground (new Color (57, 194, 216));
        redo.setActionCommand ("s9");
        redo.addActionListener (this);
        redo.setPreferredSize (new Dimension (120, 28));
        redo.setEnabled (false);

        // creating a widget to display level number
        level_num = new JLabel ("Level 1");
        level_num.setPreferredSize (new Dimension (480, 40));
        level_num.setBackground (Color.blue);
        level_num.setForeground (Color.white);
        level_num.setFont (new Font ("Helvetica", Font.BOLD, 32));

        // creating a panel for the game grid 
        Panel grid = new Panel (new GridLayout (17, 21));
        
        /* creating a grid of buttons with pictures and setting the
        action command of each button as its position in the grid */
        int m = 0;
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                //making the grid with pictures
                pics [m] = new JButton (createImageIcon ("" + map [z] [i] [j] + ".jpg"));
                pics [m].setPreferredSize (new Dimension (23, 23));
                pics [m].addActionListener (this);
                pics [m].setActionCommand (m + "");
                grid.add (pics [m]);
                m++;
            }
        }
        
        // adding widgets on the screen
        screen3.add (gold);
        screen3.add (result);
        screen3.add (title1);
        screen3.add (moves);
        screen3.add (grid);
        screen3.add (level_num);
        screen3.add (instr);
        screen3.add (reset);
        screen3.add (undo);
        screen3.add (redo);
        screen3.add (save);
        screen3.add (open);
        screen3.add (closing);
        
        // drawing the grid on the screen
        redraw ();
        
        // adding this screen to the main screen
        p_screen.add ("3", screen3);
    }

    // customizing the closing screen
    public void closing ()
    { 
    	screen4 = new Panel ();
        screen4.setBackground (new Color (4, 13, 28));
        
        // creating title label
        JLabel title = new JLabel ("Closing Screen");
        title.setFont (new Font ("Impact", Font.PLAIN, 30));
        title.setForeground (new Color (57, 194, 216));
        
        // creating a label with picture to add on the closing screen
        JLabel Closing_pic = new JLabel (createImageIcon("Closing.jpg"));
        
        // creating a return button
        JButton returnBack = new JButton ("Return to Game");
        returnBack.setPreferredSize (new Dimension (400, 50));
        returnBack.setActionCommand ("s3");
        returnBack.addActionListener (this);
        returnBack.setBackground (new Color (57, 194, 216));
        
        // creating a return button
        JButton playAgain = new JButton ("Play Again");
        playAgain.setPreferredSize (new Dimension (400, 50));
        playAgain.setActionCommand ("s12");
        playAgain.addActionListener (this);
        playAgain.setBackground (new Color (57, 194, 216));

        // adding widgets to the screen
        screen4.add (Closing_pic);
        screen4.add (playAgain);
        screen4.add (returnBack);
        p_screen.add ("4", screen4);
    }


    public void actionPerformed (ActionEvent e)
    { //displays different screens
    	if (e.getActionCommand ().equals ("s1"))
            cdLayout.show (p_screen, "1");
        else if (e.getActionCommand ().equals ("s2"))
            cdLayout.show (p_screen, "2");
        else if (e.getActionCommand ().equals ("s3"))
            cdLayout.show (p_screen, "3");
        else if (e.getActionCommand ().equals ("s4"))
            cdLayout.show (p_screen, "4");
         // clicking save button calls the save function
        else if (e.getActionCommand ().equals ("s6"))
            save ("game.txt");
    	// clicking open button calls the open function
        else if (e.getActionCommand ().equals ("s7"))
            open ("game.txt");
    	//  clicking reset button calls the reset function
        else if (e.getActionCommand ().equals ("s11"))
            reset ();
    	// clicking undo button calls the undo function
        else if (e.getActionCommand ().equals ("s5"))
            undo ();
    	// clicking next level button calls the level_change function
        else if (e.getActionCommand ().equals ("s8")){
            cdLayout.show (p_screen, "3");
            level_change ();}
    	// clicking redo button calls the redo function
        else if (e.getActionCommand ().equals ("s9"))
            redo ();
    	// clicking instructions button displays the instruction screen function
        else if (e.getActionCommand ().equals ("s10"))
            cdLayout.show (p_screen, "2");
    	// clicking play again displays the same screen again with all the 
    	// variables reseted
        else if (e.getActionCommand ().equals ("s12")){
            z = 0;
            reset ();
            x = 7;
            y = 8;
            cdLayout.show (p_screen, "3");}
    	// clicking instructions buttons 1, 2, 3, 4, 5 and 6  calls the Ins 
    	// function to change the display on the instructions screen
        else if (e.getActionCommand ().equals ("I1")){
            p = 1;
            Ins();}
        else if (e.getActionCommand ().equals ("I2")){
            p = 2;
            Ins();}
        else if (e.getActionCommand ().equals ("I3")){
            p = 3;
            Ins();}
        else if (e.getActionCommand ().equals ("I4")){
            p = 4;
            Ins();}
        else if (e.getActionCommand ().equals ("I5")){
            p = 5;
            Ins();}
        else if (e.getActionCommand ().equals ("I6")){
            p = 6;
            Ins();}
    	// clicking on the arrow keys on the screen calls move functions
    	// to move the player on the grid
        else if (e.getActionCommand ().equals ("179"))
            move_right ();
        else if (e.getActionCommand ().equals ("177"))
            move_left ();
        else if (e.getActionCommand ().equals ("158"))
            move_up ();
        else if (e.getActionCommand ().equals ("198"))
            move_down ();
    	// when the character comes back to the original starting position,
    	// the undo button is disabled 
        if (M == 0){
            redraw ();
            undo.setEnabled (false);}
        else{
            //win code
            int t = 0;
            t = check_win (t);
            if (t == 0)
                win (t);}
        moves.setText ("        moves: " + M);
        level_num.setText ("Level " + l);		
        showStatus (s + " " + M + " " + r);
        if (M == r)
            redo.setEnabled (false);
    }

    //print the grid again
    public void redraw () {
    	int move = 0;
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++){
                pics [move].setIcon (createImageIcon (map [z] [i] [j] + ".jpg"));
                move++;
            }
        }
        pics [x * col + y].setIcon (createImageIcon ("9.jpg"));
    }

    //redraw  for redo
    public void redraw_r (){
        int move = 0;
        for (int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col ; j++) {
                pics [move].setIcon (createImageIcon (map [z] [i] [j] + ".jpg"));
                move++;}
        }
        // conditions defining the starting point of the player on the grid for each level
        if (z == 0){  
            x = 7;
            y = 8;}
        else if (z == 1) {
            x = 8;
            y = 7; }
        else if (z == 2){
            x = 7;
            y = 7;}
        else if (z == 3) {
            x = 11;
            y = 14; }
        else if (z == 4) {
            x = 7;
            y = 9;}
        else if (z == 5){
            x = 8;
            y = 6;}
        else if (z == 6){
            x = 6;
            y = 4;}
        pics [x * col + y].setIcon (createImageIcon ("9.jpg"));}

    //handles the grid, moving right
    public void move_right () {
        redo.setEnabled (false);
        //restricting to move through walls and diamonds
        if (map [z] [x] [y + 1] != 1 && map [z] [x] [y + 1] != 3){         
                r = M; 
            y++;
            store ();
            redraw_1 ();
            M++;
            r++;   }
        
        // otherwise, changes the position of the character and diamond
        // on the grid and calls the redraw function to display the move 
        else if (map [z] [x] [y + 1] == 3){
            if (map [z] [x] [y + 2] != 1 && (map [z] [x] [y + 2] != 3)){
                r = M;
                y++;
                map [z] [x] [y + 1] = 3;
                map [z] [x] [y] = underMap [z] [x] [y];
                store ();
                redraw_1 ();
                M++;
                r++;}
        }
    }

    //redraws the grid on the screen again with different positions of
    //objects (passed into the functions as parameters)
    //redraw is a common function called for all the movements: left/right/up/down
    public void redraw_1 () {
        int move = 0;
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++)
            {
                pics [move].setIcon (createImageIcon (map [z] [i] [j] + ".jpg"));
                move++;
            }
        }
        pics [x * col + y].setIcon (createImageIcon ("9.jpg"));
    }


    //handles the grid, moving left
    public void move_left ()
    {
        redo.setEnabled (false);
      //restricting to move through walls and diamonds
        if (map [z] [x] [y - 1] != 1 && map [z] [x] [y - 1] != 3)
        {
            r = M;
            y--;
            store ();
            redraw_1 ();
            M++;
            r++;
        }
        
        // otherwise, changes the position of the character and diamond
        // on the grid and calls the redraw function to display the move 
        else if (map [z] [x] [y - 1] == 3)
        {
            if (map [z] [x] [y - 2] != 1 && map [z] [x] [y - 2] != 3)
            {
                r = M;
                y--;
                map [z] [x] [y - 1] = 3;
                map [z] [x] [y] = underMap [z] [x] [y];
                store ();
                redraw_1 ();
                M++;
                r++;

            }
        }
    }

    //handles the grid, moving up
    public void move_up ()
    {
        redo.setEnabled (false);
      //restricting to move through walls and diamonds
        if (map [z] [x - 1] [y] != 1 && map [z] [x - 1] [y] != 3)
        {
            r = M;
            x -= 1;
            store ();
            redraw_1 ();
            M++;
            r++;
        }
        
        // otherwise, changes the position of the character and diamond
        // on the grid and calls the redraw function to display the move 
        else if (map [z] [x - 1] [y] == 3)
        {
            if (map [z] [x - 2] [y] != 1 && map [z] [x - 2] [y] != 3)
            {
                r = M;
                x -= 1;
                map [z] [x - 1] [y] = 3;
                map [z] [x] [y] = underMap [z] [x] [y];
                store ();
                redraw_1 ();
                M++;
                r++;

            }
        }
    }

    //handles the grid, moving down
    public void move_down ()
    {
        redo.setEnabled (false);
      //restricting to move through walls and diamonds
        if (map [z] [x + 1] [y] != 1 && map [z] [x + 1] [y] != 3)
        {
            r = M;
            x += 1;
            store ();
            redraw_1 ();
            M++;
            r++;
        }
        
        // otherwise, changes the position of the character and diamond
        // on the grid and calls the redraw function to display the move 
        else if (map [z] [x + 1] [y] == 3)
        {
            if (map [z] [x + 2] [y] != 1 && map [z] [x + 2] [y] != 3)
            {
                r = M;
                x += 1;
                map [z] [x + 1] [y] = 3;
                map [z] [x] [y] = underMap [z] [x] [y];
                store ();
                redraw_1 ();
                M++;
                r++;

            }
        }
    }

    // displays the winning screen and resets all variables for the new level
    public void level_change ()
    {
        result.setIcon (createImageIcon ("diamonds.jpg"));
        gold.setText ("         ");
        l++;
        z++;
        M = 0;
        r = 0;
        
        // the x and y coordinates of the player's starting point depend 
        // on the level number
        if (z == 1){
            x = 8;
            y = 7; }
        else if (z == 2){
            x = 7;
            y = 7;}
        else if (z == 3){
            x = 11;
            y = 14;}
        else if (z == 4){
            x = 7;
            y = 9;}
        else if (z == 5){
            x = 8;
            y = 6;}
        else if (z == 6){
            x = 6;
            y = 4;}
        pics [x * col + y].setIcon (createImageIcon ("9.jpg"));
        redraw ();
        reset ();
        level.setEnabled (false);
        pics [7 * col + 18].setEnabled (true);
        pics [8 * col + 17].setEnabled (true);
        pics [8 * col + 19].setEnabled (true);
        pics [9 * col + 18].setEnabled (true);
        undo.setEnabled (true);
    }

    
    // checking the winning condition
    public int check_win (int t) {
        undo.setEnabled (true);
        //looping to see if all destination blocks are filled
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                if (map [z] [i] [j] == 4)
                {
                    t += 1;
                }
            }
        }
        return t;
    }
    
    //making changes to instruction screen
    public void Ins ()
    {
        pic1.setIcon (createImageIcon ("ins" + p + ".jpg"));
        ins1.setIcon (createImageIcon ("ins-" + p + ".jpg"));
    }

    // customizing displaying the winning screen
    public void win (int t)
    {
        screen5 = new Panel ();
        screen5.setBackground (Color.black);
        winner = new JButton (createImageIcon ("winner.gif"));
        winner.addActionListener (this);
        winner.setActionCommand ("s8");
        screen5.add (winner);
        screen5.add (level);
        p_screen.add ("5", screen5);
        cdLayout.show (p_screen, "5");
        level.setEnabled (true);
        // disabling the arrow keys so the player cannot move in that
        // level after winning it
        pics [7 * col + 18].setEnabled (false);
        pics [8 * col + 17].setEnabled (false);
        pics [8 * col + 19].setEnabled (false);
        pics [9 * col + 18].setEnabled (false);
        undo.setEnabled (false);
    }

    //store: storing each move
    public void store ()
    {
        s++;
        curx [s] = x;
        cury [s] = y;
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                steps [s] [i] [j] = map [z] [i] [j];
            }
        }
    }


    //moving back a move to implement undo
    public void undo ()
    {
        redo.setEnabled (true);
        if (s > 0){
            s--;
            x = curx [s];
            y = cury [s];
            for (int i = 0 ; i < row ; i++){
                for (int j = 0 ; j < col ; j++){
                    map [z] [i] [j] = steps [s] [i] [j]; }
            }
            redraw ();
            M--; }
        else if (s == 0) {
            int temp = r;
            reset ();
            r = temp;
        }
    }
    //displaying the undone as current move to implement redo
    public void redo ()
    {
        if (M < r){
            s++;
            x = curx [s];
            y = cury [s];
            for (int i = 0 ; i < row ; i++) {
                for (int j = 0 ; j < col ; j++) {
                    map [z] [i] [j] = steps [s] [i] [j];
                }
            }
            redraw ();
            M++;
        }
    }

    //reset
    public void reset ()
    {  
        //to set it back to the original
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                for (int k = 0 ; k < 2 ; k++)
                {
                    map [k] [i] [j] = newMap [k] [i] [j];
                }
            }
        }
        //redraw called to update grid
        redraw_r ();
        M = 0;
        r = 0;
        s = -1;
    }


    //save
    public void save (String filename){
        PrintWriter out;
        /* printing the map array in a .txt file  to save 
        the current state of the game */
        try {
            out = new PrintWriter (new FileWriter (filename)); 
            for (int i = 0 ; i < row ; i++) {
                for (int j = 0 ; j < col ; j++) {
                    out.println ("" + map [z] [i] [j]);
                }
            }
            // printing the position of the player in the same .txt file
            out.println ("" + x);
            out.println ("" + y);
            out.close ();
        }
        catch (IOException e) {
            System.out.println ("Error opening file " + e);
        }
    }
    
    //open
    public void open (String filename) {
        BufferedReader in;
        try {
            /* importing the information back from the external file, one
            line at a time and storing it into the map array */
            in = new BufferedReader (new FileReader (filename));
            String input = in.readLine ();
            for (int i = 0 ; i < row ; i++) {
                for (int j = 0 ; j < col ; j++){
                    map [z] [i] [j] = Integer.parseInt (input);
                    input = in.readLine ();
                }
            }
            // mutating the x and y coordinates to the values stored in the .txt file
            x = Integer.parseInt (input);
            input = in.readLine ();
            y = Integer.parseInt (input);

            in.close ();
        }
        // error if there is any problem opening the file
        catch (IOException e){
            System.out.println ("Error opening file " + e);}
        store ();
        redraw ();
    }

    // getting the image from the bin folder into this specific class
    protected static ImageIcon createImageIcon (String path) {
        java.net.URL imgURL = game.class.getResource (path);
        if (imgURL != null){
            return new ImageIcon (imgURL);
        }
        // error if the image is not in the bin folder for this project
        else{
            System.err.println ("Couldn't find file: " + path);
            return null;
        }
    }
}

