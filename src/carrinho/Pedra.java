/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrinho;

/**
 *
 * @author Guilherme
 */
public class Pedra {

    double pxI, pxF, pyI, pyF, x = 200,y = 70, sX = 0.1,sY = 0.1;
    
    
    
    Pedra(int tipo) {

        switch (tipo) {

            case 0:
                
                pxI = 200;
                pxF = 80;
                pyI = 70;
                pyF = 300;
                
                break;

            case 1:
                
                pxI = 200;
                pxF = 175;
                pyI = 70;
                pyF = 300;
                
                break;

            case 2:
                
                pxI = 200;
                pxF = 275;
                pyI = 70;
                pyF = 300;
                
                
                break;

        }

    }

}
