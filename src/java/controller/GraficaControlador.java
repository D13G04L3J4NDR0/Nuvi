/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Familias;
import entity.Problematicas;
import entity.TablaProblematicas;
import facade.FamiliasFacade;
import facade.ProblematicasFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Diego Leguizamon
 */
@Named(value = "graficaControlador")
@SessionScoped
public class GraficaControlador implements Serializable {

    /**
     * Creates a new instance of GraficaControlador
     */
    public GraficaControlador() {
    }
    
    List<Object[]> listadoProblematicas;
    BarChartModel graficaBarras;
    List<TablaProblematicas> tablaProblematica;
    
    @EJB
    FamiliasFacade familiasFacade;
    Familias familias = new Familias();
    
    @EJB
    ProblematicasFacade problematicasFacade;
    Problematicas problematicas = new Problematicas();
    
    TablaProblematicas tablaProblematicas = new TablaProblematicas();

    public List<TablaProblematicas> getTablaProblematica() {
        return tablaProblematica;
    }

    public void setTablaProblematica(List<TablaProblematicas> tablaProblematica) {
        this.tablaProblematica = tablaProblematica;
    }

    public BarChartModel getGraficaBarras() {
        return graficaBarras;
    }

    public void setGraficaBarras(BarChartModel graficaBarras) {
        this.graficaBarras = graficaBarras;
    }

    public List<Object[]> getListadoProblematicas() {
        return listadoProblematicas;
    }

    public void setListadoProblematicas(List<Object[]> listadoProblematicas) {
        this.listadoProblematicas = listadoProblematicas;
    }

    public Familias getFamilias() {
        return familias;
    }

    public void setFamilias(Familias familias) {
        this.familias = familias;
    }

    public Problematicas getProblematicas() {
        return problematicas;
    }

    public void setProblematicas(Problematicas problematicas) {
        this.problematicas = problematicas;
    }

    public TablaProblematicas getTablaProblematicas() {
        return tablaProblematicas;
    }

    public void setTablaProblematicas(TablaProblematicas tablaProblematicas) {
        this.tablaProblematicas = tablaProblematicas;
    }
    
    @PostConstruct
    public void init(){
        tablaProblematica = new ArrayList();
    }
    
    public void cargarDatos(){
        tablaProblematica = new ArrayList();
        listadoProblematicas = familiasFacade.graficarProblematica();
        for (Object[] elemento : listadoProblematicas) {
            TablaProblematicas tablaProblematicas = new TablaProblematicas();
            tablaProblematicas.setTipoProblematica(elemento[0].toString());
            tablaProblematicas.setCantidad(Integer.parseInt(elemento[1].toString()));
            
            tablaProblematica.add(tablaProblematicas);
        }
        graficarBarra(tablaProblematica);
    }
    
    public void graficarBarra(List<TablaProblematicas> lista){
        graficaBarras = new BarChartModel();
        ChartSeries serie = new ChartSeries();
        
        serie.setLabel("Tipo Problematica");
        for (TablaProblematicas tablaProblematicas1 : lista) {
            serie.set(tablaProblematicas1.getTipoProblematica(),tablaProblematicas1.getCantidad());
        }
        graficaBarras.addSeries(serie);
        graficaBarras.setTitle("Problematicas registradas");
        graficaBarras.setLegendPosition("e");
        Axis yAxis = graficaBarras.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad Familias"); 
    }
    
    
}
