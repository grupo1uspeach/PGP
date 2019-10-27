package beans;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.util.List;


public class Relatorio {

		public void geraRelatorio(List<Funcionario> lista_func) throws JRException {
			/*CARREGA O CODIGO FONTE PARA GERACAO DE RELATORIOS*/
			InputStream cod_fonte = Relatorio.class.getResourceAsStream("/template/relatorio.jrxml");
			
			/*COMPILA O CODIGO FONTE*/
			JasperReport relatorio = JasperCompileManager.compileReport(cod_fonte);
			
			/*GRAVA OS DADOS NO RELATORIO*/
			JasperPrint print = JasperFillManager.fillReport(relatorio, null, new JRBeanCollectionDataSource(lista_func));
			
			/*GERA VISUALIZACAO DO RELATORIO*/
			JasperViewer.viewReport(print, false);
		}
}
