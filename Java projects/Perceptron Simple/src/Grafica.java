import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class Grafica extends ApplicationFrame
{	
	private short index;
	
	private ChartPanel chartPanel;
	
	public Grafica(Punto p[], Punto p2[], Punto p3[])
	{
		super("");
		
		index = 0;
		
		XYDataset data = generarDatos(p3);
		
		index++;
		
		JFreeChart chart = ChartFactory.createXYLineChart("Adaline", "X1", "X2", data);
		
		XYPlot plot = chart.getXYPlot();
		
		generarGrafica(p, p2, plot);
		
		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1024, 720));
		setContentPane(chartPanel);
	}
	
	public XYDataset generarDatos(Punto p[])
	{
		XYSeries series;
		
		XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
		
		if (index > 0)
		{
			series = new XYSeries("Objetos #" + index);
			
			for (short i = 0; p[i].getPos() != 0; i++)
				series.add(p[i].getPosX(), p[i].getPosY());
		}
		
		else
		{
			series = new XYSeries("Recta");
			
			for (byte i = 0; i < 2; i++)
				series.add(p[i].getPosX(), p[i].getPosY());
		}
		
		xySeriesCollection.addSeries(series);
		
		return xySeriesCollection;
	}
	
	public void generarGrafica(Punto p[], Punto pun2[], XYPlot plot)
	{
		XYDataset data = generarDatos(p);
		
		plot.setDataset(index, data);
		
		XYShapeRenderer renderer = new XYShapeRenderer();
		
		plot.setRenderer(index, renderer);
		
		index++;
		
		XYDataset data2 = generarDatos(pun2);
		
		plot.setDataset(index, data2);
		
		XYShapeRenderer renderer2 = new XYShapeRenderer();
		
		plot.setRenderer(index, renderer2);
	}
	
	public void setIndex(){ index = 0; }
	
	public ChartPanel getCP(){ return chartPanel; }
}
