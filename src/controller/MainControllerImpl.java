/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Marcos;
import model.Proceso;
import repository.IBridgeCallback;
import repository.IMainRepository;
import repository.MainRepositoryImpl;
import ui.IMainView;

/**
 *
 * @author SAMSUNG
 */
public class MainControllerImpl implements IMainController{
    
    //public static MainControllerImpl INSTANCE = null;
    public static IMainView view;
    public static IMainRepository mainRepository;

    public MainControllerImpl(IMainView view) {
        this.view = view;
        this.mainRepository = MainRepositoryImpl.getInstance();
    }

    @Override
    public void agregarProcesos(Proceso proceso) {
        mainRepository.guardarProceso(proceso, new IBridgeCallback() {
            @Override
            public void procesosSeleccionados(List<Marcos> lista) {
                view.onRefreshView(lista);
            }

            @Override
            public void ningunProcesoSeleccionado() {
                
            }
        });
    }

    @Override
    public void refrescar() {
        mainRepository.elegirProceso(0, new IBridgeCallback() {
            @Override
            public void procesosSeleccionados(List<Marcos> lista) {
                view.onRefreshView(lista);
            }

            @Override
            public void ningunProcesoSeleccionado() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    

    
    
}
