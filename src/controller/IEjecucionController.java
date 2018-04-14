/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author SAMSUNG
 */
public interface IEjecucionController {
    void listarProcesosEnEjecucion();
    void finalizarProceso(String pid);
}
