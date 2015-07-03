/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrinho;

import java.awt.geom.GeneralPath;

public class Desenha {

    public GeneralPath carro(double x, double y) {

        GeneralPath carro = new GeneralPath();

        carro.moveTo(x, y);
        carro.lineTo(x + 50, y);
        carro.lineTo(x + 50, y - 25);
        carro.lineTo(x, y - 25);
        carro.lineTo(x, y);
        carro.moveTo(x + 5, y);
        carro.lineTo(x + 5, y + 5);
        carro.lineTo(x + 15, y + 5);
        carro.lineTo(x + 15, y);
        carro.moveTo(x + 45, y);
        carro.lineTo(x + 45, y + 5);
        carro.lineTo(x + 35, y + 5);
        carro.lineTo(x + 35, y);
        carro.moveTo(x + 10, y - 25);
        carro.lineTo(x + 10, y - 30);
        carro.lineTo(x + 40, y - 30);
        carro.lineTo(x + 40, y - 25);

        return carro;

    }

    public GeneralPath estrada(double x, double y) {

        GeneralPath estrada = new GeneralPath();

        estrada.moveTo(x, y);  
        estrada.lineTo(x + 400, y);
        estrada.moveTo(x + 200, y);
        estrada.lineTo(x + 50, y + 230);
        estrada.moveTo(x + 200, y);
        estrada.lineTo(x + 350, y + 230);
        estrada.moveTo(x + 200, y);
        estrada.lineTo(x + 250, y + 230);
        estrada.moveTo(x + 200, y);
        estrada.lineTo(x + 150, y + 230);

        return estrada;
    }

    public GeneralPath pedra(double x, double y) {

        GeneralPath pedra = new GeneralPath();
        
        pedra.moveTo(x, y);//x = 80  y = 300
        pedra.lineTo(x+40, y);
        pedra.lineTo(x+40, y-10);
        pedra.lineTo(x+30, y-15);
        pedra.lineTo(x+10, y-15);
        pedra.lineTo(x, y-10);
        pedra.lineTo(x,y);
        
        
        return pedra;
    }

}
