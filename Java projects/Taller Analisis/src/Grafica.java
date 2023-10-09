import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class Grafica extends ApplicationFrame
{
	public Grafica(final String nombre, int cantidadArreglo1, int cantidadArreglo2, int cantidadArreglo3, double dur1, double dur2, double dur3)
	{
		super("");
		final XYSeries series = new XYSeries("Valores");
		
		series.add(cantidadArreglo1, dur1);
		series.add(cantidadArreglo2, dur2);
		series.add(cantidadArreglo3, dur3);
		
		final XYSeriesCollection data = new XYSeriesCollection(series);
		final JFreeChart chart = ChartFactory.createXYLineChart(nombre, "Tamaño de arreglo", "Tiempo transcurrido", data, PlotOrientation.VERTICAL, true, true, false);
		
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
		setContentPane(chartPanel);
	}
}
