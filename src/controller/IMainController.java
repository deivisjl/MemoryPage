/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Proceso;
import repository.IBridgeCallback;

/**
 *
 * @author SAMSUNG
 */
public interface IMainController {
    public void agregarProcesos(Proceso proceso);
    public void refrescar();
}
