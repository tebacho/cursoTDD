package cl.kibernum.webverificador;

import cl.kibernum.webverificador.interfaces.Logger;
import cl.kibernum.webverificador.interfaces.Result;
import cl.kibernum.webverificador.interfaces.Server;
import cl.kibernum.webverificador.interfaces.Web;

public class WebVerificador {
	Logger log;
	public WebVerificador(Logger log){
		this.log = log;
	}
	public void checkWeb(Server server, Web web){
		Result result = server.connect(web);
		if (result.isOk()){
			log.registerWebIsOk(web);
		}else{
			log.registerWebReturnedError(web,result);
		}
	}
}
