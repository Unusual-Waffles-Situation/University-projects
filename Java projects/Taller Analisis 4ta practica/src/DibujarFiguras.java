import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import java.awt.Polygon;
import java.util.*;

public class DibujarFiguras extends ApplicationFrame
{
	private short index;
	private int perimetro;
	private List<Polygon> listaPoligonos;
	private XYPlot plot;
	private XYDataset data;
	
	public DibujarFiguras(Pared p, boolean verificar, List<Polygon> lista1)
	{
		super("");
		
		perimetro = 0;
		
		index = 0;
		
		List<Figura> lista = p.getListaFiguras();
		
		if (!verificar)
		{
			plot = new XYPlot();
			
			listaPoligonos = new ArrayList<>();
			
			data = generarDatos(index, verificar, lista, listaPoligonos);
		}
		
		else
		{
			listaPoligonos = lista1;
			
			data = generarDatos2(p);
		}
		
		short cantidad = p.getCantidadFiguras();
		
		index++;
		
		JFreeChart chart;
		
		if (!verificar)
		{
			chart = ChartFactory.createXYLineChart("Pared (entrada)", "X", "Y", data, PlotOrientation.VERTICAL, true, true, false);
			
			plot = chart.getXYPlot();
			plot.setRenderer(new XYLineAndShapeRenderer());
		}
			
		else
			chart = ChartFactory.createXYLineChart("Pared (salida)", "X", "Y", data, PlotOrientation.VERTICAL, false, true, false);
		
		plot = chart.getXYPlot();
		
		generarGrafica(lista, verificar, cantidad, plot, listaPoligonos);
		
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
		setContentPane(chartPanel);
	}
	
	public XYDataset generarDatos2(Pared pa)
	{
		Polygon po = new Polygon();
			
		XYSeries series = new XYSeries("", false);
			
		XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
			
		short cant = pa.getCantidadFiguras();
		short contador = 0;
		
		int arregloX[] = listaPoligonos.get(0).xpoints;
		int arregloY[] = listaPoligonos.get(0).ypoints;
		
		boolean ver;
			
		for (byte c = 0; c < 4; c++)
		{
			ver = false;
			
			Punto p = new Punto(arregloX[c], arregloY[c]);
				
			for (byte d = 1; d < cant - 1; d++)
			{
				if (listaPoligonos.get(d).contains(p.getPosX(), p.getPosY()))
				{
					ver = true;
					break;
				}
			}
			
			if (!ver)
				po.addPoint(p.getPosX(), p.getPosY());
		}
			
		for (byte k = 0; k < contador; k++)
		{
			arregloX = po.xpoints;
			arregloY = po.ypoints;
				
			series.add(arregloX[k], arregloY[k]);
		}
			
		xySeriesCollection.addSeries(series);
			
		return xySeriesCollection;
	}
		
		/*for (byte k = 0; k < 4; k++)
		{
			for (byte d = 0; d < 4; d++)
			{
				int arregloX[] = listaPoligonos.get(d).xpoints;
				int arregloY[] = listaPoligonos.get(d).ypoints;
				
				Polygon po = new Polygon();
				
				for (byte c = 0; c < 4; c++)
				{
					Punto p = new Punto(arregloX[c], arregloY[c]);
					
					if (!listaPoligonos.get(k).contains(p.getPosX(), p.getPosY()))
						po.addPoint(p.getPosX(), p.getPosY());
				}
				
				
			}
		}*/
	
	public XYDataset generarDatos(short k, boolean verificar, List<Figura> lista, List<Polygon> listaP)
	{
		XYSeries series;
		
		if (!verificar)
			series = new XYSeries("Figura #" + (k + 1), false);
		
		else
			series = new XYSeries("", false);
		
		XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
		
		// Puntos del vertice inferior
		
		series.add(lista.get(k).getVII().getPosX(), lista.get(k).getVII().getPosY()); // Vertice inferior izquierdo
		
		series.add(lista.get(k).getVSD().getPosX(), lista.get(k).getVII().getPosY());
					
		// Puntos del vertice superior
					
		series.add(lista.get(k).getVSD().getPosX(), lista.get(k).getVSD().getPosY()); // Vertice superior derecho
		series.add(lista.get(k).getVII().getPosX(), lista.get(k).getVSD().getPosY());
		
		series.add(lista.get(k).getVII().getPosX(), lista.get(k).getVII().getPosY());
		
		if (!verificar)
		{
			Polygon p = new Polygon();
			
			for (byte d = 0; d < 5; d++)
			{
				String x, y;
				x = "" + series.getDataItem(d).getX();
				y = "" + series.getDataItem(d).getY();
					
				double valX, valY;
				valX = Double.parseDouble(x);
				valY = Double.parseDouble(y);
					
				int valXFinal, valYFinal;
				valXFinal = (int) valX;
				valYFinal = (int) valY;
					
				p.addPoint(valXFinal, valYFinal);
			}
				
			listaPoligonos.add(p);
		}
		
		xySeriesCollection.addSeries(series);
		
		return xySeriesCollection;
	}
	
	public void verificarPunto(Punto p)
	{
		
	}
	
	public void generarGrafica(List<Figura> lista, boolean verificar, short cant, XYPlot plot, List<Polygon> listaP)
	{
		while (index < cant)
		{
			XYDataset data = generarDatos(index, verificar, lista, listaP);
			
			plot.setDataset(index, data);
			
			if (!verificar)
			{
				XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
				
				plot.setRenderer(index, renderer);
			}
			
			index++;
		}
	}
	
	public int getPerimetro(){ return perimetro; }
	public XYPlot getPlot(){ return plot; }
	public XYDataset getDataset(){ return data; }
	public List<Polygon> getLista(){ return listaPoligonos; }
}
