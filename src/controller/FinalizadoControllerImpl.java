/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Proceso;
import repository.IListProcessCallback;
import repository.IMainRepository;
import repository.MainRepositoryImpl;
import ui.IFinalizadoView;

/**
 *
 * @author SAMSUNG
 */
public class FinalizadoControllerImpl implements IFinalizadoController{
    
    private IFinalizadoView view;
    private IMainRepository mainRepository;
     public static String FINALIZADO = "finalizado";

    public FinalizadoControllerImpl(IFinalizadoView view) {
        this.view = view;
        this.mainRepository = MainRepositoryImpl.getInstance();
    }
    

    @Override
    public void listarProcesosFinalizados() {
        this.mainRepository.retornarListaDeProcesos(new IListProcessCallback() {
            @Override
            public void listaDeProcesos(List<Proceso> listaProcesos) {
                recorrerLista(listaProcesos);
            }
        });
    }
    
    private void recorrerLista(List<Proceso> listaProcesos) {
        List<Proceso> procesosFinalizados = new ArrayList<Proceso>();
         
         for(int i = 0; i < listaProcesos.size(); i++){
             if(listaProcesos.get(i).getEstado().equals(FINALIZADO)){
                 procesosFinalizados.add(listaProcesos.get(i));
             }
         }
         
         this.view.onProcessFinish(procesosFinalizados);
    }
    
}
