import org.jfree.chart.ChartFactory;
import java.awt.Polygon;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import java.util.*;

public class Grafica extends ApplicationFrame
{
	private byte index;
	private Polygon polygon;
	
	public Grafica(ClaseCalculo c, Punto p)
	{
		super("");
		
		XYSeries series1 = new XYSeries("Polígono", false);
		
		XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
		
		int cant = c.getCantidad();
		
		List<Punto> lista = c.getListaPuntos();
		
		polygon = new Polygon();
		
		for (int k = 0; k < cant; k++)
		{
			series1.add(lista.get(k).getPosX(), lista.get(k).getPosY());
			polygon.addPoint(lista.get(k).getPosX(), lista.get(k).getPosY());
		}
			
		xySeriesCollection.addSeries(series1);
		
		XYDataset data = xySeriesCollection;
		
		JFreeChart chart = ChartFactory.createScatterPlot("Gráfica", "X", "Y", data);
		
		XYPlot plot = chart.getXYPlot();
		
		plot.setRenderer(new XYLineAndShapeRenderer());
		
		index = 1;
		
		XYDataset data2;
		XYSeries series2 = new XYSeries("Punto p");
		
		series2.add(p.getPosX(), p.getPosY());
		
		XYSeriesCollection col = new XYSeriesCollection();
		col.addSeries(series2);
		
		data2 = col;
		
		plot.setDataset(index, data2);
		
		XYShapeRenderer renderer = new XYShapeRenderer();
		
		plot.setRenderer(index, renderer);
		
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
		setContentPane(chartPanel);
	}
	
	public boolean verificarPunto(Punto p)
	{
		if (polygon.contains(p.getPosX(), p.getPosY()))
			return true;
		
		else
			return false;
	}
	
}
