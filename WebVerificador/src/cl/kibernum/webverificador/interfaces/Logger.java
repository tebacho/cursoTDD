package cl.kibernum.webverificador.interfaces;

public interface Logger {

	void registerWebIsOk(Web web);

	void registerWebReturnedError(Web web, Result result);

}
