/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import model.Proceso;

/**
 *
 * @author SAMSUNG
 */
public interface IMainRepository {
    void guardarProceso(Proceso proceso, IBridgeCallback callback);
    void finalizarProceso(String PID, IListProcessCallback callback);
    void retornarListaDeProcesos(IListProcessCallback callback);
    void elegirProceso(int marco, IBridgeCallback callback);
}
