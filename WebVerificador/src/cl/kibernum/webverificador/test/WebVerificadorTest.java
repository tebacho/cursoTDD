package cl.kibernum.webverificador.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import cl.kibernum.webverificador.WebVerificador;
import cl.kibernum.webverificador.interfaces.Logger;
import cl.kibernum.webverificador.interfaces.Result;
import cl.kibernum.webverificador.interfaces.Server;
import cl.kibernum.webverificador.interfaces.Web;


public class WebVerificadorTest {

	Server server;		
	Logger logger;
	Web web;
	Result result;
	
	@Before
    public void setUp() throws Exception
    {
		server = mock(Server.class);		
		logger = mock(Logger.class);
		web = mock(Web.class);
		result = mock(Result.class);
		when(server.connect(web)).thenReturn(result);
    }

	@Test
	public void testCheckWebOk() {
		
		when(result.isOk()).thenReturn(true);
		new WebVerificador(logger).checkWeb(server, web);
		verify(logger).registerWebIsOk(web);
	}
	
	@Test
	public void testCheckWebNoOk() {
		
		when(result.isOk()).thenReturn(false);
		new WebVerificador(logger).checkWeb(server, web);
		verify(logger,times(1)).registerWebReturnedError(web, result);
	}

}
