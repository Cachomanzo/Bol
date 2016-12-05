package com.mygdx.game;

/**
 * Created by Ignacio on 04/12/2016.
 */



public class ScoreManager {

    //Numero con el que instancia la bola
    public static int ballNumber;
    //Numero de contacto de collision de bola
    //compara con número de instancia
    public static int contactNumber;
    //Score de player que suma y resta
    //segun si se toca a tiempo o no la bola
    public static int ScorePlayer;


    public static int IncreaseScore(int score)
    {
        ScorePlayer = score;
        return score;
    }

    public static int DecreaseScore(int score)
    {
        contactNumber = score;
        return score;
    }
}