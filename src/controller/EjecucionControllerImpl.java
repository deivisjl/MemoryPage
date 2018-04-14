/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Marcos;
import model.Proceso;
import repository.IBridgeCallback;
import repository.IListProcessCallback;
import repository.IMainRepository;
import repository.MainRepositoryImpl;
import ui.IEjecucionView;

/**
 *
 * @author SAMSUNG
 */
public class EjecucionControllerImpl implements IEjecucionController{
    
    private IEjecucionView view;
    public static IMainRepository mainRepository;
    public static String EN_EJECUCION = "en ejecución";
    

    public EjecucionControllerImpl(IEjecucionView view) {
        this.view = view;
        this.mainRepository = MainRepositoryImpl.getInstance();
    }
    

    @Override
    public void listarProcesosEnEjecucion() {
        this.mainRepository.retornarListaDeProcesos(new IListProcessCallback() {
            @Override
            public void listaDeProcesos(List<Proceso> listaProcesos) {
                recorrerLista(listaProcesos);
            }
        });
    }
    
     private void recorrerLista(List<Proceso> listaProcesos) {
         List<Proceso> procesosEjecutandose = new ArrayList<Proceso>();
         
         for(int i = 0; i < listaProcesos.size(); i++){
             if(listaProcesos.get(i).getEstado().equals(EN_EJECUCION)){
                 procesosEjecutandose.add(listaProcesos.get(i));
             }
         }
         
         this.view.onProcessActive(procesosEjecutandose);
    }

    @Override
    public void finalizarProceso(String pid) {
        this.mainRepository.finalizarProceso(pid, new IListProcessCallback() {
            @Override
            public void listaDeProcesos(List<Proceso> listaProcesos) {
                 recorrerLista(listaProcesos);
                 refrescarVistaPrincipal();
            }
        });
    }
    
    private void refrescarVistaPrincipal() {
       this.mainRepository.elegirProceso(0, new IBridgeCallback() {
           @Override
           public void procesosSeleccionados(List<Marcos> lista) {
               
           }

           @Override
           public void ningunProcesoSeleccionado() {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
    }
    
}
