import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import java.util.*;

import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class GraficaCluster extends ApplicationFrame
{
	private int index;
	
	public GraficaCluster(Cluster c[], byte cant, int variable2Cantidad)
	{
		super("");
		
		index = 0;
		
		//byte ca = 0;
		
		XYDataset data = generarDatos(c[index], variable2Cantidad, (byte)0);
		
		index++;
		
		JFreeChart chart = ChartFactory.createScatterPlot("Agrupamiento", "X", "Y", data);
		
		XYPlot plot = chart.getXYPlot();
		
		generarGrafica(c, cant, variable2Cantidad, plot);
		
		//final JFreeChart chart = generarGrafica(c, cant, variable2Cantidad);
		final ChartPanel chartPanel = new ChartPanel(chart/*, true, true, true, true, true*/);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
		setContentPane(chartPanel);
	}
	
	public XYDataset generarDatos(Cluster c, int variable2Cantidad, byte can)
	{
		XYSeries series;
		
		XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
		
		@SuppressWarnings("unchecked")
		List <Nodo> lista = c.getLista();
		
		series = new XYSeries("Cluster #" + (can + 1));
		
		for (int d = 0; d < c.getCantidadLista(); d++)
			series.add(lista.get(d).getPosX(), lista.get(d).getPosY());
		
		xySeriesCollection.addSeries(series);
		
		return xySeriesCollection;
	}
	
	public void generarGrafica(Cluster c[], byte cant, int variable2Cantidad, XYPlot plot)
	{	
		
		while (index < cant)
		{
			XYDataset data = generarDatos(c[index], variable2Cantidad, (byte)index);
			plot.setDataset(index, data);
			
			XYShapeRenderer renderer = new XYShapeRenderer();
			
			plot.setRenderer(index, renderer);
			
			index++;
		}
		
		byte can = 0;
		
		while (can < cant)
		{
			XYSeries series = new XYSeries("Centroide #" + (can + 1));
			series.add(c[can].getCentroidePuntoX(), c[can].getCentroidePuntoY());
			
			XYSeriesCollection sc = new XYSeriesCollection();
			sc.addSeries(series);
			
			XYDataset data = sc;
			
			plot.setDataset(index, data);
			
			XYShapeRenderer renderer = new XYShapeRenderer();
			
			plot.setRenderer(index, renderer);
			
			index++;
			
			can++;
			
		}
	}
}
