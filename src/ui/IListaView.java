/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.List;
import model.Proceso;

/**
 *
 * @author SAMSUNG
 */
public interface IListaView {
    void onProcessList(List<Proceso> procesos);
}
